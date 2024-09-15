package com.subash.api.ownrepo;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.User;


public interface HrOwnRepo {

	public void save(OnboardingEmployee onboardingEmployee);
	
	public void save(User user);
	
	public List<User> findAll();
	
	public User findById(int id);
	
	public void updateOnBoardEmployee(int id,int hrId);
	
	public void updateOnBoardExpEmployee(int id,int hrId);
	
	public List<AgentOnboardingEmployee> getAllOnboardingEmployee();
	
	public List<AgentOnboardingExpEmployee> getAllOnboardingExpEmployee();
	
	public List<OnboardingEmployee> getResolvedEmployee();
	
	public List<OnboardingExpEmployee> getResolvedExpEmployee();
}
