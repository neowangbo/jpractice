/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;

import javax.annotation.PostConstruct;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import org.nwb.jpractice.j2eewls.dto.AsynJobMsg;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 *
 * @author wangbo
 */
@MessageDriven(
        name = "AsynJobMsgTopicSubscriberMDB",
        activationConfig = {
            @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic"),
            @ActivationConfigProperty(propertyName = "connectionFactoryJndiName", propertyValue = "AsynJob.TopicConnectionFactory"),
            @ActivationConfigProperty(propertyName = "destinationJndiName", propertyValue = "AsynJob.Topic")
        }
)
public class AsynJobMsgTopicSubscriberMDB implements MessageListener {

    private final static MyLogger LOG = new MyLogger(AsynJobMsgTopicSubscriberMDB.class.getName());

    private final String id;

    private static int count;

    public AsynJobMsgTopicSubscriberMDB() {
        synchronized(this){
            id = "AsynJobMsgTopicSubscriberMDB[" + count + "]";
            count++;
        }
    }
    
    @PostConstruct
    public void init() {
        LOG.info("PostConstruct... id=" + id);
    }
    
    @Override
    public void onMessage(Message message) {
        try {
            ObjectMessage oMsg = (ObjectMessage) message;
            AsynJobMsg job = (AsynJobMsg) oMsg.getObject();

            Thread.sleep(1000 * job.getDuration());
            LOG.info("[%s] --- Succeeded to handle: %s", id, job.toString());

        } catch (JMSException | InterruptedException ex) {
            LOG.error("Error occurs  when handling message", ex);
        }
    }

}
