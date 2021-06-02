package br.com.webmoto.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

public class DBUtil {

    private static Connection connection = null;

    public static Connection getConnection() {
    	
        if (connection != null)
            return connection;
        else {
            try {
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/WEBMOTODB";
                String user = "root"; 
                String password = "root";
                
                Class.forName(driver);
                
                connection = DriverManager.getConnection(url, user, password);
              
                System.out.println("JDBC Connected!! - " + new Date());
            
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
      
            return connection;
        }

    }
}