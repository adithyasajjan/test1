package JavaDatabase.Assessment3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Question3 {

    public static void main(String[] args) throws Exception {

        Class.forName("com.mysql.jdbc.Driver"); //S2 - load the driver

        //S3 - Create Connection object
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/WorkerManagement","root","password");

        //S4 - Statement
        Statement st=con.createStatement();

        String inp = "a";

        String sql = " select FIRST_NAME, position('"+inp+"' in FIRST_NAME) from Worker";
        ResultSet rs = st.executeQuery(sql);

        System.out.println("    FNAME"+"    "+"POSITION");
        System.out.println("------------------------------");

        while(rs.next()){
            System.out.printf("%10s %6d\n", rs.getString(1), rs.getInt(2));
        }

    }
}
