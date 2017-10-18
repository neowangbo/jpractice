/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security;

import org.nwb.jpractice.security.digitalsignature.GenDSAKeyPair;

/**
 *
 * @author wangbo
 */
public class Entry {
    
    private final static String COMMAND_GEMKEYPAIR = "dsakeypair";
    
    private final static String COMMAND_SIGN = "sign";
    
    private final static String[] COMMANDS = {COMMAND_GEMKEYPAIR,COMMAND_SIGN};
    
    public static void main(String[] args){
        
        if(args.length > 0){
            
            final String command = args[0];
            
            System.out.println("Execute " + command);
            
            switch(command){
                case COMMAND_GEMKEYPAIR:{
                    final String path = args[1];
                    final String name = args[2];
                    GenDSAKeyPair.generate(path, name);
                    break;
                }
                case COMMAND_SIGN:{
                    final String priv = args[1];
                    final String file = args[2];
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
