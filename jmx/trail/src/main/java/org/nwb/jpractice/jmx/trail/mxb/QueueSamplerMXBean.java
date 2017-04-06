/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.mxb;

/**
 *
 * @author wangbo
 */
public interface QueueSamplerMXBean {
    
    public QueueSample getQueueSample();
    
    public void addValue(String str);
    
    public void clearQueue();
    
}
