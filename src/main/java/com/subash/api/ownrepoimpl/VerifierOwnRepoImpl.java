package com.subash.api.ownrepoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;

import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;

import com.subash.api.model.VerifySource;

import com.subash.api.ownrepo.VerifierOwnRepo;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class VerifierOwnRepoImpl implements VerifierOwnRepo {
	
	public VerifierOwnRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	EntityManager entityManager;
	
	@Override
	public void save(ReportForOnboardingEmployee reportForOnboardingEmployee) {
		entityManager.merge(reportForOnboardingEmployee);
	}

	@Override
	public void save(ReportForOnboardingExpEmployee reportForOnboardingExpEmployee) {
		entityManager.merge(reportForOnboardingExpEmployee);
		
	}
	
	@Override
	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee() {

		String query = "SELECT a FROM AgentOnboardingEmployee a WHERE a.assignToVerify = :assignToVerify";
	    return entityManager.createQuery(query, AgentOnboardingEmployee.class)
	                        .setParameter("assignToVerify", "Yes")
	                        .getResultList();
	}
	
	@Override
	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee() {

		String query = "SELECT a FROM AgentOnboardingExpEmployee a WHERE a.assignToVerify = :assignToVerify";
	    return entityManager.createQuery(query, AgentOnboardingExpEmployee.class)
	                        .setParameter("assignToVerify", "Yes")
	                        .getResultList();
	}

	@Override
	public void save(VerifySource verifySource) {
		
		entityManager.merge(verifySource);
		
	}

	@Override
	public List<VerifySource> getAllVerifySource() {
		return entityManager.createQuery("from VerifySource", VerifySource.class).getResultList();
	}

	

}
