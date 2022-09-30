package Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Index/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		TransactionUser tu = new TransactionUser();
		TransactionDao td = new TransactionDao();
		boolean accNo;
		
		List<TransactionUser> transList = new ArrayList<TransactionUser>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		
		tu.setPin(pin);
		
		String username = (String) request.getSession().getAttribute("username");
		
		try {
			
			 accNo = td.returnAccNo(tu, username);
			 if(accNo == false) {
				 
				 out.println("<script type=text/javascript>");
				 out.println("alert('Incorrect pin! Try again');");
				 out.println("location='Transaction.html';");
				 out.println("</script>");
			 }
			 else {
				 
				 transList = td.showTransactionDetails(tu, username);
				 
				 request.setAttribute("TransDetails", transList);
				 RequestDispatcher rd = request.getRequestDispatcher("Transaction1.jsp");
	             rd.forward(request, response);
	             
			 }
		}
		 catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		 }
	}
}


