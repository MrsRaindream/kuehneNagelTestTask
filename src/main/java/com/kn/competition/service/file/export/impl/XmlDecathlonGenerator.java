package com.kn.competition.service.file.export.impl;

import com.kn.competition.model.DecathlonAthleteModel;
import com.kn.competition.service.file.export.AthleteFileGenerator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Xml Decathlon File Generator
 * Created by raindream on 28.04.19.
 */
public class XmlDecathlonGenerator implements AthleteFileGenerator<DecathlonAthleteModel> {

    /** logger */
    private static final Logger LOGGER = Logger.getLogger( XmlDecathlonGenerator.class.getName() );

    /** path to xml-file */
    public static final String XML_FILE = "dataResult/decathlon/results.xml";

    @Override
    public void generateFile(List<DecathlonAthleteModel> athletes) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root elements
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("decathlonAthletes");
            doc.appendChild(rootElement);
            for (DecathlonAthleteModel athlete : athletes) {
                //TODO move to converters
                Element elementAthlete = doc.createElement("athlete");
                elementAthlete.setAttribute("name", athlete.getAthleteName());
                rootElement.appendChild(elementAthlete);

                for(Map.Entry<String, Double> entry : athlete.getScore().entrySet()) {
                    Element score = doc.createElement(entry.getKey());
                    score.appendChild(doc.createTextNode(String.valueOf(entry.getValue())));
                    elementAthlete.appendChild(score);
                }
                Element totalScore = doc.createElement("totalScore");
                totalScore.appendChild(doc.createTextNode(String.valueOf(athlete.getTotalScore())));
                elementAthlete.appendChild(totalScore);

                Element competitionPlace = doc.createElement("competitionPlace");
                competitionPlace.appendChild(doc.createTextNode(athlete.getPlace()));
                elementAthlete.appendChild(competitionPlace);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(XML_FILE));

            transformer.transform(source, result);
            LOGGER.info("XmlDecathlonGenerator: generateFile(): Xml File was successfully saved.");
        } catch (ParserConfigurationException e) {
            LOGGER.warning("XmlDecathlonGenerator: generateFile() throws ParserConfigurationException. Cause: " +
                    e.getMessage());
            e.printStackTrace();
        } catch (TransformerException e) {
            LOGGER.warning("XmlDecathlonGenerator: generateFile() throws TransformerException. Cause: " +
                    e.getMessage());
            e.printStackTrace();
        }
    }
}
