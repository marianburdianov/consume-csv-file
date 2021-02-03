package com.optimal_solutions_task.file_service;

import java.util.List;

public interface FileReaderService {

    List<String[]> getFromSourceDataCsvFile();

    String[] getHeaders();
}
