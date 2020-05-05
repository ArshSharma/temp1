package com.travel.portal.user.doa;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.travel.portal.user.models.UserRegistration;

public class UpdateUser {
	
	public int update(int id,UserRegistration user) {
		Session session=new DbLink().link();
		Transaction tx=session.beginTransaction();
		try {
			//user with the given id exists
			if(session.get(UserRegistration.class, id)!=null) {
				user.setId(id);
				session.clear();
				session.update(user);
				tx.commit();
				session.flush();
				session.close();
				return 1;
			}
			//user doesnt exist
			else
				return 0;
		}catch(Exception e) {
			e.printStackTrace();
			if(tx!=null)
				tx.rollback();
			session.close();
			return -1;
		}
	}

}
