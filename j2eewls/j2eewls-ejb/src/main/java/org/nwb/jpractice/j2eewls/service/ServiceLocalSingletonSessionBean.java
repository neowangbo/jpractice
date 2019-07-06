/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 *
 * @author b5wang
 */
@Singleton
@LocalBean
public class ServiceLocalSingletonSessionBean {
    
    private static final MyLogger LOG = new MyLogger(ServiceLocalSingletonSessionBean.class.getName());
    
    public void process(){
        LOG.info("ServiceLocalEJBSingleton is called!");
    }
    
}
