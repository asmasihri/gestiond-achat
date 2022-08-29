package com.finalapp.finalapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.finalapp.finalapp.Entity.Role;

@SpringBootApplication
public class FinalappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalappApplication.class, args);
	}


// @Bean 
// 	CommandLineRunner start(servicesuserImp accountService){
// 		return args ->{
			
			

//         accountService.addNewRole(new Role(1 , "Validateur"));
//         accountService.addNewRole(new Role(2 , "Demandeur"));

	

// 		};
// 	}
}