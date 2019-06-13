package com.kn.competition.service.file.parse;

import com.kn.competition.model.AthleteModel;

import java.util.List;

/**
 * Athlete File Parser
 * Created by raindream on 20.04.19.
 */
public interface AthleteFileParser<T extends AthleteModel> {

    /**
     * Parse file with athletes results from file to list of Athlete model
     * @return list of athlete models
     */
    List<T> parseFile();
}
