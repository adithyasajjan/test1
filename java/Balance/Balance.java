package Balance;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/Balance")
public class Balance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean accNo = false;
		double balance;
		int count=0;
		BalanceUser bu = new BalanceUser();
		BalanceDao bd = new BalanceDao();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		String username = (String) request.getSession().getAttribute("username");
		bu.setPin(pin);
		
		try {
			 accNo = bd.returnAccNo(bu, username);
			 System.out.println(accNo);
			 
			 
			 if(accNo == false) {
				 
//				 out.println("<script type=text/javascript>");
//				 out.println("alert('Incorrect pin! Try again');");
//				 out.println("location='Functions.html';");
//				 out.println("</script>");
				 
				 RequestDispatcher rd = request.getRequestDispatcher("Balance.jsp?flag1="+true);
	             rd.forward(request, response);
				 
			 }
			 else {
				 
				 	balance = bd.showBalance(bu, username);
					
				 	request.getSession().setAttribute("balance", balance);
				 	
				 	RequestDispatcher rd = request.getRequestDispatcher("Balance.jsp?flag="+true);
		            rd.forward(request, response);
				 		
			}
		 }
		 catch (Exception e) {
		// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	}

}
