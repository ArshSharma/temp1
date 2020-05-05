package com.travel.portal.user.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.UserRegistrationDb;
import com.travel.portal.user.models.UserRegistration;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class RegistrationController {
	
	@PostMapping(value = "/userRegister", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> postMethod(@RequestBody UserRegistration user) {
		
		System.out.println("inside post of registeration controller");
		System.out.println(user.getFirstname()+" "+user.getLastname()+" "+user.getEmail());
		UserRegistrationDb userReg=new UserRegistrationDb();
		int result=userReg.register(user);
		Map<String,Integer> message=new LinkedHashMap<>();
	    message.put("id", result);
	    return new ResponseEntity<>(message,HttpStatus.OK);
			
	}
	
	
	@GetMapping(value = "/user/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<UserRegistration> postMethod(@RequestBody int userId) {
		
		UserRegistrationDb userReg=new UserRegistrationDb();
		UserRegistration result=userReg.getUser(userId);
	    return new ResponseEntity<>(result,HttpStatus.OK);
			
	}

}
