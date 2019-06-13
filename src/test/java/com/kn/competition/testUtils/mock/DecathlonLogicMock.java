package com.kn.competition.testUtils.mock;

import com.kn.competition.logic.CompetitionLogic;
import com.kn.competition.model.DecathlonAthleteModel;

import java.util.List;

/**
 * DecathlonLogicMock
 * Created by raindream on 03.05.19.
 */
public class DecathlonLogicMock implements CompetitionLogic<DecathlonAthleteModel> {
    @Override
    public void fillTotalScores(List<DecathlonAthleteModel> athleteModel) {

    }

    @Override
    public List<DecathlonAthleteModel> setPlaceAndSortAthletes(List<DecathlonAthleteModel> athleteModel) {
        return null;
    }
}
