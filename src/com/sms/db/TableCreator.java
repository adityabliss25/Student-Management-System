package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TableCreator {
    public static void main(String[] args) {
        // We add the database name to the end of the URL now
        String url = "jdbc:mysql://localhost:3306/student_management_db";
        String user = "root";
        String password = "admin123";

        String createTableSQL = "CREATE TABLE IF NOT EXISTS students ("
                + "student_id INT AUTO_INCREMENT PRIMARY KEY, "
                + "first_name VARCHAR(50) NOT NULL, "
                + "last_name VARCHAR(50) NOT NULL, "
                + "email VARCHAR(100) UNIQUE, "
                + "course VARCHAR(50)"
                + ");";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSQL);
            System.out.println("✅ 'students' table is ready in the database!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}