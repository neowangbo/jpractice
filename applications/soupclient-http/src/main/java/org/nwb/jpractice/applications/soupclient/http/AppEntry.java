package org.nwb.jpractice.applications.soupclient.http;

import org.apache.commons.codec.binary.Base64;

/**
 * Hello world!
 *
 */
public class AppEntry 
{
    public static void main( String[] args ) {
    	
    	int num = args.length;
    	
    	System.out.println("Number of argments: " + num);
    	
    	for(String arg : args) {
    		System.out.println("Arg: " + arg);
    	}
    	
    	String str = "Hello world!";
        System.out.println("original string     : " + str);
        System.out.println("base64 masked string: " + Base64.encodeBase64String(str.getBytes()));
    }
}
