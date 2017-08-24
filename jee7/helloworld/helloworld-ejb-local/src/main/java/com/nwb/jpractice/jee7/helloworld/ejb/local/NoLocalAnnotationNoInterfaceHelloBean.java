/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.helloworld.ejb.local;

import javax.ejb.Stateless;

/**
 *
 * @author wangbo
 */
@Stateless(name="ejb/NoLocalAnnotationNoInterfaceHelloBean")
public class NoLocalAnnotationNoInterfaceHelloBean {
    
    public void say(String msg) {
        System.out.println("@NoLocalAnnotationNoInterfaceHelloBean :: msg = " + msg);
    }
    
}
