/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.util;

/**
 *
 * @author b5wang
 */
public class MyLogger {
    
    private final static String LOG_PATTERN = "===>>> %s :: %s";
    
    private final String name;
    
    public MyLogger(String name){
        this.name = name;
    }
    
    public void info(String msg){
        System.out.println(String.format(LOG_PATTERN, name, msg));
    }
    
    public void info(String msgPattern, Object... args){
        String msg = String.format(msgPattern, args);
        System.out.println(String.format(LOG_PATTERN, name, msg));
    }
    
    public void error(String msg, Throwable ex){
        System.out.println(String.format(LOG_PATTERN, name, msg));
        ex.printStackTrace();
    }
}
