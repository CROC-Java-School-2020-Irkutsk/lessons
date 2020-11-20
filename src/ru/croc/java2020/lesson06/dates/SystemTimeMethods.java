package ru.croc.java2020.lesson06.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class SystemTimeMethods {
    public static void main(String[] args) {
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        System.out.println("System.nanoTime() = " + System.nanoTime());
    }
}