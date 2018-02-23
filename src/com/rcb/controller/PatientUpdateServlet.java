package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.model.Patient;
import com.rcb.service.PatienfService;

/**
 * Servlet implementation class PatientUpdateServlet
 */
@WebServlet("/patientUpdate")
public class PatientUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PatienfService patientService = new PatienfService();
		Patient patient = new Patient();
		patient.setP_id(Integer.parseInt(request.getParameter("txtPid")));
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
		patient.setP_tel(request.getParameter("number"));

		System.out.println(patient.getP_id());

		Boolean result = patientService.updatePatient(patient);
		System.out.println(request);
		if (result) {
			response.sendRedirect("PatientList.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
