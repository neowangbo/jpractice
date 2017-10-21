/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security;

import org.nwb.jpractice.security.digitalsignature.GenDSAKeyPair;
import org.nwb.jpractice.security.digitalsignature.SignData;

/**
 *
 * @author wangbo
 */
public class Entry {
    
    private final static String COMMAND_GENDSAKEYPAIR = "dsakeypair";
    
    private final static String COMMAND_SIGN = "sign";
    
    private final static String COMMAND_VERIFY = "verify";
    
    private final static String[] COMMANDS = {COMMAND_GENDSAKEYPAIR,COMMAND_SIGN,COMMAND_VERIFY};
    
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
                    final String path = arg[1];
                    final String name = arg[2];
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
