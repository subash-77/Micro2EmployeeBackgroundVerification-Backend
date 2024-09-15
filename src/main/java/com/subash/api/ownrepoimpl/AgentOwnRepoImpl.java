package com.subash.api.ownrepoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.OnboardingEmployee;
import com.subash.api.model.OnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.User;
import com.subash.api.ownrepo.AgentOwnRepo;
import com.subash.api.ownrepo.HrOwnRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class AgentOwnRepoImpl implements AgentOwnRepo {
	
	public AgentOwnRepoImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	EntityManager entityManager;
	
	@Override
	public void save(AgentOnboardingEmployee agentOnboardingEmployee) {
		entityManager.merge(agentOnboardingEmployee);
	}

	@Override
	public void save(AgentOnboardingExpEmployee agentOnboardingExpEmployee) {
		entityManager.merge(agentOnboardingExpEmployee);
		
	}
	
	@Override
	public List<AgentOnboardingEmployee> getAllAgentOnboardingEmployee() {
		return entityManager.createQuery("from AgentOnboardingEmployee", AgentOnboardingEmployee.class).getResultList();
	}
	
	@Override
	public List<AgentOnboardingExpEmployee> getAllAgentOnboardingExpEmployee() {
		return entityManager.createQuery("from AgentOnboardingExpEmployee", AgentOnboardingExpEmployee.class).getResultList();
	}

	 public List<User> getSubAgentByRole() {
	        String jpql = "SELECT u FROM User u WHERE u.role = :role";
	        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);
	        query.setParameter("role", "agent"); // Hardcoded role value
	        return query.getResultList();
	    }

	@Override
	public void assignAgentForEmployee(Long agentId, Long recordId) {
		AgentOnboardingEmployee employee = entityManager.find(AgentOnboardingEmployee.class, recordId);

	    if (employee != null) {
	        // Update the subAgentAppoint field with the agentId
	        employee.setSubAgentAppoint(agentId.toString());

	        // Update the verifyStatus field to "processing"
	        employee.setVerifyStatus("processing");

	        // Merge the changes to the database
	        entityManager.merge(employee);
	    } else {
	        throw new EntityNotFoundException("Employee with ID " + recordId + " not found");
	    }
		
		
	}

	@Override
	public void assignAgentForExpEmployee(Long agentId, Long recordId) {

		AgentOnboardingExpEmployee employee = entityManager.find(AgentOnboardingExpEmployee.class, recordId);

	    if (employee != null) {
	        // Update the subAgentAppoint field with the agentId
	        employee.setSubAgentAppoint(agentId.toString());

	        // Update the verifyStatus field to "processing"
	        employee.setVerifyStatus("processing");

	        // Merge the changes to the database
	        entityManager.merge(employee);
	    } else {
	        throw new EntityNotFoundException("Employee with ID " + recordId + " not found");
	    }
		
	}

	@Override
	public List<AgentOnboardingEmployee> getAgentEmployee(String agentId) {
		 // Define the JPQL query
        String jpql = "SELECT a FROM AgentOnboardingEmployee a WHERE a.subAgentAppoint = :agentId";
        // Create a TypedQuery
        TypedQuery<AgentOnboardingEmployee> query = entityManager.createQuery(jpql, AgentOnboardingEmployee.class);
        // Set the parameter
        query.setParameter("agentId", agentId);
        // Execute the query and return the results
        return query.getResultList();
	}

	@Override
	public List<AgentOnboardingExpEmployee> getAgentExpEmployee(String agentId) {
		 // Define the JPQL query
        String jpql = "SELECT a FROM AgentOnboardingExpEmployee a WHERE a.subAgentAppoint = :agentId";
        // Create a TypedQuery
        TypedQuery<AgentOnboardingExpEmployee> query = entityManager.createQuery(jpql, AgentOnboardingExpEmployee.class);
        // Set the parameter
        query.setParameter("agentId", agentId);
        // Execute the query and return the results
        return query.getResultList();
	}

	@Override
	public AgentOnboardingEmployee getByIdOneOne(int id) {
		
		AgentOnboardingEmployee agentOnboardingEmployee = entityManager.find(AgentOnboardingEmployee.class, id);
		agentOnboardingEmployee.setAssignToVerify("Yes");
		
		entityManager.merge(agentOnboardingEmployee);
		
		return entityManager.find(AgentOnboardingEmployee.class, id);
		
	}

	@Override
	public AgentOnboardingExpEmployee getByIdTwoTwo(int id) {
		
		AgentOnboardingExpEmployee agentOnboardingExpEmployee = entityManager.find(AgentOnboardingExpEmployee.class, id);
		agentOnboardingExpEmployee.setAssignToVerify("Yes");
		
		entityManager.merge(agentOnboardingExpEmployee);
		
		return entityManager.find(AgentOnboardingExpEmployee.class, id);
	}

	@Override
	public List<ReportForOnboardingEmployee> getAllReportForEmployee() {
		
		return entityManager.createQuery("from ReportForOnboardingEmployee", ReportForOnboardingEmployee.class).getResultList();
	}

	@Override
	public List<ReportForOnboardingExpEmployee> getAllReportForExpEmployee() {
		
		return entityManager.createQuery("from ReportForOnboardingExpEmployee", ReportForOnboardingExpEmployee.class).getResultList();
	}

	@Override
	public List<AgentOnboardingEmployee> getByHrIdForEmployee(String userId) {
		String jpql = "SELECT a FROM AgentOnboardingEmployee a WHERE a.hrId = :userId";
        // Create a TypedQuery
        TypedQuery<AgentOnboardingEmployee> query = entityManager.createQuery(jpql, AgentOnboardingEmployee.class);
        // Set the parameter
        query.setParameter("userId", userId);
        // Execute the query and return the results
        return query.getResultList();
	}

	@Override
	public List<AgentOnboardingExpEmployee> getByHrIdForExpEmployee(String userId) {
		String jpql = "SELECT a FROM AgentOnboardingExpEmployee a WHERE a.hrId = :userId";
        // Create a TypedQuery
        TypedQuery<AgentOnboardingExpEmployee> query = entityManager.createQuery(jpql, AgentOnboardingExpEmployee.class);
        // Set the parameter
        query.setParameter("userId", userId);
        // Execute the query and return the results
        return query.getResultList();
	}

	@Override
	public List<AgentOnboardingEmployee> getByAssignToVerifyForEmployee() {
		
		String jpql = "SELECT a FROM AgentOnboardingEmployee a WHERE a.assignToVerify = :assignToVerify";
        TypedQuery<AgentOnboardingEmployee> query = entityManager.createQuery(jpql, AgentOnboardingEmployee.class);
        query.setParameter("assignToVerify", "Yes");
        return query.getResultList();
	}

	@Override
	public List<AgentOnboardingExpEmployee> getByAssignToVerifyForExpEmployee() {
		
		String jpql = "SELECT a FROM AgentOnboardingExpEmployee a WHERE a.assignToVerify = :assignToVerify";
        TypedQuery<AgentOnboardingExpEmployee> query = entityManager.createQuery(jpql, AgentOnboardingExpEmployee.class);
        query.setParameter("assignToVerify", "Yes");
        return query.getResultList();
	}

}
