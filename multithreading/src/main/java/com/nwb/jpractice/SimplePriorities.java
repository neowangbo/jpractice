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
public class SimplePriorities extends Thread{
    
    private int countDown = 5;
    private volatile double d = 0;
    
    @SuppressWarnings({"OverridableMethodCallInConstructor", "CallToThreadStartDuringObjectConstruction"})
    public SimplePriorities(int priority){
        setPriority(priority);
        start();
    }
    
    @Override
    public String toString(){
        return super.toString() + ": " + countDown;
    }
    
    @Override
    public void run(){
        while(true){
            for(int i = 1; i < 100000; i++){
                d = d + (Math.PI + Math.E) / (double)i;
            }
            System.out.println(this);
            if(--countDown == 0) return;
        }
    }
    
    public static void main(String[] args){
        new SimplePriorities(Thread.MAX_PRIORITY);
        for(int i = 0; i < 5; i++){
            new SimplePriorities(Thread.MIN_PRIORITY);
        }
    }
    
}
