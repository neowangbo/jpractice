/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.digitalsignature;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.DSAPrivateKey;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * http://www.herongyang.com/Cryptography/DSA-Java-DsaKeyChecker-java-Read-and-Check-DSA-Key.html
 * 
 * Remember following important object:
 * KeyFactory
 * 
 * ---PKCS8EncodedKeySpec---private key specification 
 * ---X509EncodedKeySpec---public key specification
 * 
 *      |->PrivateKey->DSAPrivateKey
 * Key -+
 *      |->PublicKey->DSAPublicKey
 * 
 *
 * @author wangbo
 */
public class ReadDSAKey {

    public static DSAPrivateKey readPrivateKey(String file) {
        DSAPrivateKey priKey = null;
        try (FileInputStream fis = new FileInputStream(file);) {
            int len = fis.available();
            byte[] byteArr = new byte[len];
            fis.read(byteArr);
            PKCS8EncodedKeySpec priKeySpec = new PKCS8EncodedKeySpec(byteArr);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PrivateKey pri = keyFactory.generatePrivate(priKeySpec);
            priKey = (DSAPrivateKey)pri;
        } catch (IOException | InvalidKeySpecException | NoSuchAlgorithmException ex) {
            Logger.getLogger(ReadDSAKey.class.getName()).log(Level.SEVERE, null, ex);
        }
        return priKey;
    }
    
    public static DSAPublicKey readPublicKey(String file) {
        DSAPublicKey pubKey = null;
        try(FileInputStream fis = new FileInputStream(file);){
            int len = fis.available();
            byte[] byteArr = new byte[len];
            fis.read(byteArr);
            X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(byteArr);
            KeyFactory keyFactory = KeyFactory.getInstance("DSA");
            PublicKey pub = keyFactory.generatePublic(pubKeySpec);
            pubKey = (DSAPublicKey)pub;
        } catch (NoSuchAlgorithmException | IOException | InvalidKeySpecException ex) {
            Logger.getLogger(ReadDSAKey.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pubKey;
    }
    
    public static KeyPair read(String pubKeyFile, String privKeyFile){
        return new KeyPair(readPublicKey(pubKeyFile), readPrivateKey(privKeyFile));
    }

}
