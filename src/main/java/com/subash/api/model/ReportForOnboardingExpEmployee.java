package com.subash.api.model;

import java.util.Arrays;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "reportforonboardingexpemployee")
public class ReportForOnboardingExpEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;
	
	@Column(name = "hrId")
	private int hrId;
	
	@Column(name = "onboardingEmployeeId")
	private int onboardingExpEmployeeId;
	
	@Column(name = "agentOnboardingEmployeeId")
	private int agentOnboardingExpEmployeeId;
	
	@Column(name ="report")
	private String report;
	
	@Column(name = "status")
	private String status;
	

	public ReportForOnboardingExpEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportForOnboardingExpEmployee(int rId, int hrId, int onboardingExpEmployeeId,
			int agentOnboardingExpEmployeeId, String report, String status) {
		super();
		this.rId = rId;
		this.hrId = hrId;
		this.onboardingExpEmployeeId = onboardingExpEmployeeId;
		this.agentOnboardingExpEmployeeId = agentOnboardingExpEmployeeId;
		this.report = report;
		this.status = status;
	}

	public int getrId() {
		return rId;
	}

	public void setrId(int rId) {
		this.rId = rId;
	}

	public int getHrId() {
		return hrId;
	}

	public void setHrId(int hrId) {
		this.hrId = hrId;
	}

	public int getOnboardingExpEmployeeId() {
		return onboardingExpEmployeeId;
	}

	public void setOnboardingExpEmployeeId(int onboardingExpEmployeeId) {
		this.onboardingExpEmployeeId = onboardingExpEmployeeId;
	}

	public int getAgentOnboardingExpEmployeeId() {
		return agentOnboardingExpEmployeeId;
	}

	public void setAgentOnboardingExpEmployeeId(int agentOnboardingExpEmployeeId) {
		this.agentOnboardingExpEmployeeId = agentOnboardingExpEmployeeId;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ReportForOnboardingExpEmployee [rId=" + rId + ", hrId=" + hrId + ", onboardingExpEmployeeId="
				+ onboardingExpEmployeeId + ", agentOnboardingExpEmployeeId=" + agentOnboardingExpEmployeeId
				+ ", report=" + report + ", status=" + status + "]";
	}

	
	
	
}
