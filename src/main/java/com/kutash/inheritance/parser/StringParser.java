package com.kutash.inheritance.parser;

import com.kutash.inheritance.exception.EmployeeException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringParser {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String SPACE_REGEX = " ";
    private static final String COMMA_REGEX = ",";

    public List<String[][]> parseString(List<String> list) throws EmployeeException {

        LOGGER.log(Level.INFO,"parsing strings");

        if (list == null){
            throw new EmployeeException("no data for parsing");
        }
        List<String> validLines = list.stream().filter(new StringValidator()::validate).collect(Collectors.toList());

        List<String[][]> data = new ArrayList<>();

        for (String s : validLines) {
            String[][] allData = new String[2][];
            String[] generalInfo = s.split(SPACE_REGEX);
            allData[0] = generalInfo;
            String[] listSkills = generalInfo[generalInfo.length-1].split(COMMA_REGEX);
            allData[1] = listSkills;
            data.add(allData);
        }
        return data;
    }
}
