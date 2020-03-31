package com.b5wang.jpractice.javase.jdk8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class LocalDateDemo {

    /**
     * A date in ISO format (yyyy-MM-dd) without time.
     * It can be used to store dates like birthdays and paydays.
     * */
    public static void main(String[] args){
        // Current date
        LocalDate ld0 = LocalDate.now();
        System.out.println("ld0: " + ld0);// Notice ISO format (yyyy-MM-dd)


        // Get a specific date
        LocalDate ld1 = LocalDate.of(2020,2,13);
        System.out.println("ld1: " + ld1);
        LocalDate ld2 = LocalDate.parse("2020-02-13");
        System.out.println("ld2: " + ld2);
        LocalDate ld3 = LocalDate.of(2020, Month.FEBRUARY,13);
        System.out.println("ld3: " + ld3);
        LocalDate ld4 = LocalDate.ofYearDay(2020,44);// 31+13=44
        System.out.println("ld4: " + ld4);
        // epochDay - the Epoch Day to convert, based on the epoch 1970-01-01
        LocalDate ld5 = LocalDate.ofEpochDay(0);
        System.out.println("ld5: " + ld5);


        // Add days on current day
        LocalDate ld6 = LocalDate.now().plusDays(1);// Tomorrow
        System.out.println("ld6: " + ld6);
        LocalDate ld7 = LocalDate.now().plusMonths(1);// The same day of next month
        System.out.println("ld7: " + ld7);
        LocalDate ld8 = LocalDate.now().minus(1, ChronoUnit.MONTHS);// The same day of last month
        System.out.println("ld8: " + ld8);


        // Checking a specific date
        LocalDate ld9 = LocalDate.parse("2008-08-08");// Friday
        System.out.println("ld9: " + ld9);
        int dayOfMonth = ld9.getDayOfMonth();
        System.out.println("dayOfMonth: " + dayOfMonth);
        DayOfWeek dayOfWeek = ld9.getDayOfWeek();
        System.out.println("dayOfWeek: " + dayOfWeek.getValue());
        boolean isLeapYear = ld9.isLeapYear();
        System.out.println("isLeapYear: " + isLeapYear);


        // Compare date
        LocalDate ld10 = LocalDate.parse("2020-01-23");
        LocalDate ld11 = LocalDate.parse("2020-02-23");
        boolean isAfter = ld10.isAfter(ld11);
        System.out.println("2020-01-23 is after 2020-02-23: " + isAfter);
        boolean isBefore = ld10.isBefore(ld11);
        System.out.println("2020-01-23 is before 2020-02-23: " + isBefore);


        // Boundary of the day
        LocalDateTime beginningOfDay = LocalDate.now().atStartOfDay();
        System.out.println("Beginning time of the day: " + beginningOfDay);
        LocalDate firstDayOfMonth = LocalDate.now().with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("First day of the month: " + firstDayOfMonth);
    }

}
