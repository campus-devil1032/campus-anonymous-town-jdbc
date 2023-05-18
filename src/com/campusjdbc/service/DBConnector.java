package com.campusjdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String dbUrl = "jdbc:mysql://ip입력:3306/스키마입력"; // your database url
    private static final String username = "mysqluser"; // your database username
    private static final String password = "mysql비밀번호"; // your database password

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}