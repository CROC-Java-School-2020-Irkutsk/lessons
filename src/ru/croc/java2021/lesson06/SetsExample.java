package ru.croc.java2021.lesson06;

import java.util.HashSet;
import java.util.Set;

public class SetsExample {

    public static void main(String[] args) {
        Set<String> strings = new HashSet<>();

        strings.add("one");

        strings.add("three");

        strings.add("two");


        for (String string : strings) {

        }



        System.out.println(strings);

    }

}
