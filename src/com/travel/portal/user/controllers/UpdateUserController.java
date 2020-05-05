package com.travel.portal.user.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.UpdateUser;
import com.travel.portal.user.models.UserRegistration;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class UpdateUserController {
	
	@PutMapping(value = "/userUpdate/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> edit(@PathVariable int id,@RequestBody UserRegistration user) {
		System.out.println("inside put method");
		System.out.println("id is "+id);
		int res=new UpdateUser().update(id,user);
		if(res==0)
			return new ResponseEntity<>("invalid id",HttpStatus.OK);
		else if(res==1)
			return new ResponseEntity<>("user info is updated",HttpStatus.OK);
		else
			return new ResponseEntity<>("user info could not be updated",HttpStatus.OK);	
	}

}
