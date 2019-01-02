/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.algorithms.list;

import java.util.Arrays;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author wangbo
 */
public class TestSingleLinkedStrList {
    
    private static final Logger LOG = Logger.getLogger(TestSingleLinkedStrList.class.getName());
    
    private static final String[] STRING_ARRAY = {"ONE","TWO","THREE","FOUR","FIVE","SIX","SEVEN","EIGHT","NINE"};
    
    private static final String[] EMPTY_STRING_ARRAY = {};
    
    private SingleLinkedStrList list = null;
    
    public TestSingleLinkedStrList(){
        LOG.info("constructor() ...");
    }
    
    
    @BeforeClass
    public static void beforeClass(){
        LOG.info("@BeforeClass method ...");
    }
    
    @AfterClass
    public static void afterClass(){
        LOG.info("@AfterClass method ...");
    }
    
    @Before
    public void before(){
        LOG.info("@Before method ...");
        
        list = new SingleLinkedStrList();
        for(String str:STRING_ARRAY){
            list.addToTail(str);
        }
    }
    
    @After
    public void after(){
        LOG.info("@Before method ...");
    }
    
    @Test
    public void testToString(){
        LOG.info("Expected: " + Arrays.toString(STRING_ARRAY));
        LOG.info("Actual  : " + list.toString());
        
        Assert.assertEquals(Arrays.toString(STRING_ARRAY), list.toString());
    }
    
    @Test
    public void testToStringByEmptyList(){
        list = new SingleLinkedStrList();
        
        LOG.info("Expected: " + Arrays.toString(EMPTY_STRING_ARRAY));
        LOG.info("Actual  : " + list.toString());
        
        Assert.assertEquals(Arrays.toString(EMPTY_STRING_ARRAY), list.toString());
    }
    
    @Test
    public void testSize(){
        LOG.info("Expected: " + STRING_ARRAY.length);
        LOG.info("Actual  : " + list.size());
        
        Assert.assertEquals(STRING_ARRAY.length, list.size());
    }
    
    @Test
    public void testSizeByEmptyList(){
        list = new SingleLinkedStrList();
        
        LOG.info("Expected: " + EMPTY_STRING_ARRAY.length);
        LOG.info("Actual  : " + list.size());
        
        Assert.assertEquals(EMPTY_STRING_ARRAY.length, list.size());
    }
    
    @Test
    public void testAddToHead(){
        String firstVal = "FIRST";
        String secVal = "SECOND";
        
        list.addToHead(firstVal);     
        Assert.assertEquals(firstVal, list.get(0));
        
        list.addToHead(secVal);     
        Assert.assertEquals(secVal, list.get(0));
    }
    
    @Test
    public void testAddToTail(){
        String firstVal = "FIRST";
        String secVal = "SECOND";
        
        list.addToTail(firstVal);
        int listIndex = list.size() - 1;
        
        LOG.info("listIndex = " + listIndex + ", lastVal = " + list.get(listIndex));
        
        Assert.assertEquals(firstVal, list.get(listIndex));
        
        list.addToTail(secVal);
        listIndex = list.size() - 1;
        
        LOG.info("listIndex = " + listIndex + ", lastVal = " + list.get(listIndex));
        
        Assert.assertEquals(secVal, list.get(listIndex));
    }
}
