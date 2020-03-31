package com.b5wang.jpractice.javase.jdk8.time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class LocalTimeDemo {

    /**
     * The LocalTime represents time without a date.
     * */
    public static void main(String[] args){
        LocalTime lt0 = LocalTime.now();
        System.out.println("lt0: " + lt0);

        // Get time by text
        LocalTime lt1 = LocalTime.of(6,30,59);
        System.out.println("lt1: " + lt1);

        // Add hour
        LocalTime lt2 = LocalTime.parse("06:30:59").plus(2, ChronoUnit.HOURS);
        System.out.println("lt2: " + lt2);

        // Get hour
        int hour = lt0.getHour();
        System.out.println("hour: " + hour);

        LocalTime lt3 = LocalTime.parse("18:30");
        LocalTime lt4 = LocalTime.parse("18:45");
        boolean isBefore = lt3.isBefore(lt4);
        boolean isAfter = lt3.isAfter(lt4);
        System.out.println("18:30 is before 18:45: " + isBefore);
        System.out.println("18:30 is after 18:45: " + isAfter);

        // The max time of a day
        LocalTime lt5 = LocalTime.MAX;
        System.out.println("The max time of a day: " + lt5.toString());// Notice the nanosecond
    }
}
