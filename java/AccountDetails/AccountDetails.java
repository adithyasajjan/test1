package AccountDetails;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/AccountDetails")
public class AccountDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AccountUser au = new AccountUser();
		AccountDao ad = new AccountDao();
		
		
		List<AccountUser> detailsList = new ArrayList<AccountUser>();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = (String) request.getSession().getAttribute("username");
		String password = (String) request.getSession().getAttribute("password");
		
		au.setUsername(username);
		au.setPassword(password);
		
		try {
			
			detailsList = ad.AccountDetails(au);
			
			request.setAttribute("AccountDetails", detailsList);
			RequestDispatcher rd = request.getRequestDispatcher("AccountDetails.jsp");
            rd.forward(request, response);
			
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
