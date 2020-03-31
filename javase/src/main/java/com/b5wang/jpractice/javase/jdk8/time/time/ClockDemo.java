package com.b5wang.jpractice.javase.jdk8.time;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class ClockDemo {

    public static void main(String[] args){
        ZoneId.getAvailableZoneIds().stream().forEach(zId->System.out.println("TimeZone: " + zId));
        System.out.println("Default time zoneId: " + ZoneId.systemDefault());

        ZoneId gmtP8 = ZoneId.of("Etc/GMT+8");

        System.out.println("==? : " + ZoneId.systemDefault().equals(gmtP8));

        LocalDateTime ldt = LocalDateTime.now();
    }

}
