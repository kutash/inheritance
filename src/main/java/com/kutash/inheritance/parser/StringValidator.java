package com.kutash.inheritance.parser;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.BooleanSupplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringValidator {

    private static final Logger LOGGER = LogManager.getLogger();
    private static final String REGEX = "^([A-Za-z]{1,30}\\s){2}(\\d+(\\.?\\d+)?\\s)([A-Za-z-]{1,30}\\s){3}(\\d+(\\/?\\d+)?\\s){2}((A1|A2|B1|B2|C1|C2)\\s)?(JUNIOR|MIDDLE|SENIOR|TEAM_LEAD|\\d+)\\s((true|false)\\s)?([A-Za-z#]{1,30},?)*";

    boolean validate(String s){

        LOGGER.log(Level.INFO,"validating string {}",s);

        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(s);
        BooleanSupplier bs = matcher::matches;
        return bs.getAsBoolean();
    }
}
