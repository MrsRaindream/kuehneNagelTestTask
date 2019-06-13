package com.kn.competition.service.file.parse.impl;

import com.kn.competition.converter.RaceTimeConverter;
import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.model.competition.CompetitionRules;
import com.kn.competition.service.file.parse.AthleteFileParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

/**
 * Csv Decathlon File Parser
 * Created by raindream on 20.04.19.
 */
public class CsvDecathlonFileParser implements AthleteFileParser<DecathlonAthleteModel> {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger( CsvDecathlonFileParser.class.getName() );

    /**
     * scv file path to parse
     */
    public static final String CSV_FILE = "dataProvider/decathlon/results.csv";

    /**
     * separator for csv file
     */
    public static final String CSV_SPLIT_BY = ";";

    public List<DecathlonAthleteModel> parseFile() {
        BufferedReader br = null;
        List<DecathlonAthleteModel> decathlonAthletes = new ArrayList<DecathlonAthleteModel>();
        String line = "";

        try {

            br = new BufferedReader(new FileReader(CSV_FILE));

            while ((line = br.readLine()) != null) {
                DecathlonAthleteModel athlete = new DecathlonAthleteModel();
                HashMap<String, Double> scores = new HashMap<>();

                String[] athleteCsvArray = line.split(CSV_SPLIT_BY);

                athlete.setAthleteName(athleteCsvArray[0]);

                scores.put(CompetitionRules.ONE_HUNDRED_METERS_TYPE, Double.parseDouble(athleteCsvArray[1]));
                scores.put(CompetitionRules.LONG_JUMP_TYPE, Double.parseDouble(athleteCsvArray[2]));
                scores.put(CompetitionRules.SHOT_PUT_TYPE, Double.parseDouble(athleteCsvArray[3]));
                scores.put(CompetitionRules.HIGH_JUMP_TYPE, Double.parseDouble(athleteCsvArray[4]));
                scores.put(CompetitionRules.FOUR_HUNDRED_METERS_TYPE, Double.parseDouble(athleteCsvArray[5]));
                scores.put(CompetitionRules.ONE_HUNDRED_TEN_HURDLES_TYPE, Double.parseDouble(athleteCsvArray[6]));
                scores.put(CompetitionRules.DISCUS_THROW_TYPE, Double.parseDouble(athleteCsvArray[7]));
                scores.put(CompetitionRules.POLE_VAULT_TYPE, Double.parseDouble(athleteCsvArray[8]));
                scores.put(CompetitionRules.JAVELIN_THROW_TYPE, Double.parseDouble(athleteCsvArray[9]));
                scores.put(CompetitionRules.ONE_THOUSAND_FIVE_HUNDRED_METERS_TYPE,
                        RaceTimeConverter.convertTimeStringToSeconds(athleteCsvArray[10]));

                athlete.setScore(scores);
                decathlonAthletes.add(athlete);
            }

        } catch (FileNotFoundException e) {
            LOGGER.warning(this.getClass().getSimpleName() + " throws " + e.getClass() + " with message: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            LOGGER.warning(this.getClass().getSimpleName() + " throws " + e.getClass() + " with message: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    LOGGER.warning(this.getClass().getSimpleName() + " throws " + e.getClass() + " with message: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        LOGGER.info("CsvDecathlonFileParser: CSV file has successfully parsed");
        return decathlonAthletes;
    }


}
