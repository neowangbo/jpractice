/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Process to execute update
 * 1. get connection
 * 2. close auto commit
 * 3. 
 * 
 * @author b5wang
 */
public class UpdateSQLStatement {
    
    private final static Logger LOG = Logger.getLogger(UpdateSQLStatement.class.getName());
    
    public static void main(String[] args) {
        
    }
    
    /**
     * 
     */
    public static void createAccount(String owner, BigDecimal balence){
        Connection conn = null;
        PreparedStatement stmt = null;
        String createAccountSQL = "insert into ACCOUNTS values (NEXT VALUE FOR SEQ_ACCOUNTS_ID,?,?,?)";
        
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);// close auto commit for rollback
            
            Date nowDate = new Date();
            Timestamp updated = new Timestamp(nowDate.getTime());
            
            stmt = conn.prepareStatement(createAccountSQL);
            stmt.setString(1, owner);
            stmt.setBigDecimal(2, balence);
            stmt.setTimestamp(3, updated);
            stmt.executeUpdate();
            
            conn.commit();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Create account error", ex);
            
            // When error occurs it need rollback the SQL just execute
            if(conn != null){
                
            }
        }
        
        
        
        
    }
    
    public static void updateAccount(int id, BigDecimal update){
        
    }
    
}
