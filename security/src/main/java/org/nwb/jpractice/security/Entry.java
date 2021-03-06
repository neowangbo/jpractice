/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security;

import org.nwb.jpractice.security.cipher.GenerateAESKey;
import org.nwb.jpractice.security.signing.GenDSAKeyPair;
import org.nwb.jpractice.security.signing.SignData;
import org.nwb.jpractice.security.signing.VerifyDataBySignature;

/**
 *
 * @author wangbo
 */
public class Entry {
    
    private final static String COMMAND_GENDSAKEYPAIR = "dsakeypair";
    
    private final static String COMMAND_SIGN = "sign";
    
    private final static String COMMAND_VERIFY = "verify";
    
    private final static String COMMAND_GENAESKEY = "aeskey";
    
    private final static String[] COMMANDS = {COMMAND_GENDSAKEYPAIR,COMMAND_SIGN,COMMAND_VERIFY,COMMAND_GENAESKEY};
    
    public static void main(String[] args){
        
        if(args.length > 0){
            
            final String command = args[0];
            
            System.out.println("Execute " + command);
            
            switch(command){
                case COMMAND_GENDSAKEYPAIR:{
                    System.out.println("Generate DSA key pair...");
                    final String path = args[1];
                    final String name = args[2];
                    GenDSAKeyPair.generate(path, name);
                    break;
                }
                case COMMAND_SIGN:{
                    System.out.println("Sign signature...");
                    final String privKeyFile = args[1];
                    final String file = args[2];
                    SignData.sign(privKeyFile, file);
                    break;
                }
                case COMMAND_VERIFY:{
                    System.out.println("Verify signature...");
                    final String pubKeyFile = args[1];
                    final String file = args[2];
                    final String sig = args[3];
                    VerifyDataBySignature.verify(pubKeyFile, file, sig);
                    break;
                }
                case COMMAND_GENAESKEY:{
                    System.out.println("Generate AES key...");
                    final String file = args[1];
                    GenerateAESKey.gen(file);
                    break;
                }
                default:{
                    help();
                }
            }
                
            
            
        }else{
            System.out.println("No command!");
            help();
        }
    }
    
    
    private static void help(){
        
        System.out.println("All commands:");
        
        for(String command : COMMANDS){
            System.out.printf("    %s\n",command);
        }
    }
    
}
