package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		ServletContext ctx = getServletContext();
		String ct = ctx.getInitParameter("City");
		String st = ctx.getInitParameter("State");
		String dt = ct+" "+st;
		
		
		
		ctx.setAttribute("info", dt);
		
		ServletConfig cfg = getServletConfig();
		
		String user = cfg.getInitParameter("user");
		String pwd = cfg.getInitParameter("pwd");
		
		out.println("<br> Username : "+user+" Password : "+pwd);
		
		out.println("from servlet1 : "+dt);
		
		out.println("<a href = 'Servlet2'> go to next page </a>");
	}


}
