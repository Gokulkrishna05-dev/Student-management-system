package com.servlets;
import jakarta.mail.*;
import jakarta.mail.internet.*;


import java.util.*;


public class Emaildemo {
	public static void main(String[] args) {
		sendMail("Srinivasan","Marimuthu","vysri@100","9943","srinivysri@gmail.com");
	}

	public static void sendMail(String name,String last,String net,String password,String gmail) {
//		SMTP  = Standard Mail Transfer Protocal
		
		String from="gokulkrishhh0504@gmail.com";
		String to=gmail;
		String pass="ytqe krqx zsxd uepc";
		
//		Properties object strores the all configuration settings for connecting to your email server
		Properties prop=new Properties();
//		Enables Authentication
		prop.put("mail.smtp.auth","true" );
		
//		Enables Starttls
		prop.put("mail.smtp.starttls.enable", "true");
		
//		Gmail host
		prop.put("mail.smtp.host", "smtp.gmail.com");
		
//		Gmail port
		prop.put("mail.smtp.port", "587");
		
//		Creating session
		Session ses=Session.getInstance(prop,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from,pass);
		};
		});
		
//		Creating the message
		try {
			Message msg=new MimeMessage(ses);
			msg.setFrom(new InternetAddress(from));
			msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			msg.setSubject("Student credintials");
			msg.setText("Hi "+name+" "+last+",\r\n"
					+ "\r\n"
					+ "Here are your login details for the student portal — please do not share them.\r\n"
					+ "\r\n"
					+ "NET ID: "+net+"\r\n"
					+ "\r\n"
					+ "password: "+password+"\r\n"
					+ "\r\n"
					+ "Use these to login in student portal."
					+ "\r\n"
					+ "If you can’t login, reply to this email.\r\n"
					+ "\r\n"
					+ "Thanks,\r\n"
					+ "Admin");
			Transport.send(msg);
			System.out.println("Message sent to "+to);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("Email does not send");
		}
		
	}
}
