/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail.standardmb;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeChangeNotification;
import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

/**
 *
 * @author wangbo
 */
public class HelloNotification extends NotificationBroadcasterSupport implements HelloNotificationMBean {

    private static final Logger LOGGER = Logger.getLogger(HelloNotification.class.getName());
    
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
    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public boolean isActive() {
        return this.active;
    }
    
    private final String name = "NotificationHello";
    
    private int cacheSize = DEFAULT_CACHE_SIZE;
    
    private static final int DEFAULT_CACHE_SIZE = 200;
    
    private long sequenceNumber = 1;
    
    private boolean active = false;
    
}
