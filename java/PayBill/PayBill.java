package PayBill;

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

import AccountDetails.AccountUser;

@WebServlet("/Index/PayBill")
public class PayBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		PayBillUser pb = new PayBillUser();
		PayBillDao pd = new PayBillDao();
		
		List<PayBillUser> detailsList = new ArrayList<PayBillUser>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String consNum1 = request.getParameter("consumerNo");
		int consNum = Integer.parseInt(consNum1);
		
		request.getSession().setAttribute("consumerNumber", consNum);
		
		try {
			
				detailsList = pd.returnBillDetails(consNum);
				
				request.setAttribute("BillDetails", detailsList);
				RequestDispatcher rd = request.getRequestDispatcher("BillDetails.jsp");
	            rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
