package com.b5wang.jpractice.javase.jdk8.time;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class OffsetDateTimeDemo {

    /**
     * OffsetDateTime, ZonedDateTime and Instant all store an instant on the time-line to nanosecond precision.
     * Instant is the simplest, simply representing the instant.
     * OffsetDateTime adds to the instant the offset from UTC/Greenwich, which allows the local date-time to be obtained.
     * ZonedDateTime adds full time-zone rules.
     * */
    public static void main(String[] args){
        ZoneOffset offsetGMT6 = ZoneOffset.of("+06:00");
        ZoneOffset offsetGMT7 = ZoneOffset.of("+07:00");

        LocalDateTime ldt = LocalDateTime.now();
        ZonedDateTime zdt = ZonedDateTime.of(ldt, ZoneId.systemDefault());
        OffsetDateTime odtGMT6 = OffsetDateTime.of(ldt,offsetGMT6);
        OffsetDateTime odtGMT7 = OffsetDateTime.of(ldt,offsetGMT7);
        System.out.println("ldt                 : " + ldt);
        System.out.println("zdt                 : " + zdt);
        System.out.println("odtGMT6             : " + odtGMT6);
        System.out.println("odtGMT7             : " + odtGMT7);
        System.out.println("zdt milliseconds    : " + zdt.toInstant().toEpochMilli());
        System.out.println("odtGMT6 milliseconds: " + odtGMT6.toInstant().toEpochMilli());
        System.out.println("odtGMT7 milliseconds: " + odtGMT7.toInstant().toEpochMilli());
    }

}
