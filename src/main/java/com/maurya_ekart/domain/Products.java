package com.maurya_ekart.domain;

import java.util.List;

import org.springframework.data.annotation.Id;

public class Products {
@Id
private String productId;
private String productName;
private Double price;
private Double mrp;
private Double discountPercentage;
private Integer productQuantity;
private List<String> image;
private String category;
private String description;
private String brand;
private String quantityUnit;
private String colour;
private String deliveryCharge;



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
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getQuantityUnit() {
	return quantityUnit;
}
public void setQuantityUnit(String quantityUnit) {
	this.quantityUnit = quantityUnit;
}
public String getColour() {
	return colour;
}
public void setColour(String colour) {
	this.colour = colour;
}
public List<String> getImage() {
	return image;
}
public void setImage(List<String> image) {
	this.image = image;
}
public String getDeliveryCharge() {
	return deliveryCharge;
}
public void setDeliveryCharge(String deliveryCharge) {
	this.deliveryCharge = deliveryCharge;
}










}
