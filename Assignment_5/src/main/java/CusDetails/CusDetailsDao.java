package CusDetails;

import java.sql.SQLException;
import java.sql.Statement;

public class CusDetailsDao {
	
	public int storeDetails(CusUser cu) throws ClassNotFoundException, SQLException {
		
		Statement stat = Util.getConnection().createStatement();
		
		String sql = " insert into Details(name, city, phNum, destination, weight) values ('"+cu.getName()+"', '"+cu.getCity()+"', '"+cu.getPhNum()+"', '"+cu.getDest()+"', "+cu.getWeight()+") " ;
		return stat.executeUpdate(sql);
	}
	
}
