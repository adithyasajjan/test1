package Balance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BalanceDao {

	public boolean returnAccNo(BalanceUser us, String username) throws SQLException, ClassNotFoundException {
		
		System.out.println(username);
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where pin="+us.getPin()+" and username='"+username+"' ";
        ResultSet rs = stat.executeQuery(sql);
        return rs.next();     

    }
	
	public double showBalance(BalanceUser us, String username) throws SQLException, ClassNotFoundException {

		Statement stat = Util.getConnection().createStatement();
        double balance;
        String sql = " select balance from RegisterDetails where pin="+us.getPin()+" and username='"+username+"' ";
        ResultSet rs = stat.executeQuery(sql);
        rs.next();
        balance = rs.getDouble(1);  

        return balance;

    }
}
