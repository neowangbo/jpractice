/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.messaging.jbevent;

/**
 *
 * @author wangbo
 */
public class QuoteListener implements QuoteChangedListener{
    
    private static int counter = 1;
    
    private String id;
    
    public QuoteListener(){
        id = "QuoteListener-" + counter;
        counter++;
    }
    
    public void quoteChanged(QuoteEvent event){
        System.out.printf("[INFO] %s :: New quote===%s \n", id, event.getQuote());
    }
    
}
