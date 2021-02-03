package com.optimal_solutions_task.file_service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.optimal_solutions_task.file_service.PathToFiles.SOURCE_DATA_FILE;

public class FileReaderServiceImpl implements FileReaderService {

    @Override
    public List<String[]> getFromSourceDataCsvFile() {

        List<String[]> allRecords = new ArrayList<>();

        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(SOURCE_DATA_FILE.getFilePath()))
                .withSkipLines(1).build()) {

            allRecords = reader.readAll();

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }

        return allRecords;
    }

    @Override
    public String[] getHeaders() {

        String[] headers = null;

        try {
            CSVReader reader = new CSVReader(new FileReader(SOURCE_DATA_FILE.getFilePath()));
            headers = reader.readNext();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return headers;
    }
}
