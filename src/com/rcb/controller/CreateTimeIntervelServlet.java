package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.service.CreateTimeIntervelService;

@WebServlet("/createTimeIntervel")
public class CreateTimeIntervelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int begin = Integer.parseInt(request.getParameter("txtFromTime"));
		int end = Integer.parseInt(request.getParameter("txtToTime"));
		int interval = Integer.parseInt(request.getParameter("txtIntervel"));

		CreateTimeIntervelService createTimeIntervel = new CreateTimeIntervelService();
		createTimeIntervel.intervals(begin * 60, end * 60, interval);
	}

}
