package com.martian.apps.javabasics.security.jca.digest;

import com.martian.apps.javabasics.util.StringUtil;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Message digest, digital fingerprint of a block of data.
 * 
 * Online SHA-256 generator
 * http://passwordsgenerator.net/sha256-hash-generator/
 * 
 * Onlien MD5 generator
 * http://passwordsgenerator.net/md5-hash-generator/
 */
public class DemoMessageDigest {
    
    public static final String MESSAGEDIGEST_ALG_SHA256 = "SHA-256";
    
    public static final String MESSAGEDIGEST_ALG_MD5 = "MD5";

    public static void main (String[] args) throws NoSuchAlgorithmException, IOException {
        // generate hash value for a string
        // System.out.println(textDigest ("Hello world!", MESSAGEDIGEST_ALG_SHA256, false));
        // System.out.println(textDigest ("Hello world!", MESSAGEDIGEST_ALG_MD5, false));
        
        // generate hash value for a file
        String file = "/Users/wangbo/DevHome/Tools/Brackets.1.6.Extract.dmg";
        System.out.println(fileDigest (file, MESSAGEDIGEST_ALG_MD5, true));
    }


    public static String textDigest (String text, String alg, boolean isLowerCase) throws NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance (alg);
        digest.update (text.getBytes ());
        byte[] hash = digest.digest ();
        
        return StringUtil.bytesToHex(hash, isLowerCase);
    }


    public static String fileDigest (String filePath, String alg, boolean isLowerCase) throws NoSuchAlgorithmException, FileNotFoundException, IOException {
        
        MessageDigest digest;
        
        /* java 8
         * try-with-resouces statement is a try statement that declares one or more resources. 
         * A resource is an object that must be closed after the program is finished with it.
         * The try-with-resources statement ensures that each resource is closed at the end of the statement. 
         * Any object that implements java.lang.AutoCloseable, which includes all objects which implement java.io.Closeable, can be used as a resource.
         * Closeable interface extends AutoCloseable interface.
         */
        try (BufferedInputStream in = new BufferedInputStream (new FileInputStream (filePath))) {
            digest = MessageDigest.getInstance (alg);
            byte[] buf = new byte[2048];
            int len;
            while ((len = in.read (buf)) >= 0) {
                digest.update (buf, 0, len);
            }
        }
        
        byte[] hash = digest.digest ();
        
        return StringUtil.bytesToHex(hash, isLowerCase);
    }

}
