package com.synerzip.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	@Query("SELECT new com.synerzip.VOs.EmployeeVO(e.empId , e.empFirstName, e.empMiddleName, e.empLastName) FROM Employee e where e.empFirstName like ?1)")
	Page<EmployeeVO> getEmployeesPagenation(String string, Pageable pageRequest);
	
	/*@Query("SELECT new com.synerzip.VOs.EmployeeVO (concat_ws(t1.empFirstName,t1.empLastName) as EmployeeName),"+
			"t4.projectName,t2.billableStatus as status, (SELECT (concat_ws(t5.empFirstName,t5.empLastName))FROM Employee as t5 where t5.empId = t3.managerId) as manager) "+
			"FROM Employee as t1 "+
			"LEFT JOIN BillingStatus as t2  ON t1.empId = t2.empId "+
			"LEFT JOIN Project as t4 ON t2.projectId = t4.projectId "+  
			"LEFT JOIN EmployeeRoleMapping as t3  ON t1.empId = t3.employeeId )FROM Employee e where e.empFirstName like ?1)")
Page<EmployeeVO> getEmployees(String string, Pageable pageRequest);

*/}
