/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.cipher;

import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

/**
 *
 * @author wangbo
 */
public class GenerateAESKey {

    public static void gen(String file) {
        try {
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();
            
            System.out.println("Format: " + key.getFormat());
            
            try(FileOutputStream fos = new FileOutputStream(file);){
                fos.write(key.getEncoded());
            } catch (IOException ex) {
                Logger.getLogger(GenerateAESKey.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Generate AES key at: " + file);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(GenerateAESKey.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
