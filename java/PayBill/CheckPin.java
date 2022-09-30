package PayBill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/CheckPin")
public class CheckPin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<PayBillUser> detailsList = new ArrayList<PayBillUser>();
		
		boolean accNo = false;
		PayBillDao pb = new PayBillDao();
		
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		
		String username = (String) request.getSession().getAttribute("username");
		
		int consNum = (int) request.getSession().getAttribute("consumerNumber");
		
		try {
			
			 accNo = pb.returnAccNo(pin, username);
			 
			 if(accNo == false) {
				 
				 RequestDispatcher rd = request.getRequestDispatcher("GetPin.jsp?flag1="+true);
	             rd.forward(request, response);
			 }
			 
			 else {
				 
				 detailsList = pb.returnBillDetails(consNum);
				 request.setAttribute("ReceiptDetails", detailsList);
				 
				 RequestDispatcher rd = request.getRequestDispatcher("Receipt.jsp");
		         rd.forward(request, response);
			 }
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		 }
		
	}

}
