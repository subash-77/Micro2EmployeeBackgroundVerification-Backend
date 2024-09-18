package com.subash.api.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;

import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.serviceimpl.AgentServiceImpl;
import com.subash.api.serviceimpl.CollegeEmailService;
import com.subash.api.serviceimpl.SchoolEmailService;
import com.subash.api.serviceimpl.RegisterServiceImpl;

@RestController
@RequestMapping("/agent")
@CrossOrigin("http://localhost:3000")

public class AgentController {
	
	SchoolEmailService schooolEmailService;
	
	CollegeEmailService collegeEmailService;

	AgentServiceImpl service;
	
	RegisterServiceImpl registerService;
	
    private JavaMailSender mailSender;

	public AgentController(SchoolEmailService schooolEmailService, CollegeEmailService collegeEmailService,
			AgentServiceImpl service, RegisterServiceImpl registerService, JavaMailSender mailSender) {
		super();
		this.schooolEmailService = schooolEmailService;
		this.collegeEmailService = collegeEmailService;
		this.service = service;
		this.registerService = registerService;
		this.mailSender = mailSender;
	}
	private LocalDate lastSentDate = LocalDate.MIN;

	@PostMapping("/addAgentOnboardingEmployee")
	public String addAgentOnboardingEmployee(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeDob") String employeeDob, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("resume") MultipartFile resume, @RequestParam("educationTenth") MultipartFile educationTenth,
			@RequestParam("educationTwelth") MultipartFile educationTwelth, @RequestParam("sem1") MultipartFile sem1,
			@RequestParam("sem2") MultipartFile sem2, @RequestParam("sem3") MultipartFile sem3,
			@RequestParam("sem4") MultipartFile sem4, @RequestParam("sem5") MultipartFile sem5,
			@RequestParam("sem6") MultipartFile sem6, @RequestParam("sem7") MultipartFile sem7,
			@RequestParam("sem8") MultipartFile sem8, @RequestParam("drivingLicense") MultipartFile drivingLicense,
			@RequestParam("aadhaar") MultipartFile aadhaar, @RequestParam("type") String type,
			@RequestParam("hrId") int hrId, @RequestParam("onboardingEmployeeId") int onboardingEmployeeId,
			@RequestParam("verifyStatus") String verifyStatus, @RequestParam("agentAppoint") String agentAppoint,
			@RequestParam("subAgentAppoint") String subAgentAppoint,
			@RequestParam("assignToVerify") String assignToVerify,
			@RequestParam("verifyFromVerifier") String verifyFromVerifier) {

		try {
			
			AgentOnboardingEmployee agentOnboardingEmployee = new AgentOnboardingEmployee();

			
			agentOnboardingEmployee.setEmployeeName(employeeName);
			agentOnboardingEmployee.setEmployeeDob(employeeDob);
			agentOnboardingEmployee.setPhoneNumber(phoneNumber);
			agentOnboardingEmployee.setResume(resume.getBytes());
			agentOnboardingEmployee.setEducationTenth(educationTenth.getBytes());
			agentOnboardingEmployee.setEducationTwelth(educationTwelth.getBytes());
			agentOnboardingEmployee.setSem1(sem1.getBytes());
			agentOnboardingEmployee.setSem2(sem2.getBytes());
			agentOnboardingEmployee.setSem3(sem3.getBytes());
			agentOnboardingEmployee.setSem4(sem4.getBytes());
			agentOnboardingEmployee.setSem5(sem5.getBytes());
			agentOnboardingEmployee.setSem6(sem6.getBytes());
			agentOnboardingEmployee.setSem7(sem7.getBytes());
			agentOnboardingEmployee.setSem8(sem8.getBytes());
			agentOnboardingEmployee.setDrivingLicense(drivingLicense.getBytes());
			agentOnboardingEmployee.setAadhaar(aadhaar.getBytes());
			agentOnboardingEmployee.setType(type);
			agentOnboardingEmployee.setHrId(hrId);
			agentOnboardingEmployee.setOnboardingEmployeeId(onboardingEmployeeId);
			agentOnboardingEmployee.setVerifyStatus(verifyStatus);
			agentOnboardingEmployee.setAgentAppoint(agentAppoint);
			agentOnboardingEmployee.setSubAgentAppoint(subAgentAppoint);
			agentOnboardingEmployee.setAssignToVerify(assignToVerify);
			agentOnboardingEmployee.setVerifyFromVerifier(verifyFromVerifier);

			service.addEmployeForAgent(agentOnboardingEmployee);

			return "success";

		} catch (Exception e) {
			e.printStackTrace(); 
			return "failure";
			
		}
	}

	@PostMapping("/addAgentOnboardingExpEmployee")
	public ResponseEntity<String> addAgentOnboardingExpEmployee(@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeDob") String employeeDob, @RequestParam("phoneNumber") String phoneNumber,
			@RequestParam("resume") MultipartFile resume, @RequestParam("educationTenth") MultipartFile educationTenth,
			@RequestParam("educationTwelth") MultipartFile educationTwelth, @RequestParam("sem1") MultipartFile sem1,
			@RequestParam("sem2") MultipartFile sem2, @RequestParam("sem3") MultipartFile sem3,
			@RequestParam("sem4") MultipartFile sem4, @RequestParam("sem5") MultipartFile sem5,
			@RequestParam("sem6") MultipartFile sem6, @RequestParam("sem7") MultipartFile sem7,
			@RequestParam("sem8") MultipartFile sem8,
			@RequestParam("expRecord") MultipartFile expRecord,
			@RequestParam("drivingLicense") MultipartFile drivingLicense,
			@RequestParam("aadhaar") MultipartFile aadhaar, @RequestParam("type") String type,
			@RequestParam("referenceName") String referenceName,
			@RequestParam("referencePosition") String referencePosition,
			@RequestParam("workDuration") String workDuration, @RequestParam("referenceNumber") String referenceNumber,
			@RequestParam("hrId") int hrId, @RequestParam("onboardingExpEmployeeId") int onboardingExpEmployeeId,
			@RequestParam("verifyStatus") String verifyStatus, @RequestParam("agentAppoint") String agentAppoint,
			@RequestParam("subAgentAppoint") String subAgentAppoint,
			@RequestParam("assignToVerify") String assignToVerify,
			@RequestParam("verifyFromVerifier") String verifyFromVerifier) {

		try {
			
			AgentOnboardingExpEmployee agentOnboardingExpEmployee = new AgentOnboardingExpEmployee();

		
			agentOnboardingExpEmployee.setEmployeeName(employeeName);
			agentOnboardingExpEmployee.setEmployeeDob(employeeDob);
			agentOnboardingExpEmployee.setPhoneNumber(phoneNumber);
			agentOnboardingExpEmployee.setResume(resume.getBytes());
			agentOnboardingExpEmployee.setEducationTenth(educationTenth.getBytes());
			agentOnboardingExpEmployee.setEducationTwelth(educationTwelth.getBytes());
			agentOnboardingExpEmployee.setSem1(sem1.getBytes());
			agentOnboardingExpEmployee.setSem2(sem2.getBytes());
			agentOnboardingExpEmployee.setSem3(sem3.getBytes());
			agentOnboardingExpEmployee.setSem4(sem4.getBytes());
			agentOnboardingExpEmployee.setSem5(sem5.getBytes());
			agentOnboardingExpEmployee.setSem6(sem6.getBytes());
			agentOnboardingExpEmployee.setSem7(sem7.getBytes());
			agentOnboardingExpEmployee.setSem8(sem8.getBytes());
			agentOnboardingExpEmployee.setExpRecord(expRecord.getBytes());
			agentOnboardingExpEmployee.setDrivingLicense(drivingLicense.getBytes());
			agentOnboardingExpEmployee.setAadhaar(aadhaar.getBytes());
			agentOnboardingExpEmployee.setType(type);
			agentOnboardingExpEmployee.setReferenceName(referenceName);
			agentOnboardingExpEmployee.setReferencePosition(referencePosition);
			agentOnboardingExpEmployee.setWorkDuration(workDuration);
			agentOnboardingExpEmployee.setReferenceNumber(referenceNumber);
			agentOnboardingExpEmployee.setHrId(hrId);
			agentOnboardingExpEmployee.setOnboardingExpEmployeeId(onboardingExpEmployeeId);
			agentOnboardingExpEmployee.setVerifyStatus(verifyStatus);
			agentOnboardingExpEmployee.setAgentAppoint(agentAppoint);
			agentOnboardingExpEmployee.setSubAgentAppoint(subAgentAppoint);

			agentOnboardingExpEmployee.setAssignToVerify(assignToVerify);
			agentOnboardingExpEmployee.setVerifyFromVerifier(verifyFromVerifier);

			service.addExpEmployeForAgent(agentOnboardingExpEmployee);

			return ResponseEntity.status(HttpStatus.OK).body("AgentOnboardingExpEmployee added successfully");

		} catch (Exception e) {
			e.printStackTrace(); 
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to add AgentOnboardingExpEmployee");
		}
	}

	@GetMapping("/allAgentOnBoardingEmployee")
	public List<AgentOnboardingEmployee> getOnBoardingEmployeeAssignedWithHeadHr() {
		return service.getAllAgentOnboardingEmployee();
	}

	@GetMapping("/allAgentOnBoardingExpEmployee")
	public List<AgentOnboardingExpEmployee> getOnBoardingExpEmployeeAssignedWithHeadHr() {
		return service.getAllAgentOnboardingExpEmployee();
	}

	@GetMapping("/GetAllSubAgentByRole")
	public List<User> GetAllSubAgentByRole() {
		return service.getAllSubAgentByRole();
	}

	@PostMapping("/getIdForAssignSubAgent")
	public ResponseEntity<?> assignAgent(@RequestParam("agentId") Long agentId, @RequestParam("recordId") Long recordId,
			@RequestParam("type") String type) {
		try {
			if (type.equalsIgnoreCase("employee")) {
				service.assignAgentOnBoardingEmployee(agentId, recordId);
			} else if (type.equalsIgnoreCase("experience")) {
				service.assignAgentOnBoardingExpEmployee(agentId, recordId);
			}

			return ResponseEntity.ok().body("Assignment successful");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to assign agent");
		}
	}

	@GetMapping("/sendAgentIdForEmployee/{agentId}")
	public List<AgentOnboardingEmployee> getOnBoardingEmployeeAssignedForSubAgent(
			@PathVariable("agentId") String agentId) {
		return service.getRecordsForAgentEmployee(agentId);
	}

	@GetMapping("/sendAgentIdForExpEmployee/{agentId}")
	public List<AgentOnboardingExpEmployee> getOnBoardingExpEmployeeAssignedForSubAgent(
			@PathVariable("agentId") String agentId) {
		return service.getRecordsForAgentExpEmployee(agentId);
	}

	@PostMapping("/sendEmployeeToVerifier")
	public String sendEmployeeToVerifier(@RequestParam String recordId) {
		
		int agentOnboardingEmployeeId = Integer.parseInt(recordId);
		AgentOnboardingEmployee agentOnboardingEmployee = getByEmployee(agentOnboardingEmployeeId);
		
		
		
		String employeeName = agentOnboardingEmployee.getEmployeeName();


	    try {
	    	String schoolEmail = registerService.findSchoolEmailAddress();
	    	
	    	schooolEmailService.sendEmailWithAttachments(
	    			schoolEmail,
	            employeeName, 
	            
	            agentOnboardingEmployee.getEducationTenth(),
	            agentOnboardingEmployee.getEducationTwelth()
	        );
	    	
	    	String collegeEmail = registerService.findCollegeEmailAddress();
	    	collegeEmailService.sendEmailWithAttachments(
	    			collegeEmail, 
		            employeeName, 
		            agentOnboardingEmployee.getSem1(),
		            agentOnboardingEmployee.getSem2(),
		            agentOnboardingEmployee.getSem3(),
		            agentOnboardingEmployee.getSem4(),
		            agentOnboardingEmployee.getSem5(),
		            agentOnboardingEmployee.getSem6(),
		            agentOnboardingEmployee.getSem7(),
		            agentOnboardingEmployee.getSem8()
		            
		        );
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Failed to send email.";
	    }

	    return "Email sent successfully.";
	}
	
	@PostMapping("/sendExperienceToVerifier")
	public String sendExperienceToVerifier(@RequestParam String recordId) {
		
		int agentOnboardingExpEmployeeId = Integer.parseInt(recordId);
		
		AgentOnboardingExpEmployee agentOnboardingExpEmployee = getByExpEmployee(agentOnboardingExpEmployeeId);
		
		
		String employeeName = agentOnboardingExpEmployee.getEmployeeName();


	    try {
String schoolEmail = registerService.findSchoolEmailAddress();
	    	
	    	schooolEmailService.sendEmailWithAttachments(
	    			schoolEmail, 
	            employeeName, 
	            
	            agentOnboardingExpEmployee.getEducationTenth(),
	            agentOnboardingExpEmployee.getEducationTwelth()
	        );
	    	
	    	String collegeEmail = registerService.findCollegeEmailAddress();
	    	collegeEmailService.sendEmailWithAttachments(
	    			collegeEmail, 
		            employeeName, 
		            agentOnboardingExpEmployee.getSem1(),
		            agentOnboardingExpEmployee.getSem2(),
		            agentOnboardingExpEmployee.getSem3(),
		            agentOnboardingExpEmployee.getSem4(),
		            agentOnboardingExpEmployee.getSem5(),
		            agentOnboardingExpEmployee.getSem6(),
		            agentOnboardingExpEmployee.getSem7(),
		            agentOnboardingExpEmployee.getSem8()
		            
		        );
	    } catch (Exception e) {
	        e.printStackTrace();
	        return "Failed to send email.";
	    }

	    return "Email sent successfully.";
		
		
	}
	
	public AgentOnboardingEmployee getByEmployee(int id) {
		return service.getByIdOne(id);
	}
	public AgentOnboardingExpEmployee getByExpEmployee(int id) {
		return service.getByIdTwo(id);
	}
	
	
	
	@GetMapping("/GetAllReportForEmployee")
	public List<ReportForOnboardingEmployee> getAllReportForEmployee() {
		return service.getAllReportForEmployee();
	}
	
	@GetMapping("/GetAllReportForExpEmployee")
	public List<ReportForOnboardingExpEmployee> getAllReportForExpEmployee() {
		return service.getAllReportForExpEmployee();
	}
	
	
	@GetMapping("/getByHrIdForEmployee/{userId}")
	public List<AgentOnboardingEmployee> getByHrIdForEmployee(
			@PathVariable("userId") String userId) {
		return service.getByHrIdForEmployee(userId);
	}

	@GetMapping("/getByHrIdForExpEmployee/{userId}")
	public List<AgentOnboardingExpEmployee> getByHrIdForExpEmployee(
			@PathVariable("userId") String userId) {
		return service.getByHrIdForExpEmployee(userId);
	}
	

    @Scheduled(cron = "0 0 0 * * ?") 
    @PostMapping("/pushNotification")
    public void addAgentOnboardingEmployee() {
        if (LocalDate.now().isAfter(lastSentDate)) {
            String schoolEmail = registerService.findSchoolEmailAddress();
            String collegeEmail = registerService.findCollegeEmailAddress();

            List<AgentOnboardingEmployee> agentOnboardingEmployees = service.getByAssignToVerifyForNotificationEmployee();
            List<AgentOnboardingExpEmployee> agentOnboardingExpEmployees = service.getByAssignToVerifyForNotificationExpEmployee();

            boolean shouldSendSchoolEmail = false;
            boolean shouldSendCollegeEmail = false;

           
            for (AgentOnboardingEmployee employee : agentOnboardingEmployees) {
                if (isStatusNullOrNotApproved(employee.getSchoolStatus())) {
                    shouldSendSchoolEmail = true;
                }
                if (isStatusNullOrNotApproved(employee.getCollegeStatus())) {
                    shouldSendCollegeEmail = true;
                }
            }

           
            for (AgentOnboardingExpEmployee expEmployee : agentOnboardingExpEmployees) {
                if (isStatusNullOrNotApproved(expEmployee.getSchoolStatus())) {
                    shouldSendSchoolEmail = true;
                }
                if (isStatusNullOrNotApproved(expEmployee.getCollegeStatus())) {
                    shouldSendCollegeEmail = true;
                }
            }

            
            if (shouldSendSchoolEmail) {
                sendEmail(schoolEmail, "Reminder: Pending Approvals", "There are pending approvals for school-related onboarding employees.");
            }

            if (shouldSendCollegeEmail) {
                sendEmail(collegeEmail, "Reminder: Pending Approvals", "There are pending approvals for college-related onboarding employees.");
            }

            
            lastSentDate = LocalDate.now();
        }
    }

    private boolean isStatusNullOrNotApproved(String status) {
        return status == null || !status.equalsIgnoreCase("Approved");
    }

    private void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        mailSender.send(message);
        System.out.println("Mail Sended");
    }

}
