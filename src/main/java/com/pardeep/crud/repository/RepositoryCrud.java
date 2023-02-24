package com.pardeep.crud.repository;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.hibernate.dialect.SQLServer2012Dialect;
import org.hibernate.dialect.SQLServerDialect;
import org.hibernate.dialect.sequence.SQLServer16SequenceSupport;
import org.hibernate.grammars.hql.HqlParser.ExistsPredicateContext;
import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.pardeep.crud.controller.CustomerController;
import com.pardeep.crud.model.Customer;

@Repository

public class RepositoryCrud {

@Autowired
NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	@SuppressWarnings("unlikely-arg-type")
	public  String insert(Customer customer) {
		String sql = "INSERT INTO Customer(fname ,lname , contact , email) VALUES (:fname ,:lname ,:contact,:email )";
		MapSqlParameterSource ins = new MapSqlParameterSource();
		ins.addValue("fname",customer.getFname());
		ins.addValue("lname",customer.getLname());
		ins.addValue("contact",customer.getContact());
		ins.addValue("email",customer.getEmail());
		
//		String sql2= "select * from  Customer where email=:email";
		
//		ResultSet rs= ins.executequery(sql2);
	
		//Email validation code .................................................................................................
		String email1=customer.getEmail();
		String regexEmail = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+.com";
//		String regexEmail = "^(.+)@(.+)$";
//		String regexEmail = "^[a-zA-Z0-9_+&*-] + (?:\\.[a-zA-Z0-9_+&*-])*@(?:[a-zA-Z0-9-]+\\.) + [a-zA-Z]{2, 7}$";
		boolean resultEmail=email1.matches(regexEmail); 
	
//		validation for contact mobile number....................................................................................
		long mobile=customer.getContact();
		String p1=String.valueOf(mobile);
		String regex="[6789][0-9]{9}";
		boolean resultMobile =p1.matches(regex);
		long m2=customer.getContact();
		String storedPassword = customer.getSingleEntry(mobile,sql1);
	
			if (resultMobile) {
				if (resultEmail) {
					System.out.println("valid Email");
					int i = namedParameterJdbcTemplate.update(sql, ins);
					if (i == 1)
						return "Record inserted Succefully Please Insert next Data";
					else
						return "Record cannot be inserted";
				} else
					System.out.println("Not a Valid Email Address");
				return "Please Enter Valid Email Address";
				
			} else
				System.out.println("not a valid Number");
			return ("Please Enter valid Contact Number");
		}
		
//update-------------------------------------------------------------------------------------------------------

	public String update(Customer customer) {
		String sql = "UPDATE Customer SET fname=:fname where custId=:custId ";
		MapSqlParameterSource up = new MapSqlParameterSource();
		up.addValue("fname",customer.getFname());
		up.addValue("custId",customer.getCustId());
		int i=namedParameterJdbcTemplate.update(sql, up);
		 if(i==1)
			 return "Record Updated succefully";
		 else
			 return "Record cannot be Updated" ;

	}
	public String delete(Customer customer) {
		String sql="delete from Customer where custId=:custId";
		MapSqlParameterSource del=new MapSqlParameterSource();
		del.addValue("custId", customer.getCustId());
		
		int i=namedParameterJdbcTemplate.update(sql,del);
		if(i==1) 
			return "Record deleted Succefully";
		else
			return "Plese insert proper customer ID";
	}
	public List<Customer> search(int custId) {
		String sql="SELECT * from Customer where custId=:custId";
		HashMap<String,Object> srh=new HashMap<>();
		srh.put("custId",custId);
		return namedParameterJdbcTemplate.query(sql, srh, BeanPropertyRowMapper.newInstance(Customer.class));
	}




}
