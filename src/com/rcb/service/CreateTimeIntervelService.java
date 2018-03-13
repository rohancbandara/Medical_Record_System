package com.rcb.service;

import com.rcb.dbconnection.DbConnection;
import com.rcb.model.TimeIntervel;

public class CreateTimeIntervelService {

	public static boolean createTable(TimeIntervel tI) {
		DbConnection db = new DbConnection();
		try {
			String sql = "INSERT INTO tbl_tables values('" + tI.getTbl_id() + "','" + tI.getdId() + "','" + tI.getDate()
					+ "','" + tI.getFromTime() + "','" + tI.getToTime() + "','" + tI.getIntervel() + "')";
			db.putData(sql);
			System.out.println("sucess Create!!");
		} catch (Exception e) {
			System.out.println("Error in cretae time createTable()");
			e.printStackTrace();
		}

		return false;
	}

	public static boolean intervals(TimeIntervel tI) {
		DbConnection db = new DbConnection();
		if (tI.getToTime() > tI.getFromTime()) {
			for (int time = tI.getFromTime(); time <= tI.getToTime(); time += tI.getIntervel()) {
				try {
					String intervels = String.format("%02d:%02d", time / 60, time % 60);
					System.out.println(intervels);
					String sql = "INSERT INTO tbl_appoinment values('" + tI.getTbl_id() + "','" + intervels + "','" + 0
							+ "','" + null + "') ";
					db.putData(sql);
					System.out.println("Sucess create intervels");
				} catch (Exception e) {
					System.out.println("error intervals()");
					e.printStackTrace();
				}

			}
			return true;
		} else {
			return false;
		}

	}
}
