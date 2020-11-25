package ru.croc.java2020.lesson07.json.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class JacksonExample {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();

        // read value from JSON file
        Company company = objectMapper
                .readValue(new File("company.json"), Company.class);
        System.out.println(company+ "\n");

        // write to string
        String jsonString = objectMapper.writeValueAsString(company);
        System.out.println(jsonString+ "\n");

        // pretty print to string
        String prettyPrint = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(company);
        System.out.println(prettyPrint+ "\n");

        // write to file
        /*objectMapper.writeValue(new File("out.json"), company);*/
        objectMapper
                //.writerWithDefaultPrettyPrinter()
                .writeValue(new File("out.json"), company);


        CustomCompany customCompany = objectMapper.readValue(new File("company.json"), CustomCompany.class);
        System.out.println(customCompany + "\n");

        customCompany.setWebsites(null);
        customCompany.setAddress(new CustomAddress("street", "city"));

        String customCompanyJsonString = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(customCompany);

        System.out.println(customCompanyJsonString+ "\n");


        var complexJson = objectMapper
                .readValue(
                        new File("complexJson.json"),
                        new TypeReference<List<Map<String, List<String>>>>() {});
        System.out.println(complexJson+ "\n");

        List<String> result = complexJson
                .stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
