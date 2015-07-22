package com.eufar.asmm.server;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggingSystem extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("ok");
		
		try {
			String value = request.getParameter("logging");
			System.out.println(value);
		} catch (Exception ex) {
			System.out.println(ex);
		}

	}
	
	
	
}