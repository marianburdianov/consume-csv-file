package com.optimal_solutions_task.file_service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum PathToFiles {

    SOURCE_DATA_FILE("src/main/resources/files_csv/Interview-task-data-osh (2).csv"),
    VALID_DATA_FILE("src/main/resources/files_csv/valid_data_file.csv"),
    FAILED_DATA_FILE("src/main/resources/files_csv/failed_data_file.csv"),
    LOG_FILE("src/main/resources/files_log/statistics.log");

    private final String filePath;

    public String getFilePath() {

        return this.filePath;
    }
}
