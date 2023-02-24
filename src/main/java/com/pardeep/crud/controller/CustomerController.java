package com.pardeep.crud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pardeep.crud.model.Customer;
import com.pardeep.crud.services.DeleteService;
import com.pardeep.crud.services.InsertService;
import com.pardeep.crud.services.SearchService;
import com.pardeep.crud.services.UpdateService;
@RestController
public class CustomerController {

//	@Autowired
//	InsertService insertservice;
//	@GetMapping(value="/insert1")
//	public String insert() {
//		return "index";
//		
//	}
	
	@GetMapping(value="/insert2")
	public String insert2() {
	return "welcome";			}
	
//@PostMapping
//public String userRgistration() {
//		
//	}
	
	//insert---------------------------------------------------------------------
	
	@Autowired
	InsertService insertservice;
	
	@PostMapping(value="/insert")
	
	public String insert(@RequestBody Customer customer) {
		System.out.println(customer.toString());		
		return insertservice.insert(customer);
	//	return "welcome";
		
	}
	//update---------------------------------------------------------------------
	@Autowired
	UpdateService updateService;
	@PutMapping(value="/update")
	public String update(@RequestBody Customer customer) {
		return updateService.update(customer);
	}
	//delete---------------------------------------------------------------------
	@Autowired
	DeleteService delete;
	@DeleteMapping(value="/delete")
	public String delete(@RequestBody Customer customer) {
		return delete.delete(customer);
	}
	//search---------------------------------------------------------------------
	@Autowired
	SearchService search;
	@GetMapping(value="/search")
	public List<Customer> search(@RequestParam int custId) {
		return search.search(custId);
	}


}
