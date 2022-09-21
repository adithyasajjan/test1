package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		double balance = 0;
		User obj = new User();
		CrudUser cu = new CrudUser();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String passwd = request.getParameter("pwd");
		
		obj.setuName(user);
		obj.setPassWd1(passwd);
		
		try {
			balance = cu.showBalance(obj);
			
			out.println("<style>\n"
			 		+ "	body{\n"
			 		+ "		background-image : \n"
			 		+ "		url('OnlineBanking.jpg');\n"
			 		+ "		background-repeat : no-repeat;\n"
			 		+ "		background-attachment : fixed;\n"
			 		+ "		background-size : 100% 100%;\n"
			 		+ "		\n"
			 		+ "\n"
			 		+ "	}\n"
			 		+ "</style>");
			
			out.println("<h1>"
					 +"<center><font color='white'>Balance : "+balance+"</font></center>"
					 + "</h1>");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
