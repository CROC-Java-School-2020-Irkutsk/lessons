package ru.croc.java2020.lesson07.xml;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.nio.file.Paths;

public class StaxParser {
    public static void main(String[] args) throws IOException, XMLStreamException {
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader parser = factory.createXMLStreamReader(Paths.get("vcs.xml").toUri().toURL().openStream());
        while (parser.hasNext()) {
            int event = parser.next();
            if (event == XMLStreamConstants.START_ELEMENT) {
                System.out.print(parser.getLocalName());
                for (int index = 0; index < parser.getAttributeCount(); index++) {
                    System.out.print(" " + parser.getAttributeLocalName(index)
                            + "=\"" + parser.getAttributeValue(index) + "\"");
                }
                System.out.println();
            }
        }
    }
}