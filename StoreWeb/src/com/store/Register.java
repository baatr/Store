package com.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	private UserBean userBean;
	private Logger logger = Logger.getLogger(Register.class.getCanonicalName());

	public Register() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.FINEST, "ENTRY");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		if (login == null || password == null) {
			out.write("Request if empty.");
		} else {
			User u = new User();
			u.setLogin(login);
			u.setPassword(password);

			userBean.add(u);

			out.write("User was added at database");

		}
		out.close();
		logger.log(Level.FINEST, "EXIT");
	}

}
