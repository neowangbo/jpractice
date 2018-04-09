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
public class RightDaemon extends Thread{
    
    private Thread[] ts = new Thread[10];
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public RightDaemon(){
        setDaemon(true);
        start();
    }
    
    @Override
    @SuppressWarnings("CallToThreadYield")
    public void run(){
        for(int i = 0; i < ts.length; i++){
            ts[i] = new DaemonSpawn(i);
        }
        
        for(int i = 0; i < ts.length; i++){
            System.out.println("ts[" + i + "].isDaemon() = " + ts[i].isDaemon());
        }
        
        while(true){
            yield();
        }
    }
    
    
}
