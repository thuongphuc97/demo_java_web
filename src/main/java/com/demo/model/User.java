package com.demo.model;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class User {
	@NotEmpty
	private String name;
	@Length(min=6,max=16)
	private String password;
	private String id;
	private String gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	}
