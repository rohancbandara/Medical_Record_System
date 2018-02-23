package com.rcb.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rcb.model.User;
import com.rcb.service.EncriptionAndDecription;
import com.rcb.service.LoginService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	User user = new User();
	LoginService loginService = new LoginService();
	EncriptionAndDecription en = new EncriptionAndDecription();

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		user.setUser_name(request.getParameter("txtName"));
		String username = request.getParameter("txtName");
		try {
			// encript password
			String User_password = en.encrypt(request.getParameter("txtPassword"));
			System.out.println(User_password);
			user.setUser_password(User_password);
		} catch (Exception e) {
			e.printStackTrace();
		}

		boolean result = loginService.authenticate(user);
		if (result) {
			HttpSession session = request.getSession();
			// session.setMaxInactiveInterval(10);
			session.setAttribute("username", username);
			String type = loginService.getUserType(user);
			// print user type
			System.out.println("type=" + type);

			response.sendRedirect("DashBoard.jsp");
		} else {
			request.setAttribute("massage", "Invalide username/password!!!");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			;
			// response.sendRedirect("");

		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		response.sendRedirect("index.jsp");
	}

}
