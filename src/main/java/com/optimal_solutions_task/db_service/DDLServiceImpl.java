package com.optimal_solutions_task.db_service;

import com.optimal_solutions_task.db_service.sql_statement.DDLStatement;
import lombok.RequiredArgsConstructor;

import java.sql.SQLException;
import java.sql.Statement;

@RequiredArgsConstructor
public class DDLServiceImpl implements DDLService {

    private final DBConnectionService connectionService;
    private final DDLStatement ddlStatement;

    @Override
    public void createTable() {

        String employees = ddlStatement.getEmployeesDDL();

        try (Statement statement = connectionService.getConnection().createStatement()) {

            statement.executeUpdate(employees);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
