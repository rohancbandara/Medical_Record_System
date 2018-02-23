package com.rcb.service;

import java.sql.ResultSet;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.Docter;
import com.rcb.model.Special;

public class DocterService {
	DbConnection db = new DbConnection();

	// insert Docter details
	public boolean putDocterData(Docter docter) {
		Special special = new Special();
		try {
			String insertDocterSQL = "INSERT INTO tbl_docters(tbl_docters.d_fname,\r\n" + "tbl_docters.d_lname,\r\n"
					+ "tbl_docters.d_dob,\r\n" + "tbl_docters.d_email,\r\n" + "tbl_docters.d_special)VALUES(" + "'"
					+ docter.getD_FName() + "'," + "'" + docter.getD_LName() + "'," + "'" + docter.getD_dob() + "',"
					+ "'" + docter.getD_email() + "'," + "'" + getSpecialId(special) + "') ";

			db.putData(insertDocterSQL);

			System.out.println("sucessfully docter Added!!!");
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("error docter Added!!!");
		}
		return false;
	}

	public int getSpecialId(Special special) {
		String getSpecialSQL = "SELECT sp_id FROM tbl_special WHERE sp_name='" + special.getSp_name() + "' ";
		int sp_idDb = 0;
		try {
			ResultSet rs = db.getData(getSpecialSQL);
			while (rs.next()) {
				sp_idDb = rs.getInt("sp_id");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sp_idDb;

	}

	public boolean deleteDocter(int did) {
		try {
			String deleteDocterSql = "DELETE FROM tbl_docters WHERE d_id='" + did + "'";
			db.putData(deleteDocterSql);
			System.out.println("sucessfully delete docter");
			return true;
		} catch (Exception e) {
			System.out.println("error delete docter");
			e.printStackTrace();
		}
		return false;
	}
}
