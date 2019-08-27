package com.b5wang.jpractice.javase.resource;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TryWithResources {

	private static final Logger LOG = LoggerFactory.getLogger(TryWithResources.class);
	
	/**
	 * Try-with-resouces statement was introduce in jdk1.7
	 * Try block
	 * Catch block
	 * Finally block
	 * 
	 * The sequence is
	 * 1) Initialize resources A,B
	 * 2) Try block
	 * 3) Close resources B,A
	 * 4) Catch block
	 * 5) Finally block
	 * 
	 * @throws IOException 
	 * */
	public static void main(String[] args) {
		
		int arg1 = 2;
		int arg2 = 3;
		
		try(
				// try-with-resources statement, including closing resources 
				MyResourceOne rs1 = new MyResourceOne(arg1);
				MyResourcesTwo rs2 = new MyResourcesTwo(arg2);
				){
			
			// try block
			LOG.info("Try block start ...");
			rs1.operate();
			rs2.operate();
			LOG.info("Try block end!");
			
		} catch(IOException ex) {
			// catch block
			LOG.error("Exception has been caught!", ex);
			Throwable[] suppressedEx = ex.getSuppressed();
			LOG.error("Suppressed exceptions {}", suppressedEx.length);
			
		} finally {
			// finally block
			LOG.info("Finally block is done!");
		}
		
	}
	
}
