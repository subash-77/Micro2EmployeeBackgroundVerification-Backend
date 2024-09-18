package com.subash.api.controller;

import java.util.List;

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
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.serviceimpl.HrServiceImpl;

@RestController
@RequestMapping("/hr")
@CrossOrigin("http://localhost:3000")
public class HrController {

	

	HrServiceImpl service;

	public HrController(HrServiceImpl service) {
		super();

		this.service = service;
	}

	@PostMapping
	public String insertEmployeeDetails(
			@RequestParam("employeeName") String employeeName,
			@RequestParam("employeeDob") String employeeDob,
			@RequestParam("phoneNumber") String phoneNumber,
	        @RequestParam("resume") MultipartFile resume,
	        @RequestParam("educationTenth") MultipartFile educationTenth,
	        @RequestParam("educationTwelth") MultipartFile educationTwelth,
	        @RequestParam("sem1") MultipartFile sem1,
	        @RequestParam("sem2") MultipartFile sem2,
	        @RequestParam("sem3") MultipartFile sem3,
	        @RequestParam("sem4") MultipartFile sem4,
	        @RequestParam("sem5") MultipartFile sem5,
	        @RequestParam("sem6") MultipartFile sem6,
	        @RequestParam("sem7") MultipartFile sem7,
	        @RequestParam("sem8") MultipartFile sem8,
	        @RequestParam("drivingLicense") MultipartFile drivingLicense,
	        @RequestParam("aadhaar") MultipartFile aadhaar,
	        @RequestParam("type") String type,
	        @RequestParam("assignToHeadHr") String assignToHeadHr,
			@RequestParam("userName") String userName,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("role") String role,
			@RequestParam("hrId") String hrId,
			@RequestParam("companyName") String companyName){
	    String msg = "";

	    try {
	    	
	        
	    	User user = new User();
	    	user.setUserName(userName);
	    	user.setEmail(email);
	    	user.setPassword(password);
	    	user.setRole(role);
	    	user.setCompanyName(companyName);
	    	user.setUserId(1);
	    	
	    	
	        OnboardingEmployee onboardingEmployee = new OnboardingEmployee();
	        onboardingEmployee.setEmployeeName(employeeName);
	        onboardingEmployee.setEmployeeDob(employeeDob);
	        onboardingEmployee.setPhoneNumber(phoneNumber);
	        onboardingEmployee.setResume(resume.getBytes());
	        onboardingEmployee.setEducationTenth(educationTenth.getBytes());
	        onboardingEmployee.setEducationTwelth(educationTwelth.getBytes());
	        onboardingEmployee.setSem1(sem1.getBytes());
	        onboardingEmployee.setSem2(sem2.getBytes());
	        onboardingEmployee.setSem3(sem3.getBytes());
	        onboardingEmployee.setSem4(sem4.getBytes());
	        onboardingEmployee.setSem5(sem5.getBytes());
	        onboardingEmployee.setSem6(sem6.getBytes());
	        onboardingEmployee.setSem7(sem7.getBytes());
	        onboardingEmployee.setSem8(sem8.getBytes());
	        onboardingEmployee.setDrivingLicense(drivingLicense.getBytes());
	        onboardingEmployee.setAadhaar(aadhaar.getBytes());
	        onboardingEmployee.setType(type);
	        onboardingEmployee.setAssignToHeadHr(assignToHeadHr);
	        onboardingEmployee.setHrId(hrId);

	        user.getOnBoardingEmployee().add(onboardingEmployee);
	        
	        service.addUserWithEmployee(user);
	        msg += "addSuccess";
	    } catch (Exception e) {
	        msg += "addFailure";

	    }
	    return msg;
	}
	
	 @PostMapping("/addOnboardingExpEmployee")
	    public String insertOnboardingExpEmployee(
	    		@RequestParam("employeeName") String employeeName,
				@RequestParam("employeeDob") String employeeDob,
				@RequestParam("phoneNumber") String phoneNumber,
	            @RequestParam("resume") MultipartFile resume,
	            @RequestParam("educationTenth") MultipartFile educationTenth,
	            @RequestParam("educationTwelth") MultipartFile educationTwelth,
	            @RequestParam("sem1") MultipartFile sem1,
	            @RequestParam("sem2") MultipartFile sem2,
	            @RequestParam("sem3") MultipartFile sem3,
	            @RequestParam("sem4") MultipartFile sem4,
	            @RequestParam("sem5") MultipartFile sem5,
	            @RequestParam("sem6") MultipartFile sem6,
	            @RequestParam("sem7") MultipartFile sem7,
	            @RequestParam("sem8") MultipartFile sem8,
	            @RequestParam("expRecord") MultipartFile expRecord,
	            @RequestParam("drivingLicense") MultipartFile drivingLicense,
	            @RequestParam("aadhaar") MultipartFile aadhaar,
	            @RequestParam("type") String type,
	            @RequestParam("hrId") String hrId,
	            @RequestParam("assignToHeadHr") String assignToHeadHr,
	            @RequestParam("referenceName") String referenceName,
	            @RequestParam("referencePosition") String referencePosition,
	            @RequestParam("workDuration") String workDuration,
	            @RequestParam("referenceNumber") String referenceNumber,
	            @RequestParam("userName") String userName,
				@RequestParam("email") String email,
				@RequestParam("password") String password,
				@RequestParam("role") String role,
				@RequestParam("companyName") String companyName) {
	        
	        String msg = "";

	        try {
	        	
	        	User user = new User();
		    	user.setUserName(userName);
		    	user.setEmail(email);
		    	user.setPassword(password);
		    	user.setRole(role);
		    	user.setCompanyName(companyName);
		    	user.setUserId(1);

	            OnboardingExpEmployee onboardingExpEmployee = new OnboardingExpEmployee();
	            onboardingExpEmployee.setEmployeeName(employeeName);
		        onboardingExpEmployee.setEmployeeDob(employeeDob);
		        onboardingExpEmployee.setPhoneNumber(phoneNumber);
	            onboardingExpEmployee.setResume(resume.getBytes());
	            onboardingExpEmployee.setEducationTenth(educationTenth.getBytes());
	            onboardingExpEmployee.setEducationTwelth(educationTwelth.getBytes());
	            onboardingExpEmployee.setSem1(sem1.getBytes());
	            onboardingExpEmployee.setSem2(sem2.getBytes());
	            onboardingExpEmployee.setSem3(sem3.getBytes());
	            onboardingExpEmployee.setSem4(sem4.getBytes());
	            onboardingExpEmployee.setSem5(sem5.getBytes());
	            onboardingExpEmployee.setSem6(sem6.getBytes());
	            onboardingExpEmployee.setSem7(sem7.getBytes());
	            onboardingExpEmployee.setSem8(sem8.getBytes());
	            onboardingExpEmployee.setExpRecord(expRecord.getBytes());
	            onboardingExpEmployee.setDrivingLicense(drivingLicense.getBytes());
	            onboardingExpEmployee.setAadhaar(aadhaar.getBytes());
	            onboardingExpEmployee.setType(type);
	            onboardingExpEmployee.setHrId(hrId);
	            onboardingExpEmployee.setAssignToHeadHr(assignToHeadHr);
	            onboardingExpEmployee.setReferenceName(referenceName);
	            onboardingExpEmployee.setReferencePosition(referencePosition);
	            onboardingExpEmployee.setWorkDuration(workDuration);
	            onboardingExpEmployee.setReferenceNumber(referenceNumber);
	            
	            user.getOnBoardingExpEmployee().add(onboardingExpEmployee);

	            service.addUserWithEmployee(user);

	            msg = "addSuccess";
	        } catch (Exception e) {
	            msg = "addFailure";
	            e.printStackTrace(); 
	        }

	        return msg;
	    }
	
	@GetMapping("/all")
	public List<User> getUser() {
		return service.getAllUser();
	}
	
	@GetMapping("{id}")
	public User getHrById(@PathVariable("id") int id) {
		return service.getHrById(id);
	}
	

	
	@PostMapping("/updateonboardingemployeeId/{id}")
	public String updateOnboardingEmployee(@PathVariable("id") int id, @RequestParam("hrId") String hrId) {
		int subHrId = Integer.parseInt(hrId);
	    service.updateOnBoardEmployee(id, subHrId);
	    return "Updated Successfully";
	}

	@PostMapping("/updateonboardingexpemployeeId/{id}")
	public String updateOnboardingExpEmployee(@PathVariable("id") int id, @RequestParam("hrId") String hrId) {
		int subHrId = Integer.parseInt(hrId);
	    service.updateOnBoardExpEmployee(id, subHrId);
	    return "Updated Successfully";
	}

	
	@GetMapping("/allOnBoardingEmployee")
	public List<AgentOnboardingEmployee> getOnBoardingEmployeeAssignedWithHeadHr() {
		return service.getAllOnboardingEmployee();
	}
	
	@GetMapping("/allOnBoardingExpEmployee")
	public List<AgentOnboardingExpEmployee> getOnBoardingExpEmployeeAssignedWithHeadHr() {
		return service.getAllOnboardingExpEmployee();	
	}
	
	@GetMapping("/allResolvedOnBoardingEmployee")
	public List<OnboardingEmployee> getOnBoardingEmployee() {
		return service.getResolveAllOnboardingEmployee();
	}
	
	@GetMapping("/allResolvedOnBoardingExpEmployee")
	public List<OnboardingExpEmployee> getOnBoardingExpEmployee() {
		return service.getResolveAllOnboardingExpEmployee();
	}

}
