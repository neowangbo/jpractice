package com.b5wang.jpractice.javase.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

    public static void main(String[] args){
        Calendar cal = Calendar.getInstance();
        long milliseconds = cal.getTimeInMillis();
        long twoDateMilliseconds = 1000 * 60 * 60 * 24;

        Date now = new Date(milliseconds);
        Date now2 = new Date(milliseconds);
        Date twoDatesAgo = new Date(milliseconds - twoDateMilliseconds);
        Date twoDatesLater = new Date(milliseconds + twoDateMilliseconds);

        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        System.out.println("Now          : " + sdf.format(now));
        System.out.println("Now 2        : " + sdf.format(now2));
        System.out.println("2 Days ago   : " + sdf.format(twoDatesAgo));
        System.out.println("2 Days later : " + sdf.format(twoDatesLater));

        // twoDatesAgo <<<<< now (now 2) <<<<<< future
        System.out.println("" + now.compareTo(twoDatesAgo));// 1
        System.out.println("" + now.compareTo(now2));// 0
        System.out.println("" + now.compareTo(twoDatesLater));//-1
    }

}
