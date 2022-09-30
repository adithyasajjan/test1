package Transaction;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TransactionDao {
	
	public boolean returnAccNo(TransactionUser us, String username) throws SQLException, ClassNotFoundException {
		
		Statement stat = Util.getConnection().createStatement();
        String sql = " select accNo from RegisterDetails where pin="+us.getPin()+" and username='"+username+"'";
        ResultSet rs = stat.executeQuery(sql);
        return rs.next();     

    }
	
	public List<TransactionUser> showTransactionDetails(TransactionUser us, String username) throws SQLException, ClassNotFoundException {

		
	 	Statement stat = Util.getConnection().createStatement();
        int accNo;
        List<TransactionUser> transList = new ArrayList<TransactionUser>();
        String sql1 = " select accNo from RegisterDetails where pin="+us.getPin()+" and username='"+username+"'";
        ResultSet rs = stat.executeQuery(sql1);
        rs.next();
        accNo = rs.getInt(1);
        
        String sql = " select * from Transaction where accNo="+accNo+" order by dt desc ";
        ResultSet rs1 = stat.executeQuery(sql);
        while(rs1.next()){
        	
        	TransactionUser use = new TransactionUser();
        	
            use.setAccNo(rs1.getInt(1));
            use.setDt(rs1.getDate(2));
            use.setToName(rs1.getString(3));
            use.setAmount(rs1.getDouble(4));
            use.setDescrip(rs1.getString(5));
            use.setDrORCr(rs1.getString(6));
            use.setBalance(rs1.getDouble(7));

            transList.add(use);

        }
        return transList;
 }

}
