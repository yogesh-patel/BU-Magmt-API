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

	@GetMapping(value="/employees/{id}")
	public ResponseEntity<List<EmployeeVO>> getEmployee(@PathVariable("id") long id) {
		EmployeeVO employeeVO = employeeService.getEmployee(id);
		return new ResponseEntity (employeeVO, HttpStatus.OK);
	}
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<EmployeeVO>> getEmployees() {
		List<EmployeeVO> empList = employeeService.getEmployees();
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);
	}	
	
	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping(value="/employees/pagenation")
	public PaginationResponseDto<EmployeeVO> getCustomers(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
			@RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
			@RequestParam(value = "sortOn", required = false, defaultValue = "empFirstName") String sortOn,
			@RequestParam(value = "sortOrder", required = false, defaultValue = "ASC") String sortOrder,
			@RequestParam(value = "searchText", required = false, defaultValue = "") String searchText) {

		return employeeService.getEmployeesPagenation(page, pageSize, sortOn, sortOrder, searchText);
	}
	
	@GetMapping(value="/employees/{name}")
	public ResponseEntity<List<EmployeeVO>> getEmployeesByName(@RequestParam(value="name") String name) {
		List<EmployeeVO> empList = employeeService.getEmployeesByName(name);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);
	}
	
	@PutMapping(value="employees/{id}")
	public ResponseEntity<List<EmployeeVO>> updateEmployee(@RequestBody EmployeeVO employeeVO, @PathVariable("id") long id) {
		employeeService.saveEmployee(employeeVO);
		List<EmployeeVO> empList = employeeService.getEmployees();
		//List<StudentVO> studentList = studentService.updateStudents();
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}

	@DeleteMapping(value="/employees/{id}")
	public ResponseEntity<List<EmployeeVO>> deleteEmployee(@PathVariable("id") long id) {
		List<EmployeeVO> empList = employeeService.deleteEmployees(id);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}
	
	@DeleteMapping(value="/employees/{name}")
	public ResponseEntity<List<EmployeeVO>> deleteEmployeeByName(@RequestParam(value="name") String name) {
		List<EmployeeVO> empList = employeeService.deleteEmployeeByName(name);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}
	
	
	
}
