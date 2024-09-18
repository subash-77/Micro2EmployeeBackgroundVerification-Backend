package com.subash.api.ownrepoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.ownrepo.HrOwnRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class HrOwnRepoImpl implements HrOwnRepo {

	public HrOwnRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	EntityManager entityManager;

	@Override
	public void save(OnboardingEmployee onboardingEmployee) {
		entityManager.merge(onboardingEmployee);
	}

	@Override
	public void save(User user) {
		entityManager.merge(user);

	}

	@Override
	public List<User> findAll() {
		return entityManager.createQuery("from User", User.class).getResultList();
	}

	@Override
	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

	@Override
	public void updateOnBoardEmployee(int id, int hrId) {
		
		String jpql = "UPDATE OnboardingEmployee o SET o.assignToHeadHr = :value, o.hrId = :hrId WHERE o.onboardingEmployeeId = :id";

		
		entityManager.createQuery(jpql).setParameter("value", "4") 
				.setParameter("hrId", hrId) 
				.setParameter("id", id) 
				.executeUpdate();
	}

	@Override
	public void updateOnBoardExpEmployee(int id, int hrId) {
		
		String jpql = "UPDATE OnboardingExpEmployee o SET o.assignToHeadHr = :value, o.hrId = :hrId WHERE o.onboardingExpEmployeeId = :id";

	
		entityManager.createQuery(jpql).setParameter("value", "4") 
				.setParameter("hrId", hrId) 
				.setParameter("id", id) 
				.executeUpdate();
	}

	@Override
	public List<AgentOnboardingEmployee> getAllOnboardingEmployee() {

	    String jpql = "SELECT a FROM AgentOnboardingEmployee a WHERE a.onboardingEmployeeId IN (" +
	                  "SELECT o.onboardingEmployeeId FROM OnboardingEmployee o WHERE o.assignToHeadHr = :value)";
	    
	
	    return entityManager.createQuery(jpql, AgentOnboardingEmployee.class)
	                        .setParameter("value", 4) 
	                        .getResultList();
	}
	
	@Override
	public List<AgentOnboardingExpEmployee> getAllOnboardingExpEmployee() {
	    
		String jpql = "SELECT a FROM AgentOnboardingExpEmployee a WHERE a.onboardingExpEmployeeId IN (" +
                "SELECT o.onboardingExpEmployeeId FROM OnboardingExpEmployee o WHERE o.assignToHeadHr = :value)";
  

  return entityManager.createQuery(jpql, AgentOnboardingExpEmployee.class)
                      .setParameter("value", 4) 
                      .getResultList();
	}

	@Override
	public List<OnboardingEmployee> getResolvedEmployee() {
	   
	    String jpql = "SELECT o FROM OnboardingEmployee o WHERE o.assignToHeadHr = :value";
	    
	 
	    return entityManager.createQuery(jpql, OnboardingEmployee.class)
	                        .setParameter("value", "4") 
	                        .getResultList();

	}

	@Override
	public List<OnboardingExpEmployee> getResolvedExpEmployee() {
		
	    String jpql = "SELECT o FROM OnboardingExpEmployee o WHERE o.assignToHeadHr = :value";
	    
	    
	    return entityManager.createQuery(jpql, OnboardingExpEmployee.class)
	                        .setParameter("value", "4") 
	                        .getResultList();
	}
	
	
	


}
