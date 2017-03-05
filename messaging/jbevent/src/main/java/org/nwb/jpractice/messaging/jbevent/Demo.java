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
public class Demo {
    
    public static void main(String[] args){
        
        QuoteSource quoteSource = new QuoteSource();
        
        QuoteListener qlistener1 = new QuoteListener();
        quoteSource.addQuoteChangedListern(qlistener1);
        
        quoteSource.fireQuoteChange("100");
        
        QuoteListener qlistener2 = new QuoteListener();
        quoteSource.addQuoteChangedListern(qlistener2);
        
        QuoteListener qlistener3 = new QuoteListener();
        quoteSource.addQuoteChangedListern(qlistener3);
        
        quoteSource.fireQuoteChange("99.99");
        
    }
    
}
