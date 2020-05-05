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

import com.travel.portal.user.doa.RetrievePassword;
import com.travel.portal.user.models.UserCredentials;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class ForgotPasswordController {
	
	@PostMapping(value = "/forgotPassword", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> postMethod(@RequestBody UserCredentials credentials) {
		System.out.println("inside post of forgot password");
		
		RetrievePassword getPass=new RetrievePassword();
		int res=getPass.getPassword(credentials.getUsername());
		Map<String,String> message=new LinkedHashMap<>();
		if(res==1) {
			message.put("msg","Password has been sent to your mail");
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		else
		{
			message.put("msg","The given email isnt registered");
			return new ResponseEntity<>(message,HttpStatus.OK);
		}
		
	}

}
