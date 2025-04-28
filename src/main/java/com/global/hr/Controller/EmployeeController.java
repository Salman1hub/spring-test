package com.global.hr.Controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.global.hr.DataJdbcHrProjectApplication;
import com.global.hr.Repositry.EmployeeRepo;
import com.global.hr.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final DataJdbcHrProjectApplication dataJdbcHrProjectApplication;
	@Autowired
	private EmployeeRepo employeerep;

	public EmployeeController(EmployeeRepo employeerep, DataJdbcHrProjectApplication dataJdbcHrProjectApplication) {
		super();
		this.employeerep = employeerep;
		this.dataJdbcHrProjectApplication = dataJdbcHrProjectApplication;
	}
@GetMapping("/count")
	public Long countemp() {
		
		
		
		return employeerep.count();
	}

@GetMapping("/{id}")
public Employee FindById(@PathVariable Long id) {
	
	
	
	return employeerep.findById(id).get();
}

@GetMapping("")
public Iterable<Employee> FindAll() {
	
	
	
	return employeerep.findAll();
}
@GetMapping("/insert")
public Employee addemp() {
	
	
	
	return employeerep.save(new Employee(null, "salman", 6000.0));
}
@GetMapping("/update")
public Employee updateemp() {
	
	
	
	return employeerep.save(new Employee(22, "salm", 9000.0));
}
@GetMapping("/filter/{name}")
public List<Employee> 	filter(@PathVariable String name) {
	
	
	
	 return employeerep.findByName(name);
}
@GetMapping("/filter/{name}/{salary}")
public List<Employee> 	filter(@PathVariable String name , @PathVariable Double salary) {
	
	
	
	 return employeerep.findByNameAndSalary(name,salary);
}
}
