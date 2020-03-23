package com.b5wang.jpractice.javase.jdk8.time;

import java.time.Clock;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * A clock providing access to the current instant, date and time using a time-zone.
 *  The primary purpose of this abstraction is to allow alternate clocks to be plugged in as and when required.
 * */
public class ClockTest {

    public static void main(String[] args){
        long currentTimeMillis1 = System.currentTimeMillis();
        System.out.println("currentTimeMillis1 = " + currentTimeMillis1);
        // Coordinated Universal Time (or UTC)
        long currentTimeMillis2 = Clock.systemUTC().millis();
        System.out.println("currentTimeMillis2 = " + currentTimeMillis2);


        TimeZone timeZone1 = TimeZone.getDefault();
        System.out.println("timeZone1 = " + timeZone1.getID());
        ZoneId timeZone2 = Clock.systemDefaultZone().getZone();
        System.out.println("timeZone2 = " + timeZone2.getId());

        Clock gmt7Clock = Clock.system(ZoneId.of("Etc/GMT-7"));
        System.out.println("gmt7 time zone id: " + gmt7Clock.getZone().getId());

        LocalDateTime gmt7Time = LocalDateTime.now(gmt7Clock);
        System.out.println("gmt7 local time now: " + gmt7Time.toString());
        System.out.println("gmt7 local time now: " + gmt7Time.toInstant());

        LocalDateTime gmt8Time = LocalDateTime.now();
        System.out.println("Default local time now: " + gmt8Time.toString());

    }

}
