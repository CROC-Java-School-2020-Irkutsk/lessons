package ru.croc.java2020.lesson07.xml;


import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SaxParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        parser.parse("vcs.xml", new DefaultHandler() {
            @Override
            public void startElement(String uri, String localName, String qName, Attributes attributes) {
                System.out.print(qName);
                for (int index = 0; index < attributes.getLength(); index++) {
                    System.out.print(" " + attributes.getLocalName(index) + "=\"" + attributes.getValue(index) + "\"");
                }
                System.out.println();
            }
        });
    }

}