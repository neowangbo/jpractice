package org.nwb.jpractice.algorithms.sorting;

public class SortingUtil {

	public static long[] getDescentArr(int len) {
		int max = len;
		long[] arr = new long[len];
		
		for(int i = 0; i < len; i++) {
			arr[i] = max--;
		}
		
		return arr;
	}
	
	public static long[] getAscentArr(int len) {
		int max = len;
		long[] arr = new long[len];
		
		for(int i = 0; i < len; i++) {
			arr[i] = i + 1;
		}
		
		return arr;
	}
	
}
