package com.employeemanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    private static final String URL =
            System.getProperty("db.url",
                    "jdbc:mysql://localhost:3306/company_db?useSSL=false&serverTimezone=UTC");
    private static final String USER =
            System.getProperty("db.user", System.getenv().getOrDefault("DB_USER", "root"));
    private static final String PASSWORD =
            System.getProperty("db.password", System.getenv().getOrDefault("DB_PASSWORD", ""));

    private DatabaseConnection() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
