package ru.croc.java2020.lesson07.xml.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class JaxbDocumentParsing {
    public static void main(String[] args) throws JAXBException {
        readRootXml();

        readListExampleXml();
    }

    private static void readRootXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Root.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Root root = (Root) unmarshaller.unmarshal(new File("root.xml"));

        System.out.println(root);
    }

    private static void readListExampleXml() throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(ListRoot.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        ListRoot root = (ListRoot)unmarshaller.unmarshal(new File("listExample.xml"));

        System.out.println(root);
    }
}
