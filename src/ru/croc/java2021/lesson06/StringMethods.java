package ru.croc.java2021.lesson06;

import java.util.ArrayList;
import java.util.Arrays;

public class StringMethods {
    public static void main(String[] args) {
        final String join1 = String.join(", ", "a", "b", "c");
        System.out.println(join1);

        final ArrayList<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");

        final String join = String.join("", strings);
        System.out.println(join);


        final String s = String.format("%s %d %d", "s", 1, 2);

        System.out.println(s);

        final String string = "String";
        final String repeat = string.repeat(5);
        System.out.println(repeat);

        final String[] s1 = repeat.split("[Sg]");
        System.out.println(Arrays.toString(s1));
    }
}
