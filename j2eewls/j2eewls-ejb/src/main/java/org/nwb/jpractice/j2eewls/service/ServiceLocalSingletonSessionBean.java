/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 * 
 * https://stackoverflow.com/questions/14464823/difference-between-stateless-and-singleton
 * 
 * Singleton can be used to load some other tasks.
 * 
 * https://www.tomitribe.com/blog/singleton-session-beans-eager-initialization-and-ordering/
 * 
 * @author b5wang
 */
@Singleton
@LocalBean
public class ServiceLocalSingletonSessionBean {
    
    private static final MyLogger LOG = new MyLogger(ServiceLocalSingletonSessionBean.class.getName());
    
    @Resource
    private TimerService timerService;
    
    public ServiceLocalSingletonSessionBean() {
    	LOG.info("ServiceLocalSingletonSessionBean constructed!");
    }
    
    /*
     *  The EJB Timer Service allows stateless session beans, singleton session beans, message-driven beans, and EJB 2.x entity beans 
     *  to be registered for timer callback events at a specified time, after a specified elapsed time, after a specified interval, 
     *  or according to a calendar-based schedule.
     *  
     * */
    @PostConstruct
    public void init() {
    	LOG.info("ServiceLocalSingletonSessionBean PostConstruct!");
    	
    	// Create a timer
    	// Start time is 5 seconds delay, timer is triggered every 1mins
    	timerService.createTimer (new Date (System.currentTimeMillis () + 5000), 60 * 1000, "Job_timer");
    	LOG.info("ServiceLocalSingletonSessionBean :: Job_timer is started.");
    }
    
    
    @Timeout
    public void onTimeout() {
    	LOG.info("ServiceLocalSingletonSessionBean :: Job_timer is triggered!");
    }
    
    public void process(){
        LOG.info("ServiceLocalSingletonSessionBean :: process() is called!");
    }
    
    
    @PreDestroy
    public void destroy() {
    	LOG.info("ServiceLocalSingletonSessionBean PreDestroy!");
    }
    
}
