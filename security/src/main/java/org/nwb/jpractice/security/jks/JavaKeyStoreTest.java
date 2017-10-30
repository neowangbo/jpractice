/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.jks;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nwb.jpractice.utils.StringUtil;

/**
 *
 * @author wangbo
 */
public class JavaKeyStoreTest {
    
    private final static String KEYSTORE = "/Users/wangbo/DevHome/projects/GitHub/jpractice/security/keystore.jks";
    
    private final static String PASS = "gemalto51";
    
    
    /**
     * A keystore can contain:
     * RSA key pair
     * DSA key pair
     * 
     */
    public static void main(String[] args){
        try (FileInputStream fis = new FileInputStream(KEYSTORE);){
            KeyStore jks = KeyStore.getInstance("JKS");
            jks.load(fis, PASS.toCharArray());
            
            
            Enumeration<String> aliasEnumeration = jks.aliases();
            while(aliasEnumeration.hasMoreElements()){
                String alias = aliasEnumeration.nextElement();
                System.out.println("-----------------------------");
                System.out.println("alias: " + alias);
                
                Certificate cert = jks.getCertificate(alias);
                System.out.println("    certificate type    : " + cert.getType());
                System.out.println("    public key algorithm: " + cert.getPublicKey().getAlgorithm());
                System.out.println("    public key format   : " + cert.getPublicKey().getFormat());
                System.out.println("    public key          : " + StringUtil.bytesToHex(cert.getPublicKey().getEncoded()));
                System.out.println("    ****");
                
                Key key = jks.getKey(alias, PASS.toCharArray());
                System.out.println("    private key alg     : " + key.getAlgorithm());
                System.out.println("    private key format  : " + key.getFormat());
                System.out.println("    private key         : " + StringUtil.bytesToHex(key.getEncoded(), true));
            }
            
        } catch (KeyStoreException | IOException | NoSuchAlgorithmException | CertificateException ex) {
            Logger.getLogger(JavaKeyStoreTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnrecoverableKeyException ex) {
            Logger.getLogger(JavaKeyStoreTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
