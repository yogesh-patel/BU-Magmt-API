package com.synerzip.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.repository.EmployeeRepository;
import com.synerzip.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

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
}
