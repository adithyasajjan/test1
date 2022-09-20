package com.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddPlayer")
public class AddPlayer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CRUDOperations co = new CRUDOperations();
		PlayerDetails pd = new PlayerDetails();
		int flag=0;
		double avgScore = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String playerName = request.getParameter("PName");
		String matches = request.getParameter("matchesPlayed");
		int matchesPlayed = Integer.parseInt(matches);
		String runs = request.getParameter("score");
		int runsScored = Integer.parseInt(runs);
		String wickets = request.getParameter("wickets");
		int wicketsTaken = Integer.parseInt(wickets);
		String outOn = request.getParameter("out");
		int outOnZero = Integer.parseInt(outOn);
		String PType = request.getParameter("PType");
		
		pd.setName(playerName);
		pd.setMatches(matchesPlayed);
		pd.setTotalRunsScored(runsScored);
		pd.setWicketsTaken(wicketsTaken);
		pd.setOutOnZero(outOnZero);
		pd.setPlayerType(PType);
		
		avgScore = runsScored/matchesPlayed;
		avgScore = Math.round(avgScore * Math.pow(10, 2)) / Math.pow(10, 2);
		
		pd.setAvgScore(avgScore);
		
		try {
			
			flag = co.addPlayerInfo(pd);
					
		} 
		catch (Exception e) {
				
				e.printStackTrace();
		}
		
		if(flag > 0) {
			
			out.println("<center><h1 style=color:green;>Player added successfully ! </h1></center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("AddPlayer.html");
		 	rd1.include(request, response);
		 	
		}
		else
		{
			out.println("<center><h1 style=color:red;>Error : Try again later</h1></center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("AddPlayer.html");
		 	rd1.include(request, response);
		}
		
	}

}
