package com.kn.competition.testUtils.mock;

import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.service.file.export.AthleteFileGenerator;

import java.util.List;

/**
 * XmlFileGeneratorMock
 * Created by raindream on 03.05.19.
 */
public class XmlFileGeneratorMock implements AthleteFileGenerator<DecathlonAthleteModel> {
    @Override
    public void generateFile(List<DecathlonAthleteModel> athlete) {

    }
}
