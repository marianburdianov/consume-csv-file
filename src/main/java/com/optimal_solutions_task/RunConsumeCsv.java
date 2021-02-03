package com.optimal_solutions_task;

import com.optimal_solutions_task.file_service.*;

public class RunConsumeCsv {

    public static void main(String[] args) {

        FileReaderService fileReaderService = new FileReaderServiceImpl();
        FileParserService fileParserService = new FileParserServiceImpl(fileReaderService);
        FileWriterService fileWriterService = new FileWriterServiceImpl(fileParserService);
        fileWriterService.writeToValidDataCsvFile();
        fileWriterService.writeToFailedDataCsvFile();
        fileWriterService.writeToLogFile();
    }
}
