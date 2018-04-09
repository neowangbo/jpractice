/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class SimpleDaemon extends Thread{
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public SimpleDaemon(){
        setDaemon(true);
        start();
    }
    
    @Override
    @SuppressWarnings("SleepWhileInLoop")
    public void run(){
        System.out.println(this);
        while(true){
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(SimpleDaemon.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(this + "---");
        }
    }
    
    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public static void main(String[] args){
        for(int i = 0; i < 10; i++){
            new SimpleDaemon();
        }
    }
}
