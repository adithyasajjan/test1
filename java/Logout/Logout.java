package Logout;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Index/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		request.getSession().invalidate();
		
		out.println("<script type=text/javascript>");
	    out.println("if(confirm('Do you really want to leave ?')) {;");
	    	out.println("location='SignIn.jsp';");
	    out.println("}");
	    out.println("else {");
	    	out.println("location='Functions.jsp';");
	    out.println("}");	
	    out.println("</script>");
	}

}
