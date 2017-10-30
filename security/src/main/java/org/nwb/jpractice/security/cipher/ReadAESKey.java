/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.cipher;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKey;

/**
 *
 * @author wangbo
 */
public class ReadAESKey {
    
    public static SecretKey read(String file){
        SecretKey key = null;
        
        try(FileInputStream fis = new FileInputStream(file);){
            
//            PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(byteArr);
//            KeyFactory keyFactory = KeyFactory.getInstance("AES");
//            PrivateKey pri = keyFactory.generatePrivate(priKeySpec);
            
        } catch (IOException ex) {
            Logger.getLogger(ReadAESKey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
