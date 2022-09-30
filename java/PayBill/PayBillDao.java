package PayBill;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import AccountDetails.Util;
import Balance.BalanceUser;

public class PayBillDao {
	
	public List<PayBillUser> returnBillDetails(int consNum) throws ClassNotFoundException, SQLException{
		
		Statement stat = Util.getConnection().createStatement();
		
		List<PayBillUser> detailsList = new ArrayList<PayBillUser>();
		
//		LocalDateTime dt = java.time.LocalDateTime.now();
		
//		String sql = " update ElectricityBill set PaymentDate='"+dt+"' where consumerNo="+consNum+" ";
//		stat.executeUpdate(sql);
		
		String sql1 = " select * from ElectricityBill where consumerNo="+consNum+" ";
		ResultSet rs = stat.executeQuery(sql1);
		
		while(rs.next()) {
			
			PayBillUser pb = new PayBillUser();
			
			pb.setConsNum(rs.getInt("consumerNo"));
			pb.setName(rs.getString("name"));
			pb.setElecProvider(rs.getString("ElectricityBiller"));
			pb.setConsump(rs.getInt("Consumption"));
			pb.setBd(rs.getDate("BillDate"));
			pb.setBdd(rs.getDate("BillDueDate"));
			pb.setPd(rs.getDate("PaymentDate"));
			pb.setStatus(rs.getString("PaymentStatus"));
			pb.setAmount(rs.getDouble("BillAmount"));
			
			detailsList.add(pb);
			
		}
		return detailsList;
	}
	
	public List<PayBillUser> returnReceipt(int consNum) throws ClassNotFoundException, SQLException {
		
		String str="Paid";
		Statement stat = Util.getConnection().createStatement();
		
		List<PayBillUser> detailsList = new ArrayList<PayBillUser>();
		
		LocalDateTime dt = java.time.LocalDateTime.now();
		
		String sql = " update ElectricityBill set PaymentDate='"+dt+"', PaymentStatus='"+str+"' where consumerNo="+consNum+" ";
		stat.executeUpdate(sql);
		
		String sql1 = " select * from ElectricityBill where consumerNo="+consNum+" ";
		ResultSet rs = stat.executeQuery(sql1);
		
		while(rs.next()) {
				
				PayBillUser pb = new PayBillUser();
				
				pb.setConsNum(rs.getInt("consumerNo"));
				pb.setName(rs.getString("name"));
				pb.setElecProvider(rs.getString("ElectricityBiller"));
				pb.setConsump(rs.getInt("Consumption"));
				pb.setBd(rs.getDate("BillDate"));
				pb.setBdd(rs.getDate("BillDueDate"));
				pb.setPd(rs.getDate("PaymentDate"));
				pb.setStatus(rs.getString("PaymentStatus"));
				pb.setAmount(rs.getDouble("BillAmount"));
				
				detailsList.add(pb);
				
			}
			return detailsList;		
		
	}
	
	public boolean returnAccNo(int pin, String username) throws SQLException, ClassNotFoundException {
			
		System.out.println(username);
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where pin="+pin+" and username='"+username+"' ";
        ResultSet rs = stat.executeQuery(sql);
        return rs.next();     
	
	    }
}
