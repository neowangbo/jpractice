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
        
        SingleLinkedStrListNode node = head;
        while(node != null){
            sb.append(node.toString());
            if(node.next != null){
                // this is not last node
                sb.append(", ");
            }
            node = node.next;
        }
        
        return sb.append("]").toString();
    }
    
    
    public int size(){
        int size = 0;
        
        SingleLinkedStrListNode node = head;
        while(node != null){
            size ++;
            node = node.next;
        }
        
        return size;
    }
    

    public void addToHead(String value){
        SingleLinkedStrListNode node = new SingleLinkedStrListNode();
        node.value = value;
        node.next = head;
        head = node;
    }
    
    
    public void addToTail(String value){
        
        SingleLinkedStrListNode node = new SingleLinkedStrListNode();
        node.value = value;
        
        if(head == null){
            head = node;
        }else{
            SingleLinkedStrListNode pre = head;
            SingleLinkedStrListNode pointer = head;
            
            while(pointer != null){
                pre = pointer;
                pointer = pointer.next;
            }
            pre.next = node;
        }
    }
    
    
}
