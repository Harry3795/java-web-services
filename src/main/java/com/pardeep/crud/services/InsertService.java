package com.pardeep.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pardeep.crud.model.Customer;
import com.pardeep.crud.repository.RepositoryCrud;



@Service
public class InsertService {
	@Autowired
	RepositoryCrud repo;
	
	
	public String insert(Customer customer) {
		
		if(repo.equals(customer.getContact())) {
			
			return "Data is Already exists";
		}
		else
			return repo.insert(customer);
					
	}
	
}
