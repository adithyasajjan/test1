package CusDetails;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.w3c.dom.CDATASection;

@WebServlet("/CusDetails")
public class CusDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Validation val = new Validation();
		CusUser cu = new CusUser();
		CusDetailsDao cd = new CusDetailsDao();
		PayableAmount pa = new PayableAmount();
		
		double amount = 0;
		
		String name = request.getParameter("fname");
		String city = request.getParameter("city");
		String phNum = request.getParameter("phNum");
		String dest =  request.getParameter("destination");
		String weight1 = request.getParameter("weight");
		double weight = Double.parseDouble(weight1);
		String region = request.getParameter("region");
		
		weight /= 	1000;
		
		cu.setName(name);
		cu.setCity(city);
		cu.setPhNum(phNum);
		cu.setDest(dest);
		cu.setWeight(weight);
		
		request.getSession().setAttribute("region", region);
		
		request.getSession().setAttribute("name", name);
		
		if(region.equals("North India INR 200/kg")) {
			
			cu.setPrice(200);
		}
		else if(region.equals("South India INR 150/kg")) {
			
			cu.setPrice(150);
		}
		else if(region.equals("East India INR 250/kg")) {
			
			cu.setPrice(250);
		}
		else {
			
			cu.setPrice(115);
		}
		
		if(val.validateName(name) == false) {
			
			RequestDispatcher rd = request.getRequestDispatcher("CourierBookingDetails.jsp?flag="+true);
            rd.forward(request, response);
		}
		
		if(val.validatePhoneNum(phNum) == false) {
			
			RequestDispatcher rd = request.getRequestDispatcher("CourierBookingDetails.jsp?flag1="+true);
            rd.forward(request, response);
		}
		
		try {
			
			if(cd.storeDetails(cu) > 0) {
				
				amount = pa.getPayableAmount(cu);
				
				request.getSession().setAttribute("amount", amount);
				
				RequestDispatcher rd = request.getRequestDispatcher("PayableAmount.jsp");
	            rd.forward(request, response);
			}
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}

}
