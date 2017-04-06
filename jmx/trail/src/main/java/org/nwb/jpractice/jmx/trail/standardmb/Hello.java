/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.standardmb;

/**
 *
 * @author wangbo
 */
public class Hello implements HelloMBean{

    @Override
    public void sayHello() {
        System.out.println("Hello, world!");
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
    
    private String name = "HelloMBean";
    
    private int cacheSize = 1024;
    
}
