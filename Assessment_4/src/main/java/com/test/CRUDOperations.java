package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CRUDOperations {

	public List<PlayerDetails> showTeam() throws ClassNotFoundException, SQLException{
		
		Statement stat = Util.getConnection().createStatement();
		List<PlayerDetails> playersList = new ArrayList<PlayerDetails>();
		
		String sql = " select * from Display order by Name";
        ResultSet rs1 = stat.executeQuery(sql);
        while(rs1.next()){

        	PlayerDetails pds = new PlayerDetails();
        	pds.setId(rs1.getInt("Id"));
            pds.setName(rs1.getString("Name"));
            pds.setMatches(rs1.getInt("MatchPlayed"));
            pds.setTotalRunsScored(rs1.getInt("TotalRunsScored"));
            pds.setWicketsTaken(rs1.getInt("WicketsTaken"));
            pds.setOutOnZero(rs1.getInt("OutOnZeroScore"));
            pds.setPlayerType(rs1.getString("PlayerType"));
            pds.setAvgScore(rs1.getDouble("AvgScore"));

            playersList.add(pds);

        }
        
        return playersList;
	}
	
	public boolean returnPlayerName(PlayerDetails pd) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		
		String sql = " select Name from Display where Id="+pd.getId()+" and Name='"+pd.getName()+"' ";
		ResultSet rs = stat.executeQuery(sql);
		return rs.next();
		
	}
	
	public int updatePlayerDetails(PlayerDetails pd) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		int x = 0, matches = 0, runs = 0, wickets = 0, out = 0;
		
		String sql = " select * from Display where Name='"+pd.getName()+"' ";
		ResultSet rs = stat.executeQuery(sql);
		rs.next();
			
		matches = rs.getInt("MatchPlayed");
		runs = rs.getInt("TotalRunsScored");
		wickets = rs.getInt("WicketsTaken");
		out = rs.getInt("OutOnZeroScore");
		
		if(pd.getMatches() > matches) {
			
			String sql1 = " update Display set MatchPlayed="+pd.getMatches()+" where Name='"+pd.getName()+"' "; 
			x+=stat.executeUpdate(sql1);
		}
		
		if(pd.getTotalRunsScored() > runs) {
			
			String sql2 = " update Display set TotalRunsScored="+pd.getTotalRunsScored()+" where Name='"+pd.getName()+"' ";
			x+=stat.executeUpdate(sql2);
			
		}
		
		if(pd.getWicketsTaken() > wickets) {
			
			String sql3 = " update Display set WicketsTaken="+pd.getWicketsTaken()+" where Name='"+pd.getName()+"' ";
			x+=stat.executeUpdate(sql3);
			
		}
		
		if(pd.getOutOnZero() > out) {
			
			String sql4 = " update Display set OutOnZeroScore="+pd.getOutOnZero()+" where Name='"+pd.getName()+"' ";
			x+=stat.executeUpdate(sql4);
			
		}
		double avgScore = runs/matches;
		avgScore = Math.round(avgScore * Math.pow(10, 2)) / Math.pow(10, 2);
		String sql5 = " update Display set AvgScore="+avgScore+" where Name='"+pd.getName()+"'";
		stat.executeUpdate(sql5);
		
		return x; 
		
	}
	
	public int addPlayerInfo(PlayerDetails pd) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		
		String sql = " insert into Display(Name, MatchPlayed, TotalRunsScored, WicketsTaken, OutOnZeroScore, "
				+ "PlayerType, AvgScore) values('"+pd.getName()+"', "+pd.getMatches()+", "+pd.getTotalRunsScored()+", "
						+ ""+pd.getWicketsTaken()+", "+pd.getOutOnZero()+", '"+pd.getPlayerType()+"', "+pd.getAvgScore()+") ";
		
		return stat.executeUpdate(sql);
		
	}
	
	public List<PlayerDetails> finalTeam(int bat, int bow, int wk, int allRou) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		String bat1 = "Batsman", bow1 = "Bowler", wk1 = "Wicket-Keeper", allRou1 = "All-Rounder";
		List<PlayerDetails> playersList = new ArrayList<PlayerDetails>();
		
		String sqlBat = " select * from Display where PlayerType='"+bat1+"' order by AvgScore desc limit "+bat+" ";
		ResultSet rs1 = stat.executeQuery(sqlBat);
		while(rs1.next()){

        	PlayerDetails pds = new PlayerDetails();
        	pds.setId(rs1.getInt("Id"));
            pds.setName(rs1.getString("Name"));
            pds.setMatches(rs1.getInt("MatchPlayed"));
            pds.setTotalRunsScored(rs1.getInt("TotalRunsScored"));
            pds.setWicketsTaken(rs1.getInt("WicketsTaken"));
            pds.setOutOnZero(rs1.getInt("OutOnZeroScore"));
            pds.setPlayerType(rs1.getString("PlayerType"));
            pds.setAvgScore(rs1.getDouble("AvgScore"));

            playersList.add(pds);

        }
		
		String sqlBow = " select * from Display where PlayerType='"+bow1+"' order by AvgScore desc limit "+bow+" ";
		ResultSet rs2 = stat.executeQuery(sqlBow);
		while(rs2.next()){

        	PlayerDetails pds = new PlayerDetails();
        	pds.setId(rs2.getInt("Id"));
            pds.setName(rs2.getString("Name"));
            pds.setMatches(rs2.getInt("MatchPlayed"));
            pds.setTotalRunsScored(rs2.getInt("TotalRunsScored"));
            pds.setWicketsTaken(rs2.getInt("WicketsTaken"));
            pds.setOutOnZero(rs2.getInt("OutOnZeroScore"));
            pds.setPlayerType(rs2.getString("PlayerType"));
            pds.setAvgScore(rs2.getDouble("AvgScore"));

            playersList.add(pds);

        }
		
		String sqlWk = " select * from Display where PlayerType='"+wk1+"' order by AvgScore desc limit "+wk+" ";
		ResultSet rs3 = stat.executeQuery(sqlWk);
		while(rs3.next()){

        	PlayerDetails pds = new PlayerDetails();
        	pds.setId(rs3.getInt("Id"));
            pds.setName(rs3.getString("Name"));
            pds.setMatches(rs3.getInt("MatchPlayed"));
            pds.setTotalRunsScored(rs3.getInt("TotalRunsScored"));
            pds.setWicketsTaken(rs3.getInt("WicketsTaken"));
            pds.setOutOnZero(rs3.getInt("OutOnZeroScore"));
            pds.setPlayerType(rs3.getString("PlayerType"));
            pds.setAvgScore(rs3.getDouble("AvgScore"));

            playersList.add(pds);

        }
		
		String sqlAlR = " select * from Display where PlayerType='"+allRou1+"' order by AvgScore desc limit "+allRou+" ";
		ResultSet rs4 = stat.executeQuery(sqlAlR);
		while(rs4.next()){

        	PlayerDetails pds = new PlayerDetails();
        	pds.setId(rs4.getInt("Id"));
            pds.setName(rs4.getString("Name"));
            pds.setMatches(rs4.getInt("MatchPlayed"));
            pds.setTotalRunsScored(rs4.getInt("TotalRunsScored"));
            pds.setWicketsTaken(rs4.getInt("WicketsTaken"));
            pds.setOutOnZero(rs4.getInt("OutOnZeroScore"));
            pds.setPlayerType(rs4.getString("PlayerType"));
            pds.setAvgScore(rs4.getDouble("AvgScore"));

            playersList.add(pds);

        }
		
		return playersList;
	}
	
}
