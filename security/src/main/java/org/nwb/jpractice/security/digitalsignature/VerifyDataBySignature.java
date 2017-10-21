/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.digitalsignature;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAPublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class VerifyDataBySignature {
    
    public static void verify(String pubKeyFile, String file, String signature){
        System.out.println("Public certificate: " + pubKeyFile);
        System.out.println("Public certificate: " + pubKeyFile);
        try(FileInputStream fis = new FileInputStream(file);){
            DSAPublicKey pub = ReadDSAKey.readPublicKey(pubKeyFile);
            if(pub == null){
                System.out.println("Public key is null!");
                return;
            }
            
            Signature sig = Signature.getInstance("SHA1withDSA", "SUN");
            sig.initVerify(pub);
            
            int len;
            byte[] buf = new byte[1024];
            while((len = fis.read(buf)) >= 0){
                sig.update(buf, 0, len);
            }
            
            boolean result = sig.verify(sigToVerify);
            
        } catch (IOException ex) {
            Logger.getLogger(VerifyDataBySignature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(VerifyDataBySignature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchProviderException ex) {
            Logger.getLogger(VerifyDataBySignature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeyException ex) {
            Logger.getLogger(VerifyDataBySignature.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SignatureException ex) {
            Logger.getLogger(VerifyDataBySignature.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
