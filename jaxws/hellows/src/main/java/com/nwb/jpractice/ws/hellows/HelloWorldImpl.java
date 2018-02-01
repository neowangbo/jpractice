/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.ws.hellows;

import javax.jws.WebService;

/**
 *
 * @author b5wang
 */
@WebService(name = "HelloWorldPortType", serviceName = "HelloWorldService")
public class HelloWorldImpl {

    // By default, all public methods are exposed as Web Services operation
    public String sayHelloWorld(String message) {
        try {
            System.out.println("sayHelloWorld:" + message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return "Here is the message: '" + message + "'";
    }
}