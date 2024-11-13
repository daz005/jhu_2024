package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
	
//    private static final String JDBC_URL = "jdbc:derby://localhost:1527/yourDB;create=true";
//    private static final String USER = "yourUsername";
//    private static final String PASSWORD = "yourPassword";

    public static final String dbClassName = "org.apache.derby.jdbc.EmbeddedDriver";
    public static final String JDBC_URL = "jdbc:derby:DerekDB;create=true";
    

    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

    	try {
	        Class.forName(dbClassName);
        } 
    	catch (ClassNotFoundException e) 
        {
            String error  = "Error loading the databse driver: "  + e.getMessage();
            System.out.println(error);
        } 

        return DriverManager.getConnection(JDBC_URL);
    }
}
