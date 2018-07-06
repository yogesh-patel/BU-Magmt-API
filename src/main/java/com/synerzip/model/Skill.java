package com.synerzip.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "skills")
public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long skill_id;
	
	@Column(nullable = false)
	private String skill_name;	
	
	public long getSkill_id() {
		return skill_id;
	}

	public void setSkill_id(Long skill_id) {
		this.skill_id = skill_id;
	}

	public String getSkill_name() {
		return skill_name;
	}

	public void setSkill_name(String skill_name) {
		this.skill_name = skill_name;
	}

	

}
