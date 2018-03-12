package com.rcb.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailService {
	public boolean sendingEmail(String Email, String Body) {
		String host = "smtp.gmail.com";
		String from = "test.rohan1993@gmail.com"; // sending this email
		String pass = "test.rohan"; // email Password
		Properties props = System.getProperties();
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.user", from);
		props.put("mail.smtp.password", pass);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, pass);
			}
		});
		try {
			Message message = new MimeMessage(session);

			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(Email));
			message.setSubject("Sequrity Alert !!");
			message.setText(Body);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			System.out.println("sending");
			Transport.send(message);
			System.out.println("send Sucessfully");
			return true;

		} catch (Exception e) {
			System.out.println("Error in send mail to " + Email);
			e.printStackTrace();
		}

		return false;
	}

	// public static void main(String args[]) {
	// sendingEmail("rohancbandara@gmail.com", "testing");
	// }
}
