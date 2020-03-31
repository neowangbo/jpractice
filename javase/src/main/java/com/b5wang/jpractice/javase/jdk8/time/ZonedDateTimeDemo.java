package com.b5wang.jpractice.javase.jdk8.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ZonedDateTimeDemo {

    public static void main(String[] args){
        // Get Timezone
        ZoneId whereAreYou = Clock.systemDefaultZone().getZone();
        System.out.println("Your time zone: " + whereAreYou);

        // List down time zones
        List<String> zoneIds = new ArrayList<>();
        ZoneId.getAvailableZoneIds().stream().forEach(el->zoneIds.add(el));
        Collections.sort(zoneIds);
        zoneIds.stream().forEach(zoneId -> System.out.println(zoneId));

        /**
         * Notice the POSIX style time zone names. For example, Etc/GMT-7 actually represents for GMT+7.
         * Positive and negative sign of Etc/GMT is right reverse to GMT. This is confusing many many people.
         * Regarding to why it is done like this, you can reference
         * https://data.iana.org/time-zones/tzdb/etcetera
         * https://stackoverflow.com/questions/41839812/what-does-etc-mean-in-time-zone-definitions
         *
         * Some terms related to Time Zone
         * Etc - etcetera, latin word, stands for "and so forth"
         * GMT - Greenwich Mean Time
         * UTC - Coordinated Universal Time or Universal Time Coordinated
         * TZ - Time zone
         * DST - Daylight Saving Time
         * */
        ZoneId gmtP0 = ZoneId.of("Etc/GMT-0");// GMT+0 timeone, Greenwich time
        System.out.println("Set a new timezone: " + gmtP0);

        ZoneId gmtP7 = ZoneId.of("Etc/GMT-7");// GMT+7 timeone
        System.out.println("Set a new timezone: " + gmtP7);

        ZoneId gmtP8 = ZoneId.of("Etc/GMT-8");// GMT+7 timeone
        System.out.println("Set a new timezone: " + gmtP7);

        ZonedDateTime zdt0 = ZonedDateTime.now(gmtP0);
        ZonedDateTime zdt7 = ZonedDateTime.now(gmtP7);
        ZonedDateTime zdt8 = ZonedDateTime.now(gmtP8);
        System.out.println("zdt0: " + zdt0);
        System.out.println("zdt7: " + zdt7);
        System.out.println("zdt8: " + zdt8);


        /**
         * Convert the time to different time zoned times.
         * No matter which time zone the times are, their time in milliseconds are the same, GMT time.
         * */
        long timeOfMillis = Clock.systemUTC().millis();
        System.out.println("GMT  millisTime: " + timeOfMillis);
        System.out.println("zdt0 millisTime: " + zdt0.toInstant().toEpochMilli());
        System.out.println("zdt7 millisTime: " + zdt7.toInstant().toEpochMilli());
        System.out.println("zdt8 millisTime: " + zdt8.toInstant().toEpochMilli());

        Instant gmtTime = Instant.ofEpochMilli(timeOfMillis);
        System.out.println("gmtTime  : " + gmtTime);

        /**
         * Convert milliseconds time to ZonedDateTime
         * */
        ZonedDateTime gmtP0Time = Instant.ofEpochMilli(timeOfMillis).atZone(gmtP0);
        ZonedDateTime gmtP7Time = Instant.ofEpochMilli(timeOfMillis).atZone(gmtP7);
        ZonedDateTime gmtP8Time = Instant.ofEpochMilli(timeOfMillis).atZone(gmtP8);
        System.out.println("gmtP0Time: " + gmtP0Time);
        System.out.println("gmtP7Time: " + gmtP7Time);
        System.out.println("gmtP8Time: " + gmtP8Time);


        /**
         * Get ZonedDateTime from string
         * String should be ISO-8601 time format by default.
         * */
        ZonedDateTime zdtFromStr0 = ZonedDateTime.parse("2020-03-27T15:45:23.141Z");
        System.out.println("zdtFromStr0: " + zdtFromStr0 + ", timezone: " + zdtFromStr0.getZone().toString());
        ZonedDateTime zdtFromStr7 = ZonedDateTime.parse("2020-03-27T22:53:58.387+07:00[Etc/GMT-7]");
        System.out.println("zdtFromStr7: " + zdtFromStr7 + ", timezone: " + zdtFromStr7.getZone().toString());


        /**
         * See time format details at java.time.format.DateTimeFormatter
         * */
        DateTimeFormatter formater1 = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss.N a O");
        DateTimeFormatter formater2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.S a O");
        ZonedDateTime zdt9 = ZonedDateTime.now();
        String formatted1Time = zdt9.format(formater1);
        String formatted2Time = zdt9.format(formater2);
        System.out.println("formatted1 Time: " + formatted1Time);
        System.out.println("formatted2 Time: " + formatted2Time);
    }

}
