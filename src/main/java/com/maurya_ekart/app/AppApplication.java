package com.maurya_ekart.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;




@SpringBootApplication
@ComponentScan(basePackages = {"com.maurya_ekart", "com.maurya_ekart.endpoint"})
@EnableMongoRepositories(basePackages = "com.maurya_ekart.repository")
public class AppApplication extends SpringBootServletInitializer{
	
	
	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}
	
	

}
