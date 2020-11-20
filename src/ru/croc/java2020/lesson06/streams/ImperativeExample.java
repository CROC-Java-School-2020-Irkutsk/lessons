package ru.croc.java2020.lesson06.streams;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ImperativeExample {
    public static void main(String[] args) {
        for (Person person : Data.PEOPLE) {
            System.out.println(person);
        }
        System.out.println();


        Set<String> femaleNamesBornThisCentury = new HashSet<>();
        for (Person person : Data.PEOPLE) {
            if (person.getGender().equals(Gender.FEMALE) && person.getDateOfBirth().isAfter(LocalDate.of(2000, 12, 31))) {
                String name = person.getName();
                femaleNamesBornThisCentury.add(name);
            }
        }
        for (String name : femaleNamesBornThisCentury) {
            System.out.println(name);
        }
    }
}
