package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/voting_system?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // Your MySQL username
    private static final String PASSWORD = "uma123"; // Your MySQL password

    static {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found. Include it in your library path.");
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connection established successfully!");
        } catch (SQLException e) {
            System.err.println("Error while establishing the connection: " + e.getMessage());
        }
        return connection;
    }
}
