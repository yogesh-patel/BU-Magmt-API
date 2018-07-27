package com.synerzip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synerzip.DTOs.PaginationResponseDto;
import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;
import com.synerzip.repository.EmployeeRepository;
import com.synerzip.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	private final static int PAGESIZE = 3;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Long getHeadCount() {
		return employeeRepository.count();
	}

	@Override
	public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeVO getEmployee(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> getEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> getEmployeesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> deleteEmployees(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeVO> deleteEmployeeByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Iterable<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public List<Employee> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "empFirstName");		
		return employeeRepository.findAll(request).getContent();
	}
	
	@Override
	public PaginationResponseDto<EmployeeVO> getEmployeesPagenation(Integer page, Integer pageSize, String sortOn, String sortOrder, String searchText) {
		PaginationResponseDto<EmployeeVO> result = new PaginationResponseDto<EmployeeVO>();
		Sort sort = new Sort("ASC".equalsIgnoreCase(sortOrder) ? Sort.Direction.ASC : Sort.Direction.DESC, sortOn);
		PageRequest pageRequest = new PageRequest(page, pageSize, sort);
		Page<EmployeeVO> employees = employeeRepository.getEmployeesPagenation("%" + searchText + "%", pageRequest);
		if (employees != null) {
			result.setCount(employees.getNumberOfElements());
			result.setPage(page);
			result.setTotalItems(employees.getTotalElements());
			result.setTotalPages(employees.getTotalPages());
			List<EmployeeVO> employeesList = employees.getContent();
			result.setItems(employeesList);
		}
		return result;
	}
}
