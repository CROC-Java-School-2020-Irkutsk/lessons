package ru.croc.java2020.lesson06.callbacks;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorUsage {
    public static void main(String[] args) {
        List<String> people = Arrays.asList("Иван", "Константин", "Игорь");

        // сортировка по длине строки в порядке убывания
        Collections.sort(people, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.length() - o1.length();
            }
        });

        System.out.println("people = " + people);
    }
}
