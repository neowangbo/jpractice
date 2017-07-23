/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.ejb;

import java.util.logging.Logger;
import javax.ejb.Stateless;

/**
 *
 * @author wangbo
 */
@Stateless
public class InternalHelloWorldSessionBeanImpl implements InternalHelloWorldSessionBean{

    private final static Logger LOGGER = Logger.getLogger(InternalHelloWorldSessionBeanImpl.class.getName());
    
    @Override
    public void sayHello() {
        LOGGER.info("Hello, World!!!");
    }

}
