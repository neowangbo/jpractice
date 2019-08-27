package com.b5wang.jpractice.javase.types;

/**
 * 192 in binary = 1100,0000
 */
public class DemoInt {

    public static void main (String[] args) {

        int hex = 0xc0;
        int decimal = 192;
        int octal = 0300;

        System.out.println ("hex int = " + hex);
        System.out.println ("decimal int = " + decimal);
        System.out.println ("octal int = " + octal);

        long hexL = 0xc0;
        long decimalL = 192;
        long octalL = 0300;

        System.out.println ("hex long = " + hexL);
        System.out.println ("decimal long = " + decimalL);
        System.out.println ("octal long = " + octalL);

    }
}
