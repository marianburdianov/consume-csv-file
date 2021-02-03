package com.optimal_solutions_task.db_service.sql_statement;

import lombok.Getter;

@Getter
public class DMLStatement {

    public String getEmployeeDML() {

        return "INSERT INTO EMPLOYEES (A, B, C, D, E, F, G, H, I, J)" +
                " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    public String selectFromEmployeesDML() {

        return "SELECT * FROM EMPLOYEES";
    }
}
