package com.travel.portal.user.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.AdminLoginValidation;
import com.travel.portal.user.models.AdminCredentials;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class AdminLoginController {
	
	@PostMapping(value = "/admin", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> postMethod(@RequestBody AdminCredentials credentials) {
		System.out.println("inside post of admin");
		AdminLoginValidation login=new AdminLoginValidation();
		boolean res=login.validate(credentials);
		Map<String,String> message=new LinkedHashMap<>();
		if(res==true) 
			 message.put("msg","valid user");
		else
			message.put("msg","not a valid user");
		
		return new ResponseEntity<>(message,HttpStatus.OK);
			
	}
}
