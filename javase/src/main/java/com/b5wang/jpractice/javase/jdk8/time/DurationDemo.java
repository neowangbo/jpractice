package com.b5wang.jpractice.javase.jdk8.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DurationDemo {

    /**
     * Duration supports Second and Nanosecond.
     * A time-based amount of time, such as '34.5 seconds'.
     * This class models a quantity or amount of time in terms of seconds and nanoseconds.
     * It can be accessed using other duration-based units, such as minutes and hours.
     * In addition, the DAYS unit can be used and is treated as exactly equal to 24 hours,
     * thus ignoring daylight savings effects. See Period for the date-based equivalent to this class.
     * */
    public static void main(String[] args){
        LocalDateTime ldt0 = LocalDateTime.of(2019,12,10,12,10,39);
        LocalDateTime ldt1 = LocalDateTime.of(2020,3,28,17,55,5);
        Duration duration01 = Duration.between(ldt0,ldt1);
        System.out.println("ldt0                          : " + ldt0);
        System.out.println("ldt1                          : " + ldt1);
        System.out.println("Duration between ldt0 and ldt1: " + duration01.toString());
        System.out.println("Duration between ldt0 and ldt1: " + duration01.getSeconds());
        System.out.println("Duration between ldt0 and ldt1: " + duration01.getNano());
        System.out.println("Duration between ldt0 and ldt1: " + duration01.get(ChronoUnit.SECONDS));
        System.out.println("Duration between ldt0 and ldt1: " + duration01.get(ChronoUnit.NANOS));
        System.out.println("Duration between ldt0 and ldt1: " + ChronoUnit.SECONDS.between(ldt0,ldt1));
        System.out.println("Duration between ldt0 and ldt1: " + ChronoUnit.NANOS.between(ldt0,ldt1));

        // All supported time units
        duration01.getUnits().forEach(u -> System.out.println(u.toString() + " - " + u.getClass().getName()));
    }

}
