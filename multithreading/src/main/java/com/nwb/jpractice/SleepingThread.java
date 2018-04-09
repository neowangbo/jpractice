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
 * 
 * 
 * @author wangbo
 */
public class SleepingThread extends Thread{
    
    private int countDown = 10;
	private static int threadCount = 0;
    
    public SleepingThread(){
        super("" + ++threadCount);
		start();//start will call run()
    }
    
    @Override
	public String toString() {
		return "#" + getName() + ": " + countDown;
	}
	
    @Override
    @SuppressWarnings("CallToThreadYield")
	public void run() {
		while(true) {
			System.out.println(this);
			if(--countDown == 0) {
				return;
			}
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(SleepingThread.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			new SleepingThread();
		}
	}
}
