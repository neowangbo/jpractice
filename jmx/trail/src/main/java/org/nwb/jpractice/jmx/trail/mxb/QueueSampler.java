/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.mxb;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class QueueSampler implements QueueSamplerMXBean {

    private static final Logger LOGGER = Logger.getLogger(QueueSampler.class.getName());
    
    private final Queue<String> queue = new ArrayBlockingQueue<>(5);

    @Override
    public QueueSample getQueueSample() {
        synchronized (queue) {
            final int size = queue.size();
            final String head = queue.poll();
            LOGGER.log(Level.INFO, "Remove[{0}] from Queue[size={1}]", new Object[]{head, size});
            return new QueueSample(new Date(), size, head);
        }
    }
    
    @Override
    public void addValue(String str){
        synchronized (queue){
            LOGGER.log(Level.INFO, "Add[{0}] into Queue", str);
            queue.add(str);
        }
    }

    @Override
    public void clearQueue() {
        synchronized (queue) {
            LOGGER.log(Level.INFO, "Clear queue");
            queue.clear();
        }
    }
}
