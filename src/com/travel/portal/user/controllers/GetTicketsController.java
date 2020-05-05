package com.travel.portal.user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.RetrieveTickets;
import com.travel.portal.user.models.TravelTickets;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class GetTicketsController {
	
	@GetMapping(value = "/admin/tickets")
	public ResponseEntity<Object> getMethod() {
		System.out.println("inside get of admin get tickets");
		RetrieveTickets data=new RetrieveTickets();
		List<TravelTickets> tickets=data.retrieve();
		return new ResponseEntity<>(tickets, HttpStatus.OK);
	}


}
