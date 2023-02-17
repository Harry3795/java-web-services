package com.apptad.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apptad.demo.model.Employee;
import com.apptad.demo.service.DeleteService;
import com.apptad.demo.service.InsertService;
import com.apptad.demo.service.SearchService;
import com.apptad.demo.service.UpdateService;

@RestController
public class Testcontroller {
	
//Insert-------------------------------------------------------------------------------------------
@Autowired
InsertService insertService;
@PostMapping(value="/creating")
public String createEmployee(@RequestBody Employee employeeModel) {
	return insertService.Insert(employeeModel);
	
}
//update---------------------------------------------------------------------
@Autowired
UpdateService updateService;
@PutMapping(value="/update")
public String updateEmployee(@RequestBody Employee employeeModel) {
	return updateService.Update(employeeModel);	
}


//delete ---------------------------------------------------------------------------------
@Autowired
DeleteService deleteService;
@DeleteMapping(value="/delete")
public String deleteEmployee(@RequestBody Employee employeeModel) {
	return deleteService.Delete(employeeModel);
	
}

//search------------------------------------------------------------------------------------

@Autowired
SearchService searchService;
@GetMapping(value="/search")
public List<Employee> searchEmployee(@RequestParam String empId) {
System.out.println(empId);
		return searchService.Search(empId); 
}


//search By name -----------------------------------------------------------------------------------
@Autowired
SearchService searchServiceByName;
@GetMapping(value="/search/name")
public List<Employee> searchEmployeeName(@RequestParam String fname) {
System.out.println(fname);
		return searchServiceByName.SearchName(fname);
}

/*
 * @Autowired SearchService getAlldata;
 * 
 * @GetMapping (value="/getalldata") public List<Employee> getAllData(){ return
 * getAlldata.getAllData();
 * 
 * }
 */



	
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
		System.out.println("Key"+ " "+emp.getKey()+ " "+"value"+emp.getValue());
	}
	return "hello pradeep";	
}





}
