package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UpdatePlayer")
public class UpdatePlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CRUDOperations co = new CRUDOperations();
		PlayerDetails pd = new PlayerDetails();
		int flag=0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String playerName = (String) request.getSession().getAttribute("PlayerName");
		String matches = request.getParameter("matchesPlayed");
		int matchesPlayed = Integer.parseInt(matches);
		String runs = request.getParameter("score");
		int runsScored = Integer.parseInt(runs);
		String wickets = request.getParameter("wickets");
		int wicketsTaken = Integer.parseInt(wickets);
		String outOn = request.getParameter("out");
		int outOnZero = Integer.parseInt(outOn);
		
		pd.setName(playerName);
		pd.setMatches(matchesPlayed);
		pd.setTotalRunsScored(runsScored);
		pd.setWicketsTaken(wicketsTaken);
		pd.setOutOnZero(outOnZero);
		
		try {
				flag = co.updatePlayerDetails(pd);
						
		} 
		catch (Exception e) {
					
					e.printStackTrace();
		}
		
		if(flag > 0) {
			out.println("<center><h1 style=color:green;>Updated info successfully</h1></center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("UpdatePlayer.html");
		 	rd1.include(request, response);
		}
		
	}

}
