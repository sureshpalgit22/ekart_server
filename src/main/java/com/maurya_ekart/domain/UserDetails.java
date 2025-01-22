package com.maurya_ekart.domain;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "maurya_users")
public class UserDetails {
	
@Id
private String id;
private String name;
private String email;
private String mobileNumber;
private String password;
private List<Products>products;
private List<Role>roles;
private List<ProductCategory>productCategory;


public List<ProductCategory> getProductCategory() {
	return productCategory;
}
public void setProductCategory(List<ProductCategory> productCategory) {
	this.productCategory = productCategory;
}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public List<Products> getProducts() {
	return products;
}
public void setProducts(List<Products> products) {
	this.products = products;
}
public List<Role> getRoles() {
	return roles;
}
public void setRoles(List<Role> roles) {
	this.roles = roles;
}




}
