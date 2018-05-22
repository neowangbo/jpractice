/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.martian.apps.javabasics.config;

/**
 * Get system properties, system properties are passed by java.exe command, like
 * java ... -DpropKey=propValue
 * @author b5wang
 */
public class SystemPropDemo {
    
    public static void main(String[] args){
        System.getProperties().entrySet().stream().forEach(entry->{
            System.out.println("System Property: " + entry.getKey() + "---" + entry.getValue());
        });
    }
    
}
