package com.store;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signin")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UserBean userBean;
	private Logger logger = Logger.getLogger(SignIn.class.getCanonicalName());

	public SignIn() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.log(Level.FINEST, "ENTRY");
		response.setContentType("text/plain");
		PrintWriter out = response.getWriter();
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		logger.log(Level.FINEST, "SignIn doPost");
		if (login == null || password == null) {
			response.sendRedirect("Register.html");
		} else {
			User u = new User();
			u.setLogin(login);
			u.setPassword(password);

			List<User> users = userBean.getUsers();

			if (users.contains(u)) {
				request.getSession().setAttribute("sessionCustomId", request.getSession().getId());
				request.getSession().setAttribute("user", u);
				response.sendRedirect("Store.jsp");
			} else {
				response.sendRedirect("Register.html");
			}

		}
		out.close();
		logger.log(Level.FINEST, "EXIT");
	}
}
