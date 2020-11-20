package ru.croc.java2020.lesson06.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;

public class FormatterCode {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();

        DateTimeFormatter isoDateFormatter = DateTimeFormatter.ISO_DATE;
        System.out.println("now = " + now);
        System.out.println("now = " + isoDateFormatter.format(now));
        System.out.println("now = " + now.format(isoDateFormatter));

        DateTimeFormatter russianFormat = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println("now = " + russianFormat.format(now));

        DateTimeFormatter fullDateFormat = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(" ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .appendLiteral(", ")
                .appendText(ChronoField.HOUR_OF_DAY)
                .appendLiteral(":")
                .appendText(ChronoField.MINUTE_OF_HOUR)
                .parseCaseInsensitive()
                .toFormatter();

        // какая строка будет выведена?
        System.out.println("now = " + LocalDateTime.now().format(fullDateFormat));


        LocalDate parsedDate = isoDateFormatter.parse("2020-01-01", LocalDate::from);
        LocalDate parsedRussianDate = LocalDate.parse("07.07.2020", russianFormat);

        System.out.println("\nparsedDate        = " + parsedDate);
        System.out.println("parsedRussianDate = " + parsedRussianDate);
    }
}
