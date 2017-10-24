/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.security.signing;

import java.security.Provider;
import java.security.Security;

/**
 *
 * @author wangbo
 */
public class JDKSecurityPrividers {
    
    public static void main(String[] args){
        Provider[] ps = Security.getProviders();
        for(Provider p : ps){
            System.out.println("" + p.getName() + " : " + p.getInfo());
        }
    }
    
}
