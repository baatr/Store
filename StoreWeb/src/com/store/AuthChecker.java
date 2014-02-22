package com.store;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class AuthChecker implements Filter {

	private Logger logger = Logger.getLogger(AuthChecker.class.getCanonicalName());

	public AuthChecker() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		logger.log(Level.FINEST, "ENTRY");
		// HttpServletRequest request = (HttpServletRequest) req;
		// HttpServletResponse response = (HttpServletResponse) res;
		// HttpSession session = request.getSession(false);
		//
		// User u = (User) session.getAttribute("user");
		//
		// String servletPath = request.getServletPath().substring(1);
		// logger.log(Level.FINEST, servletPath);
		// if ((!servletPath.equals("SignIn.html")) && (u == null)) {
		// logger.log(Level.FINEST, "User session expired");
		//
		// response.sendRedirect("SignIn.html");
		// return;
		// }
		// logger.log(Level.FINEST, "Chain.doFilter");
		chain.doFilter(req, res);
		logger.log(Level.FINEST, "EXIT");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
