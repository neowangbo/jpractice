package com.b5wang.jpractice.javase.jdk8.time;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class ZoneIdDemo {

    public static void main(String[] args){
        ZoneId.getAvailableZoneIds().forEach(z -> System.out.println(z));

        ZoneId zi = ZoneId.of("Japan");
        ZonedDateTime zdt = ZonedDateTime.now(zi);
        System.out.println("zdt: " + zdt);
    }
}
