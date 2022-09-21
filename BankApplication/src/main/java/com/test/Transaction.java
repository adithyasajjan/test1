package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CrudUser cu = new CrudUser();
		boolean flag = false;
		User obj = new User();
		List<User> transList = new ArrayList<User>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String user = request.getParameter("user");
		String passwd = request.getParameter("pwd");
		
		obj.setuName(user);
		obj.setPassWd1(passwd);
		
		try {
			 
			transList = cu.showTransactionDetails(obj);
			Iterator<User> itr = transList.listIterator();
			
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
			 
			out.println("<div align="+"center"+">");
				out.println("<h1 style=color:white;>Transaction Details</h1>");
			
					out.println("<table style=width:50% border="+1+">"
									+ "<tr> "
										+ "<th style=color:white;>AccNO</th> "
										+ "<th style=color:white;>Amount</th> "
										+ "<th style=color:white;>Dr/Cr</th>"
										+ "<th style=color:white;>Balance</th>"
									+ "</tr>");
		//			out.println("<h1>"
		//					+"<center><font color='green'>AccNo   Amount    Dr/Cr     Balance</font></center>"
		//					+ "</h1>");
						while (itr.hasNext()) {
			
			                User trans1 = itr.next();
			                out.println("<tr style=color:white;> "
			                				+ "<td style=text-align:center;>"+trans1.getAccNo()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getAmount()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getDrORCr()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getBalance()+"</td> "
			                			+ "</tr>" );
			
			            }
					out.println("</table>");
			out.println("</div>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
