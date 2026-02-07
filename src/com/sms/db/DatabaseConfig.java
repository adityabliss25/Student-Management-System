package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    // Standard MySQL connection details
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "admin123";

    public static void testConnection() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("✅ Connection Successful! Ready for thisZ project.");
        } catch (SQLException e) {
            System.err.println("❌ Connection Failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        testConnection();
    }
}