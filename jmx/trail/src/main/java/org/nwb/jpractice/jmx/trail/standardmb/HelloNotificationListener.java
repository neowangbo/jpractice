/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.standardmb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.Notification;
import javax.management.NotificationListener;

/**
 *
 * @author wangbo
 */
public class HelloNotificationListener implements NotificationListener{

    private static final Logger LOGGER = Logger.getLogger(HelloNotificationListener.class.getName());
    
    private static int sequenceNo = 1;
    
    private String listenerId;
    
    public HelloNotificationListener(){
        listenerId = this.getClass().getName() + "-" + sequenceNo;
        sequenceNo ++;
    }
    
    @Override
    public void handleNotification(Notification notification, Object handback) {
        LOGGER.log(Level.INFO, "{0} :: {1}", new Object[]{listenerId, notification.toString()});
    }
    
}
