package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;

import com.example.demo.registration.Group;
import com.example.demo.registration.GroupRepository;
import com.example.demo.registration.User;
import com.example.demo.registration.UserRepository;

@SpringBootApplication
@ConfigurationPropertiesScan
public class DemoApplication {
	
	@Autowired // Enables dependency injection. The dependency injection allows us to pass dependencies into an object.
	private UserRepository repository;
	
	@Autowired
	private GroupRepository grepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	//CommandLinerRunner allows us to execute additional code before application
	//has fully started.
	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Adding groups to the db
			Group group1 = new Group("group1");
			Group group2 = new Group("group2");
			grepository.save(group1);
			grepository.save(group2);
			
			// Add users to the groups
			repository.save(new User("username1", "email1@gmail.com", group1));
			repository.save(new User("username2", "email2@gmail.com", group1));
			repository.save(new User("username3", "email3@gmail.com", group2));
		};
	}

}
