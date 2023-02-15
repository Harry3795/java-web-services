package com.apptad.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.demo.model.Employee;
import com.apptad.demo.repository.EmployeeRepository;
@Service
public class SearchService {
	@Autowired
	EmployeeRepository employeeRepository;
	public String Search(Employee employeeModel) {
		
		return employeeRepository.search(employeeModel);
	}

}
