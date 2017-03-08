/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.messaging.jms.queue;

import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 *
 * @author wangbo
 */
public class ProducerDemo {

    public static void main(String[] args) {

        try {
            ConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");

            Connection connection = factory.createConnection();
            connection.start();

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("queue.test.1");

            MessageProducer producer = session.createProducer(destination);

            TextMessage message = session.createTextMessage();
            message.setText("Hello@" + Calendar.getInstance().getTime());
            
            producer.send(message);

        } catch (JMSException ex) {
            Logger.getLogger(ProducerDemo.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
