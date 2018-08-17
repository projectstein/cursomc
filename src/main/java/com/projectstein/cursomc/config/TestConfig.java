package com.projectstein.cursomc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.projectstein.cursomc.services.DBService;
import com.projectstein.cursomc.services.EmailService;
import com.projectstein.cursomc.services.MockEmailService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		
		dbService.instatiateTestDatabase();
		
		return true;
	}
	
	@Bean
	public EmailService emailService(){
		return new MockEmailService();
	}

}
