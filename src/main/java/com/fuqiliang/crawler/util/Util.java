package com.fuqiliang.crawler.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Util {

    public static LocalDate format(String format, String dateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        LocalDate date= LocalDate.parse(dateStr, formatter);
        return date;
    }
}
