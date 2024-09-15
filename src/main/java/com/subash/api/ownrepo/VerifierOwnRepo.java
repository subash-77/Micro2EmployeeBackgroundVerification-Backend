package com.subash.api.ownrepo;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.model.VerifySource;


public interface VerifierOwnRepo {

	public void save(ReportForOnboardingEmployee reportForOnboardingEmployee);
	
	public void save(ReportForOnboardingExpEmployee reportForOnboardingExpEmployee);
	
	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee();

	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee();
	
	public void save(VerifySource verifySource);
	
	public List<VerifySource> getAllVerifySource();
	
//	public void save(User user);
//	
//	public List<User> findAll();
//	
//	public User findById(int id);
}
