package com.maurya_ekart.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maurya_ekart.domain.UserDetails;
import com.maurya_ekart.service.MauryaService;

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
	
}
