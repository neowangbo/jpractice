package org.nwb.jpractice.algorithms.sorting;

public class InsertSorting extends Sorting {
	
	public InsertSorting(long[] arr) {
		super(arr);
	}
	

	@Override
	public void sort() {
		//1 find out marked index
		int markedIndex = arr.length % 2 == 0 ? (arr.length / 2 + 1):(arr.length / 2);
		
		//2 first half uses selection sorting
		
		
	}
	
	public static void main(String[] args) {
		int i = 9;
		
		int markedIndex;
		if(i % 2 == 0) {
			markedIndex = i/2 + 1;
			System.out.println("markedIndex = " + markedIndex);
		}else {
			markedIndex = i/2;
			System.out.println("markedIndex = " + markedIndex);
		}
	}

}
