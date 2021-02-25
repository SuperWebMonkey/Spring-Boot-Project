package com.example.demo.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// https://www.codejava.net/frameworks/spring-boot/user-registration-and-login-tutorial
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	// Fetch users by username
	List<User> findByUserName(String userName);
	// Fetch users by email
	List<User> findByEmail(String email);
	// Fetch users by id
	List<User> findById(long id);
}
