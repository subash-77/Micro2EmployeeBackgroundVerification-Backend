package com.subash.api.service;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;

public interface AgentService {

	public void addEmployeForAgent(AgentOnboardingEmployee agentOnboardingEmployee);

	public void addExpEmployeForAgent(AgentOnboardingExpEmployee agentOnboardingExpEmployee);

	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee();

	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee();
	
	public List<User> getAllSubAgentByRole();
	
	public void assignAgentOnBoardingEmployee(Long agentId , Long recordId);
	
	public void assignAgentOnBoardingExpEmployee(Long agentId , Long recordId);
	
	public List<AgentOnboardingEmployee> getRecordsForAgentEmployee(String agentId);

	public List<AgentOnboardingExpEmployee> getRecordsForAgentExpEmployee(String agentId);
	
	
	public AgentOnboardingEmployee getByIdOne(int id);

	public AgentOnboardingExpEmployee getByIdTwo(int id);
	
	
	public List<ReportForOnboardingEmployee> getAllReportForEmployee();
	
	public List<ReportForOnboardingExpEmployee> getAllReportForExpEmployee();
	
	public List<AgentOnboardingEmployee> getByHrIdForEmployee(String agentId);

	public List<AgentOnboardingExpEmployee> getByHrIdForExpEmployee(String agentId);
	
	public List<AgentOnboardingEmployee> getByAssignToVerifyForNotificationEmployee();
	
	public List<AgentOnboardingExpEmployee> getByAssignToVerifyForNotificationExpEmployee();
	
	
	
}
