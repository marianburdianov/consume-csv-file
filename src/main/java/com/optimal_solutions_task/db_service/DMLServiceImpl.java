package com.optimal_solutions_task.db_service;

import com.optimal_solutions_task.db_service.sql_statement.DMLStatement;
import com.optimal_solutions_task.file_service.FileParserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Getter
@RequiredArgsConstructor
public class DMLServiceImpl implements DMLService {

    private final DBConnectionService dbConnectionService;
    private final DMLStatement dmlStatement;
    private final FileParserService fileParserService;

    @Override
    public void insertIntoTable() {

        List<String[]> employees = null;
        String query = dmlStatement.getEmployeeDML();

        try (Connection connection = dbConnectionService.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            employees = fileParserService.selectValidDataFromSourceFile();

            for (String[] record : employees) {

                statement.setString(1, record[0]);
                statement.setString(2, record[1]);
                statement.setString(3, record[2]);
                statement.setString(4, record[3]);
                statement.setString(5, record[4]);
                statement.setString(6, record[5]);
                statement.setString(7, record[6]);
                statement.setBoolean(8, Boolean.parseBoolean(record[7]));
                statement.setBoolean(9, Boolean.parseBoolean(record[8]));
                statement.setString(10, record[9]);

                statement.addBatch();
            }

            statement.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void selectFromEmployees() {

        String query = dmlStatement.selectFromEmployeesDML();

        try (Connection connection = dbConnectionService.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (ResultSet resultSet = preparedStatement.executeQuery(); resultSet.next(); ) {

                String employee = String.format("Read employee: A=%s B=%s C=%s D=%s E=%s F=%s G=%s H=%s I=%s J=%s",

                        resultSet.getString("A"),
                        resultSet.getString("B"),
                        resultSet.getString("C"),
                        resultSet.getString("D"),
                        resultSet.getString("E"),
                        resultSet.getString("F"),
                        resultSet.getString("G"),
                        resultSet.getBoolean("H"),
                        resultSet.getBoolean("I"),
                        resultSet.getString("J"));

                System.out.println(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
