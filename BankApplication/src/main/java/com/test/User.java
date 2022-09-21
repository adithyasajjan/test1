package com.test;

public class User {
	
	public String uName;
	public String passWd1;
	public String passWd2;
	double amount;
	String phNo;
	String email;
	int accNo;
	String DrORCr;
    double balance;
	
    
    public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	
	public String getDrORCr() {
		return DrORCr;
	}
	public void setDrORCr(String drORCr) {
		DrORCr = drORCr;
	}
	
    public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getPassWd1() {
		return passWd1;
	}
	public void setPassWd1(String passWd1) {
		this.passWd1 = passWd1;
	}
	
	public String getPassWd2() {
		return passWd2;
	}
	public void setPassWd2(String passWd2) {
		this.passWd2 = passWd2;
	}
	
}
