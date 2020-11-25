package ru.croc.java2020.lesson07.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomParser {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        Document doc = builder.parse("vcs.xml");
        Element root = doc.getDocumentElement();

        printElementData(root, 0);
    }

    static void printElementData(Element element, int level) {
        System.out.print("  ".repeat(level) + element.getNodeName());

        for (int index = 0; index < element.getAttributes().getLength(); index++) {
            Node attribute = element.getAttributes().item(index);
            System.out.print(" " + attribute.getNodeName() + " = \"" + attribute.getTextContent() + "\"");
        }

        if (element.getFirstChild() instanceof Text) {
            System.out.print(" value = \"" + ((Text) element.getFirstChild()).getData().trim() + "\"");
        }

        System.out.println();

        for (int index = 0; index < element.getChildNodes().getLength(); index++) {
            Node item = element.getChildNodes().item(index);
            if (item instanceof Element) { //skip whitespace
                printElementData((Element) item, level + 1);
            }
        }
    }

}