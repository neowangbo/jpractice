/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.local;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Init;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateless;

/**
 *
 * @author b5wang
 */
@Stateless
public class HelloWorldSessionBean implements HelloWorldSessionBeanLocal {

    private final static Logger LOGGER = Logger.getLogger(HelloWorldSessionBean.class.getName());
    
    public HelloWorldSessionBean(){
        LOGGER.info("......HelloWorldSessionBean constructor");
    }
    
    /**
     * Immediately called after this bean is initialized by container.
     */
    @PostConstruct
    public void afterInit(){
        LOGGER.info("......HelloWorldSessionBean@PostConstruct");
    }
    
    /**
     * Just called before this bean is destroyed by container.
     */
    @PreDestroy
    public void beforeDestroy(){
        LOGGER.info("......HelloWorldSessionBean@PreDestroy");
    }
    
    /**
     * Just called before the container passivates the bean instance. 
     * This annotation applies to stateful session beans.
     */
    @PrePassivate
    public void passivate(){
        LOGGER.info("......HelloWorldSessionBean@PrePassivate");
    }
    
    /**
     * Immediately called when the activated bean instance is ready.
     * This annotation is only applicable to stateful session beans.
     */
    @PostActivate
    public void activate(){
        LOGGER.info("......HelloWorldSessionBean@PostActivate");
    }
    
    /**
     * 
     */
    @Init
    public void init(){
        LOGGER.info("......HelloWorldSessionBean@Init");
    }
    
    /**
     * 
     */
    @Remove
    public void remove(){
        LOGGER.info("......HelloWorldSessionBean@Remove");
    }
    
    
    @Override
    public void sayHello() {
        LOGGER.log(Level.INFO, "!!! Hello World!!!");
    }

}
