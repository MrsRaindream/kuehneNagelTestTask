package com.kn.competition.logic;

import com.kn.competition.model.AthleteModel;

import java.util.List;

/**
 * Logic for calculate total score and place
 * Created by raindream on 20.04.19.
 */
public interface CompetitionLogic <T extends AthleteModel> {

    /**
     * Fill total score for athlete
     * @param athleteModel
     */
    void fillTotalScores(List<T> athleteModel);

    /**
     * Fill and sort place for athlete
     * @param athleteModel
     */
    List<T> setPlaceAndSortAthletes(List<T> athleteModel);

}
