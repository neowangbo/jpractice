/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.service;

import org.nwb.jpractice.j2eewls.dto.AsynJobMsg;

/**
 *
 * @author wangbo
 */
public interface AsynJobMsgTopicPublisher {
    void publish(AsynJobMsg msg);
}
