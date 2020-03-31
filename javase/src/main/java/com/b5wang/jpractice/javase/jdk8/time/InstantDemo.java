package com.b5wang.jpractice.javase.jdk8.time;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

public class InstantDemo {

    public static void main(String[] args){
        Instant ins0 = Instant.now();
        System.out.println("ins0: " + ins0);

        Clock japanClock = Clock.system(ZoneId.of("Japan"));
        Instant ins1 = Instant.now(japanClock);
        System.out.println("ins1: " + ins1 + ", clock: " + japanClock.toString());
    }
}
