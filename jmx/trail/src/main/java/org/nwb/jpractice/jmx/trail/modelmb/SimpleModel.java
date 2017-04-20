/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.modelmb;

import javax.management.MBeanException;
import javax.management.RuntimeOperationsException;
import javax.management.modelmbean.RequiredModelMBean;

/**
 *
 * @author wangbo
 */
public class SimpleModel extends RequiredModelMBean{
    
    public SimpleModel() throws RuntimeOperationsException, MBeanException{
        super();
    }
    
}
