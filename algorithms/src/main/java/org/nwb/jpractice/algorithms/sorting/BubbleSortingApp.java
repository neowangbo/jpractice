package org.nwb.jpractice.algorithms.sorting;

public class BubbleSortingApp {

	public static void main(String[] args) {
		int j = 200;
		int max = j;
		long[] arr = new long[j];
		
		for(int i = 0; i < j; i++) {
			arr[i] = max--;
		}
		
		BubbleSorting bs = new BubbleSorting(arr);
		bs.display();
		bs.sort2();
		bs.display();
	}
	
}
