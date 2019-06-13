package com.kn.competition.logic.impl;

import com.kn.competition.logic.CompetitionLogic;
import com.kn.competition.model.AthleteModel;
import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.model.competition.Competition;
import com.kn.competition.model.competition.CompetitionRules;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * Decathlon logic for calculate total score and
 * Created by raindream on 20.04.19.
 */
public class DecathlonLogicImpl implements CompetitionLogic<DecathlonAthleteModel> {

    private static final Logger LOGGER = Logger.getLogger(DecathlonLogicImpl.class.getName());

    public void fillTotalScores(List<DecathlonAthleteModel> athletes) {
        if (athletes == null || athletes.size() == 0) {
            LOGGER.warning("DecathlonLogic: fillTotalScores: can't find any athletes");
            return;
        }

        for (DecathlonAthleteModel athlete : athletes) {
            fillTotalScore(athlete);
        }
        LOGGER.info("DecathlonLogic: fillTotalScores: filling athletes scores finished");

    }

    private void fillTotalScore(DecathlonAthleteModel athleteModel) {
        HashMap<String, Double> scoreMap = Optional.ofNullable(athleteModel)
                .map(DecathlonAthleteModel::getScore)
                .orElse(null);
        if(scoreMap == null || scoreMap.isEmpty()) {
            LOGGER.warning("DecathlonLogic: fillTotalScore(): athlete score is empty: " + athleteModel.toString());
            return;
        }
        Integer totalScore = 0;
        for (Map.Entry<String, Double> entry: scoreMap.entrySet()) {
            totalScore += getPoints(entry.getKey(), entry.getValue());
        }
        athleteModel.setTotalScore(totalScore);
    }

    private Integer getPoints(String competitionName, Double points) {
        Competition competition = CompetitionRules.competitionMap.get(competitionName);
        Double sum = competition.getParameterA() *
                Math.pow(Math.abs(points - competition.getParameterB()), competition.getParameterC());
        return sum.intValue();
    }

    //TODO implement place "3-4"  instead of 3 and 4 for equals scores
    public List<DecathlonAthleteModel> setPlaceAndSortAthletes(List<DecathlonAthleteModel> athleteModelList) {
        if(athleteModelList == null || athleteModelList.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        List<DecathlonAthleteModel> sortedResult = athleteModelList.stream()
                .sorted(Comparator.comparing(AthleteModel::getTotalScore).reversed())
                .collect(Collectors.toList());

        int place = 1;
        for (DecathlonAthleteModel athlete : sortedResult) {
            athlete.setPlace(String.valueOf(place));
            place++;
        }
        return sortedResult;
    }


}
