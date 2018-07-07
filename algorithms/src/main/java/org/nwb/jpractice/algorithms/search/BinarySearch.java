package org.nwb.jpractice.algorithms.search;

/**
 * Search in an ordered array
 * 
 * */
public class BinarySearch {

	private static final int[] ARRAY_EVEN;
	
	static {
		ARRAY_EVEN = new int[1000];
	}
	
	private static final int[] ARRAY_ODD;
	
	static {
		ARRAY_ODD = new int[1000];
	}
	
	public static void main(String[] args) {
		int[] array = null;
		int step = array.length;
		int target = 0;
		
		//1. check value is inside arrange
		if(target < array[0] && array[step - 1] < step) {
			System.out.println(String.format("Not found %d. It's not in arrange of [%d,%d].", target, array[0], array[step - 1]));
		}else {
			if(target == array[0]) {
				System.out.println(String.format("Found %d, index = %d", target, 0));
				return;
			}else if(target == array[0]) {
				System.out.println(String.format("Found %d, index = %d", target, step - 1));
				return;
			}
		}
		
		// 2. start binary
		int index = -1;
		int start = 0;
		int end = 0;
		int middle = 0;
		while(step > 0) {
			step = step / 2;
			
		}
	}
}
