package com.synerzip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.service.EmployeeService;

@RequestMapping(value="empapi/v1")
public class EmployeeController {


	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value="/employees")
	public ResponseEntity<EmployeeVO> createStudent(@RequestBody EmployeeVO employeeVO) {

		try {
			EmployeeVO result = employeeService.saveEmployee(employeeVO);
			return new ResponseEntity<EmployeeVO>(result, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<EmployeeVO>(new EmployeeVO(), HttpStatus.EXPECTATION_FAILED);
		}
	}

	
	@GetMapping(value="/employees/{id}")
	public ResponseEntity<List<EmployeeVO>> getStudent(@PathVariable("id") long id) {
		EmployeeVO employeeVO = employeeService.getEmployee(id);
		return new ResponseEntity (employeeVO, HttpStatus.OK);
	}
	
	@GetMapping(value="/employees")
	public ResponseEntity<List<EmployeeVO>> getStudents() {
		List<EmployeeVO> empList = employeeService.getEmployees();
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);
	}
	
	@GetMapping(value="/employees/{name}")
	public ResponseEntity<List<EmployeeVO>> getStudentsByName(@RequestParam(value="name") String name) {
		List<EmployeeVO> empList = employeeService.getEmployeesByName(name);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);
	}
	
	@PutMapping(value="employees/{id}")
	public ResponseEntity<List<EmployeeVO>> updateStudent(@RequestBody EmployeeVO employeeVO, @PathVariable("id") long id) {
		employeeService.saveEmployee(employeeVO);
		List<EmployeeVO> empList = employeeService.getEmployees();
		//List<StudentVO> studentList = studentService.updateStudents();
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}

	@DeleteMapping(value="/employees/{id}")
	public ResponseEntity<List<EmployeeVO>> deleteStudent(@PathVariable("id") long id) {
		List<EmployeeVO> empList = employeeService.deleteEmployees(id);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}
	
	@DeleteMapping(value="/employees/{name}")
	public ResponseEntity<List<EmployeeVO>> deleteStudentByName(@RequestParam(value="name") String name) {
		List<EmployeeVO> empList = employeeService.deleteEmployeeByName(name);
		return new ResponseEntity<List<EmployeeVO>>(empList, HttpStatus.OK);	

	}
	
	
	
}
