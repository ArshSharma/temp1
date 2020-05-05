package com.travel.portal.user.doa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.travel.portal.user.models.UserRegistration;
import com.travel.portal.user.utility.GenerateMails;

public class RetrievePassword {
	
	public int getPassword(String username) {
		Session session=new DbLink().link();
		Criteria criteria = session.createCriteria(UserRegistration.class);
		criteria.add(Restrictions.eq("username",username));
	    int results = criteria.list().size();
	    if(results!=1) {
	    	session.close();
	    	return -1;
	    }
	    else {
	    	UserRegistration user=(UserRegistration)(criteria.list().get(0));
	    	String password=user.getPassword();
	    	new GenerateMails().sendMail(username,password);
	    	session.close();
	    	return 1;
	    }
		
	}

}
