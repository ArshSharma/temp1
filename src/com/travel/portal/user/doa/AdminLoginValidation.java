package com.travel.portal.user.doa;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import com.travel.portal.user.models.AdminCredentials;

public class AdminLoginValidation {
	
	public boolean validate(AdminCredentials data) {
		DbLink db=new DbLink();
		Session session=db.link();
		Criteria criteria = session.createCriteria(AdminCredentials.class);
		criteria.add(Restrictions.eq("username",data.getUsername()));
		criteria.add(Restrictions.eq("password",data.getPassword()));
	    int results = criteria.list().size();
	    if(results==1)
	    	return true;
		return false;
	}

}
