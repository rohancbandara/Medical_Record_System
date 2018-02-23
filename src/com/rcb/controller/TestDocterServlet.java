package com.rcb.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rcb.dao.DocterDao;

/**
 * Servlet implementation class TestDocterServlet
 */
@WebServlet("/testDocter")
public class TestDocterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static String LIST_USER = "/TestDocterlist.jsp";
	private DocterDao dao;
	  public TestDocterServlet() {
	        super();
	        dao = new DocterDao();
	    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		 
         request.setAttribute("docters", dao.getAllDocters());
        
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String forward="/TestDocterlist.jsp";
        String action = request.getParameter("action");
        
        if (action.equalsIgnoreCase("listUser")){
            forward = LIST_USER;
            request.setAttribute("docters", dao.getAllDocters());
        }
	
	}

}
