/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.utils;

/**
 * Conversion from binary to integer has 2 requirements.
 * 1, keep value.---force cast
 * 2, keep value of each bit.---
 * @author wangbo
 */
public class ByteUtil {
    
    /**
     * (int) b is wrong! why?
     *
     * @param b byte
     * @return int
     */
    public static int toInt (byte b) {
        return b & 0xff;
    }
    
    public static void main(String[] args){
        byte b = -1;
        int i = (int)b;
        
        System.out.println("b=" + b);
        System.out.println("i=" + i);
        System.out.println("==" + toInt(b));
        System.out.println("==" + Integer.toBinaryString(toInt(b)));
    }
}
