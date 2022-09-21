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

@WebServlet("/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
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
			
			 balance = cu.showBalance(obj);
			 if((balance-amount) <= 1000) {
				 out.println("<h1>"
				 		+ "<center><font color='white'>Minimum balance of Rs.1000 must be maintained! Thank you</font></center>"
				 		+ "</h1>");
				 out.println("<br>");
				 out.println("<h1>"
				 		+ "<center><font color='white'>Balance : "+balance+"</font></center>"
				 		+ "</h1>");
				 out.println("<br>");
				 RequestDispatcher rd1 = request.getRequestDispatcher("Transfer.html");
				 	rd1.include(request, response);
			 }
			 
			 else {
				 
				 accNo = cu.returnAccNo(obj);
				 flag = cu.updateDebitBalance(accNo, obj);
				 if(flag > 0) {
					 
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
							 +"<center><font color='white'>An amount of Rs. "+amount+" has been debited</font></center>"
							 + "</h1>");
					 
					 balance = cu.showBalance(obj);
					 out.println("<h1>"
					 		+ "<center><font color='white'>Balance : Rs. "+balance+"</font></center> "
					 				+ "</h1>");
					 
				 }
				 else
				 {
			
					 out.println("<center><font color='green'>Oops! Something went wrong. Try again later.</font></center>");
					 
				 }
				 
			 }
				
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
