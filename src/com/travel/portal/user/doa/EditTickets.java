package com.travel.portal.user.doa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.travel.portal.user.models.TravelTickets;
import com.travel.portal.user.models.UserRegistration;


public class EditTickets {

	public int update(int id,TravelTickets ticket) {
		
		Session session=new DbLink().link();
		Transaction tx=session.beginTransaction();
		try {
			TravelTickets dbTicket=session.get(TravelTickets.class, id);
		//ticket with the given id exists
		if(dbTicket!=null) {
			System.out.println("inside ticket with this id exists if block");
			Session session1=new DbLink().link();
			//getting the associated user object to populate the user attribute in ticket entity
			UserRegistration user=session1.get(UserRegistration.class,dbTicket.getUser().getId());
			session1.close();
			System.out.println("user is "+user);
			ticket.setTicketId(id);
			ticket.setUser(user);
			//update the submission date to the current date in the default pattern of database
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			ticket.setSubmission_date(LocalDate.parse(localDate.toString(), dtf));
			ticket.setStatus("RESUBMITTED");
			session.update(ticket);
			tx.commit();
			session.close();
			return 1;
			}
		//ticket with the given id doesn't exist
		else
			return 0;
		}
		catch(Exception e)
		{
			System.out.println("inside catch");
			e.printStackTrace();
			//if (tx != null)
				//tx.rollback();
			session.close();
			return -1;
		}
	}
}
