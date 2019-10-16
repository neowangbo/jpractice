/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.web;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.nwb.jpractice.j2eewls.dto.AsynJobMsg;
import org.nwb.jpractice.j2eewls.service.AsynJobMsgQueueSenderLocal;
import org.nwb.jpractice.j2eewls.service.AsynJobMsgTopicPublisherLocal;
import org.nwb.jpractice.j2eewls.util.MyLogger;

/**
 *
 * @author b5wang
 */
@WebServlet(name = "MessageServlet", urlPatterns = "/msg")
public class MessageServlet extends HttpServlet {

    private static final MyLogger LOG = new MyLogger(MessageServlet.class.getName());

    @EJB
    private AsynJobMsgQueueSenderLocal asynJobMsgQueueSenderLocal;
    
    @EJB
    private AsynJobMsgTopicPublisherLocal asynJobMsgTopicPublisherLocal;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msgType = request.getParameter("type");// Type of msg
        Integer msgNo = Integer.valueOf(request.getParameter("no"));// Number of msg

        LOG.info("Receive HTTP request /msg?type=%s&no=%d", msgType, msgNo);

        if ("PTP".equalsIgnoreCase(msgType)) {
            // Point-to-point message, to a queue
            for (int i = 0; i < msgNo; i++) {
                AsynJobMsg msg = new AsynJobMsg();
                msg.setId("AsynJobMsg[" + i + "]");
                msg.setDuration(15);// processing 15 seconds
                asynJobMsgQueueSenderLocal.send(msg);
            }
        } else if ("PS".equalsIgnoreCase(msgType)) {
            // Publish & subscribe
            for (int i = 0; i < msgNo; i++) {
                AsynJobMsg msg = new AsynJobMsg();
                msg.setId("AsynJobMsg[" + i + "]");
                msg.setDuration(15);// processing 15 seconds
                asynJobMsgTopicPublisherLocal.publish(msg);
            }
        } else {

        }

    }
}
