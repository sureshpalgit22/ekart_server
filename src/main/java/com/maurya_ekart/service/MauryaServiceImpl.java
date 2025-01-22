package com.maurya_ekart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.ProductCategory;
import com.maurya_ekart.domain.Products;
import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.domain.UserDto;
import com.maurya_ekart.exception.SellerException;
import com.maurya_ekart.repository.MauryaRepository;

@Service
public class MauryaServiceImpl implements MauryaService{
	
	@Autowired
	private MauryaRepository mauryaRpository;
	
	

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Welcome Ajay Again";
	}



	@Override
	public UserDetails saveUsers(UserDetails users) {
		return mauryaRpository.save(users);
	}



	@Override
	public LoginResult checkUserLogin(String userEmailOrMobileNumber, String password) {
		 List<UserDetails> userList = mauryaRpository.findAll();
	        for (UserDetails user : userList) {
	            if ((user.getEmail().equals(userEmailOrMobileNumber) || user.getMobileNumber().equals(userEmailOrMobileNumber)) && user.getPassword().equals(password)) {
	                return LoginResult.SUCCESS;
	            }
	        }
	        
	        if (!isValidEmailOrMobileNumber(userEmailOrMobileNumber)) {
	            return LoginResult.INVALID_EMAIL_OR_MOBILE_NUMBER;
	        } else {
	            return LoginResult.INVALID_PASSWORD;
	        }
	        
	}

	 private boolean isValidEmailOrMobileNumber(String input) {
	        return input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") || input.matches("^\\d{10}$");
	    }
	 
	 @Override
	 public UserDto getUserId(String userEmailOrMobileNumber) {
	     try {
	         Optional<UserDetails> userOptional = mauryaRpository.findByEmail(userEmailOrMobileNumber);
	         
	         if (userOptional.isPresent()) {
	             UserDetails user = userOptional.get();
	             UserDto userDetail = new UserDto();
	             userDetail.setId(user.getId());
	             return userDetail;
	         } else {
	             throw new SellerException("User not found for email or mobile number: " + userEmailOrMobileNumber);
	         }

	     } catch (Exception e) {
	         e.printStackTrace();
	         throw new SellerException("Failed to retrieve user details: " + e.getMessage());
	     }
	 }

	@Override
	public ProductCategory saveCategory(ProductCategory categoryDetails) {
	    String id = categoryDetails.getUserId();
	    
	   
	    Optional<UserDetails> users = mauryaRpository.findById(id);
	    
	    if (users.isPresent()) {
	        UserDetails user = users.get();
	        
	       
	        ProductCategory cd = new ProductCategory();
	        cd.setCategoryName(categoryDetails.getCategoryName()); 
	        cd.setCategoryImage(categoryDetails.getCategoryImage());
	        Random random = new Random();
	        int randomNumber = 1000 + random.nextInt(9000);
	        
	        String categoryId = categoryDetails.getCategoryName().substring(0, 3).toUpperCase() + randomNumber;
	        cd.setCategoryId(categoryId);
	        cd.setUserId(id);
	        
	        List<ProductCategory> productCategories = user.getProductCategory();
	        if (productCategories == null) {
	            productCategories = new ArrayList<>();
	        }
	        productCategories.add(cd);  
	        
	        
	        user.setProductCategory(productCategories);
	        
	     
	        mauryaRpository.save(user);  
	        return cd;  
	    }
	    
	   
	    return null;
	}



	@Override
	public List<ProductCategory> getProductCategoryDetails(String id) {
		 Optional<UserDetails> users = mauryaRpository.findById(id);
		 List<ProductCategory> categories=new ArrayList<>();
		 if (users.isPresent()) {
		        UserDetails user = users.get();
		        categories=user.getProductCategory();
		 }
		 
		return categories;
	}



	public List<ProductCategory> deleteProductCategory(String id, String categoryName) {
	    Optional<UserDetails> users = mauryaRpository.findById(id);
	    List<ProductCategory> categories = new ArrayList<>();
	    
	    if (users.isPresent()) {
	        UserDetails user = users.get();
	        categories = user.getProductCategory();
	      
	        categories.removeIf(category -> category.getCategoryName().equalsIgnoreCase(categoryName));
	        
	        mauryaRpository.save(user);
	    }

	    return categories;
	}


@Override
	public ProductCategory updateCategory(ProductCategory productCategory) {
	    String userId = productCategory.getUserId();
	    String categoryId = productCategory.getCategoryId();
	    
	    
	    Optional<UserDetails> users = mauryaRpository.findById(userId);
	    
	    if (users.isPresent()) {
	        UserDetails user = users.get();
	        
	       
	        List<ProductCategory> productCategories = user.getProductCategory();
	        
	      
	        if (productCategories == null) {
	            productCategories = new ArrayList<>();
	        }
	        
	        for (ProductCategory category : productCategories) {
	            if (category.getCategoryId().equals(categoryId)) {
	                category.setCategoryName(productCategory.getCategoryName());
	                category.setCategoryImage(productCategory.getCategoryImage());
	                break;
	            }
	        }
	        
	       
	        mauryaRpository.save(user);
	        
	        return productCategory; 
	    }
	    
	    return null;
	}



public String saveProductDetails(Products products, String userId) {
    Optional<UserDetails> userOptional = mauryaRpository.findById(userId);

    if (!userOptional.isPresent()) {
        throw new SellerException("User not found with ID: " + userId);
    }

    UserDetails userDetails = userOptional.get();

    if (userDetails.getProducts() == null) {
        userDetails.setProducts(new ArrayList<>());
    }

    List<Products> productList = userDetails.getProducts();

    Random random = new Random();
    int randomNumber = 1000 + random.nextInt(9000);
    
    String productId = products.getProductName().substring(0, 3).toUpperCase() + randomNumber;
    
    Products productDetails = new Products();
    productDetails.setProductName(products.getProductName());
    productDetails.setCategory(products.getCategory());
    productDetails.setImage(products.getImage());
    productDetails.setMrp(products.getMrp());
    productDetails.setProductQuantity(products.getProductQuantity());
    productDetails.setProductId(productId);
    productDetails.setDescription(products.getDescription());
    productDetails.setDiscountPercentage(calculateDiscount(products.getMrp(),products.getPrice()));    
    
  

    productDetails.setPrice(products.getPrice());

    productList.add(productDetails);

   
    try {
        mauryaRpository.save(userDetails);
    } catch (Exception e) {
        throw new SellerException("Failed to save product details: " + e.getMessage());
    }

    return "Product details saved successfully.";
}





private double calculateDiscount(Double mrp, Double price) {
    if (mrp == null || price == null) {
        return 0.0;
    }

    try {
        if (mrp <= 0 || price <= 0 || price > mrp) {
            return 0.0; 
        }

        double discountPercentage = ((mrp - price) / mrp) * 100;
        return Math.round(discountPercentage * 100.0) / 100.0; 
    } catch (Exception e) {
        return 0.0; 
    }
}


@Override
public List<Products> getProductDetails(String id) {
 Optional<UserDetails> users = mauryaRpository.findById(id);
 List<Products> products=new ArrayList<>();
 
 if(users.isPresent()) {
	 UserDetails user = users.get();
	 products=user.getProducts();
 }
	
	return products;
}


@Override
public List<Products> getAllProductDetails() {
    try {
        
        List<UserDetails> users = mauryaRpository.findAll();
        List<Products> products = new ArrayList<>();

        
        if (!users.isEmpty()) {
         
            for (UserDetails user : users) {
                products.addAll(user.getProducts());
            }
        }

        return products;
    } catch (Exception e) {
    	 throw new SellerException("Failed to get products details: " + e.getMessage());
    }
}



public Products getProductById(String productId) {
    try {
       
        List<UserDetails> users = mauryaRpository.findAll();
        Products details = null; // To store the matching product
        
        if (!users.isEmpty()) {
            for (UserDetails user : users) {
                
                for (Products product : user.getProducts()) {
                  
                    if (productId.equals(product.getProductId())) {
                        details = product; 
                        break;
                    }
                }
                if (details != null) {
                    break; 
                }
            }
        }

       
        return details;
    } catch (Exception e) {
        throw new SellerException("Failed to get product details: " + e.getMessage());
    }
}







    





}
