package com.apptad.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apptad.demo.service.EmailSentService;

@RestController 
public class EmailController {
	@Autowired
	EmailSentService emailsentservice;
	@GetMapping(value="/emailsent")
	public String emailsent() {
		emailsentservice.sentmail();
		return "email sent";
	}
}
