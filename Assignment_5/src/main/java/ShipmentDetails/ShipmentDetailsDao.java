package ShipmentDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import CusDetails.Util;

public class ShipmentDetailsDao {

	public int returnTrackId(String name) throws ClassNotFoundException, SQLException {
		
		
		Statement stat = Util.getConnection().createStatement();
		
		String sql = " select trackingId from Details where name='"+name+"' " ;
		ResultSet rs = stat.executeQuery(sql);
		
		rs.next();
		return rs.getInt("trackingId");
		
	}
	
	public LocalDate returnShippingDate(String region) {
		
		LocalDate dt = LocalDate.now();
		
		LocalDate dt1;
		
		if(region.equals("North India INR 200/kg")) {
			
			dt1 = dt.plusDays(5);
		}
		
		else if(region.equals("South India INR 250/kg")) {
			
			dt1 = dt.plusDays(3);
		}
		
		else if(region.equals("East India INR 250/kg")) {
			
			dt1 = dt.plusDays(4);
		}
		else {
			
			dt1 = dt.plusDays(4);
		}
		
		return dt1;
	}
}
