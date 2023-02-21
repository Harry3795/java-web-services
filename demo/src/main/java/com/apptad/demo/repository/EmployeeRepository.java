  package com.apptad.demo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apptad.demo.DemoApplication;
import com.apptad.demo.model.Employee;
import com.fasterxml.jackson.databind.BeanProperty;

@Repository
public class EmployeeRepository {
	@Autowired
	//INSERT--------------------------------------------------------------------------------------
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public String insert(Employee employeeModel) {
		String sql = "INSERT INTO Emp(fname ,lname , address, contact,emailId) VALUES (:fname ,:lname , :address, :contact,:emailId )";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
//		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		paramap.addValue("lname",employeeModel.getLname());
		paramap.addValue("address",employeeModel.getAddress());
		paramap.addValue("contact",employeeModel.getContact());
		paramap.addValue("emailId",employeeModel.getEmailId());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record Inserted";
		 else
			 return "Record cannot be inserted" ;
		 
	}
	//UPDATE -----------------------------------------------------------------------------------------------------------
	public String update(Employee employeeModel) {
		String sql = "UPDATE Employee set fname=:fname,lname=:lname,address=:address,contact=:contact,emailId=:emailId where empId=:empId";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		paramap.addValue("lname",employeeModel.getLname());
		paramap.addValue("address",employeeModel.getAddress());
		paramap.addValue("contact",employeeModel.getContact());
		paramap.addValue("emailId",employeeModel.getEmailId());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record updated";
		 else
			 return "Record cannot be updated";
	}
	//DELETE---------------------------------------------------------------------------------------------------------------------------
	public String delete(Employee employeeModel) {
		String sql = "DELETE from Employee where empId=:empId and fname=:fname";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record Deleted";
		 else
			 return "Record cannot be Deleted";
	}
//	//SEARCH----------------------------------------------------------------------------------------------------------------
	public List<Employee> search(String  empId) {
		String sql = "SELECT * FROM Employee where empId=:empId";
		Map<String, Object> paramap=new HashMap<>();
		paramap.put("empId", empId);
		return namedParameterJdbcTemplate.query(sql, paramap, BeanPropertyRowMapper.newInstance(Employee.class));
//			 return employeeModel.getEmpId()+" "+employeeModel.getFname()+" "+employeeModel.getLname()+" "+employeeModel.getAddress()+" "+employeeModel.getContact()+" "+
//			 employeeModel.getEmailId();
		 
	
		
	}
//	public List<Employee> getAllData() {
//		String sql="select * from employee";
//		NamedParameterJdbcTemplate jdbcTemplate;
//		return jdbcTemplate.query("SELECT * from Employee", BeanPropertyRowMapper.newInstance(Employee.class));
//		
//		}
//	search by name ------------------------------------------------------------------------------------------------
	public List<Employee> searchByName(String fname) {
		String sql = "SELECT * FROM Employee where fname=:fname";
		Map<String, Object> paramap=new HashMap<>();
		paramap.put("fname", fname);
		return namedParameterJdbcTemplate.query(sql, paramap, BeanPropertyRowMapper.newInstance(Employee.class));
	}
	
	
	}

