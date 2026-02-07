package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentInsert {
    public static void main(String[] args) {
        // The URL now specifies the database you just created
        String url = "jdbc:mysql://localhost:3306/student_management_db";
        String user = "root";
        String password = "admin123";

        // SQL query with placeholders (?) for security
        String sql = "INSERT INTO students (first_name, last_name, email, course) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // 2. Add four parameters instead of three
            pstmt.setString(1, "John");           // matches first_name
            pstmt.setString(2, "Doe");            // matches last_name
            pstmt.setString(3, "john@email.com"); // matches email
            pstmt.setString(4, "Java Programming"); // matches course

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Success! Student added to the database.");
            }
        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}