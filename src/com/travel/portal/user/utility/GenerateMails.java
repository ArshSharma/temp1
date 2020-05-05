package com.travel.portal.user.utility;
import java.util.Properties;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
/**
 * This class is used to send 
 * system generated mails to the users
 * @author bhavneetkaur
 *
 */
public class GenerateMails {
	
	//Configuring the mail sender
	public static JavaMailSender getJavaMailSender() {
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    mailSender.setHost("smtp.gmail.com");
	    mailSender.setPort(587);
	    mailSender.setUsername("N.TravelPortal@gmail.com");
	    mailSender.setPassword("Passwordis123");
	     
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", "smtp");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	     
	    return mailSender;
	}
	//defines the template of the email
    public static SimpleMailMessage emailTemplate(String username)
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(username);
        message.setFrom("n.travelportal@gmail.com");
        message.setSubject("Nagarro Travel Portal Information");
        message.setText("Confirmation Mail");
        return message;
    }
	//Sends the confirmation mail to the registered user along with the username 
    //and system generated password
	public String sendMail(String username) 
    {
		GeneratePassword getPassword=new GeneratePassword();
		String password=getPassword.generate();
        SimpleMailMessage mailMessage = emailTemplate(username);
        mailMessage.setText("Welcome to the Nagarro Travel Portal:\r\n" + 
        		"\r\n" + "You have registered successfully" +"\r\n"+
        		"Here are your login credentials"+" \r\n" +
        		"Username: " +username +" \r\n"+ 
        		"Password:" +password + " \r\n"+
        		"\r\n" + 
        		"Please contact the Travel team if you have any questions.\r\n" + 
        		"\r\n" + 
        		"Thank you,\r\n" + 
        		"Nagarro Travel Team.\r\n" + 
        		"");
        JavaMailSender mailSender=getJavaMailSender();
        mailSender.send(mailMessage);
        return password;
    }
	//Sends the password retrieval mail in case of forgot password
	public void sendMail(String username,String password) 
    {
        SimpleMailMessage mailMessage = emailTemplate(username);
        mailMessage.setText("You have requested your user name and password for "
        		+ "your access to the Nagarro Travel Portal:\r\n" + 
        		"\r\n" + 
        		"Usename: " +username+ "\r\n"+ 
        		"Password: " +password+ "\r\n"+ 
        		"\r\n" + 
        		"Please contact the Travel team if you have any questions.\r\n" + 
        		"\r\n" + 
        		"Thank you,\r\n" + 
        		"Nagarro Travel Team.\r\n" + 
        		"");
        JavaMailSender mailSender=getJavaMailSender();
        mailSender.send(mailMessage);
    }
}
