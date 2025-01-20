package com.maurya_ekart.service;

import java.util.List;

import org.apache.catalina.User;

import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.ProductCategory;
import com.maurya_ekart.domain.Products;
import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.domain.UserDto;

public interface MauryaService {

	String getName();

	UserDetails saveUsers(UserDetails users);

	LoginResult checkUserLogin(String userEmailOrMobileNumber, String password);

	ProductCategory saveCategory(ProductCategory productCategory);

	List<ProductCategory> getProductCategoryDetails(String id);

	List<ProductCategory> deleteProductCategory(String id, String categoryName);

	ProductCategory updateCategory(ProductCategory productCategory);

	String saveProductDetails(Products products, String userId);

	List<Products> getProductDetails(String id);

	UserDto getUserId(String userEmailOrMobileNumber);

	

	

}
