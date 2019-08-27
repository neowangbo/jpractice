package com.b5wang.jpractice.javase.resource;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyResourceOne implements Closeable {

	private final static Logger LOG = LoggerFactory.getLogger(MyResourceOne.class);
	
	/*
	 * 0 - no error, default error
	 * 1 - error happen when init resource
	 * 2 - error happen when operate resource
	 * 3 - error happen when close resource
	 * 4 - error happen when operate and close resource, at 2 phases
	 * other values - no error
	 * */
	private int condition;
	
	public MyResourceOne() throws IOException {
		this(0);
	}
	
	public MyResourceOne(int condition) throws IOException {
		this.condition = condition;
		
		LOG.info("Initializing MyResourceOne. condition = {}",condition);
		
		if(this.condition == 1) {
			throw new IOException("Error occured during initializing the resouce MyResourceOne.");
		}
		
		LOG.info("Initializing MyResourceOne successfully");
	}
	
	public void operate() throws IOException{
		LOG.info("Operating MyResourceOne");
		if(this.condition == 2 || this.condition == 4) {
			throw new IOException("Error occured during operating resouce MyResourceOne.");
		}
		LOG.info("Operating MyResourceOne successfully");
	}
	
	@Override
	public void close() throws IOException {
		LOG.info("Closing MyResourceOne");
		if(this.condition == 3 || this.condition == 4) {
			throw new IOException("Error occured during closing the resouce MyResourceOne.");
		}
		LOG.info("Closing MyResourceOne successfully");
	}

}
