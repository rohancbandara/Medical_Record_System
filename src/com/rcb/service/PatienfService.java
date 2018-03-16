package com.rcb.service;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Patient;

public class PatienfService {
	DbConnection db = new DbConnection();

	// inser patient qury
	public boolean putPatientData(Patient patient) {

		try {
			String patientPutSql = "INSERT INTO tbl_patient(p_fname,\r\n" + "p_lname,\r\n" + "p_nic,\r\n"
					+ "p_email,\r\n" + "p_gender,\r\n" + "p_dob,\r\n" + "p_blood_group,\r\n" + "p_marital,\r\n"
					+ "p_haddress,\r\n" + "p_tel,\r\n" + "p_status)VALUES(" + "'" + patient.getP_fname() + "'," + "'"
					+ patient.getP_lname() + "'," + "'" + patient.getP_nic() + "'," + "'" + patient.getP_email() + "',"
					+ "'" + patient.getP_gender() + "'," + "'" + patient.getP_dob() + "'," + "'" + patient.getP_blood()
					+ "'," + "'" + patient.getP_marital() + "'," + "'" + patient.getP_haddress() + "'," + "'"
					+ patient.getP_tel() + "'," + "'" + patient.getP_status() + "')";
			db.putData(patientPutSql);

			// -----------------------------------------------------------------------
			SendingEmail(patient);

			// -----------------------------------------------------------------------
			System.out.println("sucessfully patient Added!!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Insert Patient quary erro...!!!");

		}
		return false;
	}

	// delete patient
	public boolean deletePatient(int pid) {
		try {
			String deletePatientSql = "DELETE FROM tbl_patient WHERE p_id='" + pid + "'";
			db.putData(deletePatientSql);
			System.out.println("sucessfully delete patient");
			return true;
		} catch (Exception e) {
			System.out.println("error patient docter");
			e.printStackTrace();
		}
		return false;
	}

	// update patient
	public boolean updatePatient(Patient patient) {
		try {
			String updatePatientSql = "UPDATE tbl_patient set p_fname='" + patient.getP_fname() + "',\r\n" + "p_lname='"
					+ patient.getP_lname() + "',\r\n" + "p_nic='" + patient.getP_nic() + "',\r\n" + "p_email='"
					+ patient.getP_email() + "',\r\n" + "p_gender='" + patient.getP_gender() + "',\r\n" + "p_dob='"
					+ patient.getP_dob() + "',\r\n" + "p_blood_group='" + patient.getP_blood() + "',\r\n"
					+ "p_marital='" + patient.getP_marital() + "',\r\n" + "p_haddress='" + patient.getP_haddress()
					+ "',\r\n" + "p_tel='" + patient.getP_tel() + "',\r\n" + "p_status='" + patient.getP_status()
					+ "' WHERE p_id='" + patient.getP_id() + "'";

			db.putData(updatePatientSql);
			System.out.println("sucessfully update patient");
			return true;
		} catch (Exception e) {
			System.out.println("error patient update");
			e.printStackTrace();
		}
		return false;
	}

	public static void SendingEmail(Patient patient) {

		final String username = "rcb.medical.record.system@gmail.com";
		final String password = "rcb@1234";

		Properties props = new Properties();
		props.put("mail.smtp.auth", true);
		props.put("mail.smtp.starttls.enable", true);
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("rcb.medical.record.system@gmail.com"));// ur email
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(patient.getP_email()));// u will send
																											// to
			message.setSubject("Use this code as Sequrity code ");
			message.setText("code 000000000000000000 ");
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();

			System.out.println("sending");
			Transport.send(message);
			System.out.println("Done");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}

}
