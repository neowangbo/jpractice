package org.nwb.jpractice.algorithms.sorting;

import java.util.Arrays;

public class InsertSorting extends Sorting {
	
	public InsertSorting(long[] arr) {
		super(arr);
	}
	

	@Override
	public void sort() {
		//1. find out marked index
		int markedIndex = arr.length % 2 == 0 ? (arr.length / 2):(arr.length / 2 + 1);
		System.out.println("arr.length: " + arr.length + ", markedIndex: " + markedIndex);
		
		//2. first half uses selection sorting
		int min;
		for(int i = 0; i < markedIndex; i++) {			
			min = i;
			for(int j = i+1; j < markedIndex; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				swap(i,min);
			}
		}
		System.out.println("Complete selection sorting: " + Arrays.toString(arr));
		
		//3. move element from markedIndex
		long tmp;
		for(int i = markedIndex; i < arr.length; i++) {
			tmp = arr[i];
			
			System.out.println("i=" + i + ", tmp=" + tmp);
			
			for(int j = i - 1; j >= 0; j--) {
				if(tmp < arr[j]) {
					arr[j + 1] = arr[j];
				}else {
					arr[j] = tmp;
					break;
				}
				
				if(j == 0) {
					arr[0] = tmp;
				}
			}
		}
		
	}
	
}
