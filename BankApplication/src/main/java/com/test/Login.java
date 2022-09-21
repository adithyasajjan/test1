package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag = false;
		User obj = new User();
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String passwd = request.getParameter("pwd");
		
		obj.setuName(user);
		obj.setPassWd1(passwd);
		
		try {
			flag = CrudUser.loginUser(obj);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag == true) {
			out.println("<h1 style=color:white;>Welcome ! "+user+"</h1>");
			RequestDispatcher rd1 = request.getRequestDispatcher("Functions.html");
		 	rd1.include(request, response);

		}
		else{
		 	out.println("<center><font color='red'> incorrect credentials or you haven't registered yet!</font></center>");
		 	RequestDispatcher rd = request.getRequestDispatcher("login.html");
		 	rd.include(request, response);
		}
		
		
		
		
//		if(user.equals("admin") && passwd.equals("a123"))
//		{
//			out.println("Login Success!");
//		}
//		else
//		{
//			out.println("Login Failed! Invalid Credentials");
//
//		}
		
	}

}
