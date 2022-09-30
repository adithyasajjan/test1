package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Index/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag = false;
		LoginUser obj = new LoginUser();
		LoginDao ld = new LoginDao();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String user = request.getParameter("uname");
		
		String passwd = request.getParameter("passwd");
		
		obj.setuName(user);
		obj.setPassWd(passwd);
		
		request.getSession().setAttribute("username", user);
		request.getSession().setAttribute("password", passwd);
		
		try {
			
			flag = ld.loginUser(obj);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		if(flag == true) {
			
//			   out.println("<script type=text/javascript>");
//			   out.println("alert('Logged in successfully');");
//			   out.println("location='Functions.html';");
//			   out.println("</script>");
			
//			request.getSession().setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("Functions.jsp");
            rd.forward(request, response);

		}
		else{
	
//			   out.println("<script type=text/javascript>");
//			   out.println("alert('Username or password incorrect');");
//			   out.println("location='SignIn.html';");
//			   out.println("</script>");
			
//			   request.getSession().setAttribute("error", "Invalid credentials !");
		   	   RequestDispatcher rd = request.getRequestDispatcher("SignIn.jsp?flag="+true);
               rd.forward(request, response);
			   
		}
		
	}

}
