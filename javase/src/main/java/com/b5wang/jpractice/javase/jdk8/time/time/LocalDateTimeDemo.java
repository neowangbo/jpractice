package com.b5wang.jpractice.javase.jdk8.time;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeDemo {

    /**
     * A combination of date and time.
     * */
    public static void main(String[] args){

        // Create a LocalDateTime
        LocalDateTime ldt0 = LocalDateTime.now();
        System.out.println("ldt0: " + ldt0);
        LocalDateTime ldt1 = LocalDateTime.of(2020,1,23,18,30,59,230);
        System.out.println("ldt1: " + ldt1);
        LocalDateTime ldt2 = LocalDateTime.of(2020, Month.JANUARY,23,18,30,59,230);
        System.out.println("ldt2: " + ldt2);
        LocalDateTime ldt3 = LocalDateTime.parse("2020-01-23T18:30:59.230");
        System.out.println("ldt3: " + ldt3);

        // Compare
        boolean isBefore = ldt2.isBefore(ldt3);
        System.out.println("2020-01-23T18:30:59.000000230 before 2020-01-23T18:30:59.230: " + isBefore);
        boolean isAfter = ldt2.isAfter(ldt3);
        System.out.println("2020-01-23T18:30:59.000000230 after 2020-01-23T18:30:59.230: " + isAfter);
        LocalDateTime ldt4 = LocalDateTime.parse("2020-01-23T18:30:59.000000230");
        boolean isEqual = ldt2.isEqual(ldt4);
        System.out.println("2020-01-23T18:30:59.000000230 equals to 2020-01-23T18:30:59.000000230: " + isEqual);

        // Calculate time
        LocalDateTime ldt5 = ldt0.plusDays(1);
        LocalDateTime ldt6 = ldt0.plus(2, ChronoUnit.HOURS);
        System.out.println("ldt0: " + ldt0);
        System.out.println("ldt5: " + ldt5);
        System.out.println("ldt6: " + ldt6);

    }

}
