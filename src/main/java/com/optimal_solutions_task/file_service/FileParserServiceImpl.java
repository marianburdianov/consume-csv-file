package com.optimal_solutions_task.file_service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@RequiredArgsConstructor
public class FileParserServiceImpl implements FileParserService {

    private final FileReaderService readerService;


    @Override
    public List<String[]> selectValidDataFromSourceFile() {

        List<String[]> listOfAllRecords = readerService.getFromSourceDataCsvFile();
        List<String[]> validRecords = new ArrayList<>();
        int numberOfHeaders = readerService.getHeaders().length;

        for (String[] record : listOfAllRecords) {

            String[] quotedFields = new String[numberOfHeaders];

            if (record.length == numberOfHeaders) {

                for (int i = 0; i < record.length; i++) {

                    if (verifyIfContainsComma(record[i])) {

                        quotedFields[i] = addQuotesToContainingCommaFields(record[i]);

                    } else {
                        quotedFields[i] = record[i];
                    }
                }
                validRecords.add(quotedFields);
            }
        }
        return validRecords;
    }

    private boolean verifyIfContainsComma(String field) {
        return field.contains(",");
    }

    private String addQuotesToContainingCommaFields(String field) {
        return StringUtils.wrap(field, "\"");
    }


    @Override
    public List<String[]> selectInvalidDataFromSourceFile() {

        List<String[]> listOfAllRecords = readerService.getFromSourceDataCsvFile();
        List<String[]> invalidRecords = new ArrayList<>();

        for (String[] record : listOfAllRecords) {

            if (record.length != readerService.getHeaders().length) {
                invalidRecords.add(record);
            }
        }
        return invalidRecords;
    }

    @Override
    public int getNumberOfAllRecords() {

        return readerService.getFromSourceDataCsvFile().size();
    }
}
