package ru.croc.java2021.lesson08;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Стартовый класс.
 */
public class Main {


    public static void main(String[] args) throws Exception {
/*        JAXBContext context = JAXBContext.newInstance(Simple.class);
        Marshaller marshaller = context.createMarshaller();
        Simple obj = new Simple(id, name);
        obj.setId(42);
        obj.setName("Сыр");

        marshaller.marshal(obj, System.out);

        String  str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><simple><id>42</id><name>Сыр</name></simple>";

        Unmarshaller unmarshaller = context.createUnmarshaller();
        Simple obj2 = (Simple) unmarshaller.unmarshal(new StringReader(str));

        System.out.println();
        System.out.println(obj2.getName());

        String  str1 = new ObjectMapper().writeValueAsString(obj);
        System.out.println();
        System.out.println(str1);
*/
        Simple obj3 = new ObjectMapper().readValue("{\"name\":\"Сыр\",\"number\":42}", Simple.class);
        System.out.println();
        System.out.println(obj3.getId());
        System.out.println(obj3.getName());
    }

    @XmlRootElement
    public static class Simple {

        private final int id;
        private final String name;

        @JsonCreator
        public Simple(@JsonProperty("number") int id, @JsonProperty("name") String name) {
            this.id = id;
            this.name = name;
        }

        @XmlElement
        public int getId() {
            return id;
        }

        @XmlElement
        public String getName() {
            return name;
        }
    }
}