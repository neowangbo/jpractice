package org.nwb.jpractice.algorithms.list.foreach;

import java.util.Iterator;

/**
 * @see: https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html
 * @see: https://docs.oracle.com/javase/8/docs/api/index.html
 * */
public class ForEachImpl implements Iterable<String>{
	
	private String[] ELEMENTS = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
	
	public class IteratorImpl implements Iterator<String>{

		private int index = 0;
		
		private IteratorImpl() {
			// is not able to initiate
		}
		
		@Override
		public boolean hasNext() {
			return index < ELEMENTS.length;
		}

		@Override
		public String next() {
			return ELEMENTS[index++];
		}
	}
	
	@Override
	public Iterator<String> iterator() {
		return new IteratorImpl();
	}

	public static void main(String[] args) {
		ForEachImpl fei = new ForEachImpl();
		for(String el : fei) {
			System.out.println(" - " + el);
		}
	}
	
}
