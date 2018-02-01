/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nwb.jpractice.jee7.jaxws;

import java.util.Arrays;

/**
 * Defines a simple JavaBean called BasicStruct that has integer, String, and String[] properties
 *
 * @author wangbo
 */
public class BasicStruct {

    // Properties
    private int intValue;
    private String stringValue;
    private String[] stringArray;
    // Getter and setter methods

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public String[] getStringArray() {
        return stringArray;
    }

    public void setStringArray(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public String toString() {
        
        return "IntValue=" + intValue + ", StringValue=" + stringValue + ", stringArray=" + Arrays.toString(stringArray);
    }
    
    /**
     * 
     */
    public static void main(String[] args){
        String[] stringArray = null;
        System.out.println(Arrays.toString(stringArray));
    }
}
