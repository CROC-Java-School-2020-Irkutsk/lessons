package ru.croc.java2020.lesson07.json;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class JsonApiObjecModelExample {
    public static void main(String[] args) throws IOException {
        builderUsage();
        System.out.println();
        readerUsage();
    }

    private static void builderUsage() throws FileNotFoundException {
        JsonObjectBuilder objectBuilder = Json.createObjectBuilder();
        JsonObject object = objectBuilder
                .add("id", 1)
                .add("name", "falcon")
                .add("age", 3)
                .build();

        System.out.println(object.toString());

        System.out.println(object.get("id"));
        System.out.println(object.get("name"));
        System.out.println(object.get("age"));

        try (JsonWriter writer = Json.createWriter(new FileOutputStream("out.json"))) {
            writer.write(object);
        }
    }

    private static void readerUsage() throws IOException {
        try (JsonReader reader = Json.createReader(new FileInputStream("company.json"))) {
            JsonObject object = reader.readObject();

            System.out.println(object);

            object.forEach((key, value) -> System.out.println(key + ": " + value));
        }
    }
}
