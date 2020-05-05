package com.travel.portal.user.doa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.travel.portal.user.models.UserCredentials;
import com.travel.portal.user.models.UserRegistration;

/**
 * This class confirms the sent credentials
 * against the data in the database
 * @author bhavneetkaur
 *
 */
public class LoginValidation {
	
	public int validate(UserCredentials credentials) {
		DbLink db=new DbLink();
		Session session=db.link();
		Criteria criteria = session.createCriteria(UserRegistration.class);
		criteria.add(Restrictions.eq("username",credentials.getUsername()));
		criteria.add(Restrictions.eq("password",credentials.getPassword()));
	    int results = criteria.list().size();
	    if(results==1) {
	    	UserRegistration user=(UserRegistration)criteria.list().get(0);
	    	return user.getId();
	    }
	    else
	    	return -1;
	    
	}

}
