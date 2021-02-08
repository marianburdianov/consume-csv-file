package com.optimal_solutions_task.db_service;

import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

public class DBConnectionServiceImpl implements DBConnectionService {

    @Override
    public Connection getConnection() {

        String dbUrl = "jdbc:h2:mem:default";
        Connection connection = null;

        try {

            DataSource dataSource = getDataSource(dbUrl);
            connection = dataSource.getConnection();

        } catch (Exception e) {

        }
        return connection;
    }

    private DataSource getDataSource(String dbUrl) {

        HikariDataSource dataSource = new HikariDataSource();

        dataSource.setJdbcUrl(dbUrl);

        return dataSource;
    }
}
