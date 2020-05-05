package com.travel.portal.user.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.RaiseTickets;
import com.travel.portal.user.models.TravelTickets;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class RaiseTicketsController {
	
	@PostMapping(value = "/tickets/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> postMethod(@PathVariable int userId,@RequestBody TravelTickets ticket) {
		System.out.println("inside post of raising tickets");
		RaiseTickets request=new RaiseTickets();
		int result=request.submit(ticket,userId);
		Map<String,Integer> message=new LinkedHashMap<>();
	    message.put("id", result);
	    return new ResponseEntity<>(message,HttpStatus.OK);
	}

}
