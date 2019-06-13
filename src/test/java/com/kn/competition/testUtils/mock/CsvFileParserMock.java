package com.kn.competition.testUtils.mock;

import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.service.file.parse.AthleteFileParser;

import java.util.List;

/**
 * CsvFileParserMock
 * Created by raindream on 03.05.19.
 */
public class CsvFileParserMock implements AthleteFileParser<DecathlonAthleteModel> {
    @Override
    public List<DecathlonAthleteModel> parseFile() {
        return null;
    }
}
