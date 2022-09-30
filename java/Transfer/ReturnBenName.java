package Transfer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReturnBenName {
	
	public String benName(int accNo) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
	
		String sql = "select name from Beneficiary where accNo="+accNo+" ";
		ResultSet rs = stat.executeQuery(sql);
		
		rs.next();
		return rs.getString("name");
	}
}
