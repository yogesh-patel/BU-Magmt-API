package com.synerzip.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters.LocalDateTimeConverter;


@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id	
	@Column(name="emp_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long emp_id;
	
	@Column(nullable = false)
	private String empFirstName;
	
	@Column(nullable = true)
	private String emp_middle_name;
	
	@Column(nullable = false)
	private String emp_last_name;
	
	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime created_date;
	
	private String createdBy;

	@Convert(converter = LocalDateTimeConverter.class)
	private LocalDateTime modified_date;

	
	private String modified_by;
	
	private Boolean is_active;
	
	/*@Column(nullable = false)
	private long manager_id;*/	

	public long getEmp_id() {
		return emp_id;
	}



	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}



	public String getEmp_first_name() {
		return empFirstName;
	}



	public void setEmp_first_name(String emp_first_name) {
		this.empFirstName = emp_first_name;
	}



	public String getEmp_middle_name() {
		return emp_middle_name;
	}



	public void setEmp_middle_name(String emp_middle_name) {
		this.emp_middle_name = emp_middle_name;
	}



	public String getEmp_last_name() {
		return emp_last_name;
	}



	public void setEmp_last_name(String emp_last_name) {
		this.emp_last_name = emp_last_name;
	}



	public LocalDateTime getCreated_date() {
		return created_date;
	}



	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}



	public String getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}



	public LocalDateTime getModified_date() {
		return modified_date;
	}



	public void setModified_date(LocalDateTime modified_date) {
		this.modified_date = modified_date;
	}



	public String getModified_by() {
		return modified_by;
	}



	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}



	public Boolean getIs_active() {
		return is_active;
	}



	public void setIs_active(Boolean is_active) {
		this.is_active = is_active;
	}


	/*public long getManager_id() {
		return manager_id;
	}



	public void setManager_id(long manager_id) {
		this.manager_id = manager_id;
	}*/



	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
}	
	
	
	
	
	
	
	
	
	
	


