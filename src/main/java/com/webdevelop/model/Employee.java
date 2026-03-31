package com.webdevelop.model;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.webdevelop.model.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="employee")
public class Employee {
@Id
@GeneratedValue
private int id;
private String fname;
private String lname;
@DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
private LocalDate dob;
private String phone;
private String email;
private String password;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="add_tbl")
private Address add;
private String role;

@OneToMany(cascade=CascadeType.ALL)
@JoinColumn(name="manager_tbl")
List<Manager> manager;

public List<Manager> getManager() {
	return manager;
}
public void setManager(List<Manager> manager) {
	this.manager = manager;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Address getAdd() {
	return add;
}
public void setAdd(Address add) {
	this.add = add;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}






}
