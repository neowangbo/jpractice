package org.nwb.jpractice.algorithms.sorting;

import java.util.Arrays;

public abstract class Sorting {
	
	protected long[] arr;
    
    public Sorting(long[] arr){
        this.arr = arr;
    }
    
    public void display(){
        System.out.print(Arrays.toString(arr));
        System.out.println();
    }
    
    public abstract void sort();
    
    protected void swap(int x, int y){
        long tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}
