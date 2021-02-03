package com.optimal_solutions_task.db_service.sql_statement;

import lombok.Getter;

@Getter
public class DDLStatement {

    public String getEmployeesDDL() {

        return "DROP TABLE IF EXISTS EMPLOYEES;" +
                "CREATE TABLE EMPLOYEES(\n" +
                "A VARCHAR(20) DEFAULT NULL,\n" +
                "B VARCHAR(20) DEFAULT NULL,\n" +
                "C VARCHAR(50) DEFAULT NULL,\n" +
                "D VARCHAR(10) DEFAULT NULL,\n" +
                "E VARCHAR(5000) DEFAULT NULL,\n" +
                "F VARCHAR(5000) DEFAULT NULL,\n" +
                "G VARCHAR(30) DEFAULT NULL,\n" +
                "H BOOLEAN DEFAULT NULL,\n" +
                "I BOOLEAN DEFAULT NULL,\n" +
                "J VARCHAR(50) DEFAULT NULL)";
    }
}
