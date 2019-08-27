package com.b5wang.jpractice.javase.util;

/**
 * 
 */
public class ByteUtil {

    /**
     * (int) b is wrong! why?
     * */
    public static int toInt (byte b) {
        return b & 0xff;
    }

}
