/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice;

import static java.lang.Thread.yield;

/**
 *
 * @author wangbo
 */
public class DaemonSpawn  extends Thread{
    
    private int i;
    
    public DaemonSpawn(int i){
        start();
        this.i = i;
        System.out.println("DaemonSpawn -" + i + "- started");
    }

    @Override
    @SuppressWarnings("CallToThreadYield")
    public void run(){
        while(true){
            System.out.println("DaemonSpawn -" + i + "- running ...");
            yield();
        }
    }
}
