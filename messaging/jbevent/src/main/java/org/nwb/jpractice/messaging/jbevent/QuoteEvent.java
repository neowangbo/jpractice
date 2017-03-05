/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.messaging.jbevent;

import java.util.EventObject;

/**
 *
 * @author wangbo
 */
public class QuoteEvent extends EventObject{

    private String quote;
    
    public QuoteEvent(Object source, String quote){
        super(source);
        this.quote = quote;
    }
    
    public String getQuote(){
        return quote;
    }
    
}
