package com.appweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages= {"com.appweb.controllers"})
public class ApplicationWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationWebApplication.class, args);
	}

}
