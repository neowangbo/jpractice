/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.cipher;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 * AES - Advanced Encryption Standard
 *
 * @author wangbo
 */
public class AESSample {

    public static void main(String[] args) {

        try {
            // 1. generate secrete key
            KeyGenerator keygen = KeyGenerator.getInstance("AES");
            SecureRandom random = new SecureRandom();
            keygen.init(random);
            SecretKey key = keygen.generateKey();

            // 2. original text file
            String originalFile = "/Users/wangbo/DevHome/projects/GitHub/jpractice/security/simple.txt";
            String cipheredFile = originalFile + ".ciphered";
            String uncipheredFile = originalFile + ".unciphered";

            // 3. cipher object
            Cipher cipher = Cipher.getInstance("AES");
            
            // 4. encryption
            int mode = Cipher.ENCRYPT_MODE;
            cipher.init(mode, key);
            try (FileInputStream fis = new FileInputStream(originalFile); FileOutputStream fos = new FileOutputStream(cipheredFile);) {
                crypt(fis,fos,cipher);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AESSample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | GeneralSecurityException ex) {
                Logger.getLogger(AESSample.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            // 5. decryption
            mode = Cipher.DECRYPT_MODE;
            cipher.init(mode, key);
            try (FileInputStream fis = new FileInputStream(cipheredFile); FileOutputStream fos = new FileOutputStream(uncipheredFile);) {
                crypt(fis,fos,cipher);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AESSample.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException | GeneralSecurityException ex) {
                Logger.getLogger(AESSample.class.getName()).log(Level.SEVERE, null, ex);
            }
            

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException ex) {
            Logger.getLogger(AESSample.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void crypt(InputStream in, OutputStream out, Cipher cipher) throws IOException, GeneralSecurityException {
        int blockSize = cipher.getBlockSize();
        int outputSize = cipher.getOutputSize(blockSize);
        byte[] inBytes = new byte[blockSize];
        byte[] outBytes = new byte[outputSize];
        
        int inLength = 0;
        boolean more = true;
        while ((inLength = in.read(inBytes)) == blockSize) {
            int outLength = cipher.update(inBytes, 0, blockSize, outBytes);
            out.write(outBytes, 0, outLength);
        }
        
        if (inLength > 0) {
            outBytes = cipher.doFinal(inBytes, 0, inLength);
        } else {
            outBytes = cipher.doFinal();
        }
        
        out.write(outBytes);
    }

}
