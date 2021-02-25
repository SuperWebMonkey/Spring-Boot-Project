package com.example.demo.registration;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
public class Group {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long groupId;
	private String groupName;
	
	public Group(String groupName) {
		this.setGroupName(groupName);
	}
	
	// For one to many relationship where Group can 
	// have many users
	@OneToMany(cascade = CascadeType.ALL, mappedBy="group")
	private List<User> users;
	
	public long getGroupId() {
		return groupId;
	}
	
	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
}
