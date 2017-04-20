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
public class Greeting extends Hello{
    
    private static final Logger LOGGER = Logger.getLogger(Greeting.class.getName());
    
    private String name = "Greeting";
    
    @Override
    public String getName() {
        return this.name;
    }
    
}
