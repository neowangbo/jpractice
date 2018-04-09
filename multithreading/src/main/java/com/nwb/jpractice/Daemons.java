/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice;

/**
 *
 * @author wangbo
 */
public class Daemons {
    
    public static void main(String[] args) throws InterruptedException{
        Thread d = new RightDaemon();
        System.out.println("d.isDaemon() = " + d.isDaemon());
        
        Thread.sleep(10000);
        System.out.println("Main tread end.");
    }
    
}
