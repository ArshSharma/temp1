package com.travel.portal.user.doa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.travel.portal.user.models.TravelTickets;
import com.travel.portal.user.models.UserRegistration;


public class RaiseTickets {
	
	public int submit(TravelTickets ticket,int id) {
		DbLink db=new DbLink();
		Session session=db.link();
		UserRegistration user=session.get(UserRegistration.class, id);
		session.close();
		Session session1=db.link();
		Transaction tx=session1.beginTransaction();
		try {
			ticket.setStatus("SUBMITTED");
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			ticket.setSubmission_date(LocalDate.parse(localDate.toString(), dtf));
			ticket.setUser(user);
			session1.save(ticket);
			tx.commit();
			Criteria criteria=session1.createCriteria(TravelTickets.class);
			criteria.add(Restrictions.eq("submission_date",LocalDate.parse(localDate.toString(), dtf)));
		    TravelTickets savedTicket=(TravelTickets)(criteria.list().get(0));
		    session.close();
			
			session1.close();
			return savedTicket.getTicketId();
		}catch(Exception ex) {
			if(tx!=null)
				tx.rollback();
			ex.printStackTrace();
			session1.close();
			return -1;
		}
	}

}
