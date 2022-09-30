package Deposit;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/Deposit")
public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DepositUser du = new DepositUser();
		
		int flag = 0;
		boolean accNo = false;
		double balance;
		
		DepositDao dd = new DepositDao();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String amount1 = request.getParameter("amount");
		double amount = Double.parseDouble(amount1);
		
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		String descrip = request.getParameter("description");
		
		String uname = (String) request.getSession().getAttribute("username");
		
		du.setAmount(amount);
		du.setPin(pin);
		du.setDescrip(descrip);
		
		System.out.println(descrip);
		
		try {
			
			 accNo = dd.returnAccNo(du, uname);
			 if(accNo == false) {
				 
//				 out.println("<script type=text/javascript>");
//				 out.println("alert('Incorrect pin! Try again');");
//				 out.println("location='Deposit.html';");
//				 out.println("</script>");
				 
				 RequestDispatcher rd = request.getRequestDispatcher("Deposit.jsp?flag1="+true);
	             rd.forward(request, response);
			 }
			 
			 else {
				
				 flag = dd.updateCreditBalance(pin, uname, du);
				 if(flag > 0) {
					 
					 balance = dd.showBalance(du, uname);
					 
				 	out.println("<script type=text/javascript>");
				    out.println("alert('Deposited successfully ! Total Avail.bal = "+balance+"');");
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
			 
			 
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
