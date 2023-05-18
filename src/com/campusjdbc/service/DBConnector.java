package com.campusjdbc.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    private static final String dbUrl = "jdbc:mysql://13.209.76.58:3306/somebody_town"; // your database url
    private static final String username = "jeff"; // your database username
    private static final String password = "dlaxowhd"; // your database password

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