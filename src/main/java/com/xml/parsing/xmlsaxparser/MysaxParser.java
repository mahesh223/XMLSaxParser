package com.xml.parsing.xmlsaxparser;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

/**
 * @author Kavya Kommineni
 * This class parses the XML file using SAXParser
 */
public class MysaxParser {
	private final static Logger logger = Logger.getLogger(MysaxParser.class.getName());

	/**
	 * This method takes the file path as input and parses the XML using mySAXHandler
	 * @param args
	 * @throws ParserConfigurationException
	 */
	public static void main(String[] args) throws ParserConfigurationException {
		
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser parser = factory.newSAXParser();
			parser.parse(Files.newInputStream(Paths.get("K://saxParserXml/Contacts.xml")), new MySAXHandler());
		} catch (FileNotFoundException e) {
			logger.error("File is not found in the specified path");
		} catch (SAXException e) {
			logger.error("Exception while parsing the file :: " + e.getMessage());
		} catch (Exception e) {
			logger.error(e.getCause());
		}
	}
}