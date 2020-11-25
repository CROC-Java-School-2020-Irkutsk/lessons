package ru.croc.java2020.lesson07.json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.stream.JsonParser;
import javax.json.stream.JsonParser.Event;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class JsonStreamingApiExample {
    public static void main(String[] args) throws FileNotFoundException {
        try (JsonParser parser = Json.createParser(new FileInputStream("company.json"))) {
            int level = 0;
            boolean isArray = false;


            while (parser.hasNext()) {
                Event event = parser.next();
                switch (event) {
                    case KEY_NAME:
                        System.out.print("  ".repeat(level) + parser.getString() + ": ");
                        break;
                    case VALUE_NUMBER:
                        if (isArray) {
                            System.out.println("  ".repeat(level) + parser.getInt());
                        } else {
                            System.out.println(parser.getInt());
                        }
                        break;
                    case VALUE_STRING:
                        if (isArray) {
                            System.out.println("  ".repeat(level) + parser.getString());
                        } else {
                            System.out.println(parser.getString());
                        }
                        break;
                    case START_OBJECT:
                        level++;
                        break;
                    case END_OBJECT:
                        level--;
                        break;
                    case START_ARRAY:
                        level++;
                        isArray = true;
                        break;
                    case END_ARRAY:
                        level--;
                        isArray = false;
                        break;
                }
            }
        }
    }
}
