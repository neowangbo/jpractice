/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import org.nwb.jpractice.ejb3.helloworld.jar.Util;

/**
 * It's not eager initialization.
 * @author b5wang
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanLocal {

    private final static Logger LOGGER = Logger.getLogger(HelloWorldBean.class.getName());

    private final static int WAITING_15_SECONDS = 1000*15;
    
    private static int counter = 0;
    
    private int beanId = 0;
    
    public HelloWorldBean(){
        LOGGER.info("HelloWorldBean Constructor ...");
        counter++;
        beanId = counter;
        LOGGER.log(Level.INFO, "HelloWorldBean Constructor ... Counter={0}, BeanId={1}", new Object[]{counter,beanId});
    }
    
    @PostConstruct
    public void postConstruct(){
        LOGGER.log(Level.INFO, "HelloWorldBean[{0}] @PostConstruct ...", beanId);
    }
    
    @PreDestroy
    public void preDestroy(){
        LOGGER.log(Level.INFO, "HelloWorldBean[{0}] @PreDestroy ...", beanId);
    }
    
    @Override
    public void sayHello() {
        LOGGER.log(Level.INFO, "HelloWorldBean[{0}] Call local ejb HelloWorldBean! Start processing ...", beanId);
        
        try {
            Thread.sleep(WAITING_15_SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(HelloWorldBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Util.sayHello();
        LOGGER.log(Level.INFO, "HelloWorldBean[{0}] Call local ejb HelloWorldBean! End processing ...", beanId);
    }

}
