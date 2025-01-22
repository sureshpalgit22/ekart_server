package com.maurya_ekart.service;

import java.util.Date;
import org.bson.types.ObjectId;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurya_ekart.config.TokenGenerator;
import com.maurya_ekart.domain.Customer;
import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.Massage;
import com.maurya_ekart.domain.Token;
import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.exception.SellerException;
import com.maurya_ekart.repository.CustomerRepository;
import com.maurya_ekart.repository.TokenRepository;

@Service
public class CustomerServiceIml implements CustomerService {
    
	@Autowired
	private CustomerRepository customerRepo;
	
	 @Autowired
	    private TokenRepository tokenRepository;
	@Override
	public String getString() {
		
		return "Hello Bhai Ji";
	}

	@Override
	public Customer signUpCustomer(Customer cutomer) {
		try {
			
			return customerRepo.save(cutomer);
		} catch (Exception e) {
	        throw new SellerException("Failed to save customer details: " + e.getMessage());

		}
		
	}

	@Override
	public Massage checkUserLogin(String userEmailOrMobileNumber, String password) {
		try {
			List<Customer> userList = customerRepo.findAll();
			Massage msg = new Massage();
			for (Customer user : userList) {
               
				if ((user.getEmail().equals(userEmailOrMobileNumber)
						|| user.getMobileNumber().equals(userEmailOrMobileNumber))
						&& user.getPassword().equals(password)) {
					user.setLoginStatus(true);
					msg.setUserId(user.getId());
					msg.setMassage(LoginResult.SUCCESS);
					msg.setUserDetais(user);
					
					Token token = new Token();
					String tokens=new TokenGenerator().generateSecureToken();
		            token.setToken(tokens);
		            
		            token.setUserEmail(user.getEmail());
		            token.setUserId(user.getId());
		            token.setExpiryDate(new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(5))); // 1-hour expiry
                    msg.setToken(tokens);
	
		            tokenRepository.save(token);
		          
				   
					
				}
			}

			if (!isValidEmailOrMobileNumber(userEmailOrMobileNumber)) {
				msg.setMassage(LoginResult.INVALID_EMAIL_OR_MOBILE_NUMBER);

			} 
			
			return msg;
		} catch (Exception e) {
			throw new SellerException("Please enter valid email & password: " + e.getMessage());

		}
		

	}
	 private boolean isValidEmailOrMobileNumber(String input) {
	        return input.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") || input.matches("^\\d{10}$");
	    }

		@Override
		public Customer validateTokenAccess(String token) {
			try {
				Token tokenDetails = tokenRepository.findByToken(token);
				Optional<Customer> cutomerDetails=null;
				if (tokenDetails != null) {
					
					 cutomerDetails = customerRepo.findByEmail(tokenDetails.getUserEmail());

				}
				
				return cutomerDetails.get();
			} catch (Exception e) {
			    throw new SellerException("Please enter valid email & password: " + e.getMessage());

			}
			
			
}
}
