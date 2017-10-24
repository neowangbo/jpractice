/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.signing;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class GenDSAKeyPair {

    /**
     * Generate a private key and public key.
     * 
     * @param path - a path where you want to put the private and public
     * @param name - generate 2 files, .key is private key and .cer is public key
     */
    public static void generate(String path, String name){
        
        
        try {
            /*
            * DSA - Data Signing Algorithm
            */
            KeyPairGenerator generator = KeyPairGenerator.getInstance("DSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            generator.initialize(1024, random);
            
            KeyPair keyPair = generator.generateKeyPair();
            
            PrivateKey priv = keyPair.getPrivate();
            PublicKey pub = keyPair.getPublic();
            
            File pathObj = new File(path);
            
            String privFullPath = pathObj.getAbsolutePath() + File.separator + name + ".key";
            System.out.println("Generate private key: " + privFullPath);
            try(FileOutputStream fos = new FileOutputStream(privFullPath)){
                fos.write(priv.getEncoded());
            } catch (IOException ex) {
                Logger.getLogger(GenDSAKeyPair.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            String pubFullPath = pathObj.getAbsolutePath() + File.separator + name + ".cer";
            System.out.println("Generate public key: " + pubFullPath);
            try(FileOutputStream fos = new FileOutputStream(pubFullPath)){
                fos.write(pub.getEncoded());
            } catch (IOException ex) {
                Logger.getLogger(GenDSAKeyPair.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Done!");
            
        } catch (NoSuchAlgorithmException | NoSuchProviderException ex) {
            Logger.getLogger(GenDSAKeyPair.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args){
        String path = "/Users/wangbo/DevHome/projects/GitHub/jpractice/security/target/";
        
        File file = new File(path);
        System.out.println("---" + file.getAbsolutePath());// re calculate absolute path name
        System.out.println("---" + file.getPath());// simply return the value of path field
    }
    
}
