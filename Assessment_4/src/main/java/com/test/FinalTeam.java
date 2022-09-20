package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FinalTeam")
public class FinalTeam extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CRUDOperations co = new CRUDOperations();
		List<PlayerDetails> transList = new ArrayList<PlayerDetails>();
		double avgScore = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Bat = request.getParameter("Bat");
		int Batsman = Integer.parseInt(Bat);
		
		String Bow = request.getParameter("Bow");
		int Bowler = Integer.parseInt(Bow);
		
		String Wk = request.getParameter("WKeeper");
		int Wicket_Keeper = Integer.parseInt(Wk);
		
		String AllRou = request.getParameter("AllRou");
		int All_Rounder = Integer.parseInt(AllRou);
		
		int sum = Batsman + Bowler + Wicket_Keeper + All_Rounder;
		
		if(sum < 11 || sum > 11) {
			
			out.println("<center><h1 style=color:white;>Cricket team must comprise of exactly 11 players, check once</h1></center>");
			RequestDispatcher rd1 = request.getRequestDispatcher("FinalTeam.html");
		 	rd1.include(request, response);
		 	
		}
		
		try {
			 
			transList = co.finalTeam(Batsman, Bowler, Wicket_Keeper, All_Rounder);
			Iterator<PlayerDetails> itr = transList.listIterator();
			
			 out.println("<style>\n"
				 		+ "	body{\n"
				 		+ "		background-image : \n"
				 		+ "		url('Cricket4.jpeg');\n"
				 		+ "		background-repeat : no-repeat;\n"
				 		+ "		background-attachment : fixed;\n"
				 		+ "		background-size : 100% 100%;\n"
				 		+ "		\n"
				 		+ "\n"
				 		+ "	}\n"
				 		+ "</style>");
			 
			out.println("<div align="+"center"+">");
				out.println("<h1 style=color:white;>FINAL CRICKET SQUAD</h1>");
			
					out.println("<table style=width:50% border="+1+">"
									+ "<tr> "
										+ "<th style=color:white;>PlayerID</th> "
										+ "<th style=color:white;>Name</th> "
										+ "<th style=color:white;>MatchPlayed</th>"
										+ "<th style=color:white;>TotalRunsScored</th>"
										+ "<th style=color:white;>WicketsTaken</th>"
										+ "<th style=color:white;>OutOnZeroScore</th>"
										+ "<th style=color:white;>PlayerType</th>" 
										+ "<th style=color:white;>AvgScore</th>"
									+ "</tr>");
		//			out.println("<h1>"
		//					+"<center><font color='green'>AccNo   Amount    Dr/Cr     Balance</font></center>"
		//					+ "</h1>");
						while (itr.hasNext()) {
			
			                PlayerDetails trans1 = itr.next();
			                avgScore = trans1.getAvgScore();
			                avgScore =  Math.round(avgScore * Math.pow(10, 2)) / Math.pow(10, 2);
			                out.println("<tr style=color:white;> "
			                				+ "<td style=text-align:center;>"+trans1.getId()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getName()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getMatches()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getTotalRunsScored()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getWicketsTaken()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getOutOnZero()+"</td> "
			                				+ "<td style=text-align:center;>"+trans1.getPlayerType()+"</td> "
			                				+ "<td style=text-align:center;>"+avgScore+"</td> "
			                			+ "</tr>" );
			
			            }
					out.println("</table>");
			out.println("</div>");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
