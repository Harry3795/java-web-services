package com.apptad.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSentService {
	@Autowired
	JavaMailSender javamailsender;
	public void sentmail() {
		SimpleMailMessage simpleMailMessage=new SimpleMailMessage();
		simpleMailMessage.setTo("pradeep.kumar@apptadinc.com");
		simpleMailMessage.setSubject("This is the mail service check first time");
		simpleMailMessage.setCc("priyanka.kumari@apptadinc.com","ritu.kumari@apptadinc.com");
		simpleMailMessage.setText("This mail Sent by Pradeep sharma");
		javamailsender.send(simpleMailMessage);
	}
	
	
}
