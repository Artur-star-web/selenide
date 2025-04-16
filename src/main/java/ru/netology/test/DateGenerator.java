package ru.netology.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateGenerator {
    public static String getDatePlusDays(int daysToAdd) {
        return LocalDate.now()
                .plusDays(daysToAdd)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


}
