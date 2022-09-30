package Withdraw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Index/Withdraw")
public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		WithdrawUser wu = new WithdrawUser();
		
		int flag = 0;
		boolean accNo = false;
		double balance, balance1;
	
		
		WithdrawDao wd = new WithdrawDao();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String amount1 = request.getParameter("amount");
		double amount = Double.parseDouble(amount1);
		
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		String descrip = request.getParameter("description");
		
		wu.setAmount(amount);
		wu.setPin(pin);
		wu.setDescrip(descrip);
		
		String uname = (String) request.getSession().getAttribute("username");
		
		System.out.println(descrip);
		
		try {
			
			 accNo = wd.returnAccNo(wu, uname);
			 if(accNo == false) {
				 
				 RequestDispatcher rd = request.getRequestDispatcher("Withdraw.jsp?flag1="+true);
	             rd.forward(request, response);
				 
			 }
			 
			 else {
				 
				 balance = wd.showBalance(wu, uname);
				 if((balance-amount) <= 1000 && (balance-amount) >= 0) {
					 
//					 	out.println("<script type=text/javascript>");
//					    out.println("alert('Maintain a minimum balance of Rs. 1000/-');");
//					    out.println("location='Withdraw.html';");
//					    out.println("</script>");
					 
					 RequestDispatcher rd = request.getRequestDispatcher("Withdraw.jsp?flag2="+true);
		             rd.forward(request, response);
					 
				 }
				 
				 else if(balance < amount){
					 
//					 	out.println("<script type=text/javascript>");
//					    out.println("alert('Insufficient funds !');");
//					    out.println("location='Withdraw.html';");
//					    out.println("</script>");
					 
					 RequestDispatcher rd = request.getRequestDispatcher("Withdraw.jsp?flag3="+true);
		             rd.forward(request, response);
				 }
				 
				 else { 
					 
					 flag = wd.updateDebitBalance(pin, uname, wu);
					 balance1 = wd.showBalance(wu, uname);
					 if(flag > 0) {
						 
					 	out.println("<script type=text/javascript>");
					    out.println("alert('Withdrawn successfully ! Total Avail.bal = "+balance1+"');");
					    out.println("location='Functions.html';");
					    out.println("</script>");
						 
					 }
					 
					 else
					 {
						 	
						   out.println("<script type=text/javascript>");
						   out.println("alert('Oops ! something went wrong Try again later');");
						   out.println("location='Functions.html';");
						   out.println("</script>");
					 }
				 }
				
				
			 }
			 
			 
		  }	 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
