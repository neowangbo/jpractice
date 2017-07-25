/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.jar;

import java.util.logging.Logger;

/**
 *
 * @author b5wang
 */
public class Util {
    
    private final static Logger LOGGER = Logger.getLogger(Util.class.getName());
    
    public static void sayHello(){
        LOGGER.info("Hello, World!!!");
    }
    
}
