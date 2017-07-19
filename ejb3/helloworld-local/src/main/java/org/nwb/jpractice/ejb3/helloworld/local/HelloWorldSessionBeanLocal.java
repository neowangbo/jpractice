/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.ejb3.helloworld.local;

import javax.ejb.Local;

/**
 *
 * @author b5wang
 */
@Local
public interface HelloWorldSessionBeanLocal {
    void sayHello();
}
