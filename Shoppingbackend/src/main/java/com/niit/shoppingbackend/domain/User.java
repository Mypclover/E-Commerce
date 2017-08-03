package com.niit.shoppingbackend.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

@Entity   // to map the data base table
@Table(name ="User")  //if the table name and domain class name is different
@Component   //context.scan("com.niit") --will scan the package and create singleton instances
public class User {
	
	//we have define all properties for all the fields in table.
	
	
	//we have mention which one is primary key
	@Id
	private String id;
	
	@Column(name="name")  // if the field name in table and property name in class is
							// Different, then we required specify column name
		                   // Otherwise no need specify
	@NotEmpty(message="user name should not be empty")
	private String name;
	
	private String password;
	
	@NotEmpty(message="User contact Should not be empty")
	private String contact;
	
	private String role;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	//@Min(2)
	//@Max(15)
	
	
}
