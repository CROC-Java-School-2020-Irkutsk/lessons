package ru.croc.java2020.lesson07.xml;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class XmlDocumentGeneration {
    public static void main(String[] args) throws ParserConfigurationException, TransformerException,
            XMLStreamException, IOException {
        Document document = createDocument();
        writeWithXslt(document);
        System.out.println();
        //writeWithLsSerializer(document);
        System.out.println();
        writeWithStax();
    }

    private static Document createDocument() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        Element rootElement = doc.createElement("root");
        Element childElement = doc.createElement("child");
        Text textNode = doc.createTextNode("text");

        doc.appendChild(rootElement);
        rootElement.appendChild(childElement);
        childElement.appendChild(textNode);
        rootElement.setAttribute("attribute", "value");
        return doc;
    }

    private static void writeWithXslt(Document document) throws TransformerException, FileNotFoundException {
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        FileOutputStream outputStream = new FileOutputStream("new.xml");
        t.transform(new DOMSource(document), new StreamResult(outputStream));
        /*String result = outputStream.toString();
        System.out.println(result);*/
    }

    private static void writeWithLsSerializer(Document document) {
        DOMImplementation impl = document.getImplementation();
        var implLs = (DOMImplementationLS) impl.getFeature("LS", "3.0");
        LSSerializer ser = implLs.createLSSerializer();
        ser.getDomConfig().setParameter("format-pretty-print", true);
        ser.writeToURI(document, "new.xml");
        //System.out.println(result);
    }

    private static void writeWithStax() throws XMLStreamException, IOException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLStreamWriter writer = factory.createXMLStreamWriter(out);

        writer.writeStartDocument();
        writer.writeCharacters("\n");
        writer.writeStartElement("root");
        writer.writeAttribute("attribute", "value");
        writer.writeCharacters("\n    ");
        writer.writeStartElement("child");
        writer.writeCharacters("text");
        writer.writeEndElement();
        writer.writeCharacters("\n");
        writer.writeEndElement();
        writer.writeEndDocument();

        String result = out.toString();
        try (var outStream = new FileOutputStream("out.xml", true)) {
            out.writeTo(outStream);
        }
        System.out.println(result);
    }
}
