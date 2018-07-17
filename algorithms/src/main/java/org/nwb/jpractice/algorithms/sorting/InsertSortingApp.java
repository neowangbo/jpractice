package org.nwb.jpractice.algorithms.sorting;

public class InsertSortingApp {

	public static void main(String[] args) {
		long[] arr = SortingUtil.getDescentArr(9);
		InsertSorting is = new InsertSorting(arr);
		
		is.display();
		is.sort();
		is.display();
	}
	
}
