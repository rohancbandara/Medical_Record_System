package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.model.Patient;
import com.rcb.service.EmailService;
import com.rcb.service.PatienfService;

@WebServlet("/RegisterPatient")
public class RegisterPatientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Patient patient = new Patient();
		EmailService sendEmail = new EmailService();

		patient.setP_fname(request.getParameter("txtFname"));
		patient.setP_lname(request.getParameter("txtLname"));
		patient.setP_nic(request.getParameter("txtNic"));
		patient.setP_email(request.getParameter("txtEmail"));
		patient.setP_gender(request.getParameter("gender"));
		patient.setP_dob(request.getParameter("dob"));
		patient.setP_job(request.getParameter("txtJob"));
		patient.setP_blood(request.getParameter("bloodGroup"));
		patient.setP_marital(request.getParameter("status"));
		patient.setP_haddress(request.getParameter("homeAdd"));

		// patient.setP_caddress(request.getParameter("currentAdd"));
		// patient.setP_country(request.getParameter("country"));
		// patient.setP_state(request.getParameter("txtState"));
		// patient.setP_city(request.getParameter("txtCity"));
		patient.setP_tel(request.getParameter("number"));

		String action = request.getParameter("btnSubmit");
		if (action.equals("save")) {
			PatienfService regPatient = new PatienfService();
			// sendEmail.SendingEmail(patient);
			try {
				boolean result1 = regPatient.putPatientData(patient);
				// boolean result2 =
				if (result1) {
					System.out.println("sucess add ");
					response.sendRedirect("PatientList.jsp");
				}

				response.sendRedirect("PatientAdd.jsp");

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("error in ");
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("btnSubmit");

		if (action.equals("cancle")) {
			PatienfService regPatient = new PatienfService();

			response.sendRedirect("DashBoard.jsp");

		}
	}

}
