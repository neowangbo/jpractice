/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.signing;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.interfaces.DSAPrivateKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nwb.jpractice.utils.StringUtil;

/**
 *
 * @author wangbo
 */
public class SignData {

    public static void sign(String privKeyFile, String file) {
        
        System.out.println("Private key: " + privKeyFile);
        System.out.println("File       : " + file);

        try (FileInputStream fis = new FileInputStream(file);) {
            DSAPrivateKey privKey = ReadDSAKey.readPrivateKey(privKeyFile);
            if (privKey == null) {
                System.out.println("DSA private key is null.");
                return;
            }

            Signature dsa = Signature.getInstance("SHA1withDSA", "SUN");
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
            dsa.initSign(privKey, random);

            byte[] buf = new byte[1024];
            int len;
            while ((len = fis.read(buf)) >= 0) {
                dsa.update(buf, 0, len);
            }
            
            byte[] realSig = dsa.sign();
            
            String sig = StringUtil.bytesToHex(realSig, true);
            System.out.println("Signature: " + sig);
        } catch (NoSuchAlgorithmException | NoSuchProviderException | InvalidKeyException | SignatureException | IOException ex) {
            Logger.getLogger(SignData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
