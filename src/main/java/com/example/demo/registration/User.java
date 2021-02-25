package com.example.demo.registration;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import jdk.jshell.spi.ExecutionControl.UserException;

//https://spring.io/guides/tutorials/rest/

@Entity
public class User  {

    @Id 
    @GeneratedValue (strategy=GenerationType.AUTO) 
    private Long id;
    @Column(unique=true) // prevents users from using the same email for multiple registrations
    private String userName;
    private String email;
    
    // For many to one relationship where users
    // can be part of one group
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="group")
    private Group group;
    
    User() {}
    
    public User(String userName, String email) {
    	this.setUserName(userName);
    	this.setEmail(email);
    }
    
    public User(String userName, String email, Group group) {
    	this.setUserName(userName);
    	this.setEmail(email);
    	this.setGroup(group);
    }
    
    public Long getId() {
    	return this.id;
    }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Group getGroup() {
		return group;
	}
	
	public void setGroup(Group group) {
		this.group = group;
	}
    
    @Override
    public boolean equals(Object o) {
    	if (this == o)
    		return true;
    	if (!(o instanceof User))
    		return false;
    	User user = (User) o;
    	return Objects.equals(this.id, user.id) &&
    			Objects.equals(this.userName, user.userName);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(this,id, this.userName);
    }
    
    @Override
    public String toString() {
    	return "user{" + this.id + ", user name=" + this.userName +
    			"}";
    }
}