package com.travel.portal.user.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.travel.portal.user.constants.Constants;

@Entity
@Table(name=Constants.ADMIN_TABLE)
public class AdminCredentials {
	
	@Id
	@GeneratedValue
	@Column(name=Constants.ADMIN_ID)
	private int admin_id;
	@Column(name=Constants.USERNAME)
	private String username;
	@Column(name=Constants.PASSWORD)
	private String password;
	
	//getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
