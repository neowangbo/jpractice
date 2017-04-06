/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jmx.trail;

import java.lang.management.ManagementFactory;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
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

/**
 *
 * Run: java -cp trail.jar org.nwb.jpractice.jmx.trail.Main
 *
 * @author wangbo
 */
public class Main {

    public static void main(String[] args) {

        try {

            MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();

            Hello mbean = new Hello();
            ObjectName name = new ObjectName("org.nwb.jpractice.jmx.trail.standardmb:type=Hello");
            mbs.registerMBean(mbean, name);

            ObjectName mxbName = new ObjectName("org.nwb.jpractice.jmx.trail.mxb:type=QueueSampler");
            QueueSampler mxbean = new QueueSampler();
            mbs.registerMBean(mxbean, mxbName);

            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Waiting forever ...");

            Thread.sleep(Long.MAX_VALUE);

        } catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
