package com.pardeep.crud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.pardeep.crud.model.Customer;
import com.pardeep.crud.repository.RepositoryCrud;
@Service
public class UpdateService {
	@Autowired
	RepositoryCrud repo;

	public String update(Customer customer) {
		// TODO Auto-generated method stub
		return repo.update(customer);
	}

}
