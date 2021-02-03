package com.optimal_solutions_task.file_service;

import com.opencsv.CSVWriter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static com.optimal_solutions_task.file_service.PathToFiles.*;

@Setter
@Getter
@RequiredArgsConstructor
public class FileWriterServiceImpl implements FileWriterService {

    private final FileParserService fileParserService;

    @Override
    public void writeToValidDataCsvFile() {

        List<String[]> validRecords = fileParserService.selectValidDataFromSourceFile();

        try (CSVWriter writer = new CSVWriter(new FileWriter(VALID_DATA_FILE.getFilePath()))) {

            writer.writeAll(validRecords);

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFailedDataCsvFile() {

        List<String[]> invalidRecords = fileParserService.selectInvalidDataFromSourceFile();

        try (CSVWriter writer = new CSVWriter(new FileWriter(FAILED_DATA_FILE.getFilePath()))) {

            writer.writeAll(invalidRecords);

        } catch (FileNotFoundException e) {
            e.fillInStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToLogFile() {

        FileHandler handler = null;
        SimpleFormatter formatter;
        Logger logger = Logger.getLogger("Statistics_log");

        int numberOfReceivedRecords = fileParserService.getNumberOfAllRecords();
        int numberOfSuccessfulRecords = fileParserService.selectValidDataFromSourceFile().size();
        int numberOfFailedRecords = fileParserService.selectInvalidDataFromSourceFile().size();

        try {

            handler = new FileHandler(LOG_FILE.getFilePath(), true);
            logger.addHandler(handler);
            formatter = new SimpleFormatter();
            handler.setFormatter(formatter);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            handler.close();
        }

        logger.info(numberOfReceivedRecords + " of records received");
        logger.info(numberOfSuccessfulRecords + " of records successful");
        logger.info(numberOfFailedRecords + " of records failed");
    }
}
