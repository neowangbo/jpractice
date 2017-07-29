/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.DependsOn;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * Startup annotation for eager initialization.
 * DependsOn to specify the initial orders.
 * @author wangbo
 */
@Singleton
@Startup
@DependsOn("PrimarySingletonBean")
public class SecondarySingletonBean {
    
    private final static Logger LOGGER = Logger.getLogger(SecondarySingletonBean.class.getName());
    
    @EJB
    private PrimarySingletonBean primarySingletonBean;
    
    /**
     *
     */
    @PostConstruct
    public void postConstruct(){
        LOGGER.info("SecondarySingletonBean @PostConstruct");
    }
    
    /**
     *
     */
    @PreDestroy
    public void preDestroy(){
        LOGGER.info("SecondarySingletonBean @PreDestroy");
    }
    
    /**
     * 
     */
    public void configApp(){
        LOGGER.info("SecondarySingletonBean configApp() is called!!!");
        primarySingletonBean.configApp();
    }
}
