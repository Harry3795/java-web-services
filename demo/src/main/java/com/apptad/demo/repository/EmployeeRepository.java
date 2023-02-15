package com.apptad.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.apptad.demo.model.Employee;

@Repository
public class EmployeeRepository {
	@Autowired

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	public String insert(Employee employeeModel) {
		String sql = "INSERT INTO Employee(empId, fname ,lname , address, contact,emailId) VALUES (:empId, :fname ,:lname , :address, :contact,:emailId )";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		paramap.addValue("lname",employeeModel.getLname());
		paramap.addValue("address",employeeModel.getAddress());
		paramap.addValue("contact",employeeModel.getContact());
		paramap.addValue("emailId",employeeModel.getEmailId());
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record Inserted";
		 else
			 return "Record cannot be inserted";
		 
	}
	public String update(Employee employeeModel) {
		String sql = "UPDATE Employee set fname=:fname where empId=:empId";
		MapSqlParameterSource paramap = new MapSqlParameterSource();
		paramap.addValue("empId",employeeModel.getEmpId());
		paramap.addValue("fname",employeeModel.getFname());
		
		int i=namedParameterJdbcTemplate.update(sql, paramap);
		 if(i==1)
			 return "Record updated";
		 else
			 return "Record cannot be updated";
	}
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
	
	
	}

