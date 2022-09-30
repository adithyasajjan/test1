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

@WebServlet("/Index/Receipt")
public class Receipt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int consNum = (int) request.getSession().getAttribute("consumerNumber");
		
		PayBillDao pd = new PayBillDao();
		
		List<PayBillUser> detailsList = new ArrayList<PayBillUser>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		
		try {
			
			detailsList = pd.returnReceipt(consNum);
			
			request.setAttribute("ReceiptDetails", detailsList);
			RequestDispatcher rd = request.getRequestDispatcher("GetPin.jsp");
            rd.forward(request, response);
		
		} catch (ClassNotFoundException | SQLException e) {
		
			e.printStackTrace();
		}
		
	}

}
