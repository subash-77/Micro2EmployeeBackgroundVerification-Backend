package com.subash.api.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.ownrepo.AgentOwnRepo;
import com.subash.api.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService {

	AgentOwnRepo ownrepo;
	
	public AgentServiceImpl(AgentOwnRepo ownrepo) {
		super();
		this.ownrepo = ownrepo;
	}



	@Override
	public void addEmployeForAgent(AgentOnboardingEmployee agentOnboardingEmployee) {
		
		ownrepo.save(agentOnboardingEmployee);
	}



	@Override
	public void addExpEmployeForAgent(AgentOnboardingExpEmployee agentOnboardingExpEmployee) {
		ownrepo.save(agentOnboardingExpEmployee);
		
	}

	
	@Override
	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee() {
		
		return ownrepo.getAllAgentOnboardingEmployee();
		 
	}

	@Override
	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee() {
		
		return ownrepo.getAllAgentOnboardingExpEmployee();
		 
	}



	@Override
	public List<User> getAllSubAgentByRole() {
		
		return ownrepo.getSubAgentByRole();
	}



	@Override
	public void assignAgentOnBoardingEmployee(Long agentId, Long recordId) {
		// TODO Auto-generated method stub
		ownrepo.assignAgentForEmployee(agentId, recordId);
	}



	@Override
	public void assignAgentOnBoardingExpEmployee(Long agentId, Long recordId) {
		// TODO Auto-generated method stub
		ownrepo.assignAgentForExpEmployee(agentId, recordId);
	}



	@Override
	public List<AgentOnboardingEmployee> getRecordsForAgentEmployee(String agentId) {
		// TODO Auto-generated method stub
		return ownrepo.getAgentEmployee(agentId);
	}



	@Override
	public List<AgentOnboardingExpEmployee> getRecordsForAgentExpEmployee(String agentId) {
		// TODO Auto-generated method stub
		return ownrepo.getAgentExpEmployee(agentId);
	}



	@Override
	public AgentOnboardingEmployee getByIdOne(int id) {
		
		return ownrepo.getByIdOneOne(id);
	}



	@Override
	public AgentOnboardingExpEmployee getByIdTwo(int id) {
		return ownrepo.getByIdTwoTwo(id);
	}



	@Override
	public List<ReportForOnboardingEmployee> getAllReportForEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getAllReportForEmployee();
	}



	@Override
	public List<ReportForOnboardingExpEmployee> getAllReportForExpEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getAllReportForExpEmployee();
	}



	@Override
	public List<AgentOnboardingEmployee> getByHrIdForEmployee(String agentId) {
		// TODO Auto-generated method stub
		return ownrepo.getByHrIdForEmployee(agentId);
	}



	@Override
	public List<AgentOnboardingExpEmployee> getByHrIdForExpEmployee(String agentId) {
		// TODO Auto-generated method stub
		return ownrepo.getByHrIdForExpEmployee(agentId);
	}



	@Override
	public List<AgentOnboardingEmployee> getByAssignToVerifyForNotificationEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getByAssignToVerifyForEmployee();
	}



	@Override
	public List<AgentOnboardingExpEmployee> getByAssignToVerifyForNotificationExpEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getByAssignToVerifyForExpEmployee();
	}

}
