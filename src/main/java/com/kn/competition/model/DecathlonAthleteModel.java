package com.kn.competition.model;

import java.util.HashMap;

/**
 * Decathlon Athlete Model
 * Created by raindream on 20.04.19.
 */
public class DecathlonAthleteModel extends AthleteModel {

    /**
     * Map with competition scores: HashMap < competitionName, score>
     */
    private HashMap<String, Double> score;

    public HashMap<String, Double> getScore() {
        return score;
    }

    public void setScore(HashMap<String, Double> score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "DecathlonAthleteModel{" +
                "score=" + score +
                "} " + super.toString();
    }
}
