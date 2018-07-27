package com.synerzip.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synerzip.DTOs.PaginationResponseDto;
import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;


public interface EmployeeService {

	public Long getHeadCount();

	public EmployeeVO saveEmployee(EmployeeVO employeeVO);

	public EmployeeVO getEmployee(long id);

	public List<EmployeeVO> getEmployees();

	public List<EmployeeVO> getEmployeesByName(String name);

	public List<EmployeeVO> deleteEmployees(long id);

	public List<EmployeeVO> deleteEmployeeByName(String name);
	
	public Iterable<Employee> findAllEmployees();
	
	public List<Employee> getPage(int pageNumber);
	
	public PaginationResponseDto<EmployeeVO> getEmployeesPagenation(Integer page, Integer pageSize, String sortOn,
			String sortOrder, String searchText);

	
	
}
