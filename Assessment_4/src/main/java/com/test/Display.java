package com.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class Display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
//		PlayerDetails pd = new PlayerDetails();
		CRUDOperations co = new CRUDOperations();
		boolean flag = false;
		List<PlayerDetails> transList = new ArrayList<PlayerDetails>();
		double avgScore = 0;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			 
			transList = co.showTeam();
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
				out.println("<h1 style=color:white;>CRICKET SQUAD</h1>");
			
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


