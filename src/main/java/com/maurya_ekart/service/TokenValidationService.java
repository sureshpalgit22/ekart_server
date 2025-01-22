package com.maurya_ekart.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurya_ekart.domain.Token;
import com.maurya_ekart.repository.TokenRepository;

@Service
public class TokenValidationService {
	 @Autowired
	    private TokenRepository tokenRepository;

	    public boolean validateToken(String token) {
	        Token storedToken = tokenRepository.findByToken(token);

	        if (storedToken == null) {
	            return false; // Invalid token
	        }

	        if (storedToken.getExpiryDate().before(new Date())) {
	            return false; 
	        }

	        return true; // Token is valid
	    }
}
