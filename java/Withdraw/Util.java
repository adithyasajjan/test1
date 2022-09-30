package Withdraw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Util{
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {

        Connection con = null;

        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ServletUser", "root", "password");

        return con;
        
    }
}