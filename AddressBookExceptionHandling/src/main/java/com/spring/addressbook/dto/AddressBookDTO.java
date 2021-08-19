package com.spring.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

public class AddressBookDTO 
{
	private String name;
	private String address;
	private String city;
	private String zip;
	private String email;
	private String phone;
	public AddressBookDTO(String name, String address, String city, String zip, String email, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.email = email;
		this.phone = phone;
	}
	
	public AddressBookDTO()
	{
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
