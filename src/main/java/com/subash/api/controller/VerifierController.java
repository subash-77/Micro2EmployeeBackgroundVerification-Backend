package com.subash.api.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.VerifySource;
import com.subash.api.serviceimpl.AgentServiceImpl;
import com.subash.api.serviceimpl.VerifierServiceImpl;

@RestController
@RequestMapping("/verifier")
//@CrossOrigin("http://localhost:3000")
@CrossOrigin("*")
public class VerifierController {

	VerifierServiceImpl service;
	
	AgentServiceImpl agentService;

	
	public VerifierController(VerifierServiceImpl service, AgentServiceImpl agentService) {
		super();
		this.service = service;
		this.agentService = agentService;
	}
	@PostMapping("/addReportEmployee")
	public ResponseEntity<String> addReportForOnboardingEmployee( @RequestParam String content,
		    @RequestParam(required = false) Integer documentId,
		    @RequestParam(required = false) Integer onboardingEmployeeId,
		    @RequestParam Integer hrId,
		    @RequestParam String recordType,
		    @RequestParam String status,
		    @RequestParam String companyName
			) {

		try {
			
			System.out.println(companyName);
			if(recordType.equals("Employee")) {
				ReportForOnboardingEmployee reportOne = new ReportForOnboardingEmployee();
				
				reportOne.setHrId(hrId);
				reportOne.setReport(content);
				reportOne.setOnboardingEmployeeId(onboardingEmployeeId);
				reportOne.setAgentOnboardingEmployeeId(documentId);
				reportOne.setStatus(status);
				
				
				service.addReportForEmployee(reportOne);
				
				AgentOnboardingEmployee agentOnboardingEmployee =  agentService.getByIdOne(documentId);

				if(status.equalsIgnoreCase("approved")) {
					agentOnboardingEmployee.setVerifyFromVerifier("Approved");
					agentOnboardingEmployee.setVerifyStatus("Verified");
					if(companyName.equalsIgnoreCase("school")) {
						agentOnboardingEmployee.setSchoolStatus("Approved");
					} else if(companyName.equalsIgnoreCase("college")) {
						agentOnboardingEmployee.setCollegeStatus("Approved");
					}
					
				} else {
					agentOnboardingEmployee.setVerifyFromVerifier("Rejected");
					agentOnboardingEmployee.setVerifyStatus("Verified");
					
					if(companyName.equalsIgnoreCase("school")) {
						agentOnboardingEmployee.setSchoolStatus("Rejected");
					} else if(companyName.equalsIgnoreCase("college")) {
						agentOnboardingEmployee.setCollegeStatus("Rejected");
					}
				}
				
				
				agentService.addEmployeForAgent(agentOnboardingEmployee);
				
				
			} else {
				
				ReportForOnboardingExpEmployee reportTwo = new ReportForOnboardingExpEmployee();
				reportTwo.setHrId(hrId);
				reportTwo.setReport(content);
				reportTwo.setOnboardingExpEmployeeId(onboardingEmployeeId);
				reportTwo.setAgentOnboardingExpEmployeeId(documentId);
				reportTwo.setStatus(status);
				
				service.addReportForExpEmployee(reportTwo);
				
				AgentOnboardingExpEmployee agentOnboardingExpEmployee =  agentService.getByIdTwo(documentId);
				
				if(status.equalsIgnoreCase("approved")) {
					agentOnboardingExpEmployee.setVerifyFromVerifier("Approved");
					agentOnboardingExpEmployee.setVerifyStatus("Verified");
					
					if(companyName.equalsIgnoreCase("school")) {
						agentOnboardingExpEmployee.setSchoolStatus("Approved");
					} else if(companyName.equalsIgnoreCase("college")) {
						agentOnboardingExpEmployee.setCollegeStatus("Approved");
					} else if(companyName.equalsIgnoreCase("company")) {
						agentOnboardingExpEmployee.setExpRecordStatus("Approved");
					}
				} else {
					agentOnboardingExpEmployee.setVerifyFromVerifier("Rejected");
					agentOnboardingExpEmployee.setVerifyStatus("Verified");
					if(companyName.equalsIgnoreCase("school")) {
						agentOnboardingExpEmployee.setSchoolStatus("Rejected");
					} else if(companyName.equalsIgnoreCase("college")) {
						agentOnboardingExpEmployee.setCollegeStatus("Rejected");
					} else if(companyName.equalsIgnoreCase("company")) {
						agentOnboardingExpEmployee.setExpRecordStatus("Rejected");
					}
				}
				
				agentService.addExpEmployeForAgent(agentOnboardingExpEmployee);
			}
			

			return ResponseEntity.status(HttpStatus.OK).body("ReportForOnboardingEmployee added successfully");

		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Failed to add ReportForOnboardingEmployee");
		}
	}
	@GetMapping("/getAllEmployee")
	public List<AgentOnboardingEmployee> getOnBoardingEmployeeAssignedVerifyStatusYes() {
		return service.getAllAgentOnboardingEmployee();
	}

	@GetMapping("/getAllExpEmployee")
	public List<AgentOnboardingExpEmployee> getOnBoardingExpEmployeeAssignedVerifyStatusYes() {
		return service.getAllAgentOnboardingExpEmployee();
	}

	@PostMapping("/addVerificationRecords")
	public String addAgentOnboardingEmployee(
			@RequestParam("resume") MultipartFile resume,
			@RequestParam("educationTenth") MultipartFile educationTenth,
			@RequestParam("educationTwelth") MultipartFile educationTwelth, @RequestParam("sem1") MultipartFile sem1,
			@RequestParam("sem2") MultipartFile sem2, @RequestParam("sem3") MultipartFile sem3,
			@RequestParam("sem4") MultipartFile sem4, @RequestParam("sem5") MultipartFile sem5,
			@RequestParam("sem6") MultipartFile sem6, @RequestParam("sem7") MultipartFile sem7,
			@RequestParam("sem8") MultipartFile sem8, @RequestParam("drivingLicense") MultipartFile drivingLicense,
			@RequestParam("aadhaar") MultipartFile aadhaar) {

		try {
			
			VerifySource verifySource = new VerifySource();

		
			verifySource.setResume(resume.getBytes());
			verifySource.setEducationTenth(educationTenth.getBytes());
			verifySource.setEducationTwelth(educationTwelth.getBytes());
			verifySource.setSem1(sem1.getBytes());
			verifySource.setSem2(sem2.getBytes());
			verifySource.setSem3(sem3.getBytes());
			verifySource.setSem4(sem4.getBytes());
			verifySource.setSem5(sem5.getBytes());
			verifySource.setSem6(sem6.getBytes());
			verifySource.setSem7(sem7.getBytes());
			verifySource.setSem8(sem8.getBytes());
			verifySource.setDrivingLicense(drivingLicense.getBytes());
			verifySource.setAadhaar(aadhaar.getBytes());
			

			service.addVerifyRecords(verifySource);

			return "success";
			

		} catch (Exception e) {
			e.printStackTrace(); 
			return "failure";
		}
	}
	
	@GetMapping("/getAllVerifyResource")
	public List<VerifySource> getAllVerificationResource() {
		return service.getAllVerifyRecords();
	}

}
