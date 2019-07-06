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
import org.nwb.jpractice.j2eewls.util.MyLogger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author b5wang
 */
@Stateless
public class AsynJobMsgQueueSenderEJB2 {

    private final static MyLogger LOG = new MyLogger(AsynJobMsgQueueSenderEJB2.class.getName());

    @Resource(mappedName = "AsynJob.Queue.ConnectionFactory")
    private QueueConnectionFactory queueConnectionFactory;

    @Resource(mappedName = "AsynJob.Queue")
    private Queue queue;

    private QueueConnection queueConnection;

    private QueueSession queueSession;

    private QueueSender queueSender;

    @PostConstruct
    public void init() {
        try {
            queueConnection = queueConnectionFactory.createQueueConnection();
            queueSession = queueConnection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
            queueSender = queueSession.createSender(queue);
        } catch (JMSException ex) {
            LOG.error("Error occurs when init instance", ex);
        }
    }

    @PreDestroy
    public void close() {
        try {
            queueSender.close();
            queueSession.close();
            queueConnection.close();
        } catch (JMSException ex) {
            LOG.error("Error occurs when close instance", ex);
        }
    }

    public void sendMsg(String msg) {
        LOG.info("Prepare to send the message: " + msg);
        try {
            ObjectMessage objMsg = queueSession.createObjectMessage(msg);
            queueSender.send(objMsg);
            LOG.info("Have sent the message: " + msg);
        } catch (JMSException ex) {
            LOG.error("Error occurs when sending: " + msg, ex);
        }
    }

}
