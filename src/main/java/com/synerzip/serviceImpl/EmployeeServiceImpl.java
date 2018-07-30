package com.synerzip.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.synerzip.DTOs.PaginationResponseDto;
import com.synerzip.VOs.EmployeeVO;
import com.synerzip.exceptions.EmployeeProfileCreationException;
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
	@Transactional
	public EmployeeVO saveEmployee(EmployeeVO employeeVO) {
		try {
			Employee emp = new Employee();
			BeanUtils.copyProperties(employeeVO, emp);
			employeeRepository.save(emp);
			employeeVO.setEmpId(emp.getEmpId());
			return employeeVO;
		} catch (Exception e) {
			System.out.println("Exception occured " + e);
			throw new EmployeeProfileCreationException("Error Occured While creating Employee");
		}

	}

	
	@Override
	public EmployeeVO getEmployee(long id) {
		Employee employee = employeeRepository.findOne(id);
		EmployeeVO empvo = new EmployeeVO();
		BeanUtils.copyProperties(employee, empvo);
		return empvo;
	}

	@Override
	public void deleteEmployees(long id) {
		employeeRepository.delete(id);
	
	}

	/*public Iterable<Employee> findAllEmployees() {
		return employeeRepository.findAll();
	}
	
	public List<Employee> getPage(int pageNumber) {
		PageRequest request = new PageRequest(pageNumber - 1, PAGESIZE, Sort.Direction.ASC, "empFirstName");		
		return employeeRepository.findAll(request).getContent();
	}*/
	
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
