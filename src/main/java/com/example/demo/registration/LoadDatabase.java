package com.example.demo.registration;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// https://spring.io/guides/gs/accessing-data-jpa/

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
  @Bean
  CommandLineRunner initDatabase(UserRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new User("user1", "password")));
      log.info("Preloading " + repository.save(new User("user2", "password2")));
      log.info("Preloading " + repository.save(new User("user3", "password3")));
      log.info("Preloading " + repository.save(new User("user4", "password4")));
      
   // fetch all users
      log.info("Users found with findAll():");
      log.info("-------------------------------");
      for (User user : repository.findAll()) {
        log.info(user.toString());
      }
      log.info("");

      // fetch an individual user by ID
      List<User> user = repository.findById(1L);
      log.info("User found with findById(1L):");
      log.info("--------------------------------");
      log.info(user.toString());
      log.info("");

      // fetch customers by user name
      log.info("User found with findByUsertName('user1'):");
      log.info("--------------------------------------------");
      repository.findByUserName("user1").forEach(user1 -> {
        log.info(user1.toString());
      });
      // for (Customer user : repository.findByLastName("user1")) {
      //  log.info(user1.toString());
      // }
      log.info("");
    };
  }
}