package com.b5wang.jpractice.javase.concurrency;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureIsDoTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		Future<Integer> f = es.submit(() -> {
			System.out.println("Long time job A :: started!");
			// 长时间的异步计算, 10 seconds
			for(int i = 1; i <=10; i++) {
				Thread.sleep(1000);
				System.out.println("Long time job A :: running " + i + " seconds.");
			}
			// 然后返回结果
			System.out.println("Long time job A :: ended!");
			return 999;
		});
		
		System.out.println("Short time job B :: started!");
		System.out.println("Short time job B :: ended!");
		
        while(!f.isDone()) {
        	System.out.println("Checking job A is done or not? ...");
        	Thread.sleep(1000 * 5);
        };
        System.out.println("Checking job A has been done!");
	}	
	
}
