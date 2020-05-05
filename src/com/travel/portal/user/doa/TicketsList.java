package com.travel.portal.user.doa;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.travel.portal.user.models.TravelTickets;
public class TicketsList {
	
	public List<TravelTickets> getList(int userId){
		
		Session session=new DbLink().link();
		try {
		Query query = session
			    .createQuery( "From TravelTickets where user.id ="+userId );
		List<TravelTickets> ticketsList=query.list();
		session.close();
		return ticketsList;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
			return null;
		}
	}
	
	public TravelTickets getTicket(int ticketId){
		
		Session session=new DbLink().link();
		try {
		TravelTickets ticket=(TravelTickets)session.get(TravelTickets.class, ticketId);
		
		session.close();
		return ticket;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
			return null;
		}
	}

}
