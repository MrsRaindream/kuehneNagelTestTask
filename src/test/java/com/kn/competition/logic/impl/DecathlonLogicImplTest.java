package com.kn.competition.logic.impl;

import com.kn.competition.logic.CompetitionLogic;
import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.model.competition.CompetitionRules;
import com.kn.competition.testUtils.TestWithoutLog;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNull;

/**
 * DecathlonLogicImplTest
 * Created by raindream on 03.05.19.
 */
public class DecathlonLogicImplTest extends TestWithoutLog {

    private CompetitionLogic<DecathlonAthleteModel> logic = new DecathlonLogicImpl();

    private List<DecathlonAthleteModel> athletes;

    private DecathlonAthleteModel athleteModel;

    @Test
    public void testNullFillTotalScores() {
        athletes = null;
        logic.fillTotalScores(athletes);
        assertNull(athletes);
    }

    @Test
    public void testEmptyFillTotalScores() {
        athletes = new ArrayList<>();
        logic.fillTotalScores(athletes);
        assertEquals(new ArrayList<>(), athletes);
    }

    @Test
    public void testPositiveFillTotalScores() {
        initPositive();
        logic.fillTotalScores(athletes);
        Integer actualTotalScore = athletes.get(0).getTotalScore();
        assertEquals(43, actualTotalScore.intValue());
    }

    @Test
    public void testSetPlaceAndSortAthletes() {
        initPositive();
        logic.setPlaceAndSortAthletes(athletes);
        String actualPlace = athletes.get(0).getPlace();
        assertEquals("1", actualPlace);
    }

    private void initPositive() {
        HashMap<String, Double> score = new HashMap(){{
            put(CompetitionRules.DISCUS_THROW_TYPE, 1D);
        }};
        athleteModel = new DecathlonAthleteModel();
        athleteModel.setScore(score);
        athletes = Arrays.asList(athleteModel);
    }

}
