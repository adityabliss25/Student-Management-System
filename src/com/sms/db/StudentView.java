package com.sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentView {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_management_db";
        String user = "root";
        String password = "admin123";

        String sql = "SELECT * FROM students";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID | Name | Email | Course");
            System.out.println("-----------------------------------");

            while (rs.next()) {
                int id = rs.getInt("student_id");
                String first = rs.getString("first_name");
                String last = rs.getString("last_name");
                String email = rs.getString("email");
                String course = rs.getString("course");

                System.out.println(id + " | " + first + " " + last + " | " + email + " | " + course);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}