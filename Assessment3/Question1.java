package JavaDatabase.Assessment3;

import java.sql.*;

public class Question1 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver"); //S2 - load the driver

        //S3 - Create Connection object
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WorkerManagement","root","password");

        //S4 - Statement
        Statement st=con.createStatement();

        String sql = "select upper(concat(FIRST_NAME,' ',LAST_NAME)) as FULL_NAME from Worker";
        ResultSet rs = st.executeQuery(sql);

        System.out.println(" FULL_NAME");
        System.out.println("---------------");
        while(rs.next()){
            System.out.println(rs.getString("FULL_NAME"));
        }
//        PreparedStatement ps =
    }
}
