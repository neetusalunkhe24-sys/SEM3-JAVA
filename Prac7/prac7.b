package com.mycompany.prac_7b;

import java.sql.*;
import java.util.Scanner;

public class Prac_7b {
    public static void main(String[] args) {
        // Database credentials
        String url = "jdbc:mysql://localhost:3306/test_db";
        String user = "root";
        String password = "1234";

        // Get the record ID to fetch from user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee ID to fetch: ");
        int employeeId = scanner.nextInt();

        // SQL query to fetch a specific record by ID
        String query = "SELECT * FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Set the ID parameter in the query
            stmt.setInt(1, employeeId);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    String department = rs.getString("department");

                    System.out.println("Employee ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Age: " + age);
                    System.out.println("Department: " + department);
                } else {
                    System.out.println("No employee found with ID " + employeeId);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
