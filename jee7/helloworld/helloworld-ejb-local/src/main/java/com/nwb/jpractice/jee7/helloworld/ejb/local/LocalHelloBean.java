/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.local;

import com.nwb.jpractice.jee7.helloworld.ejb.api.LocalHello;
import javax.ejb.Stateless;

/**
 * (1) implements a interface with Local annotation
 * @author wangbo
 */
@Stateless(name="ejb/LocalHelloBean")
public class LocalHelloBean implements LocalHello{

    @Override
    public void say(String msg) {
        System.out.println("@LocalHelloBean :: msg = " + msg);
    }
    
}
