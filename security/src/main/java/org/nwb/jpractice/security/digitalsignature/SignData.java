/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.digitalsignature;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class SignData {
    
    public static void sign(String privFile, String file){
        
        try {
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            
            try(FileInputStream fis = new FileInputStream(privFile);){
                int len = fis.available();
                byte[] ba = new byte[len];
                fis.read(ba);
                
                PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(ba);
                PrivateKey priKey = keyFactory.generatePrivate(priKeySpec);
                
            } catch (IOException | InvalidKeySpecException ex) {
                Logger.getLogger(SignData.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            PrivateKey priv = new PrivateKey();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(SignData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
