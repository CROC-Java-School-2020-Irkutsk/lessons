package ru.croc.java2020.lesson06.dates;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Stack;

public class DstCode {
    public static void main(String[] args) {
        /*marchChangeover();
        novemberChangeover();
        nonexistentDate();*/

        Stack<String> stringStack = new Stack<>();
        stringStack.push("1");
        stringStack.push("2");

        System.out.println("stringStack = " + stringStack);

        var myStack = new Stack<>() {
            @Override
            public synchronized String toString() {
                return super.toString();
            }
        };
    }

    private static void marchChangeover() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        System.out.println("dateTime = " + dateTime);

        dateTime = dateTime.plusHours(1);

        System.out.println("dateTime = " + dateTime);
    }

    private static void novemberChangeover() {
        LocalDate date = LocalDate.of(2016, Month.NOVEMBER, 6);
        LocalTime time = LocalTime.of(1, 30);
        ZoneId zone = ZoneId.of("Asia/Irkutsk");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);

        System.out.println("\ndateTime = " + dateTime);

        dateTime = dateTime.plusHours(1);

        System.out.println("dateTime = " + dateTime);

        dateTime = dateTime.plusHours(1);

        System.out.println("dateTime = " + dateTime);
    }

    private static void nonexistentDate() {
        LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
        LocalTime time = LocalTime.of(2, 30);
        ZoneId zone = ZoneId.of("US/Eastern");
        ZonedDateTime dateTime = ZonedDateTime.of(date, time, zone);
        System.out.println("\ndateTime = " + dateTime);
    }
}
