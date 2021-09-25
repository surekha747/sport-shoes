package com.simplilearn.sportyshoes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="signedup_users")
public class SignedUsers {
public SignedUsers() {
		super();
		// TODO Auto-generated constructor stub
	}
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column
private String first_name;
@Column
private String last_name;
@Column
private String email;
@Column
private String contact_no;
@Column
private String address;
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public SignedUsers(String first_name, String last_name, String email, String contact_no,String address) {
	super();
	this.first_name = first_name;
	this.last_name = last_name;
	this.email = email;
	this.contact_no = contact_no;
	this.address=address;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getContact_no() {
	return contact_no;
}
public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}
}
