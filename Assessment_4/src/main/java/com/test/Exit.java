package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Exit")
public class Exit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<style>\n"
		 		+ "	body{\n"
		 		+ "		background-image : \n"
		 		+ "		url('Cricket4.jpeg');\n"
		 		+ "		background-repeat : no-repeat;\n"
		 		+ "		background-attachment : fixed;\n"
		 		+ "		background-size : 100% 100%;\n"
		 		+ "		\n"
		 		+ "\n"
		 		+ "	}\n"
		 		+ "</style>");
		
		out.println("<div text-align="+"center"+">");
		out.println("<h1 style=color:white;>Thank you for visiting my website</h1>");
		out.println("</div>");
	}

}
