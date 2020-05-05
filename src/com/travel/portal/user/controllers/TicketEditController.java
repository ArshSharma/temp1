package com.travel.portal.user.controllers;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.EditTickets;
import com.travel.portal.user.models.TravelTickets;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.PATCH})
@RestController
public class TicketEditController {
	
	@PatchMapping(value = "/ticketEdit/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public static ResponseEntity<Object> edit(@PathVariable int id,@RequestBody TravelTickets ticket) {
		
		int res=new EditTickets().update(id,ticket);
		
		Map<String,Integer> message=new LinkedHashMap<>();
	    message.put("id", res);
	    return new ResponseEntity<>(message,HttpStatus.OK);
	}


}
