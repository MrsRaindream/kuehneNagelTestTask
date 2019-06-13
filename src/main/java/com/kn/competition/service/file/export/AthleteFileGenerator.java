package com.kn.competition.service.file.export;

import com.kn.competition.model.AthleteModel;

import java.util.List;

/**
 * Athlete File Generator
 * Created by raindream on 28.04.19.
 */
public interface AthleteFileGenerator<T extends AthleteModel> {

    /**
     * Generate file with Athletes results
     * @param athlete
     */
    void generateFile(List<T> athlete);
}
