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
public class OozinozRocket extends PhysicalRocket implements RocketSim {
    
    private double time;
    
    public OozinozRocket(double burnArea, double burnRate, double fuelMass, double totalMass) {
        super(burnArea, burnRate, fuelMass, totalMass);
    }
    
    public double getMass(){
        return super.getMass(time);
    }

    public double getThrust() {
        return super.getThrust(time);
    }

    public void setSimTime(double t) {
        this.time = time;
    }
    
}
