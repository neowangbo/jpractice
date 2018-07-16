package org.nwb.jpractice.algorithms.sorting;

public class BubbleSortingApp {

	public static void main(String[] args) {
		long[] arr = SortingUtil.getDescentArr(50);
		BubbleSorting bs = new BubbleSorting(arr);
		bs.display();
		bs.sort2();
		bs.display();
	}
	
}
