package com.calculator.make_my_day;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MySQLConnect {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establish the connection to the database
            String url = "jdbc:mysql://localhost:3306/ClientInfo";
            String user = "myusername";
            String password = "mypassword";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection to MySQL database established!");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver not found");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed");
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                    System.out.println("Connection to MySQL database closed");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
    }
}


