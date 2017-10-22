/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.utils;

/**
 *
 * @author wangbo
 */
public class StringUtil {

    public static String byteToHex(byte b) {
        return byteToHex(b, true);
    }

    /**
     * 1 byte is 8 bits, and it can be split into 2 hexadecimal digits.<br>
     * byte b = 1100,0000 = 0xC0 <br>
     * byte b = 0000,1100 = 0x0C
     *
     * @param b
     * @param isLowerCase
     * @return
     */
    public static String byteToHex(byte b, boolean isLowerCase) {
        String hexStr = "";

        int i = ByteUtil.toInt(b);
        if (i < 16) {
            // i < (binary) 0000,1111, should fill 0 before, finally it's 0x0f
            hexStr = "0" + Integer.toString(i, 16);
        } else {
            hexStr = Integer.toString(i, 16);
        }

        return isLowerCase ? hexStr.toLowerCase() : hexStr.toUpperCase();
    }

    public static String bytesToHex(byte[] bs) {
        return bytesToHex(bs, true);
    }

    public static String bytesToHex(byte[] bs, boolean isLowerCase) {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < bs.length; i++) {
            sb.append(byteToHex(bs[i], isLowerCase));
        }
        return sb.toString();
    }

    /**
     * Source: https://stackoverflow.com/questions/140131/convert-a-string-representation-of-a-hex-dump-to-a-byte-array-using-java
     * @param s string
     * @return byte[]
     */
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
        }
        return data;
    }

    public static void main(String[] args) {
        byte b = 0x0c;

        System.out.println("b = " + byteToHex(b));
        System.out.println("b = " + byteToHex(b, false));

        byte[] bs = new byte[4];
        bs[0] = 0x0c;
        bs[1] = (byte) 0xc0;
        bs[2] = 0x00;
        bs[3] = (byte) 0xff;

        System.out.println("bs = " + bytesToHex(bs));
        System.out.println("bs = " + bytesToHex(bs, false));

    }
}
