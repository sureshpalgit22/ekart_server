package com.maurya_ekart.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maurya_ekart.domain.Customer;
import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.Massage;
import com.maurya_ekart.domain.Token;
import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.repository.TokenRepository;
import com.maurya_ekart.service.CustomerService;

import jakarta.ws.rs.core.Response;

@RestController
@RequestMapping("/customer")
public class CustomerEndPoint {

	@Autowired
	private CustomerService service;
	
	 @Autowired
	    private TokenRepository tokenRepository;
	
	
	@GetMapping("/get")
	public String getName() {
		return service.getString();
		
	}
	
	@PostMapping("/registor")
	public Response signUpCustomer(@RequestBody Customer cutomer) {
		Customer customerDetails=service.signUpCustomer(cutomer);
    	return Response.status(Response.Status.CREATED).entity(customerDetails).build();
	}
	
	 @GetMapping("/check-customer-login")
	    public Massage checkCustomerLogin(@RequestParam("userEmailOrMobileNumber") String userEmailOrMobileNumber,@RequestParam("password")String password) {
			return service.checkUserLogin(userEmailOrMobileNumber,password);
	    	
	    }
	
	 @PostMapping("/logout")
	    public ResponseEntity<?> logout(@RequestHeader("Authorization") String token) {
	        Token storedToken = tokenRepository.findByToken(token);
	        if (storedToken != null) {
	            tokenRepository.delete(storedToken);
	            return ResponseEntity.ok("Logged out successfully");
	        }
	        return ResponseEntity.status(400).body("Invalid token");
	    }
	 
	@GetMapping("/validate-access")
	public Customer validateTokenAccess(@RequestParam("token") String token) {
		return service.validateTokenAccess(token);
	}
	
	


    
}
