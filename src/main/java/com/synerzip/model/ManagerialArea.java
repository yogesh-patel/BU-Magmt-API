package com.synerzip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "managerial_area")
public class ManagerialArea {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String managerial_area_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getManagerial_area_name() {
		return managerial_area_name;
	}

	public void setManagerial_area_name(String managerial_area_name) {
		this.managerial_area_name = managerial_area_name;
	}

	
	
	

}
