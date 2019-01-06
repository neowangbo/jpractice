/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Create connection
 * 
 * @author wangbo
 */
public class DBConnection {
    
    private static final String CONNECTION_STRING = "jdbc:derby://localhost:1527/wbbankdb";
    
    private static final String USERNAME = "admin";

    private static final String PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException{
        Properties prop = new Properties();
        prop.put("user", USERNAME);
        prop.put("password", PASSWORD);
        
        return DriverManager.getConnection(CONNECTION_STRING, prop);
    }
    
}
