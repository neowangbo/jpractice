package com.martian.apps.javabasics.util;

/**
 * 
 */
public class StringUtil {

    public static String byteToHex(byte b) {
        return byteToHex (b, true);
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
    public static String byteToHex (byte b, boolean isLowerCase) {
        String hexStr = "";

        int i = ByteUtil.toInt (b);
        if (i < 16) {
            // i < (binary) 0000,1111, should fill 0 before
            hexStr = "0";
        }

        if (isLowerCase) {
            hexStr += Integer.toString (i, 16).toLowerCase ();
        } else {
            hexStr += Integer.toString (i, 16).toUpperCase ();
        }

        return hexStr;
    }

    public static String bytesToHex(byte[] bs){
        return bytesToHex(bs, true);
    }
    
    public static String bytesToHex (byte[] bs, boolean isLowerCase) {
        final StringBuilder sb = new StringBuilder(); 
        for (int i = 0; i < bs.length; i++) {
            sb.append(byteToHex(bs[i], isLowerCase));
        }
        return sb.toString();
    }


    public static void main (String[] args) {
        byte b = 0x0c;

        System.out.println ("b = " + byteToHex (b));
        System.out.println ("b = " + byteToHex (b, false));
        
        
        byte[] bs = new byte[4];
        bs[0] = 0x0c;
        bs[1] = (byte) 0xc0;
        bs[2] = 0x00;
        bs[3] = (byte) 0xff;
        
        System.out.println ("bs= " + bytesToHex (bs));
        System.out.println ("bs = " + bytesToHex (bs, false));

    }
}
