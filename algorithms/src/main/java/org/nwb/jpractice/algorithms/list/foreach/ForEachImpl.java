package org.nwb.jpractice.algorithms.list.foreach;

import java.util.Iterator;

/**
 * @see: https://docs.oracle.com/javase/8/docs/technotes/guides/language/foreach.html
 * @see: https://docs.oracle.com/javase/8/docs/api/index.html
 * Iterable<T> interface since 1.5
 * Iterator<E> interface since 1.2
 * */
public class ForEachImpl implements Iterable<String>{
	
	private String[] ELEMENTS = {"ZERO","ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
	
	private class IteratorImpl implements Iterator<String>{

		private int index = 0;
		
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
