package com.subash.api.ownrepo;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;

public interface AgentOwnRepo {

	public void save(AgentOnboardingEmployee agentOnboardingEmployee);

	public void save(AgentOnboardingExpEmployee agentOnboardingExpEmployee);

	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee();

	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee();
	
	public List<User> getSubAgentByRole();
	
	public void assignAgentForEmployee(Long agentId, Long recordId);
	
	public void assignAgentForExpEmployee(Long agentId, Long recordId);
	
	public List<AgentOnboardingEmployee> getAgentEmployee(String agentId);

	public List<AgentOnboardingExpEmployee> getAgentExpEmployee(String agentId);
	
	public AgentOnboardingEmployee getByIdOneOne(int id);
	
	public AgentOnboardingExpEmployee getByIdTwoTwo(int id);
	
	public List<ReportForOnboardingEmployee> getAllReportForEmployee();
	
	public List<ReportForOnboardingExpEmployee> getAllReportForExpEmployee();
	
	public List<AgentOnboardingEmployee> getByHrIdForEmployee(String agentId);

	public List<AgentOnboardingExpEmployee> getByHrIdForExpEmployee(String agentId);
	
	public List<AgentOnboardingEmployee> getByAssignToVerifyForEmployee();
	
	public List<AgentOnboardingExpEmployee> getByAssignToVerifyForExpEmployee();
	
	
	

//	public void save(User user);
//	
//	public List<User> findAll();
//	
//	public User findById(int id);
}
