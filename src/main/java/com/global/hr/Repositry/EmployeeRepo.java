package com.global.hr.Repositry;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.global.hr.entity.Employee;
@Repository
public interface EmployeeRepo extends CrudRepository<Employee,Long> {
	List<Employee> findByName (String name);
	@Query(value="SELECT * FROM employees SELECT * FROM employees WHERE name LIKE :empname AND salary >= :empsalary")
	List<Employee> findByNameAndSalary (@Param("empname") String name,@Param("empsalary") Double salary);

}
