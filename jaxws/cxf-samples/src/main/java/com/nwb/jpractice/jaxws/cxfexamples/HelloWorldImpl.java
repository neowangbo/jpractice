/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jaxws.cxfexamples;

import javax.jws.WebService;

/**
 *
 * @author b5wang
 */
@WebService(endpointInterface = "com.nwb.jpractice.jaxws.cxfexamples.HelloWorld")
public class HelloWorldImpl implements HelloWorld{
    
    public HelloWorldImpl(){
        System.out.println("HelloWorldImpl is initializing ......");
    }
    
    @Override
    public String sayHi(String text) {
        System.out.println("sayHi is called ......");
        return "Hello " + text + "!";
    }
    
}
