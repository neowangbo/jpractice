package org.nwb.jpractice.j2eewls.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import org.nwb.jpractice.j2eewls.api.RemoteStatelessEJBDemo;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/* 
 * In weblogic managed server "JNDI Tree structure" you see <mappedName>#<EJB Interface class name>
 * */
@Stateless(name="RemoteStatelessEJBDemoBean", mappedName="ejb/RemoteStatelessEJBDemoBean")
public class RemoteStatelessEJBDemoBean implements RemoteStatelessEJBDemo {

	private final static MyLogger LOG = new MyLogger(RemoteStatelessEJBDemoBean.class.getName());
	
	public RemoteStatelessEJBDemoBean() {
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
