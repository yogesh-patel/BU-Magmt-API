package com.synerzip.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
/*
	@Query(value = "select(SELECT COUNT(emp_id) as head_count from Employee),"
			+"(SELECT COUNT(emp_id) as billable_count from BillingStatus where billable_status='billable' ),"
			+"(SELECT COUNT(emp_id) as bench_count from BillingStatus where billable_status='bench')")	
	List<DashboardDataVO> getDashboardData();
	*/
	
	List<Employee> findByempFirstNameContaining(String firstName);
	
}
