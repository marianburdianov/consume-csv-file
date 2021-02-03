package com.optimal_solutions_task.file_service;

public interface FileWriterService {

    void writeToValidDataCsvFile();

    void writeToFailedDataCsvFile();

    void writeToLogFile();
}
