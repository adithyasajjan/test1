package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean flag = false;
		CRUDOperations co = new CRUDOperations();
		PlayerDetails pd = new PlayerDetails();
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String Id = request.getParameter("PID");
		int playerId = Integer.parseInt(Id);
		String playerName = request.getParameter("PName");
		request.getSession().setAttribute("PlayerName", playerName);
		
		pd.setId(playerId);
		pd.setName(playerName);
		
		try {
			
			flag = co.returnPlayerName(pd);
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(flag == true) {
			out.println("<center><h1 style=color:white;>Edit "+playerName+"'s Info</h1></center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("UpdatePlayer.html");
		 	rd1.include(request, response);

		}
		else{
		 	out.println("<h2 align=center>"
		 			+ "<span style=color:red;>Player doesn't exists! wish to add ?</span> : <a href=AddPlayer.html>Add Player</a> "
		 			+ "</h2>");
		 	RequestDispatcher rd1 = request.getRequestDispatcher("Update.html");
		 	rd1.include(request, response);
		}
		
		
		
		
//		if(user.equals("admin") && passwd.equals("a123"))
//		{
//			out.println("Login Success!");
//		}
//		else
//		{
//			out.println("Login Failed! Invalid Credentials");
//
//		}
		
	}

}


