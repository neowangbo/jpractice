package org.nwb.jpractice.algorithms.sorting;

public class SelectSortingApp {

	public static void main(String[] args) {
		int j = 200;
		int max = j;
		long[] arr = new long[j];
		
		for(int i = 0; i < j; i++) {
			arr[i] = max--;
		}
		
		SelectionSorting ss = new SelectionSorting(arr);
		ss.display();
		ss.sort();
		ss.display();
	}
	
}
