package ru.croc.java2020.lesson06.streams;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class Data {
    private static final List<String> FEMALE_NAMES = List.of("Елена", "Ирина", "Мария", "Анастасия", "Надежда");
    private static final List<String> MALE_NAMES = List.of("Иван", "Петр", "Алексей", "Никита", "Дмитрий");

    public static final List<Person> PEOPLE = new ArrayList<>();
    static {
        PEOPLE.addAll(generatePersonList(FEMALE_NAMES, Gender.FEMALE, 25));
        PEOPLE.addAll(generatePersonList(MALE_NAMES, Gender.MALE, 25));
        Collections.shuffle(PEOPLE);
    }

    private static List<Person> generatePersonList(List<String> names, Gender gender, int size) {
        return ThreadLocalRandom
                .current()
                .ints(size, 0, names.size() - 1)
                .mapToObj(names::get)
                .map(name -> new Person(name, gender, LocalDate.of(
                        ThreadLocalRandom.current().nextInt(1960, 2020),
                        ThreadLocalRandom.current().nextInt(1, 12),
                        ThreadLocalRandom.current().nextInt(1, 28)
                )))
                .collect(Collectors.toList());
    }
}
