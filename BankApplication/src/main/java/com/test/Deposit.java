package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User obj = new User();
//		boolean flag = false;
		int accNo, flag = 0;
		double balance;
		
		CrudUser cu = new CrudUser();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String passwd = request.getParameter("pwd");
		String amount1 = request.getParameter("amount");
		double amount = Double.parseDouble(amount1);
		
		obj.setuName(user);
		obj.setPassWd1(passwd);
		obj.setAmount(amount);
		
		try {
			
			 accNo = cu.returnAccNo(obj);
			 flag = cu.updateCreditBalance(accNo, obj);
			 if(flag > 0) {
				 
				 out.println("<h1>"
						 +"<center><font color='green'>An amount of Rs. "+amount+" has been credited</font></center>"
						 + "</h1>");
				 
				 balance = cu.showBalance(obj);
				 out.println("<h1>"
				 		+ "<center><font color='green'>Balance : Rs. "+balance+"</font></center> "
				 				+ "</h1>");
				 RequestDispatcher rd1 = request.getRequestDispatcher("Deposit.html");
				 rd1.include(request, response);
				 
			 }
			 else
			 {
		
				 out.println("<center><font color='green'>Oops! Something went wrong. Try again later.</font></center>");
				 RequestDispatcher rd = request.getRequestDispatcher("Deposit.html");
				 rd.include(request, response);
				 
			 }
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
