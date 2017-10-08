/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.digitalsignature;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import org.nwb.jpractice.utils.StringUtil;
import sun.security.jca.Providers;


/**
 *
 * @author wangbo
 */
public class TextMessageDigest {
    
    public static final String ALG_SHA256 = "SHA-256";
    
    public static final String ALG_MD5 = "MD5";
    
    public static final String MSG_1 = "Hello Tom, Thanks for your help last firiday!";
    
    public static final String MSG_2 = "Helle Tom, Thanks for your help last firiday!";
    
    public static void main(String[] args) throws NoSuchAlgorithmException{
        
        MessageDigest digest = MessageDigest.getInstance (ALG_MD5);
        
        digest.update (MSG_1.getBytes());
        byte[] hash1 = digest.digest ();
        
        digest.update (MSG_2.getBytes());
        byte[] hash2 = digest.digest ();
        
        System.out.println("Signature of message 1 : " + StringUtil.bytesToHex(hash1, true));
        System.out.println("Signature of message 2 : " + StringUtil.bytesToHex(hash2, true));
    }
    
}
