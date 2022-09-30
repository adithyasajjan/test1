package Register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Index/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Validation val = new Validation();
		RegisterUser obj = new RegisterUser();
		RegisterDao rg = new RegisterDao();
		int x = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("uname");
		String passwd1 = request.getParameter("passwd1");
		String passwd2 = request.getParameter("passwd2");
		String pin1 = request.getParameter("pincode");
		int pin = Integer.parseInt(pin1);
		String amount1 = request.getParameter("amount");
		double amount = Double.parseDouble(amount1);
		
		obj.setUsername(user);
		obj.setPasswd1(passwd1);
		obj.setPasswd2(passwd2);
		obj.setPin(pin);
		obj.setBalance(amount);
		
		
		try {
			
			if(val.validatePassword(passwd1)) {
				
				if(val.validatePasswords(passwd1, passwd2)) {
					
					if(rg.checkUsername(obj) != true) {
						
						x = rg.dataSave(obj);
	
					}
					else {
						
						out.println("<script type=text/javascript>");
					    out.println("alert('Username already taken, try another one');");
					    out.println("location='SignUp.html';");
					    out.println("</script>");
					}
					
				}
				else {
					
					out.println("<script type=text/javascript>");
				    out.println("alert('Password doesn't match');");
				    out.println("location='SignUp.html';");
				    out.println("</script>");
				}
				
			}
			else
			{
				
				out.println("<script type=text/javascript>");
			    out.println("alert('Password should contain uppercase and lowercase letters, "
			    		+ " numbers, special characters (@,#,$,%,^, &,+,=,*), "
			    		+ " minimum length of the password is 8');");
			    out.println("location='SignUp.html';");
			    out.println("</script>");
			}
			
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			

		} 
		System.out.println(x);
		if(x > 0) {
			
			out.println("<script type=text/javascript>");
		    out.println("alert('Account created successfully');");
		    out.println("location='SignIn.html';");
		    out.println("</script>");
		}
		
		else {
			out.println("<script type=text/javascript>");
		    out.println("alert('Sorry, Try again later !');");
		    out.println("location='SignUp.html';");
		    out.println("</script>");
		}	

	}

}
