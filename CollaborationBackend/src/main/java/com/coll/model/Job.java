package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Job
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int jobId;
	String jobDesc;
	String designation;
	Date lastDatetoApply;
	String CTC;
	String jobLocation;
	String companyName;
	String skill;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobDesc() {
		return jobDesc;
	}
	public void setJobDesc(String jobDesc) {
		this.jobDesc = jobDesc;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public Date getLastDatetoApply() {
		return lastDatetoApply;
	}
	public void setLastDatetoApply(Date lastDatetoApply) {
		this.lastDatetoApply = lastDatetoApply;
	}
	
	
	public String getCTC() {
		return CTC;
	}
	public void setCTC(String cTC) {
		CTC = cTC;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	
	
	
}