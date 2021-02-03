package com.optimal_solutions_task.file_service;

import java.util.List;

public interface FileParserService {

    List<String[]> selectValidDataFromSourceFile();

    List<String[]> selectInvalidDataFromSourceFile();

    int getNumberOfAllRecords();
}
