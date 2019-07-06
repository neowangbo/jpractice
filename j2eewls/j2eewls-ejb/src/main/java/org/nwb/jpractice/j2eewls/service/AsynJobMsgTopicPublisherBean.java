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
import javax.jms.Session;
import javax.jms.Topic;
import javax.jms.TopicConnection;
import javax.jms.TopicConnectionFactory;
import javax.jms.TopicPublisher;
import javax.jms.TopicSession;
import org.nwb.jpractice.j2eewls.dto.AsynJobMsg;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 *
 * @author wangbo
 */
@Stateless
public class AsynJobMsgTopicPublisherBean implements AsynJobMsgTopicPublisherLocal {

    private final static MyLogger LOG = new MyLogger(AsynJobMsgTopicPublisherBean.class.getName());

    @Resource(mappedName = "AsynJob.TopicConnectionFactory")
    private TopicConnectionFactory connectionFactory;

    @Resource(mappedName = "AsynJob.Topic")
    private Topic topic;

    private TopicConnection connection;

    private TopicSession session;

    private TopicPublisher publisher;

    public AsynJobMsgTopicPublisherBean() {

    }

    @PostConstruct
    public void init() {
        try {
            connection = connectionFactory.createTopicConnection();
            session = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);
            publisher = session.createPublisher(topic);
        } catch (JMSException ex) {
            LOG.error("Error occurs when init instance", ex);
        }
    }

    @PreDestroy
    public void close() {
        try {
            publisher.close();
            session.close();
            connection.close();
        } catch (JMSException ex) {
            LOG.error("Error occurs when close instance", ex);
        }
    }

    @Override
    public void publish(AsynJobMsg msg) {
        LOG.info("Publishing the message: " + msg);
        try {
            ObjectMessage objMsg = session.createObjectMessage(msg);
            publisher.send(objMsg);
        } catch (JMSException ex) {
            LOG.error("Error occurs when publishing: " + msg, ex);
        }

    }

}
