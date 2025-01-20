package com.maurya_ekart.domain;

import org.springframework.data.annotation.Id;

public class Products {
@Id
private String productId;
private String productName;
private Double price;
private Double mrp;
private Double discountPercentage;
private Integer productQuantity;
private String image;
private String category;
private String description;



public String getProductId() {
	return productId;
}
public void setProductId(String productId) {
	this.productId = productId;
}
public String getProductName() {
	return productName;
}
public void setProductName(String productName) {
	this.productName = productName;
}


public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Double getMrp() {
	return mrp;
}
public void setMrp(Double mrp) {
	this.mrp = mrp;
}
public Double getDiscountPercentage() {
	return discountPercentage;
}
public void setDiscountPercentage(Double discountPercentage) {
	this.discountPercentage = discountPercentage;
}
public Integer getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(Integer productQuantity) {
	this.productQuantity = productQuantity;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}







}
