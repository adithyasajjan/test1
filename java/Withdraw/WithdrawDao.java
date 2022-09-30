package Withdraw;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;




public class WithdrawDao {
	
	public boolean returnAccNo(WithdrawUser us, String username) throws SQLException, ClassNotFoundException {
		
		
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where pin="+us.getPin()+" and username='"+username+"'";
        ResultSet rs = stat.executeQuery(sql);
        return rs.next();     

    }
	
	public int updateDebitBalance(int pin, String username, WithdrawUser us) throws SQLException, ClassNotFoundException {

	 	Statement stat = Util.getConnection().createStatement();
        double balance1;
        String type = "Dr";
        String to_name = "Self";
        int accNo;
        
        if(us.getDescrip() == null) {
        	
        	us.setDescrip("none");
        }
        
        String sql4 = " select accNo from RegisterDetails where pin="+pin+" and username='"+username+"'";
        ResultSet rs4 = stat.executeQuery(sql4);
        rs4.next();
        accNo = rs4.getInt("accNo");
        
        String sql1 =" select balance from RegisterDetails where accNo="+accNo+" ";
        ResultSet rs = stat.executeQuery(sql1);
        rs.next();
        balance1 = rs.getDouble(1);
        balance1 -= us.getAmount();
        
        balance1 = Math.round(balance1 * Math.pow(10, 3)) / Math.pow(10, 3);
        
        LocalDateTime dt = java.time.LocalDateTime.now();

        String sql = " insert into Transaction values("+accNo+", '"+dt+"' ,'"+to_name+"', "+us.getAmount()+",'"+us.getDescrip()+"', '"+type+"', "+balance1+") ";
        int res = stat.executeUpdate(sql);

        String sql2 = " update RegisterDetails set balance="+balance1+" where accNo="+accNo+" ";
        stat.executeUpdate(sql2);

        return res;

	}
	
	public double showBalance(WithdrawUser us, String username) throws SQLException, ClassNotFoundException {

		Statement stat = Util.getConnection().createStatement();
        double balance;
        String sql = " select balance from RegisterDetails where pin="+us.getPin()+" and username='"+username+"' ";
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        balance = rs.getDouble(1);  

        return balance;

    }
}
