package com.bridgelabz.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


//@Data
//@Getter
//@Setter
//@ToString
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class User {
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long id;
	private String emailId;
	private String password;
	
	
	
	public User() {
		super();
	}
	public User(long id, String emailId, String password) {
		super();
		this.id = id;
		this.emailId = emailId;
		this.password = password;
	}
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", emailId=" + emailId + ", password=" + password + "]";
	}

	
	
	
	

}
