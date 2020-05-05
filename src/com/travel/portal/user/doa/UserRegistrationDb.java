package com.travel.portal.user.doa;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.travel.portal.user.models.UserRegistration;
import com.travel.portal.user.utility.GenerateMails;;

public class UserRegistrationDb {
	
	public int register(UserRegistration user) {
		System.out.println("in hereeeeeeeeeeee");
		DbLink connection=new DbLink();
		Session session=connection.link();
		Transaction tx = session.beginTransaction();
		try {
			System.out.println("in tryyyyyyyyyyyyyyyyyyyyyy");
			Criteria criteria = session.createCriteria(UserRegistration.class);
			criteria.add(Restrictions.eq("email",user.getEmail()));
		    int results = criteria.list().size();
		    if(results!=0)
		    	return -1;
		    else {
		    	GenerateMails confirmationMail=new GenerateMails();
				String generatedPassword=confirmationMail.sendMail(user.getEmail());
				user.setPassword(generatedPassword);
				user.setUsername(user.getEmail());
				session.save(user);
			    tx.commit();
			    Criteria criteria1 = session.createCriteria(UserRegistration.class);
				criteria.add(Restrictions.eq("email",user.getEmail()));
			    UserRegistration savedUser=(UserRegistration)(criteria1.list().get(0));
			    session.close();
				return savedUser.getId();
		    }
		}
		catch(Exception ex) {
			if(tx!=null)
					tx.rollback();
			session.close();
			ex.printStackTrace();
			return 0;
		}
	}
	
	public UserRegistration getUser(int userId) {
		Session session=new DbLink().link();
		UserRegistration user=session.get(UserRegistration.class, userId);
		session.close();
		return user;
	}

}
