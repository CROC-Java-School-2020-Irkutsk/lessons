package ru.croc.java2021.lesson06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>(10);
        strings.add("one");
        strings.add("two");
        strings.add("three");

        List<String> other = new ArrayList<>(strings);

        System.out.println(strings == other);

        System.out.println(strings.equals(other));

        for (String s : strings) {
            System.out.println(s);
        }

        final Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            final String next = iterator.next();
            System.out.println(next);
        }

    }
}
