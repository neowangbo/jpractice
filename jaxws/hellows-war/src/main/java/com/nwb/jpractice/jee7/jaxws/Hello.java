/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.jaxws;

import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebService;
import weblogic.jws.Policy;

/**
 *
 * @author wangbo
 */
@WebService(name="HelloWorldPortType", serviceName="HelloWorldService")
@Policy(uri="policy:Wssp1.2-2007-Wss1.0-UsernameToken-Plain-X509-Basic256.xml")
@RolesAllowed({"Admin","AppUser"})
public class Hello {

    private static final String MSG_HELLO = "Hello, ";
    
    public Hello(){
    }
    
    @WebMethod
    public String sayHello(String name){
        return MSG_HELLO + name + "!";
    }
}
