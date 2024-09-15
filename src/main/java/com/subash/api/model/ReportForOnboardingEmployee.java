package com.subash.api.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reportforonboardingemployee")
public class ReportForOnboardingEmployee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rId;
	
	@Column(name = "hrId")
	private int hrId;
	
	
	@Column(name = "onboardingEmployeeId")
	private int onboardingEmployeeId;
	
	@Column(name = "agentOnboardingEmployeeId")
	private int agentOnboardingEmployeeId;
	
	@Column(name ="report")
	private String report;
	
	@Column(name = "status")
	private String status;
	
	

	public ReportForOnboardingEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReportForOnboardingEmployee(int rId, int hrId, int onboardingEmployeeId, int agentOnboardingEmployeeId,
			String report, String status) {
		super();
		this.rId = rId;
		this.hrId = hrId;
		this.onboardingEmployeeId = onboardingEmployeeId;
		this.agentOnboardingEmployeeId = agentOnboardingEmployeeId;
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

	public int getOnboardingEmployeeId() {
		return onboardingEmployeeId;
	}

	public void setOnboardingEmployeeId(int onboardingEmployeeId) {
		this.onboardingEmployeeId = onboardingEmployeeId;
	}

	public int getAgentOnboardingEmployeeId() {
		return agentOnboardingEmployeeId;
	}

	public void setAgentOnboardingEmployeeId(int agentOnboardingEmployeeId) {
		this.agentOnboardingEmployeeId = agentOnboardingEmployeeId;
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
		return "ReportForOnboardingEmployee [rId=" + rId + ", hrId=" + hrId + ", onboardingEmployeeId="
				+ onboardingEmployeeId + ", agentOnboardingEmployeeId=" + agentOnboardingEmployeeId + ", report="
				+ report + ", status=" + status + "]";
	}

}
