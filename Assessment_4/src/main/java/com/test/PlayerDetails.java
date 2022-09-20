package com.test;

public class PlayerDetails {

	int id;
	String name;
    int matches;
    int totalRunsScored;
    int wicketsTaken;
    int outOnZero;
    String playerType;
    double avgScore;
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMatches() {
		return matches;
	}
	
	public void setMatches(int matches) {
		this.matches = matches;
	}
	
	public int getTotalRunsScored() {
		return totalRunsScored;
	}
	
	public void setTotalRunsScored(int totalRunsScored) {
		this.totalRunsScored = totalRunsScored;
	}
	
	public int getWicketsTaken() {
		return wicketsTaken;
	}
	
	public void setWicketsTaken(int wicketsTaken) {
		this.wicketsTaken = wicketsTaken;
	}
	
	public int getOutOnZero() {
		return outOnZero;
	}
	
	public void setOutOnZero(int outOnZero) {
		this.outOnZero = outOnZero;
	}
	
	public String getPlayerType() {
		return playerType;
	}
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}
	
	public double getAvgScore() {
		return avgScore;
	}
	
	public void setAvgScore(double avgScore) {
		this.avgScore = avgScore;
	}
    
    
}
