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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.LoginValidation;
import com.travel.portal.user.models.UserCredentials;
/**
 * Controller that takes care of all the 
 * requests related to login
 * @author bhavneetkaur
 *
 */
@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class LoginController {
	
	@GetMapping(value = "/user")
	public ResponseEntity<Object> getMethod() {

		System.out.println("inside get");
		String msg = "Data on its way";
		Object message = msg;
		return new ResponseEntity<Object>(message, HttpStatus.OK);
	}

	@PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity postMethod(@RequestBody UserCredentials credentials) {
		System.out.println("inside post");
		System.out.println(credentials.getUsername()+" "+credentials.getPassword()+" "+credentials);
		LoginValidation loginService=new LoginValidation();
		int userId=loginService.validate(credentials);
		Map<String,Integer> message=new LinkedHashMap<>();
	    message.put("id", userId);
		return new ResponseEntity<>(message,HttpStatus.OK);
	}

}
