package com.rcb.service;

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

}
