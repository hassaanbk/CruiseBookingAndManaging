package com.micro.service;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

	@Id
	private int custId;
	//@NotBlank(message = "First Name is mandatory")
	private String firstName;
	private String lastName;
	//@NotBlank(message = "Address is mandatory")
	private String address;
	//@NotBlank(message = "City is mandatory")
	private String city;
	//@NotBlank(message = "Country is mandatory")
	private String country;
	//@NotBlank(message = "Phone is mandatory")
	private float phone;
	//@NotBlank(message = "Email is mandatory")
	private String email;
	//@NotBlank(message = "Password is mandatory")
	private String password;
	
	public Customer() {
		
	}

	public Customer(int custId, String firstName, String lastName, String address, String city, String country,
			float phone, String email, String password) {
		super();
		this.custId = custId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public float getPhone() {
		return phone;
	}

	public void setPhone(float phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
