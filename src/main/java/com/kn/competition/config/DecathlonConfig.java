package com.kn.competition.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Decathlon Config
 * Created by raindream on 21.04.19.
 */
public final class DecathlonConfig {

    /** path to file with decathlon constants */
    private static final String PATH_TO_PROPERTIES = "config/decathlon.properties";

    /**
     * Decathlon constants for calculate total score
     * @return
     */
    public static final Properties getProperties() {
        Properties properties = new Properties();

       try (InputStream input = new FileInputStream(PATH_TO_PROPERTIES)) {
           properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
