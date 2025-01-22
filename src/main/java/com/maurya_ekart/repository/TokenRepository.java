package com.maurya_ekart.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.maurya_ekart.domain.Token;

public interface TokenRepository extends MongoRepository<Token, String>{

	Token findByToken(String token);

}
