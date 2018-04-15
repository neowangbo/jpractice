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
public class SingleLinkedStrListNode {
    
    public String value;
    
    public SingleLinkedStrListNode next;
    
    public SingleLinkedStrListNode(){}
    
    public SingleLinkedStrListNode(String value){
        this(value, null);
    }
    
    public SingleLinkedStrListNode(String value, SingleLinkedStrListNode next){
        this.value = value;
        this.next = next;
    }
    
    @Override
    public String toString(){
        return value;
    }
    
}
