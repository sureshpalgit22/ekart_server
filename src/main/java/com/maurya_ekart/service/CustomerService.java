package com.maurya_ekart.service;

import com.maurya_ekart.domain.Customer;
import com.maurya_ekart.domain.LoginResult;
import com.maurya_ekart.domain.Massage;

public interface CustomerService {

	String getString();

	Customer signUpCustomer(Customer cutomer);

	Massage checkUserLogin(String userEmailOrMobileNumber, String password);

	Customer validateTokenAccess(String token);

}
