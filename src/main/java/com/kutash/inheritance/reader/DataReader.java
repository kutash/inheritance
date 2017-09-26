package com.kutash.inheritance.reader;

import com.kutash.inheritance.exception.ReadingException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DataReader {

    private static final Logger LOGGER = LogManager.getLogger();

    public List<String> read(String fileName) throws ReadingException {

        LOGGER.log(Level.INFO,"reader data from file");

        List<String> rows;
        try {
            //This method ensures that the file is closed when all bytes have been read or an I/O error, or other runtime exception, is thrown.
            rows  = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new ReadingException("exception in reader data", e);
        }
        if (rows.size() == 0){
            LOGGER.log(Level.FATAL,"empty file");
            throw new ReadingException("empty file");
        }
        return rows;
    }
}
