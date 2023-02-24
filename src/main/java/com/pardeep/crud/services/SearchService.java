package com.pardeep.crud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pardeep.crud.model.Customer;
import com.pardeep.crud.repository.RepositoryCrud;
@Service
public class SearchService {
	@Autowired
	RepositoryCrud repo;
	public List<Customer> search(int custId) {
	
		return repo.search(custId);
	}

}
