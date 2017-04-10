/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail;

import java.lang.management.ManagementFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import org.nwb.jpractice.jmx.trail.mxb.QueueSampler;
import org.nwb.jpractice.jmx.trail.standardmb.Hello;
import org.nwb.jpractice.jmx.trail.standardmb.HelloNotification;
import org.nwb.jpractice.jmx.trail.standardmb.HelloNotificationListener;

/**
 *
 * Run: 
 * java -cp trail.jar org.nwb.jpractice.jmx.trail.Main
 *
 * @author wangbo
 */
public class Main {

    public static void main(String[] args) {

        try {
            
            // Get JVM MBeanServer
            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
            
            
            // Standard MBean
            Hello mbean = new Hello();
            ObjectName name = new ObjectName("org.nwb.jpractice.jmx.trail.standardmb:type=Hello");
            mbs.registerMBean(mbean, name);

            
            // MXBean
            QueueSampler mxbean = new QueueSampler();
            ObjectName mxbName = new ObjectName("org.nwb.jpractice.jmx.trail.mxb:type=QueueSampler");
            mbs.registerMBean(mxbean, mxbName);

            
            // MBean with notification
            HelloNotification nmbean = new HelloNotification();
            ObjectName nmbName = new ObjectName("org.nwb.jpractice.jmx.trail.standardmb:type=HelloNotification");
            mbs.registerMBean(nmbean, nmbName);
            
            // Add notification listeners
            nmbean.addNotificationListener(new HelloNotificationListener(), null, null);
            nmbean.addNotificationListener(new HelloNotificationListener(), null, null);
            nmbean.addNotificationListener(new HelloNotificationListener(), null, null);
            
            
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Waiting forever ...");
            Thread.sleep(Long.MAX_VALUE);

        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
