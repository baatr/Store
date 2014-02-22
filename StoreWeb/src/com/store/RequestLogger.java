package com.store;

import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.logging.Logger;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST }, urlPatterns = { "/*" })
public class RequestLogger implements Filter {

	private Logger logger = Logger.getLogger(RequestLogger.class.getCanonicalName());

	public RequestLogger() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logger.log(Level.FINEST, "ENTRY");
//		HttpServletRequest req = (HttpServletRequest) request;
//		Enumeration<String> params = req.getParameterNames();
//
//		HttpSession s = req.getSession() != null ? req.getSession() : null;
//
//		logger.log(Level.FINEST, "Logged! " + (s != null ? (User) s.getAttribute("user") : "empty"));
//		while (params.hasMoreElements()) {
//			String name = params.nextElement();
//			String value = request.getParameter(name);
//			logger.log(Level.FINEST, req.getRemoteAddr() + "::Request Params::{" + name + "=" + value + "}");
//		}
//
//		Cookie[] cookies = req.getCookies();
//		if (cookies != null) {
//			for (Cookie cookie : cookies) {
//				logger.log(Level.FINEST, req.getRemoteAddr() + "::Cookie::{" + cookie.getName() + "," + cookie.getValue() + "}");
//			}
//		}
//
		chain.doFilter(request, response);
		logger.log(Level.FINEST, "EXIT");
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
