package com.xoriant.springbootappclientapp.resourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.xoriant.springbootappclientapp.model.Employee;

@RestController
public class ClientResourse {

	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/client/{id}")
	public Employee getRequestedData(@PathVariable int id) {
		return restTemplate.getForObject("http://localhost:8080/employeesbyid/"+id, Employee.class);
	}
}
