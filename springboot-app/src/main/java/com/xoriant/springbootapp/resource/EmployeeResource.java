package com.xoriant.springbootapp.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xoriant.springbootapp.model.Employee;
import com.xoriant.springbootapp.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class EmployeeResource {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/employees") //@RequestMapping(value= "/employees", method = RequestMethod.POST)
	public List<Employee> getEmployees() {
		return employeeService.getEmployees();
	}

	@GetMapping("/employeesbyid/{id}") 
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/employeesbyname/{name}") 
	public Employee getEmployeeByName(@PathVariable String name) {
		return employeeService.getEmployeeByName(name);
	}

	@PostMapping("/employees") 
	public void addEmployee(@RequestBody Employee employee) {
		employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employees/{id}") 
	public void updateEmployee(@PathVariable int id,@RequestBody Employee employee) {
		employeeService.updateEmployee(employee,id);
	}
	
	@DeleteMapping("/employees/{id}") 
	public void deleteEmployee(@PathVariable int id) {
		employeeService.deleteEmployee(id);
	}
}
