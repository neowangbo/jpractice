/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;


import org.nwb.jpractice.j2eewls.util.MyLogger;
import weblogic.cluster.singleton.SingletonService;

/**
 *
 * @author b5wang
 */
public class ServiceClusterSingleton implements SingletonService{
    
    private static final MyLogger LOG = new MyLogger(ServiceClusterSingleton.class.getName());

    public ServiceClusterSingleton(){
        LOG.info("ServiceClusterSingleton constructor");
    }
    
    @Override
    public void activate() {
        LOG.info("ServiceClusterSingleton activate");
    }

    @Override
    public void deactivate() {
        LOG.info("ServiceClusterSingleton deactivate");
    }
    
}
