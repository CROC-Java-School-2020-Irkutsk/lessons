package ru.croc.java2020.lesson06.dates;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeZoneCode {
    public static void main(String[] args) {
        LocalDateTime dateTime = LocalDateTime.of(2020, 2, 3, 15, 45);

        ZoneId irkutskZoneId = ZoneId.of("Asia/Irkutsk");
        ZonedDateTime irkutskTime = ZonedDateTime.of(dateTime, irkutskZoneId);
        System.out.println("irkutskTime = " + irkutskTime);

        ZoneId moscowZoneId = ZoneId.of("Europe/Moscow");
        ZonedDateTime moscowTime = ZonedDateTime.of(dateTime, moscowZoneId);
        System.out.println("moscowTime  = " + moscowTime);

        Duration irkMoscowDuration = Duration.between(irkutskTime, moscowTime);
        System.out.println("irkMoscowDuration = " + irkMoscowDuration);

        ZonedDateTime irkTimeInMoscow = irkutskTime.withZoneSameInstant(moscowZoneId);
        System.out.println("irkTimeInMoscow = " + irkTimeInMoscow);
    }
}
