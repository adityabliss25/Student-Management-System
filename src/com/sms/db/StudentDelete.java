package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class StudentDelete {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_management_db";
        String user = "root";
        String password = "admin123";

        String sql = "DELETE FROM students WHERE student_id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, 1); // Deletes the student with ID 1

            int rowsDeleted = pstmt.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("🗑️ Student record deleted successfully!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}