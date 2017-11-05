/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author wangbo
 */
@WebService
public class Hello {

    private static final String message = "Hello, ";
    
    public Hello(){
    }
    
    @WebMethod
    public String sayHello(String name){
        return message + name + ".";
    }
}
