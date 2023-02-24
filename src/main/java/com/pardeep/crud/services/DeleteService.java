package com.pardeep.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pardeep.crud.model.Customer;
import com.pardeep.crud.repository.RepositoryCrud;
@Service
public class DeleteService {
	@Autowired
	RepositoryCrud repo;
	public String delete(Customer customer) {
		
		return repo.delete(customer);
	}

}
