package ShipmentDetails;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ShipmentDetails")
public class ShipmentDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ShipmentDetailsDao sd = new ShipmentDetailsDao();
		
		String name = (String) request.getSession().getAttribute("name");
		
		String region = (String) request.getSession().getAttribute("region");
		
		int trackingId = 0;
		LocalDate DeliveryDt, CurDate;
		
		try {
			
			trackingId = sd.returnTrackId(name);
			
			CurDate = LocalDate.now();
			
			DeliveryDt = sd.returnShippingDate(region);
			
			request.getSession().setAttribute("TrackId", trackingId);
			
			request.getSession().setAttribute("CurDate", CurDate);
			
			request.getSession().setAttribute("DeliveryDt", DeliveryDt);
			
			RequestDispatcher rd = request.getRequestDispatcher("ShipmentDetails.jsp");
            rd.forward(request, response);
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
