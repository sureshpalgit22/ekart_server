package com.maurya_ekart.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.maurya_ekart.domain.UserDetails;

@Repository
public interface MauryaRepository extends MongoRepository<UserDetails, String>{

	Optional<UserDetails> findByEmail(String userEmailOrMobileNumber);

}
