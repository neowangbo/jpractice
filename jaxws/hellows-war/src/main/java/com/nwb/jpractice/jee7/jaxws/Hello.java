/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.jaxws;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author wangbo
 */
@DeclareRoles({"AppUser","Admin"})
@WebService
public class Hello {

    private static final String message = "Hello, ";
    
    public Hello(){
    }
    
    @RolesAllowed({"AppUser","Admin"})
    @WebMethod
    public String sayHello(String name){
        return message + name + ".";
    }
}
