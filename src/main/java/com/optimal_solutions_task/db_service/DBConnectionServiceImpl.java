package com.optimal_solutions_task.db_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionServiceImpl implements DBConnectionService {

    @Override
    public Connection getConnection() {

        String dbUrl = "jdbc:h2:mem:default";

        Connection connection = null;

        try {

            connection = DriverManager.getConnection(dbUrl);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
