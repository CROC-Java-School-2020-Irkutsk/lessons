package ru.croc.java2020.lesson06.dates;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class InstantCode {
    public static void main(String[] args) {
        Instant now = Instant.now();
        Instant alsoNow = Instant.ofEpochMilli(System.currentTimeMillis());
        Instant andAlsoNow = Instant.ofEpochSecond(System.currentTimeMillis() / 1000);

        System.out.println("now        = " + now);
        System.out.println("alsoNow    = " + alsoNow);
        System.out.println("andAlsoNow = " + andAlsoNow);

        System.out.println("\nnow.plus(1, ChronoUnit.DAYS) = " + now.plus(1, ChronoUnit.DAYS));
        System.out.println("now                          = " + now);

        System.out.println("\nnow.get(ChronoField.MILLI_OF_SECOND) = " + now.get(ChronoField.MILLI_OF_SECOND));
    }
}
