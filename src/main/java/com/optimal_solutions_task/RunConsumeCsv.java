package com.optimal_solutions_task;

import com.optimal_solutions_task.db_service.*;
import com.optimal_solutions_task.db_service.sql_statement.DDLStatement;
import com.optimal_solutions_task.db_service.sql_statement.DMLStatement;
import com.optimal_solutions_task.file_service.*;

public class RunConsumeCsv {

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileParserService fileParserService = new FileParserServiceImpl(fileReaderService);
        FileWriterService fileWriterService = new FileWriterServiceImpl(fileParserService);
        fileWriterService.writeToValidDataCsvFile();
        fileWriterService.writeToFailedDataCsvFile();
        fileWriterService.writeToLogFile();

        DDLStatement ddlStatement = new DDLStatement();
        DBConnectionService connectionService = new DBConnectionServiceImpl();
        DDLService ddlService = new DDLServiceImpl(connectionService, ddlStatement);
        ddlService.createTable();

        DMLStatement dmlStatement = new DMLStatement();
        DMLService dmlService = new DMLServiceImpl(connectionService, dmlStatement, fileParserService);
        dmlService.insertIntoTable();
        dmlService.selectFromEmployees();

    }
}
