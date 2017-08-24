/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.local;

import com.nwb.jpractice.jee7.helloworld.ejb.api.Hello;
import javax.ejb.Stateless;

/**
 * No view annotation but implement a no view interface
 * @author wangbo
 */
@Stateless(name="ejb/NoLocalAnnotatedHelloBean")
public class NoLocalAnnotatedHelloBean implements Hello{

    @Override
    public void say(String msg) {
        System.out.println("@NoLocalAnnotatedHelloBean :: msg = " + msg);
    }
    
}
