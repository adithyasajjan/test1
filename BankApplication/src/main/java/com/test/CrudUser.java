package com.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CrudUser {
	
	//insert data into User table
	public static int dataSave(User us) throws ClassNotFoundException, SQLException {
		Statement stat = Util.getConnection().createStatement();
		String sql = "insert into User values('"+us.getuName()+"', '"+us.getPassWd1()+"')";
		String sql2 = "insert into RegisterDetails(username, passwd, balance) values ('"+us.getuName()+"', '"+us.getPassWd1()+"', "+us.getBalance()+") ";
		stat.executeUpdate(sql2);
		return stat.executeUpdate(sql);
	}
	
	
	public static boolean loginUser(User us) throws Exception{
		
		//select username from User table
		Statement stat = Util.getConnection().createStatement();
		String sql = "select username from User where username='"+us.getuName()+"' and password='"+us.getPassWd1()+"'";
		ResultSet rs = stat.executeQuery(sql);
		return rs.next();
//		return rs.getString(1);
		
	}
	
	public String returnUName(User us) throws SQLException, ClassNotFoundException {

		
		Statement stat = Util.getConnection().createStatement();
        String sql = " select username from User where password='"+us.getPassWd1()+"' ";
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        return rs.getString(1);

    }
	
	public int returnAccNo(User us) throws SQLException, ClassNotFoundException {
		
		
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where username='"+us.getuName()+"' and passwd='"+us.getPassWd1()+"' ";
        System.out.println(us.getuName()+" "+us.getPassWd1());
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        return rs.getInt("accNo");

    }
	
	public int updateDebitBalance(int accNo, User us) throws SQLException, ClassNotFoundException {

		Statement stat = Util.getConnection().createStatement();
        double balance1;
        String type = "Dr";
        String sql1 =" select round(balance,2) from RegisterDetails where accNo="+accNo+" ";
        ResultSet rs = stat.executeQuery(sql1);
        rs.next();
        balance1 = rs.getDouble(1);
        
        
        if(balance1 > 1000) {
            balance1 -= us.getAmount();
        }
        
        balance1 = Math.round(balance1 * Math.pow(10, 3)) / Math.pow(10, 3);
        
        String sql = " insert into Transaction values("+accNo+", "+us.getAmount()+", '"+type+"', "+balance1+") ";

        int res = stat.executeUpdate(sql);

        String sql2 = " update RegisterDetails set balance="+balance1+" where accNo="+accNo+" ";
        stat.executeUpdate(sql2);

        return res;

    }
	
	public double showBalance(User us) throws SQLException, ClassNotFoundException {

		Statement stat = Util.getConnection().createStatement();
        double balance;
        String sql = " select balance from RegisterDetails where username='"+us.getuName()+"' and passwd='"+us.getPassWd1()+"' ";
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        balance = rs.getDouble(1);  

        return balance;

    }
	
	 public int updateCreditBalance(int accNo, User us) throws SQLException, ClassNotFoundException {

		 	Statement stat = Util.getConnection().createStatement();
	        double balance1;
	        String type = "Cr";
	        String sql1 =" select balance from RegisterDetails where accNo="+accNo+" ";
	        ResultSet rs = stat.executeQuery(sql1);
	        rs.next();
	        balance1 = rs.getDouble(1);
	        balance1 += us.getAmount();
	        
	        balance1 = Math.round(balance1 * Math.pow(10, 3)) / Math.pow(10, 3);

	        String sql = " insert into Transaction values("+accNo+", "+us.getAmount()+", '"+type+"', "+balance1+") ";
	        int res = stat.executeUpdate(sql);

	        String sql2 = " update RegisterDetails set balance="+balance1+" where accNo="+accNo+" ";
	        stat.executeUpdate(sql2);

	        return res;

	 }
	 
	 public List<User> showTransactionDetails(User us) throws SQLException, ClassNotFoundException {

		 	Statement stat = Util.getConnection().createStatement();
	        int accNo;
	        List<User> transList = new ArrayList<User>();
	        String sql1 = " select accNo from RegisterDetails where username='"+us.getuName()+"' and passwd='"+us.getPassWd1()+"' ";
	        ResultSet rs = stat.executeQuery(sql1);
	        rs.next();
	        accNo = rs.getInt(1);
	        String sql = " select * from Transaction where accNo="+accNo+" ";
	        ResultSet rs1 = stat.executeQuery(sql);
	        while(rs1.next()){

	            User use = new User();
	            use.setAccNo(rs1.getInt(1));
	            use.setAmount(rs1.getDouble(2));
	            use.setDrORCr(rs1.getString(3));
	            use.setBalance(rs1.getDouble(4));

	            transList.add(use);

	        }
	        return transList;
	 }
	 
	 public int transferDetails(int accNo, int Benf_AccNo, User us) throws ClassNotFoundException, SQLException {
		 
		 Statement stat = Util.getConnection().createStatement();
		 double balance1;
		 String type = "Dr";
		 
		 String sql = " select accNo from RegisterDetails where username='"+us.getuName()+"' and passwd='"+us.getPassWd1()+"' ";
		 System.out.println(us.getuName()+" "+us.getPassWd1());
		 ResultSet rs1 = stat.executeQuery(sql);
		 rs1.next();
		 accNo = rs1.getInt("accNo");
		 
		 
		 String sql1 =" select balance from RegisterDetails where accNo="+accNo+" ";
	     ResultSet rs = stat.executeQuery(sql1);
	     rs.next();
	     balance1 = rs.getDouble("balance");
	     
	     if(balance1 > 1000) {
	          balance1 -= us.getAmount();  
	     }
	     
	     balance1 = Math.round(balance1 * Math.pow(10, 3)) / Math.pow(10, 3);
	     
	     String sql2 = " insert into Transaction values("+accNo+", "+us.getAmount()+", '"+type+"', "+balance1+") ";
	     stat.executeUpdate(sql2);

         String sql3 = " update RegisterDetails set balance="+balance1+" where accNo="+accNo+" ";
         stat.executeUpdate(sql3);
        
         String sql4 = " insert into Transfer values("+Benf_AccNo+", "+us.getAmount()+", "+balance1+") ";
         int res = stat.executeUpdate(sql4);
        
         return res;
	     
	 }
}
