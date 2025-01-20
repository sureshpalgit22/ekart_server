package com.maurya_ekart.domain;

import org.springframework.data.annotation.Id;

/**
 * 
 */
public class ProductCategory {
	
@Id
private String categoryId;
private String categoryName;
private String categoryImage;
private String userId;




public String getCategoryId() {
	return categoryId;
}
public void setCategoryId(String categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryImage() {
	return categoryImage;
}
public void setCategoryImage(String categoryImage) {
	this.categoryImage = categoryImage;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}




}
