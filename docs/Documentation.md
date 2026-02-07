# Student Management System - Technical Documentation

## 1. Project Overview
The Student Management System (SMS) is a Java-based console application designed to perform CRUD (Create, Read, Update, Delete) operations on a student database. The system utilizes JDBC (Java Database Connectivity) to communicate with a MySQL server, allowing for persistent data storage.

## 2. System Architecture
The application follows a tiered architecture:Presentation Layer: Console-based User Interface (UI) using Scanner.Logic Layer: Java methods to handle user input and process SQL queries.Data Layer: MySQL Database storing student records in a relational format.

## 3. Database Schema
The database is named student_management_db. It contains a single table named students with the following structure:
| Field | Type | Key | Extra |
| :--- | :--- | :--- | :--- |
| student_id | INT | Primary Key | AUTO_INCREMENT |
| first_name | VARCHAR(50) | - | NOT NULL |
| last_name | VARCHAR(50) | - | NOT NULL |
| email | VARCHAR(100) | Unique | - |
| course | VARCHAR(50) | - | - |

## 4. Features (CRUD Operations)
The application implements the following core functionalities:

Create (Add Student): Collects user input and uses a PreparedStatement to securely insert new records into the database.

Read (View All Students): Fetches all records using a ResultSet and displays them in a formatted table in the console.

Update (Edit Course): Allows the user to modify the course of an existing student identified by their unique student_id.

Delete (Remove Student): Permanently removes a student record from the database based on the provided student_id.

## 5. Technical Implementation Details
Driver: mysql-connector-j-9.6.0.jar

Connection Management: Established via DriverManager.getConnection() using a secure local URL (jdbc:mysql://localhost:3306/).

Security: Implemented PreparedStatement for all variable-based queries to prevent SQL Injection attacks.

Resource Management: Utilized try-with-resources blocks to ensure Database Connections and ResultSets are closed automatically, preventing memory leaks.

## 6. Setup Instructions
Database: Import the SQL schema and create the students table in MySQL Workbench.

Java Environment: Import the MySQL Connector JAR into the project libraries in IntelliJ IDEA.

Configuration: Update the URL, USER, and PASS constants in the StudentApp.java file to match the local environment.

Execution: Run the main method in StudentApp.java to launch the console menu.
