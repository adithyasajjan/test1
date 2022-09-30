package PayBill;

import java.util.Date;

public class PayBillUser {
	
	int consNum;
	String name;
	String elecProvider;
	int consump;
	Date bd;
	Date bdd;
	Date pd;
	String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	double amount;
	
	public int getConsNum() {
		return consNum;
	}
	public void setConsNum(int consNum) {
		this.consNum = consNum;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getElecProvider() {
		return elecProvider;
	}
	public void setElecProvider(String elecProvider) {
		this.elecProvider = elecProvider;
	}
	
	public int getConsump() {
		return consump;
	}
	public void setConsump(int consump) {
		this.consump = consump;
	}
	
	public Date getBd() {
		return bd;
	}
	public void setBd(Date bd) {
		this.bd = bd;
	}
	
	public Date getBdd() {
		return bdd;
	}
	public void setBdd(Date bdd) {
		this.bdd = bdd;
	}
	
	public Date getPd() {
		return pd;
	}
	public void setPd(Date pd) {
		this.pd = pd;
	}
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
}
