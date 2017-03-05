/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.messaging.jbevent;

import java.util.ArrayList;

/**
 *
 * @author wangbo
 */
public class QuoteSource {

    private ArrayList<QuoteChangedListener> listeners;
    
    public QuoteSource(){
        listeners = new ArrayList();
    }
    
    public void addQuoteChangedListern(QuoteChangedListener listener){
        listeners.add(listener);
    }
    
    public void fireQuoteChange(String newQuote){
        QuoteEvent quote = new QuoteEvent(this,newQuote);
        
        ArrayList<QuoteChangedListener> listenersCopy;
        
        synchronized(this){
            listenersCopy = (ArrayList<QuoteChangedListener>)listeners.clone();
        }
        
        for(QuoteChangedListener listener : listenersCopy){
            listener.quoteChanged(quote);
        }
    }
    
}
