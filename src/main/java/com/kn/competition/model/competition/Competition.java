package com.kn.competition.model.competition;

import com.kn.competition.config.DecathlonConfig;

import java.util.Properties;

/**
 * Competition model for calculate Decathlon total score
 * @link https://en.wikipedia.org/wiki/Decathlon
 * Created by raindream on 20.04.19.
 */
public class Competition {

    /**
     * Competition type
     */
    private String type;

    /**
     * Parameter A for calculate Decathlon total score
     * @link https://en.wikipedia.org/wiki/Decathlon
     */
    private Double parameterA;

    /**
     * Parameter B for calculate Decathlon total score
     * @link https://en.wikipedia.org/wiki/Decathlon
     */
    private Double parameterB;

    /**
     *  Parameter C for calculate Decathlon total score
     *  @link https://en.wikipedia.org/wiki/Decathlon
     */
    private Double parameterC;

    public Competition(String type) {
        this.type = type;
        Properties properties = DecathlonConfig.getProperties();
        this.parameterA = Double.valueOf(properties.getProperty(type + "." + "paramA"));
        this.parameterB = Double.valueOf(properties.getProperty(type + "." + "paramB"));
        this.parameterC = Double.valueOf(properties.getProperty(type + "." + "paramC"));
    }

    public String getType() {
        return type;
    }

    public Double getParameterA() {
        return parameterA;
    }

    public Double getParameterB() {
        return parameterB;
    }

    public Double getParameterC() {
        return parameterC;
    }
}
