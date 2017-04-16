/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.standardmb;

import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class Hello implements HelloMBean{
    
    private static final Logger LOGGER = Logger.getLogger(Hello.class.getName());

    @Override
    public void sayHello() {
        LOGGER.info("[Hello] Hello, world!");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCacheSize() {
        return this.cacheSize;
    }

    @Override
    public void setCacheSize(int size) {
        this.cacheSize = size;
    }

    @Override
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }
    
    private String name = "Hello";
    
    private int cacheSize = 1024;
    
    private boolean active = false;

}
