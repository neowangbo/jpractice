/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.remote;

import com.nwb.jpractice.jee7.helloworld.ejb.api.RemoteHello;
import javax.ejb.Stateless;

/**
 *
 * @author wangbo
 */
@Stateless(name="ejb/RemoteHelloBean")
public class RemoteHelloBean implements RemoteHello{

    @Override
    public void say(String msg) {
        System.out.println("@RemoteHelloBean :: msg = " + msg);
    }
    
}
