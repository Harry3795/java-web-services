package com.apptad.demo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apptad.demo.model.Employee;
import com.apptad.demo.service.InsertService;
@RestController
public class Testcontroller {
	

@Autowired
InsertService insertService;
@PostMapping(value="/creating")
public String createEmployee(@RequestBody Employee employeeModel) {
	return insertService.Insert(employeeModel);
	
}

	
	
	
@GetMapping(value="/test1")
public String Test1() {
	return "hii";
}

@GetMapping(value="/test2")
public String Test2() {
	return "hii pradeep";
}

@GetMapping(value="/test3")
public String Test3(@RequestParam String fname,@RequestParam String lname) {
	return fname + lname;
}
@PostMapping(value="/test4")
public String Test4(@RequestBody String details) {
	System.out.println(details);
	return details;
}
@PostMapping(value="/test5")
	public String Test5(@RequestBody Employee emp) {
		System.out.println(emp);
		return "hello Panda";
}

@GetMapping(value="id/{name}")
	public String test6(@PathVariable String name) {
		return name;
}
@PostMapping(value="/test7")
public String Test7(@RequestBody Employee emp) {
	System.out.println(emp);
	return emp.toString();
}
@PostMapping(value="/test8")
public String Test8(@RequestBody Map<String, String> mymap) {
	for(Map.Entry<String, String> emp:mymap.entrySet()) {
		System.out.println("Key"+ " "+emp.getKey()+ "value"+emp.getValue());
	}
	return "hello Panda";	
}





}
