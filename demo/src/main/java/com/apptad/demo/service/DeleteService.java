package com.apptad.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apptad.demo.model.Employee;
import com.apptad.demo.repository.EmployeeRepository;
@Service
public class DeleteService {
	@Autowired
	EmployeeRepository employeeRepository;
	public String Delete(Employee employeeModel) {
		
		return employeeRepository.delete(employeeModel);
	}

}
