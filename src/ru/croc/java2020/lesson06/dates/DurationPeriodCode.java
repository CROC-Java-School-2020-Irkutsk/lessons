package ru.croc.java2020.lesson06.dates;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DurationPeriodCode {
    public static void main(String[] args) {
        printDuration();
        printPeriod();
    }

    private static void printDuration() {
        Duration duration1 = Duration.between(LocalTime.of(10, 00), LocalTime.now());

        Duration duration2 = Duration.between(
                LocalDateTime.of(2020, 11, 10, 10, 00),
                LocalDateTime.now());

        Duration duration3 = Duration.between(
                Instant.now().minus(100, ChronoUnit.HOURS),
                Instant.now()
        );

        System.out.println("duration1 = " + duration1);
        System.out.println("duration2 = " + duration2);
        System.out.println("duration3 = " + duration3);
    }

    private static void printPeriod() {
        Period period = Period.between(LocalDate.of(2020, 5, 12), LocalDate.now());
        System.out.println("period = " + period);
    }
}
