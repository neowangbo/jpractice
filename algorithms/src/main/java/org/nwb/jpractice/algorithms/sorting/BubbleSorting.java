/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.algorithms.sorting;

import java.util.Arrays;

/**
 *
 * O(N^2)
 * 
 * @author wangbo
 */
public class BubbleSorting {
    
    private long[] arr;
    
    public BubbleSorting(long[] arr){
        this.arr = arr;
    }
    
    public void display(){
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
    
    public void sort(){
        if(arr == null){
            return;
        }
        
        int step = 0;
        for(int i = 0; i < arr.length; i++){
            step = arr.length - 1 - i;
            for(int j = 0; j < step; j++){
                if(arr[j] > arr[j + 1]){
                    swap(j,j+1);
                }
            }
        }
    }
    
    public void sort2() {
    	int out, in;
    	
    	for(out = arr.length - 1; out >= 1; out--) {
    		for(in = 0; in < out; in++) {
    			if(arr[in] > arr[in+1]) {
    				swap(in,in+1);
    			}
    		}
    	}
    }
    
    private void swap(int x, int y){
        long tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
    
}
