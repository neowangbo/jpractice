package com.b5wang.jpractice.javase.resource;

import java.io.Closeable;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyResourcesTwo implements Closeable {

private final static Logger LOG = LoggerFactory.getLogger(MyResourcesTwo.class);
	
	/*
	 * 0 - no error, default error
	 * 1 - error happen when init resource
	 * 2 - error happen when operate resource
	 * 3 - error happen when close resource
	 * 4 - error happen when operate and close resource, at 2 phases
	 * other values - no error
	 * */
	private int condition;
	
	public MyResourcesTwo() throws IOException {
		this(0);
	}
	
	public MyResourcesTwo(int condition) throws IOException {
		this.condition = condition;
		
		LOG.info("Initializing MyResourcesTwo. condition = {}",condition);
		
		if(this.condition == 1) {
			throw new IOException("Error occured during initializing the resouce MyResourcesTwo.");
		}
		
		LOG.info("Initializing MyResourcesTwo successfully");
	}
	
	public void operate() throws IOException{
		LOG.info("Operating MyResourcesTwo");
		if(this.condition == 2 || this.condition == 4) {
			throw new IOException("Error occured during operating resouce MyResourcesTwo.");
		}
		LOG.info("Operating MyResourcesTwo successfully");
	}
	
	@Override
	public void close() throws IOException {
		LOG.info("Closing MyResourcesTwo");
		if(this.condition == 3 || this.condition == 4) {
			throw new IOException("Error occured during closing the resouce MyResourcesTwo.");
		}
		LOG.info("Closing MyResourcesTwo successfully");
	}

}
