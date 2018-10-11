package org.nwb.jpractice.applications.soupclient.http;

import org.apache.commons.codec.binary.Base64;

/**
 * Hello world!
 *
 */
public class AppEntry 
{
    public static void main( String[] args ) {
    	String str = "Hello, " + args[0] + "!";
        System.out.println("original string     : " + str);
        System.out.println("base64 masked string: " + Base64.encodeBase64String(str.getBytes()));
    }
}
