package com.maurya_ekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maurya_ekart.domain.UserDetails;
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

	

}
