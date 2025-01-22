package com.maurya_ekart.domain;

public class Massage {
private String userId;
private LoginResult massage;
private Customer userDetais;
private String token;

public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public LoginResult getMassage() {
	return massage;
}
public void setMassage(LoginResult massage) {
	this.massage = massage;
}
public Customer getUserDetais() {
	return userDetais;
}
public void setUserDetais(Customer userDetais) {
	this.userDetais = userDetais;
}
public String getToken() {
	return token;
}
public void setToken(String token) {
	this.token = token;
}




}
