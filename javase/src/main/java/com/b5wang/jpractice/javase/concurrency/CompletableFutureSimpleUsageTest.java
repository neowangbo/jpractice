package com.b5wang.jpractice.javase.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * 
 * As same as Future
 */
public class CompletableFutureSimpleUsageTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Long time job A :: started!");
			// 长时间的异步计算, 10 seconds
			for(int i = 1; i <=10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Long time job A :: running " + i + " seconds.");
			}
			// 然后返回结果
			System.out.println("Long time job A :: ended!");
			return 999;
		});
		
		System.out.println("Short time job B :: started!");
		System.out.println("Short time job B :: ended!");
		
		/*
		 * join vs get, join不抛出异常，get抛出异常
		 * */
		//int result = future.join();
		int result = future.get();
		System.out.println("result=" + result);
	}

}
