package com.synerzip.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.synerzip.VOs.EmployeeVO;


public interface EmployeeService {

	public Long getHeadCount();

	public EmployeeVO saveEmployee(EmployeeVO employeeVO);

	public EmployeeVO getEmployee(long id);

	public List<EmployeeVO> getEmployees();

	public List<EmployeeVO> getEmployeesByName(String name);

	public List<EmployeeVO> deleteEmployees(long id);

	public List<EmployeeVO> deleteEmployeeByName(String name);

	
	
}
