package com.apptad.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.demo.model.Employee;
import com.apptad.demo.repository.EmployeeRepository;
@Service
public class UpdateService {
	@Autowired
	EmployeeRepository employeeRepository;
	public String Update(Employee employeeModel) {
		
		return employeeRepository.update(employeeModel);
	}

}
