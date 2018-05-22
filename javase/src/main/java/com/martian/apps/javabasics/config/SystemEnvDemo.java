/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javabasics.config;

import java.util.Map;

/**
 * Get OS System Environment Variables.
 * System environment variables are related with OS.
 * @author b5wang
 */
public class SystemEnvDemo {
    
    public static void main(String[] args){
        Map<String,String> env = System.getenv();
        env.entrySet().stream().forEach((entry) -> {
            System.out.println("System Environment: " + entry.getKey() + "---" + entry.getValue());
        });
        
        System.out.println("echo %JAVA_HOME%: " + System.getenv("JAVA_HOME"));
        System.out.println("LOCAL_SFTP: " + System.getenv("LOCAL_SFTP"));
    }
    
}
