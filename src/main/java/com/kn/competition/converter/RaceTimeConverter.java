package com.kn.competition.converter;

import java.util.logging.Logger;

/**
 * Race Time Converter
 * Created by raindream on 02.05.19.
 */
public class RaceTimeConverter {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger(RaceTimeConverter.class.getName());

    /**
     * Convert string, contains Minutes Seconds Milliseconds separated with dot to seconds (double)
     * @param value string, contains minutes dot seconds dot milliseconds
     * @return seconds (Double)
     */
    public static final Double convertTimeStringToSeconds(String value) {
        Double resultInSeconds = null;
        if(value == null) {
            LOGGER.warning("RaceTimeConverter: convertTimeStringToSeconds caught error: " +
                    "there is null-input parameter (string should contain min.sec.mil)");
            return resultInSeconds;
        }
        String[] stringArray = value.split("" +
                "\\.");
        if(stringArray.length != 3) {
            LOGGER.warning("RaceTimeConverter: convertTimeStringToSeconds caught error: " +
                    "there is incorrect input parameter (string should contain min.sec.mil)");
            return resultInSeconds;
        }
        try {
            resultInSeconds = Double.parseDouble(stringArray[0])*60 +
                    Double.parseDouble(stringArray[1]) +
                    Double.parseDouble(stringArray[2])/1000;
        } catch (NumberFormatException e) {
            LOGGER.warning("RaceTimeConverter: convertTimeStringToSeconds caught NumberFormatException: " +
                    e.getMessage());
            return resultInSeconds;
        }
        return resultInSeconds;
    }
}
