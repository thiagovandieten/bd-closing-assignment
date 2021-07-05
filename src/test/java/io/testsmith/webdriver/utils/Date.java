package io.testsmith.webdriver.utils;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class Date {

    //6.5 moet current date worden
    public static String Tomorrow() {
        org.joda.time.LocalDate date = org.joda.time.LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
        date = date.plusDays(1);
        return date.toString(fmt);
    }
}
