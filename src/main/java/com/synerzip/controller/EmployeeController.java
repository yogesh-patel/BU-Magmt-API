package com.synerzip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.synerzip.DTOs.PaginationResponseDto;
import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;
import com.synerzip.service.EmployeeService;


@RestController

public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="employees")
	public PaginationResponseDto<EmployeeVO> getCustomers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "sortOn", required = false, defaultValue = "empFirstName") String sortOn,
			@RequestParam(value = "sortOrder", required = false, defaultValue = "ASC") String sortOrder,
			@RequestParam(value = "searchText", required = false, defaultValue = "") String searchText) {

		return employeeService.getEmployeesPagenation(page, pageSize, sortOn, sortOrder, searchText);
	}
	
	@PostMapping(value="employees")
	public ResponseEntity<EmployeeVO> createEmployee(@RequestBody EmployeeVO empVO) {

		try {
			EmployeeVO result = employeeService.saveEmployee(empVO);
			return new ResponseEntity<EmployeeVO>(result, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<EmployeeVO>(new EmployeeVO(), HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@PutMapping(value="employees/{id}")
	public ResponseEntity<EmployeeVO> updateEmployee(@RequestBody EmployeeVO empVO, @PathVariable("id") long id) {
		EmployeeVO empTemp = employeeService.getEmployee(id);
		
		if(empTemp!=null) {
			empVO.setEmpId(empTemp.getEmpId());
		}
		else {
			return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
		}
		employeeService.saveEmployee(empVO);
		EmployeeVO employeeVO = employeeService.getEmployee(id);
		return new ResponseEntity<EmployeeVO>(employeeVO, HttpStatus.OK);	

}

	@DeleteMapping(value="employees/{id}")
	public ResponseEntity deleteEmployee(@PathVariable("id") long id) {
		 employeeService.deleteEmployees(id);
		return new ResponseEntity(HttpStatus.OK);	

	}
	

	
	
}
