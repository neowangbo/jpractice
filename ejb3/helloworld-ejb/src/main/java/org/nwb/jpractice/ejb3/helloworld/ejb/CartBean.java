/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

/**
 *
 * @author wangbo
 */
@Stateful
public class CartBean implements Cart{

    private final static Logger LOGGER = Logger.getLogger(CartBean.class.getName());
    
    private static int counter = 0;
    
    private int beanId;
    
    public CartBean(){
        counter ++;
        beanId = counter;
        LOGGER.log(Level.INFO, "CartBean[{0}] is initialized ...", beanId);
    }
    
    @PostConstruct
    public void postConstruct(){
        LOGGER.log(Level.INFO, "CartBean[{0}] @PostConstruct ...", beanId);
    }
    
    @PreDestroy
    public void preDestroy(){
        LOGGER.log(Level.INFO, "CartBean[{0}] @PreDestroy ...", beanId);
    }
    
    @PostActivate
    public void postActivate(){
        LOGGER.log(Level.INFO, "CartBean[{0}] @PostActivate ...", beanId);
    }
    
    @PrePassivate
    public void prePassivate(){
        LOGGER.log(Level.INFO, "CartBean[{0}] @PrePassivate ...", beanId);
    }
    
    
    @Override
    public void selectBook() {
        Random random = new Random();
        final int num = random.nextInt(100);
        LOGGER.log(Level.INFO, "CartBean[{0}]  select book number {1}...", new Object[]{beanId, num});
    }

    
    /**
     * Remove the bean instance
     */
    @Remove
    @Override
    public void remove() {
        LOGGER.log(Level.INFO, "CartBean[{0}] @Remove ...", beanId);
    }
    
}
