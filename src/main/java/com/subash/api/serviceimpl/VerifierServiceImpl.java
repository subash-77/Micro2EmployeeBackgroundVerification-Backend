package com.subash.api.serviceimpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.subash.api.model.AgentOnboardingEmployee;
import com.subash.api.model.AgentOnboardingExpEmployee;
import com.subash.api.model.ReportForOnboardingEmployee;
import com.subash.api.model.ReportForOnboardingExpEmployee;
import com.subash.api.model.VerifySource;
import com.subash.api.ownrepo.AgentOwnRepo;
import com.subash.api.ownrepo.VerifierOwnRepo;
import com.subash.api.service.AgentService;
import com.subash.api.service.VerifierService;

@Service
public class VerifierServiceImpl implements VerifierService {

	VerifierOwnRepo ownrepo;
	
	public VerifierServiceImpl(VerifierOwnRepo ownrepo) {
		super();
		this.ownrepo = ownrepo;
	}



	@Override
	public void addReportForEmployee(ReportForOnboardingEmployee reportForOnboardingEmployee) {
		
		ownrepo.save(reportForOnboardingEmployee);
	}



	@Override
	public void addReportForExpEmployee(ReportForOnboardingExpEmployee reportForOnboardingExpEmployee) {
		ownrepo.save(reportForOnboardingExpEmployee);
		
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
	public void addVerifyRecords(VerifySource verifySource) {
		ownrepo.save(verifySource);
		
	}



	@Override
	public List<VerifySource> getAllVerifyRecords() {
		// TODO Auto-generated method stub
		return ownrepo.getAllVerifySource();
	}

}
