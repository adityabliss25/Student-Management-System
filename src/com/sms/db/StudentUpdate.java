package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentUpdate {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_management_db";
        String user = "root";
        String password = "admin123";

        // We use the WHERE clause to make sure we only update the right person!
        String sql = "UPDATE students SET course = ? WHERE student_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, "Data Science"); // New course name
            pstmt.setInt(2, 1);                  // The ID of the student (John Doe was #1)

            int rowsUpdated = pstmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("✅ Student record updated successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}