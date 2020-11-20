package ru.croc.java2020.lesson06.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Person {

    private final String name;
    private final LocalDate dateOfBirth;
    private final Gender gender;
    private final List<String> posessions = new ArrayList<>();

    public Person(String name, Gender gender, LocalDate dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPosessions() {
        return posessions;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "'" + name + '\'' + " " + dateOfBirth + " " + gender;
    }

}
