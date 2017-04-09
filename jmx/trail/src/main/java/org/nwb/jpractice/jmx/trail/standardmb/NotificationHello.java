/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.standardmb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeChangeNotification;
import javax.management.MBeanNotificationInfo;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 *
 * @author wangbo
 */
public class NotificationHello extends NotificationBroadcasterSupport implements HelloMBean {

    private static final Logger LOGGER = Logger.getLogger(NotificationHello.class.getName());
    
    @Override
    public void sayHello() {
        LOGGER.info("[NotificationHello] Hello, world!");
    }

    @Override
    public int add(int x, int y) {
        return x + y;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getCacheSize() {
        return this.cacheSize;
    }
    
    @Override
    public void setCacheSize(int size) {
        int oldSize = this.cacheSize;
        this.cacheSize = size;

        LOGGER.log(Level.INFO, "Cache size now {0}", this.cacheSize);
        
        Notification n = new AttributeChangeNotification(this,
                                sequenceNumber++, System.currentTimeMillis(),
                                "CacheSize changed", "CacheSize", "int",
                                oldSize, this.cacheSize);

        sendNotification(n);
    }
    
    @Override
    public MBeanNotificationInfo[] getNotificationInfo() {
        String[] types = new String[]{
            AttributeChangeNotification.ATTRIBUTE_CHANGE
        };

        String name = AttributeChangeNotification.class.getName();
        String description = "An attribute of this MBean has changed";
        MBeanNotificationInfo info = 
                new MBeanNotificationInfo(types, name, description);
        return new MBeanNotificationInfo[]{info};
    }
    
    private final String name = "NotificationHello";
    
    private int cacheSize = DEFAULT_CACHE_SIZE;
    
    private static final int DEFAULT_CACHE_SIZE = 200;
    
    private long sequenceNumber = 1;
    
}
