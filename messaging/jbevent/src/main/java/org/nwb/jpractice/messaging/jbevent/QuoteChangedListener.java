/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.messaging.jbevent;

import java.util.EventListener;

/**
 *
 * @author wangbo
 */
public interface QuoteChangedListener extends EventListener{
    
    void quoteChanged(QuoteEvent event);
    
}
