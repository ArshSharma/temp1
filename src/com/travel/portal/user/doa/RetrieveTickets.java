package com.travel.portal.user.doa;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.travel.portal.user.models.TravelTickets;

public class RetrieveTickets {
	
	public List<TravelTickets> retrieve(){
		Session session=new DbLink().link();
		try {
			Query query = session.createQuery("from TravelTickets");
			List<TravelTickets> ticketsList=query.getResultList();
			session.close();
			return ticketsList;
		}catch(Exception ex) {
			ex.printStackTrace();
			session.close();
			return null;
		}
	}

}
