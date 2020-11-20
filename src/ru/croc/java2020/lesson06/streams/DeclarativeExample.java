package ru.croc.java2020.lesson06.streams;

import java.time.LocalDate;

public class DeclarativeExample {
    public static void main(String[] args) {
        Data.PEOPLE.forEach(System.out::println);
        System.out.println();

        Data.PEOPLE.stream()
            .filter(person -> person.getGender().equals(Gender.FEMALE))
            .filter(person -> person.getDateOfBirth().isAfter(LocalDate.of(2000, 12, 31)))
            .map(Person::getName)
            .distinct()
            .forEach(System.out::println);
    }
}
