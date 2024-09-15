package com.subash.api.controller;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.subash.api.model.Token;
import com.subash.api.model.User;
import com.subash.api.service.RegisterService;
import com.subash.api.serviceimpl.AgentEmailService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/register")
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("*")

public class RegisterController {

	RegisterService service;
	
	AgentEmailService agentService;
	
    public RegisterController(RegisterService service, AgentEmailService agentService) {
		super();
		this.service = service;
		this.agentService = agentService;
	}

	private static final String SECRET_KEY = "SUBASH";

    private static final long EXPIRATION_TIME = 3600000; 
	
	
	@PostMapping
	public String insertRegister(@RequestBody User user) {
		String msg = "";

		try {
			service.addRegister(user);
			msg += "addSuccess";

		} catch (Exception e) {
			msg += "addFailure";
		}
		return msg;

	}
	
	@PostMapping("/Update")
	public String insertUpdateRegister(@RequestBody User user) {
		String msg = "";
		
		
		service.updatePassword(user.getUserId(),user.getPassword());
			msg += "addSuccess";
		return msg;

	}
	
	 @PostMapping("/checkCredentials")
	    public String checkCredentials(@RequestBody User user) {
	        boolean isValid = service.checkCredentials(user.getEmail(), user.getPassword());
	       
	        if (isValid) {


	        	String token = generateToken(user.getEmail());
	            String role = service.findRole(user.getEmail());
	            
	            String company = service.findCompanyName(user.getEmail());
	            int userId = service.findPatientId(user.getEmail());


	           
//	            if ("psychiatrist".equals(role) && psychiatristLogin != null) {
//	                return "validCredentials:" + token + ":" + role + ":" + psychiatristLogin.getPsychiatristId();
//	            } else {
//	                return "validCredentials:" + token + ":" + role + ":" + patientId+":"+patientId; 
//	            }
//	        } else {
//	            
	            return "validCredentials:" + token + ":" + role + ":" + userId +":" + company ;
	        }
	        
	        return "invalidCredentials";
	            
	    }
	 @PostMapping("/addToken")
		public String insertToken(@RequestBody Token token) {
			String msg = "";

			try {
				service.addToken(token);
				msg += "tokenAddSuccess";

			} catch (Exception e) {
				msg += "tokenaddFailure";
			}
			return msg;

		}
	 @PostMapping("/deleteToken")
		public String deleteToken(@RequestParam String randomvalue) {
			String msg = "";

			try {
				service.deleteToken(randomvalue);
				msg += "tokenDeleteSuccess";

			} catch (Exception e) {
				msg += "tokenDeleteFailure";
			}
			return msg;

		}
	 @GetMapping("/gettokendetails")
	    public String getTokenDetails(@RequestParam String randomvalue) {
		 
	        try {
	            boolean isTokenValid = service.isTokenValid(randomvalue);
	            if (isTokenValid) {
	            	
	                return "Token is valid and not expired";
	            } else {
	            	service.deleteToken(randomvalue);
	                return "Token is expired or not found";
	            }
	        } catch (Exception e) {
	            service.deleteToken(randomvalue);
	        	return "Token Deleted and Session Expired Good Bye";
	        }
	    }
	 
	    private String generateToken(String username) {
	        Instant now = Instant.now();
	        Instant expiryTime = now.plus(EXPIRATION_TIME, ChronoUnit.MILLIS);

	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(Date.from(now))
	                .setExpiration(Date.from(expiryTime))
	                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
	                .compact();
	    }
	    
	    @PostMapping("/addSubAgent")
		public String insertSubAgent(@RequestBody User user) {
			String msg = "";

			try {
				service.addRegister(user);
				
				 String agentEmail = user.getEmail();
		            String password = user.getPassword();
		            
		            // Define email subject
		            String subject = "Regarding Agent Login Credentials";
		            
		            // Craft the email content
		            String agentText = String.format(
		                "Dear %s,%n%n" +
		                "Welcome to our system! Here are your login credentials:%n%n" +
		                "Email: %s%n" +
		                "Password: %s%n%n" +
		                "Please keep your credentials safe and secure. If you have any questions or need assistance, feel free to contact our support team.%n%n" +
		                "Best regards,%n" +
		                "The Support Team",
		                user.getUserName(),  // Assuming User class has a getName() method
		                agentEmail,
		                password
		            );
		            
		            // Send the email with credentials
		            agentService.sendEmail(agentEmail, subject, agentText);
				
				msg += "addSuccess";

			} catch (Exception e) {
				msg += "addFailure";
			}
			return msg;

		}
	    
	    @GetMapping("{id}")
		public User getJewelleryById(@PathVariable("id") int id) {
			return service.getJewellery(id);
		}
}
