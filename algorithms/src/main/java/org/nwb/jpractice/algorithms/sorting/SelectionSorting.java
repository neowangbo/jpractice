package org.nwb.jpractice.algorithms.sorting;

/**
 * Comparison: O(N^2)
 * Swap      : O(N)
 * 
 * */
public class SelectionSorting extends Sorting{

	public SelectionSorting(long[] arr) {
		super(arr);
	}

	@Override
	public void sort() {
		if(arr == null) {
			return;
		}
		
		int min;
		for(int i = 0; i < arr.length; i++) {
			min = i;
			for(int j = i + 1; j < arr.length; j++) {
				if(arr[min] > arr[j]) {
					min = j;
				}
			}
			
			if(min != i) {
				swap(i,min);
			}
		}
	}

}
