package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;


public class TransferDao {
	
	public boolean returnAccNo(TransferUser us, String username) throws SQLException, ClassNotFoundException {
		
		
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where pin="+us.getPin()+" and username='"+username+"'";
        ResultSet rs = stat.executeQuery(sql);
        return rs.next();     

    }
	
	public double showBalance(TransferUser us, String username) throws SQLException, ClassNotFoundException {

		Statement stat = Util.getConnection().createStatement();
        double balance;
        String sql = " select balance from RegisterDetails where pin="+us.getPin()+" and username='"+username+"' ";
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        balance = rs.getDouble(1);  

        return balance;

    }
	
	public int transferDetails(int pin, int Benf_AccNo, String Benif_Name, TransferUser us, String username) throws ClassNotFoundException, SQLException {
		 
		 Statement stat = Util.getConnection().createStatement();
		 double balance1;
		 String type = "Dr";
		 int accNo = 0;
		 
		 if(us.getDescrip() == null) {
			 
			 us.setDescrip("none");
		 }
		 
		 String sql = " select accNo from RegisterDetails where pin="+pin+" and username='"+username+"' ";
		 
		 ResultSet rs1 = stat.executeQuery(sql);
		 rs1.next();
		 accNo = rs1.getInt("accNo");
		 
		 
		 String sql1 =" select balance from RegisterDetails where accNo="+accNo+" ";
	     ResultSet rs = stat.executeQuery(sql1);
	     rs.next();
	     
	     balance1 = rs.getDouble("balance");
	     
	     balance1 -= us.getAmount();  
	     
	     
	     balance1 = Math.round(balance1 * Math.pow(10, 3)) / Math.pow(10, 3);
	     
	     LocalDateTime dt = java.time.LocalDateTime.now();
	     
	     String sql2 = " insert into Transaction values("+accNo+", '"+dt+"','"+Benif_Name+"',"+us.getAmount()+",'"+us.getDescrip()+"', '"+type+"', "+balance1+") ";
	     stat.executeUpdate(sql2);

        String sql3 = " update RegisterDetails set balance="+balance1+" where accNo="+accNo+" ";
        stat.executeUpdate(sql3);
       
        String sql4 = " insert into Transfer values("+Benf_AccNo+", '"+Benif_Name+"', "+us.getAmount()+", "+balance1+") ";
        int res = stat.executeUpdate(sql4);
       
        return res;
	     
	 }
	
	public boolean validateUser(String username) throws SQLException, ClassNotFoundException {
		
		Statement stat = Util.getConnection().createStatement();
		
		String sql = "select username from RegisterDetails where username='"+username+"' ";
		
		ResultSet rs = stat.executeQuery(sql);
		
	    return rs.next();
	}
	
	public String benName(int BeaccNo) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
	
		String sql = "select name from Beneficiary where accNo="+BeaccNo+" ";
		ResultSet rs = stat.executeQuery(sql);
		
		rs.next();
		return rs.getString("name");
	}
}
