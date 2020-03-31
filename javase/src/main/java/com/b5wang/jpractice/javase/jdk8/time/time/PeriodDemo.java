package com.b5wang.jpractice.javase.jdk8.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDemo {

    /**
     *  Days, months, and years are supported unit.
     *  A date-based amount of time in the ISO-8601 calendar system, such as '2 years, 3 months and 4 days'.
     * */
    public static void main(String[] args){
        LocalDate ld0 = LocalDate.of(2019,1,1);
        LocalDate ld1 = LocalDate.of(2020,1,19);
        Period period01 = Period.between(ld0,ld1);
        System.out.println("ld0                         : " + ld0);
        System.out.println("ld1                         : " + ld1);
        System.out.println("Duration between ld0 and ld1: " + period01.toString());
        System.out.println("Duration between ld0 and ld1: " + period01.getDays());
        System.out.println("Duration between ld0 and ld1: " + period01.getMonths());
        System.out.println("Duration between ld0 and ld1: " + period01.getYears());
        System.out.println("Duration between ld0 and ld1: " + period01.get(ChronoUnit.DAYS));
        System.out.println("Duration between ld0 and ld1: " + period01.get(ChronoUnit.MONTHS));
        System.out.println("Duration between ld0 and ld1: " + period01.get(ChronoUnit.YEARS));
        System.out.println("Duration between ld0 and ld1: " + ChronoUnit.DAYS.between(ld0,ld1));
        System.out.println("Duration between ld0 and ld1: " + ChronoUnit.MONTHS.between(ld0,ld1));
        System.out.println("Duration between ld0 and ld1: " + ChronoUnit.YEARS.between(ld0,ld1));

        // Add days on a date
        LocalDate ld2 = ld0.plus(Period.ofDays(10));
        System.out.println("ld2: " + ld2);

        LocalDate ld3 = LocalDate.of(2020,1,1);
        LocalDate ld4 = LocalDate.of(2020,3,15);
        Period period34 = Period.between(ld3,ld4);
        System.out.println("ld3                         : " + ld3);
        System.out.println("ld4                         : " + ld4);
        System.out.println("Duration between ld3 and ld4: " + period34.toString());
        System.out.println("Duration between ld3 and ld4: " + period34.getDays());
        System.out.println("Duration between ld3 and ld4: " + period34.getMonths());
        System.out.println("Duration between ld3 and ld4: " + period34.getYears());
        System.out.println("Duration between ld3 and ld4: " + ChronoUnit.DAYS.between(ld3,ld4));
        System.out.println("Duration between ld3 and ld4: " + ChronoUnit.MONTHS.between(ld3,ld4));
        System.out.println("Duration between ld3 and ld4: " + ChronoUnit.YEARS.between(ld3,ld4));

        // All units supported by Period
        period01.getUnits().forEach(u->{
            System.out.println(u.toString() + " - " + u.getClass().getName());
        });
        period34.getUnits().forEach(u->{
            System.out.println(u.toString() + " - " + u.getClass().getName());
        });
    }

}
