package com.travel.portal.user.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.portal.user.doa.TicketsList;
import com.travel.portal.user.models.TravelTickets;

@CrossOrigin(value="*",origins="*",allowedHeaders="*",methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
@RestController
public class TicketsListController {
	
	@GetMapping(value = "/tickets/list/{userId}")
	public ResponseEntity<List<TravelTickets>> getMethod(@PathVariable int userId) {

		System.out.println("inside ticket get");
		TicketsList tickets=new TicketsList();
		List<TravelTickets> list=tickets.getList(userId);
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
	@GetMapping(value = "/tickets/{ticketId}")
	public ResponseEntity<TravelTickets> getTicketMethod(@PathVariable int ticketId) {

		TicketsList tickets=new TicketsList();
		TravelTickets ticket=tickets.getTicket(ticketId);
		return new ResponseEntity<>(ticket,HttpStatus.OK);
	}

}
