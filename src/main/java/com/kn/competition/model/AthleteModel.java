package com.kn.competition.model;

/**
 * Abstract model Athlete
 * Created by raindream on 20.04.19.
 */
public abstract class AthleteModel {

    /**
     * Athlete name
     */
    private String athleteName;

    /**
     * Athlete total score
     */
    private Integer totalScore;

    /**
     * Athlete competition place
     */
    private String place;

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "AthleteModel{" +
                "athleteName='" + athleteName + '\'' +
                ", totalScore=" + totalScore +
                ", place='" + place + '\'' +
                '}';
    }
}
