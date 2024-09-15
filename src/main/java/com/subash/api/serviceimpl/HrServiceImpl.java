package com.subash.api.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.ownrepoimpl.HrOwnRepoImpl;
import com.subash.api.service.HrService;

@Service
public class HrServiceImpl implements HrService {

	HrOwnRepoImpl ownrepo;
	
	
	public HrServiceImpl(HrOwnRepoImpl ownrepo) {
		super();
		this.ownrepo = ownrepo;
	}


	@Override
	public void addEmployee(OnboardingEmployee onboardingEmployee) {
		
		ownrepo.save(onboardingEmployee);
	}


	@Override
	public void addUserWithEmployee(User user) {
		
		ownrepo.save(user);
	}


	@Override
	public List<User> getAllUser() {
		
		return ownrepo.findAll();
	}


	@Override
	public User getHrById(int id) {
		return ownrepo.findById(id);
	}


	@Override
	public void updateOnBoardEmployee(int id,int hrId) {
		
		ownrepo.updateOnBoardEmployee(id, hrId);
	}


	@Override
	public void updateOnBoardExpEmployee(int id,int hrId) {
		// TODO Auto-generated method stub
		ownrepo.updateOnBoardExpEmployee(id, hrId);
	}


	@Override
	public List<AgentOnboardingEmployee> getAllOnboardingEmployee() {
		
		return ownrepo.getAllOnboardingEmployee();
		 
	}

	@Override
	public List<AgentOnboardingExpEmployee> getAllOnboardingExpEmployee() {
		
		return ownrepo.getAllOnboardingExpEmployee();
		 
	}


	@Override
	public List<OnboardingEmployee> getResolveAllOnboardingEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getResolvedEmployee();
	}


	@Override
	public List<OnboardingExpEmployee> getResolveAllOnboardingExpEmployee() {
		// TODO Auto-generated method stub
		return ownrepo.getResolvedExpEmployee();
	}
}
