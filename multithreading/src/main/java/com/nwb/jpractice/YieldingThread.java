/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice;

/**
 * 
 * Call yield() to yield current thread.
 * But can't rely on yield() method.
 * 
 * @author wangbo
 */
public class YieldingThread extends Thread{
    
    private int countDown = 10;
	private static int threadCount = 0;
    
    public YieldingThread(){
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
            yield();
		}
	}
	
	public static void main(String[] args) {
		for(int i = 0; i < 5; i++) {
			new YieldingThread();
		}
	}
}
