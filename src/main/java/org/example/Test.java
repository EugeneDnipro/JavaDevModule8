package org.example;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.TimeZone;

public class Test {

    public static String getCurrentUtcTime(String timezone) {
        if (timezone == null) {
            timezone = "UTC";
        } else if (timezone.contains(" ")) {
            timezone = timezone.replace(" ", "+");
        }
        ZoneId zone = ZoneId.of(timezone);
        System.out.println("zone = " + zone);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        System.out.println("TimeZone.getTimeZone(zone) = " + TimeZone.getTimeZone(zone));
        return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss '" + timezone + "'"));
    }

    public static void main(String[] args) {
        System.out.println(getCurrentUtcTime("UTC+1"));

    }
}
