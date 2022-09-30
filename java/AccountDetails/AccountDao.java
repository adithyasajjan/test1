package AccountDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class AccountDao {
	
	public List<AccountUser> AccountDetails(AccountUser us) throws ClassNotFoundException, SQLException {
		 
		 Statement stat = Util.getConnection().createStatement();
		 
		 List<AccountUser> detailsList = new ArrayList<AccountUser>();
		 
		 String sql = "select accNo, username, balance from RegisterDetails where username='"+us.getUsername()+"' and passwd='"+us.getPassword()+"' ";
		 
		 ResultSet rs1 = stat.executeQuery(sql);
		 
         while(rs1.next()){

        	AccountUser use = new AccountUser();
        	
            use.setAccNo(rs1.getInt("accNo"));
            use.setUsername(rs1.getString("username"));
            use.setBalance(rs1.getDouble("balance"));

            detailsList.add(use);
                      
         }
         return detailsList;
	 }
}
