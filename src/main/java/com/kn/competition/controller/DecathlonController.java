package com.kn.competition.controller;

import com.kn.competition.logic.CompetitionLogic;
import com.kn.competition.logic.impl.DecathlonLogicImpl;
import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.service.file.export.AthleteFileGenerator;
import com.kn.competition.service.file.export.impl.XmlDecathlonGenerator;
import com.kn.competition.service.file.parse.AthleteFileParser;
import com.kn.competition.service.file.parse.impl.CsvDecathlonFileParser;

import java.util.List;
import java.util.logging.Logger;

/**
 * Decathlon controller, which doing all dirty work
 * Created by raindream on 01.05.19.
 */
public class DecathlonController {

    private static final Logger LOGGER = Logger.getLogger( DecathlonController.class.getName() );

    /** logic for calculating score and sorting */
    private CompetitionLogic<DecathlonAthleteModel> decathlonLogic;
    /** csv file parser */
    private AthleteFileParser<DecathlonAthleteModel> csvFileParser;
    /** xml file generator */
    private AthleteFileGenerator<DecathlonAthleteModel> xmlFileGenerator;

    public DecathlonController() {
        this.decathlonLogic = new DecathlonLogicImpl();
        this.csvFileParser = new CsvDecathlonFileParser();
        this.xmlFileGenerator = new XmlDecathlonGenerator();
    }

    /**
     * Parse csv-file, calculate total score, sort by place and generate xml-file
     */
    public void calculateAndConvertCompetition() {
        List<DecathlonAthleteModel> athletes = csvFileParser.parseFile();
        decathlonLogic.fillTotalScores(athletes);
        List<DecathlonAthleteModel> sortedAthletes = decathlonLogic.setPlaceAndSortAthletes(athletes);
        xmlFileGenerator.generateFile(sortedAthletes);
        LOGGER.info("DecathlonController: calculateAndConvertCompetition finished with success");
    }
}
