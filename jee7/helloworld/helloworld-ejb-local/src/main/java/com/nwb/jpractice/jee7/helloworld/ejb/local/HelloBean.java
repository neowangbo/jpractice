/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.local;

import com.nwb.jpractice.jee7.helloworld.ejb.api.Hello;
import javax.ejb.Local;
import javax.ejb.Stateless;

/**
 * (2) Using Local annotation directly on EJB
 * @author wangbo
 */
@Local(com.nwb.jpractice.jee7.helloworld.ejb.api.Hello.class)
@Stateless(name="ejb/HelloBean")
public class HelloBean implements Hello{

    @Override
    public void say(String msg) {
        System.out.println("@HelloBean :: msg = " + msg);
    }
    
}
