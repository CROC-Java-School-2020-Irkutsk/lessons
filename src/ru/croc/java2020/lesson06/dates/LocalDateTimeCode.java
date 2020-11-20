package ru.croc.java2020.lesson06.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeCode {
    public static void main(String[] args) {
        printLocalDate();
        printLocalTime();
        printLocalDateTime();
    }

    private static void printLocalDate() {
        LocalDate today = LocalDate.of(2020, 11, 18);
        LocalDate alsoToday = LocalDate.of(2020, Month.NOVEMBER, 18);
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);

        System.out.println("today     = " + today);
        System.out.println("alsoToday = " + alsoToday);
        System.out.println("tomorrow  = " + tomorrow);

        System.out.println("\ntoday.getYear()       = " + today.getYear());
        System.out.println("today.getMonth()      = " + today.getMonth());
        System.out.println("today.getDayOfMonth() = " + today.getDayOfMonth());
        System.out.println("today.getDayOfWeek()  = " + today.getDayOfWeek());
    }

    private static void printLocalTime() {
        LocalTime time = LocalTime.of(17, 30, 15);
        System.out.println("\ntime = " + time);
        System.out.println("time.getHour()   = " + time.getHour());
        System.out.println("time.getMinute() = " + time.getMinute());
        System.out.println("time.getSecond() = " + time.getSecond());
    }

    private static void printLocalDateTime() {
        LocalDateTime dateTime =
                LocalDateTime.of(2020, Month.NOVEMBER, 18, 17, 30, 15);

        System.out.println("\ndateTime = " + dateTime);

        LocalDateTime now = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        LocalDateTime alsoNow = LocalDateTime.now();
        LocalDateTime andAlsoNow = LocalDate.now().atTime(LocalTime.now());
        LocalDateTime anotherNow = LocalTime.now().atDate(LocalDate.now());

        LocalDate today = now.toLocalDate();
        LocalTime currentTime = now.toLocalTime();

        System.out.println("now = " + now);
        System.out.println("today = " + today);
        System.out.println("currentTime = " + currentTime);
    }
}
