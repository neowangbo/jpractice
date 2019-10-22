package org.nwb.jpractice.j2eewls.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 * This class is to observe the lifecyle of stateless local ejb.
 * During the weblogic startup, the EJB bean would not be loaded.
 * A servlet is invoking EJB
 * 1) Constructed - 
 * 2) Inject dependencies
 * 3) @PostConstruct is triggered
 * 4) the method is invoked
 * 
 * Binding Name: java:global.j2eewls.j2eewls-ejb.LocalStatelessEJBDemoBean
 * Binding Name: java:global.j2eewls.j2eewls-ejb.LocalStatelessEJBDemoBean!org.nwb.jpractice.j2eewls.service.LocalStatelessEJBDemo
 * 
 * */
@Stateless
public class LocalStatelessEJBDemoBean implements LocalStatelessEJBDemo {

	private final static MyLogger LOG = new MyLogger(LocalStatelessEJBDemoBean.class.getName());
	
	public LocalStatelessEJBDemoBean() {
		LOG.info("Initialized");
	}
	
	@PostConstruct
	public void init() {
		LOG.info("@PostConstruct");
	}
	
	@PreDestroy
	public void close() {
		LOG.info("@PreDestroy");
	}
	
	
	@Override
	public void process() {
		LOG.info("I am called!");
	}
	
}
