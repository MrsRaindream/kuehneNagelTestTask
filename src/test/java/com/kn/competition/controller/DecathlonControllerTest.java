package com.kn.competition.controller;

import com.kn.competition.logic.CompetitionLogic;
import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.service.file.export.AthleteFileGenerator;
import com.kn.competition.service.file.parse.AthleteFileParser;
import com.kn.competition.testUtils.TestWithoutLog;
import com.kn.competition.testUtils.mock.CsvFileParserMock;
import com.kn.competition.testUtils.mock.DecathlonLogicMock;
import com.kn.competition.testUtils.mock.XmlFileGeneratorMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

/**
 * Created by raindream on 02.05.19.
 */
@RunWith(MockitoJUnitRunner.class)
public class DecathlonControllerTest extends TestWithoutLog {

    @InjectMocks
    private DecathlonController decathlonController;

    @Mock
    private CompetitionLogic<DecathlonAthleteModel> decathlonLogic = new DecathlonLogicMock();

    @Mock
    private AthleteFileParser<DecathlonAthleteModel> csvFileParser = new CsvFileParserMock();

    @Mock
    private AthleteFileGenerator<DecathlonAthleteModel> xmlFileGenerator = new XmlFileGeneratorMock();

    @Before
    public void init() {
        ReflectionTestUtils.setField(decathlonController, "decathlonLogic", decathlonLogic);
        ReflectionTestUtils.setField(decathlonController, "csvFileParser", csvFileParser);
        ReflectionTestUtils.setField(decathlonController, "xmlFileGenerator", xmlFileGenerator);

        when(csvFileParser.parseFile()).thenReturn(new ArrayList<>());
        doNothing().when(decathlonLogic).fillTotalScores(any());
        when(decathlonLogic.setPlaceAndSortAthletes(any())).thenReturn(new ArrayList<>());
        doNothing().when(xmlFileGenerator).generateFile(any());
    }

    @Test
    public void testCalculateAndConvertCompetition() {
        decathlonController.calculateAndConvertCompetition();
        verify(csvFileParser, times(1)).parseFile();
        verify(decathlonLogic, times(1)).fillTotalScores(new ArrayList<>());
        verify(decathlonLogic, times(1)).setPlaceAndSortAthletes(new ArrayList<>());
        verify(xmlFileGenerator, times(1)).generateFile(any());
    }
}
