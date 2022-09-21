package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validation val = new Validation();
		User obj = new User();
		int x = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("fname");
		String user = request.getParameter("uname");
		String passwd1 = request.getParameter("passwd1");
		String passwd2 = request.getParameter("passwd2");
		String amount1 = request.getParameter("amount");
		double amount=Double.parseDouble(amount1);
		String phNo = request.getParameter("mobile");
		String email = request.getParameter("email");
		
		System.out.println(passwd1+" "+passwd2);
		obj.setuName(user);
		obj.setPassWd1(passwd1);
		obj.setPassWd2(passwd2);
		obj.setBalance(amount);
		obj.setPhNo(phNo);
		obj.setEmail(email);
		
		try {
			
			if(val.validatePasswd(passwd1, passwd2)) {
				x = CrudUser.dataSave(obj);
			}
			else
			{
				
				out.println("<center><font color='red'> Password doesn't match </font></center>");
			 	RequestDispatcher rd = request.getRequestDispatcher("BankSignUp.html");
			 	rd.include(request, response);
			
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();

		} 
		if(x > 0) {
			out.println("<h1 style=color:white;>Account created successfully!</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
		 	rd.include(request, response);
			
		}
		
		else {
			out.println("<center><font color='red'> Invalid Credentials, Try again later! </font></center>");
		}	

	}

}
