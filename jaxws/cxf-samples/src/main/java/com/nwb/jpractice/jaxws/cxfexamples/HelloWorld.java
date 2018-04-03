/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jaxws.cxfexamples;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author b5wang
 */
@WebService
public interface HelloWorld {
    @WebMethod
    String sayHi(String text);
}
