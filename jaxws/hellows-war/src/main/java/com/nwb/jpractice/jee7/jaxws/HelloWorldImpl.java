/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.jaxws;

import javax.jws.WebService;

/**
 *
 * @author wangbo
 */
@WebService(name="HelloWorldPortType", serviceName="HelloWorldService")
//@Policy(uri="policy:Wssp1.2-2007-Wss1.0-UsernameToken-Plain-X509-Basic256.xml")
public class HelloWorldImpl {
    
    public String sayHelloTo(String name){
        return "Hello, " + name + "!";
    }
    
}
