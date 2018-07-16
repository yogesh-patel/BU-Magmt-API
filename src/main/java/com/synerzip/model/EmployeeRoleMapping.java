package com.synerzip.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employee_role_mapping")
public class EmployeeRoleMapping {
	
	@Id	
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_id", referencedColumnName = "emp_id")	
	private Employee employee;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "role", referencedColumnName = "role_id")	
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "manager_id", referencedColumnName = "emp_id")
	private Employee managerId;
	
	public Employee getEmployee() {
		return employee;
	}
	
	

	public Employee getManagerId() {
		return managerId;
	}



	public void setManager_id(Employee managerId) {
		this.managerId = managerId;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	
	
	
	

}
