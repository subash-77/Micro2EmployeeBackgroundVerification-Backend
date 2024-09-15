package com.subash.api.service;

import java.util.List;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.User;

public interface HrService {

	public void addEmployee(OnboardingEmployee onboardingEmployee);
	
	public void addUserWithEmployee(User user);
	
	public List<User> getAllUser();
	
	public User getHrById(int id);
	
	public void updateOnBoardEmployee(int id , int hrId);
	
	public void updateOnBoardExpEmployee(int id, int hrId);
	
	public List<AgentOnboardingEmployee> getAllOnboardingEmployee();
	
	public List<AgentOnboardingExpEmployee> getAllOnboardingExpEmployee();
	
public List<OnboardingEmployee> getResolveAllOnboardingEmployee();
	
	public List<OnboardingExpEmployee> getResolveAllOnboardingExpEmployee();
}
