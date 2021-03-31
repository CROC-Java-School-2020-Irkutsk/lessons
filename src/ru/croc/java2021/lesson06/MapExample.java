package ru.croc.java2021.lesson06;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExample {


    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("Язык", "Language");
        map.put("Книга", "Book");

        final Set<String> keys = map.keySet();
        System.out.println(keys);

        for (String key : keys) {
            System.out.println(map.get(key));
        }
    }

}
