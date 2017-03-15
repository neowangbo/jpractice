/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.designpattern.interfacepattern.adapter;

/**
 *
 * @author wangbo
 */
public interface RocketSim {
    
    double getMass();
    double getThrust();
    void setSimTime(double t);
    
}
