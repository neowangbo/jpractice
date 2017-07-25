/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import org.nwb.jpractice.ejb3.helloworld.jar.Util;

/**
 *
 * @author b5wang
 */
@Stateless
public class HelloWorldBean implements HelloWorldBeanLocal {

    private final static Logger LOGGER = Logger.getLogger(HelloWorldBean.class.getName());
    
    @Override
    public void sayHello() {
        LOGGER.info("Call local ejb HelloWorldBean!");
        Util.sayHello();
    }

}
