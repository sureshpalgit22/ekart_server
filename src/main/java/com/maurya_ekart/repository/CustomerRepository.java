package com.maurya_ekart.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maurya_ekart.domain.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Optional<Customer> findByEmail(String userEmail);

	Optional<Customer> findById(ObjectId userId);

}
