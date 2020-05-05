package com.travel.portal.user.doa;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.travel.portal.user.constants.Constants;
import com.travel.portal.user.models.AdminCredentials;
import com.travel.portal.user.models.TravelTickets;
import com.travel.portal.user.models.UserRegistration;
/**
 * This class creates a connection 
 * between database and the application,
 * returns a session object
 * @author bhavneetkaur
 *
 */
public class DbLink {
	
	Session session;
	public Session link() {
		// Configuring database
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure(Constants.HIBERNATE_XML).build();
		MetadataSources ms = new MetadataSources(ssr).addAnnotatedClass(UserRegistration.class)
													 .addAnnotatedClass(TravelTickets.class)
													 .addAnnotatedClass(AdminCredentials.class);
		Metadata meta = ms.getMetadataBuilder().build();
		// Defining session
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		session = factory.openSession();
		return session;
	}
}
