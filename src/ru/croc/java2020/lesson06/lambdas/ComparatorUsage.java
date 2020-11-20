package ru.croc.java2020.lesson06.lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class ComparatorUsage {
    public static void main(String[] args) {
        List<String> people = Arrays.asList("Иван", "Константин", "Игорь");

        // сортировка по длине строки в порядке убывания
        // однострочное лямбда-выражение
        Collections.sort(people, (o1, o2) -> o2.length() - o1.length());

        // многострочное лямбда-выражение
        Collections.sort(people, (o1, o2) -> Integer.compare(o2.length(), o1.length()));

        // многострочное лямбда-выражение
        Function<String, Integer> length = s -> s.length();
        Collections.sort(people, Comparator.comparing(length).reversed());


        Function<Integer, String[]> stringArrayFunction = String[]::new;


        System.out.println("people = " + people);
    }
}
