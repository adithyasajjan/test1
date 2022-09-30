package Register;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class RegisterDao {

	public int dataSave(RegisterUser us) throws ClassNotFoundException, SQLException {
		Statement stat = Util.getConnection().createStatement();
		String sql = " insert into User values('"+us.getUsername()+"', '"+us.getPasswd1()+"', "+us.getPin()+") ";
		String sql2 = "insert into RegisterDetails(username, passwd, pin, balance) values ('"+us.getUsername()+"', '"+us.getPasswd1()+"',"+us.getPin()+", "+us.getBalance()+") ";
		stat.executeUpdate(sql2);
		return stat.executeUpdate(sql);
	}
	
	public boolean checkUsername(RegisterUser us) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		String sql = " select username from User where username='"+us.getUsername()+"' ";
		ResultSet rs = stat.executeQuery(sql);
		return rs.next();
		
	}
}

