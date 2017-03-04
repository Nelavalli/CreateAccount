package com.dbs.capi;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CreateAccount {

	@Autowired
	CamelContext camelContext;
	
	public static void main(String[] args) {
		SpringApplication.run(CreateAccount.class, args);

	}

}