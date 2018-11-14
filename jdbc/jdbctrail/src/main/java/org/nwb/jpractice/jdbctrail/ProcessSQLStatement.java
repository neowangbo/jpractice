/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author wangbo
 */
public class ProcessSQLStatement {
 
    public static void main(String[] args) {
        try {
            Connection conn1 = DBConnection.getConnection();
            Connection conn2 = DBConnection.getConnection();
            
            if(conn1 == conn2){
                System.out.println("Same connection");
            }else{
                System.out.println("Different connection");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ProcessSQLStatement.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
