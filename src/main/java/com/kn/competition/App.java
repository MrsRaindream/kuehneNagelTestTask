package com.kn.competition;

import com.kn.competition.controller.DecathlonController;

/**
 * Decathlon competitions
 * Parse csv-file, calculate total score, sort by place and generate xml-file
 * @since 2019-05-02
 */
public class App 
{
    public static void main( String[] args )
    {
        DecathlonController decathlonController = new DecathlonController();
        decathlonController.calculateAndConvertCompetition();
    }
}
