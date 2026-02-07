package com.sms;

import java.sql.*;
import java.util.Scanner;

public class StudentApp {
    // Database credentials
    private static final String URL = "jdbc:mysql://localhost:3306/student_management_db";
    private static final String USER = "root";
    private static final String PASS = "admin123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("=== Welcome to the Student Management System ===");

        while (!exit) {
            System.out.println("\n1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Course");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: addStudent(scanner); break;
                case 2: viewStudents(); break;
                case 3: updateStudent(scanner); break;
                case 4: deleteStudent(scanner); break;
                case 5: exit = true; break;
                default: System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
        System.out.println("Goodbye!");
    }

    // --- CRUD METHODS ---

    private static void addStudent(Scanner sc) {
        System.out.print("Enter First Name: "); String first = sc.nextLine();
        System.out.print("Enter Last Name: "); String last = sc.nextLine();
        System.out.print("Enter Email: "); String email = sc.nextLine();
        System.out.print("Enter Course: "); String course = sc.nextLine();

        String sql = "INSERT INTO students (first_name, last_name, email, course) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, first);
            pstmt.setString(2, last);
            pstmt.setString(3, email);
            pstmt.setString(4, course);
            pstmt.executeUpdate();
            System.out.println("✅ Student added!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void viewStudents() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM students")) {
            System.out.println("\nID | Name | Email | Course");
            while (rs.next()) {
                System.out.println(rs.getInt("student_id") + " | " +
                        rs.getString("first_name") + " " + rs.getString("last_name") + " | " +
                        rs.getString("email") + " | " + rs.getString("course"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void updateStudent(Scanner sc) {
        System.out.print("Enter Student ID to update: "); int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter New Course: "); String course = sc.nextLine();

        String sql = "UPDATE students SET course = ? WHERE student_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, course);
            pstmt.setInt(2, id);
            int rows = pstmt.executeUpdate();
            if (rows > 0) System.out.println("✅ Update successful!");
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private static void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to delete: "); int id = sc.nextInt();
        try (Connection conn = DriverManager.getConnection(URL, USER, PASS);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM students WHERE student_id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("🗑️ Student deleted!");
        } catch (SQLException e) { e.printStackTrace(); }
    }
}