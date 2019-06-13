package com.kn.competition.model.competition;

import java.util.HashMap;

/**
 * Decathlon competition rules
 * Created by raindream on 21.04.19.
 */
public final class CompetitionRules {

    /** One Hundred Meters competition type */
    public static final String ONE_HUNDRED_METERS_TYPE = "oneHundredMeters";
    /** Long Jump competition type */
    public static final String LONG_JUMP_TYPE = "longJump";
    /** Short put competition type */
    public static final String SHOT_PUT_TYPE = "shotPut";
    /** high jump competition type */
    public static final String HIGH_JUMP_TYPE = "highJump";
    /** 400 meters competition type */
    public static final String FOUR_HUNDRED_METERS_TYPE = "fourHundredMeters";
    /** 110 hurdles competition type */
    public static final String ONE_HUNDRED_TEN_HURDLES_TYPE = "oneHundredTenHurdles";
    /** Discus throw competition type */
    public static final String DISCUS_THROW_TYPE = "discusThrow";
    /** Pole vault competition type */
    public static final String POLE_VAULT_TYPE = "poleVault";
    /** Javelin throw competition type */
    public static final String JAVELIN_THROW_TYPE = "javelinThrow";
    /** 1500 meters competition type */
    public static final String ONE_THOUSAND_FIVE_HUNDRED_METERS_TYPE = "oneThousandFiveHundredMeters";

    /**
     * Competition map, contains data for calculate total score
     */
    public static final HashMap<String, Competition> competitionMap = new HashMap<String, Competition>() {{
        put(ONE_HUNDRED_METERS_TYPE, new Competition(ONE_HUNDRED_METERS_TYPE));
        put(LONG_JUMP_TYPE, new Competition(LONG_JUMP_TYPE));
        put(SHOT_PUT_TYPE, new Competition(SHOT_PUT_TYPE));
        put(HIGH_JUMP_TYPE, new Competition(HIGH_JUMP_TYPE));
        put(FOUR_HUNDRED_METERS_TYPE, new Competition(FOUR_HUNDRED_METERS_TYPE));
        put(ONE_HUNDRED_TEN_HURDLES_TYPE, new Competition(ONE_HUNDRED_TEN_HURDLES_TYPE));
        put(DISCUS_THROW_TYPE, new Competition(DISCUS_THROW_TYPE));
        put(POLE_VAULT_TYPE, new Competition(POLE_VAULT_TYPE));
        put(JAVELIN_THROW_TYPE, new Competition(JAVELIN_THROW_TYPE));
        put(ONE_THOUSAND_FIVE_HUNDRED_METERS_TYPE, new Competition(ONE_THOUSAND_FIVE_HUNDRED_METERS_TYPE));
    }};
}
