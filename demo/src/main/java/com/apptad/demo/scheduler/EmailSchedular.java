package com.apptad.demo.scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.apptad.demo.service.EmailSentService;
@Component
public class EmailSchedular {
		@Autowired
		EmailSentService emailsentserver;
		@Scheduled(cron ="*/10 * * * * *" )
		public void demoscheduler() {
			emailsentserver.sentmail();
			System.out.println("hello Pradeep");
		
			
		}
	}
	

