package com.synerzip.VOs;

import java.time.LocalDateTime;

public class EmployeeVO {

	private long empId;

	private String empFirstName;

	private String empMiddleName;

	private String empLastName;

	private Boolean isActive;

	private String email;

	private int contact;

	private LocalDateTime DOB;

	private String experience;
	
	private String manager;
	private String Projct;
	private String status;
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	private String fullname;
	
	

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getProjct() {
		return Projct;
	}

	public void setProjct(String projct) {
		Projct = projct;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpMiddleName() {
		return empMiddleName;
	}

	public void setEmpMiddleName(String empMiddleName) {
		this.empMiddleName = empMiddleName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public LocalDateTime getDOB() {
		return DOB;
	}

	public void setDOB(LocalDateTime dOB) {
		DOB = dOB;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	public EmployeeVO() {
		
	}
	
	public EmployeeVO(String manager, String projct, String status, String fullname) {
		super();
		this.manager = manager;
		Projct = projct;
		this.status = status;
		this.fullname = fullname;
	}

	public EmployeeVO(long empId, String empFirstName, String empMiddleName, String empLastName) {
		super();
		this.empId = empId;
		this.empFirstName = empFirstName;
		this.empMiddleName = empMiddleName;
		this.empLastName = empLastName;
	}

}
