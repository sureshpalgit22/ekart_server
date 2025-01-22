package com.maurya_ekart.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

import org.springframework.data.annotation.Id;


@Document(collection = "maurya_customer")
public class Customer {
@Id
private String Id;
private String name;
private String email;
private Long mobileNumber;
private String password;
private List<Products>myOrders;
private List<Role>roles;
private Boolean loginStatus;
public String getId() {
	return Id;
}
public void setId(String id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public List<Products> getMyOrders() {
	return myOrders;
}
public void setMyOrders(List<Products> myOrders) {
	this.myOrders = myOrders;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}
public Long getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(Long mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public Boolean getLoginStatus() {
	return loginStatus;
}
public void setLoginStatus(Boolean loginStatus) {
	this.loginStatus = loginStatus;
}




}
