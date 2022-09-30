package login;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class LoginDao {
	
public boolean loginUser(LoginUser us) throws Exception{
		
		//select username from User table
		Statement stat = Util.getConnection().createStatement();
		String sql = "select username from User where username='"+us.getuName()+"' and passwd='"+us.getPassWd()+"'";
		ResultSet rs = stat.executeQuery(sql);
		return rs.next();
//		return rs.getString(1);
		
	}
}
