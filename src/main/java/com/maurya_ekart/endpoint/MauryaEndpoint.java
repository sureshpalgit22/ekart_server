package com.maurya_ekart.endpoint;

import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.ProductCategory;
import com.maurya_ekart.domain.Products;
import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.domain.UserDto;
import com.maurya_ekart.service.MauryaService;

import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/maurya")
public class MauryaEndpoint {
	@Autowired
	private MauryaService mauryaService;
	
    @GetMapping("/get")
	public String getName() {
		return mauryaService.getName();
		
	}
    
    @PostMapping("/add-user")
     public Response saveUser(@RequestBody UserDetails users) {
    	UserDetails createdUser = mauryaService.saveUsers(users);
    	return Response.status(Response.Status.CREATED).entity(createdUser).build();
    }
    
    @GetMapping("/check-login")
    public LoginResult loging(@RequestParam("userEmailOrMobileNumber") String userEmailOrMobileNumber,@RequestParam("password")String password) {
		return mauryaService.checkUserLogin(userEmailOrMobileNumber,password);
    	
    }
    
    @GetMapping("/get-userId")
    public UserDto getUserId(@RequestParam("userEmailOrMobileNumber") String userEmailOrMobileNumber) {
    	return mauryaService.getUserId(userEmailOrMobileNumber);
    }
    
    @PostMapping("/save-category")
    public Response saveCategory(@RequestBody ProductCategory productCategory ) {
    	ProductCategory product = mauryaService.saveCategory(productCategory);
    	return Response.status(Response.Status.CREATED).entity(product).build();
    }
    
    @PostMapping("/update-category")
    public Response updateCategory(@RequestBody ProductCategory productCategory ) {
    	ProductCategory product = mauryaService.updateCategory(productCategory);
    	return Response.status(Response.Status.CREATED).entity(product).build();
    }
    @GetMapping("/get-category")
    public List<ProductCategory> getProductCategory(@RequestParam("id") String id){
		return mauryaService.getProductCategoryDetails(id);
    	
    }
    
    @GetMapping("/delete-category")
    public List<ProductCategory> deleteProductCategory(@RequestParam("id") String id,@RequestParam("name") String categoryName){
		return mauryaService.deleteProductCategory(id,categoryName);
    	
    }
    
    @PostMapping("/save-product")
    public String saveProductDetails(@RequestBody Products products,@RequestParam("userId") String userId){
	return mauryaService.saveProductDetails(products,userId);
    	
    }
    
    @GetMapping("/get-products")
    public List<Products> getProducts(@RequestParam("userId") String id){
		return mauryaService.getProductDetails(id);
    	
    }
    
    
    
	
}
