/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.algorithms.list;

/**
 *
 * @author wangbo
 */
public class SingleLinkedStrList {
    
    private SingleLinkedStrListNode head;
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        
        SingleLinkedStrListNode index = head;
        while(index != null){
            sb.append(index.getValue());
            if(index.getNext() != null){
                sb.append(",");
            }
            index = index.getNext();
        }
        
        return sb.append("]").toString();
    }
    
    
    public void addToHead(String value){
        SingleLinkedStrListNode node = new SingleLinkedStrListNode(value, head);
        head = node;
    }
    
    
    
}
