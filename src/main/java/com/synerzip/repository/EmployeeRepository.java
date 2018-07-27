package com.synerzip.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.synerzip.VOs.EmployeeVO;
import com.synerzip.model.Employee;

public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
	
		
	@Query("SELECT new com.synerzip.VOs.EmployeeVO(e.empId , e.empFirstName, e.empMiddleName, e.empLastName) FROM Employee e where e.empFirstName like ?1)")
	Page<EmployeeVO> getEmployeesPagenation(String string, Pageable pageRequest);
	
}
