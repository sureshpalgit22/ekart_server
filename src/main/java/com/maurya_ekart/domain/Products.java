package com.maurya_ekart.domain;

import org.springframework.data.annotation.Id;

public class Products {
@Id
private String productId;
private String productName;
private String price;
private String mrp;
private String discountPercentage;
private String productQuantity;
private byte[] image;
private String category;

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
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getMrp() {
	return mrp;
}
public void setMrp(String mrp) {
	this.mrp = mrp;
}
public String getDiscountPercentage() {
	return discountPercentage;
}
public void setDiscountPercentage(String discountPercentage) {
	this.discountPercentage = discountPercentage;
}
public String getProductQuantity() {
	return productQuantity;
}
public void setProductQuantity(String productQuantity) {
	this.productQuantity = productQuantity;
}
public byte[] getImage() {
	return image;
}
public void setImage(byte[] image) {
	this.image = image;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}



}
