package com.subash.api.service;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.VerifySource;


public interface VerifierService {

	public void addReportForEmployee(ReportForOnboardingEmployee reportForOnboardingEmployee);
	
	public void addReportForExpEmployee(ReportForOnboardingExpEmployee reportForOnboardingExpEmployee);
	
	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee();

	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee();
	
	
	public void addVerifyRecords(VerifySource verifySource);
	
	public List<VerifySource> getAllVerifyRecords();
	
}
