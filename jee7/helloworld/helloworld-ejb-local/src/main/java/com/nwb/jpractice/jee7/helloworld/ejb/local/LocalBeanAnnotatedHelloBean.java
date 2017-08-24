/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.local;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * (3) No interface view EJB
 * @author wangbo
 */
@LocalBean
@Stateless(name="ejb/LocalBeanAnnotatedHelloBean")
public class LocalBeanAnnotatedHelloBean {
    
    public void say(String msg) {
        System.out.println("@LocalBeanAnnotatedHelloBean :: msg = " + msg);
    }
    
}
