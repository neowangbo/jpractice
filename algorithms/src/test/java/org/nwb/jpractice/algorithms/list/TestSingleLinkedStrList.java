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
    }
    
    @After
    public void after(){
        LOG.info("@Before method ...");
    }
    
    @Test
    public void testToString(){
        SingleLinkedStrList list = new SingleLinkedStrList();
        for(String str:STRING_ARRAY){
            list.addToTail(str);
        }
        
        LOG.info("Expected: " + Arrays.toString(STRING_ARRAY));
        LOG.info("Actual  : " + list.toString());
        
        Assert.assertEquals(Arrays.toString(STRING_ARRAY), list.toString());
    }
    
}
