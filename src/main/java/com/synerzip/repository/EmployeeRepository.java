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

}
