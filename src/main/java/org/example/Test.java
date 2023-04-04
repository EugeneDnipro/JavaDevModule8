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

        TimeZone tz = TimeZone.getTimeZone(timezone);
//        System.out.println("tz.getID() = " + tz.getID());
//        System.out.println("tz.getID().equals(zone) = " + tz.getID().equals(zone));

        //hasSameRules(TimeZone other)

        String zoneString = zone.getId();
        System.out.println("zoneString = " + zoneString);
        TimeZone tz2 = TimeZone.getTimeZone(zoneString);
        System.out.println(tz2.getID());


        String timezoneId = null;
        String[] splitted;
        if ((timezone.contains("+")) || (timezone.contains("-"))) {
            splitted = timezone.split("[\\-\\t\\n\\x0b\\r\\f]");
            timezoneId = splitted[0];
        }

        System.out.println("timezoneId = " + timezoneId);

        String timeZoneId = timezone;
        boolean isValidTimeZone = Arrays.asList(TimeZone.getAvailableIDs(3600000)).contains(timeZoneId);
        System.out.println("isValidTimeZone = " + isValidTimeZone);
        System.out.println("TimeZone.getAvailableIDs() = " + Arrays.toString(TimeZone.getAvailableIDs()));

        ZonedDateTime zonedDateTime = ZonedDateTime.now(zone);
        System.out.println("TimeZone.getTimeZone(zone) = " + TimeZone.getTimeZone(timezone));
        return zonedDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss '" + timezone + "'"));
    }

    public static void main(String[] args) {
        System.out.println(getCurrentUtcTime("UTC+2"));

    }
}
