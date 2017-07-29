/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

/**
 *
 * @author wangbo
 */
@Singleton
public class PrimarySingletonBean {
    
    private final static Logger LOGGER = Logger.getLogger(PrimarySingletonBean.class.getName());
    
    /**
     *
     */
    @PostConstruct
    public void postConstruct(){
        LOGGER.info("PrimarySingletonBean @PostConstruct");
    }
    
    /**
     *
     */
    @PreDestroy
    public void preDestroy(){
        LOGGER.info("PrimarySingletonBean @PreDestroy");
    }
    
    /**
     * 
     */
    public void configApp(){
        LOGGER.info("PrimarySingletonBean configApp() is called!!!");
    }
    
    
}
