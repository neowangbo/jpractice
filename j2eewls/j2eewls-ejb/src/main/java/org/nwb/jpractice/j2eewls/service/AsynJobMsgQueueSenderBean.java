/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import org.nwb.jpractice.j2eewls.dto.AsynJobMsg;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 * This is another specific set of API for Queue, please see
 * AsynJobMsgQueueSenderEJB2.java
 *
 * @author b5wang
 */
@Stateless
public class AsynJobMsgQueueSenderBean implements AsynJobMsgQueueSenderLocal {

    private final static MyLogger LOG = new MyLogger(AsynJobMsgQueueSenderBean.class.getName());

    @Resource(mappedName = "AsynJob.QueueConnectionFactory")
    private QueueConnectionFactory connectionFactory;

    @Resource(mappedName = "AsynJob.Queue")
    private Queue queue;

    private QueueConnection connection;

    private QueueSession session;

    private QueueSender sender;

    public AsynJobMsgQueueSenderBean(){
        LOG.info("Constructor...");
    }
    
    @PostConstruct
    public void init() {
        LOG.info("PostConstruct...");
        try {
            connection = connectionFactory.createQueueConnection();
            session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
            sender = session.createSender(queue);
        } catch (JMSException ex) {
            LOG.error("Error occurs when init instance", ex);
        }
    }

    @PreDestroy
    public void close() {
        try {
            sender.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
            LOG.error("Error occurs when close instance", ex);
        }
    }

    @Override
    public void send(AsynJobMsg msg) {
        LOG.info("Sending the message: " + msg);
        try {
            ObjectMessage objMsg = session.createObjectMessage(msg);
            sender.send(objMsg);
        } catch (JMSException ex) {
            LOG.error("Error occurs when sending: " + msg, ex);
        }
    }
}
