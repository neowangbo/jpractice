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
        
        SingleLinkedStrListNode pointer = head;
        while(pointer != null){
            sb.append(pointer.value);
            if(pointer.next != null){
                // this is not last node
                sb.append(",");
            }
            pointer = pointer.next;
        }
        
        return sb.append("]").toString();
    }
    

    public int size(){
        int size = 0;
        SingleLinkedStrListNode pointer = head;
        while(pointer != null){
            size ++;
            pointer = pointer.next;
        }
        return size;
    }

    
    public void addToHead(String value){
        SingleLinkedStrListNode node = new SingleLinkedStrListNode(value);
        node.next = head;
        head = node;
    }
    
    
    
}
