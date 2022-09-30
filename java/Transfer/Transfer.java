package Transfer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/Transfer")
public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TransferUser tu = new TransferUser();
		TransferDao td = new TransferDao();
		boolean accNo = false;
		double balance, balance1;
		int flag=0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
	
		String Benif_Name = request.getParameter("BenName");
		
		String Be_AccNo = request.getParameter("accNo");
		int Benif_AccNo = Integer.parseInt(Be_AccNo);
		
		String amount1 = request.getParameter("amount");
		double amount=Double.parseDouble(amount1);
		
		String  pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		String descrip = request.getParameter("description");
		
		tu.setAmount(amount);
		tu.setPin(pin);
		tu.setDescrip(descrip);
		
		String uname = (String) request.getSession().getAttribute("username");
		
		System.out.println(uname);
		System.out.println(Benif_Name);
		
		
		
		try {
			
			accNo = td.returnAccNo(tu, uname);
			
						
			if(Benif_Name.equals(uname)) {
				
//				 out.println("<script type=text/javascript>");
//				 out.println("alert('Cannot transfer money into the same account !');");
//				 out.println("location='Transfer.jsp';");
//				 out.println("</script>");
				
				 RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp?flag1="+true);
	             rd.forward(request, response);
			}
			
			else if(accNo == false) {
				 
//				 out.println("<script type=text/javascript>");
//				 out.println("alert('Incorrect pin! Try again');");
//				 out.println("location='Transfer.jsp';");
//				 out.println("</script>");
				 
				 RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp?flag2="+true);
	             rd.forward(request, response);
			}
				
			else {
				
				balance = td.showBalance(tu, uname);
				if((balance-amount) <= 1000 && (balance-amount) >= 0) {
					 
//				 	out.println("<script type=text/javascript>");
//				    out.println("alert('Maintain a minimum balance of Rs. 1000/-');");
//				    out.println("location='Transfer.jsp';");
//				    out.println("</script>");
					
					 RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp?flag3="+true);
		             rd.forward(request, response);
				 
				}
				
				else if(balance < amount){
					
//					out.println("<script type=text/javascript>");
//				    out.println("alert('Insufficient funds !');");
//				    out.println("location='Transfer.jsp';");
//				    out.println("</script>");
					
					 RequestDispatcher rd = request.getRequestDispatcher("Transfer.jsp?flag4="+true);
		             rd.forward(request, response);
				}
				
				else {
					
					flag = td.transferDetails(pin, Benif_AccNo, Benif_Name, tu, uname);
					balance1 = td.showBalance(tu, uname);
					if(flag > 0) {
						
						out.println("<script type=text/javascript>");
					    out.println("alert('Transfer successful ! Total Avail.bal = "+balance1+"');");
					    out.println("location='Functions.html';");
					    out.println("</script>");
					}
					
					else {
						
						out.println("<script type=text/javascript>");
						out.println("alert('Oops ! something went wrong Try again later');");
						out.println("location='Functions.html';");
						out.println("</script>");
					}
					
				}
				
			}
			 
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		

	}

}
