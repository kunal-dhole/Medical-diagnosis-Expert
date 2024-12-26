package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	  private static final String URL = "jdbc:mysql://localhost:3306/medical";
	    private static final String USER = "root"; // Replace with your database username
	    private static final String PASSWORD = "root"; // Replace with your database password

	    static {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException("MySQL JDBC Driver not found.", e);
	        }
	    }

	    public static Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    }
	}

