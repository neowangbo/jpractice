/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nwb.jpractice.jdbctrail.exceptions.BusinessException;

/**
 * Process to execute update 1. get connection 2. close auto commit 3.
 *
 * @author b5wang
 */
public class UpdateSQLStatement {

    private final static Logger LOG = Logger.getLogger(UpdateSQLStatement.class.getName());

    public static void main(String[] args) {

//        BigDecimal balance = new BigDecimal(190000);
//        createAccount("Stephen King",balance);

//        BigDecimal newBalance = new BigDecimal(500);
//        updateAccount(101,newBalance);

//        BigDecimal amount = new BigDecimal(5000);
//        createTransaction(1, 3, amount, "transfer money");

        BigDecimal val1 = new BigDecimal(1000);
        BigDecimal val2 = new BigDecimal(2000);
        LOG.info("val1.campareTo(val2): " + val1.compareTo(val2));
    }

    /**
     * Create a new account
     */
    public static void createAccount(String owner, BigDecimal balence) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String createAccountSQL = "insert into accounts values (next value for seq_accounts_id,?,?,?)";

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
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    LOG.log(Level.SEVERE, "Error occur when close connection!", ex1);
                }
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null){
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error occur when close statement!", ex);
            }
        }
    }

    public static void updateAccount(int id, BigDecimal newBalance) {
        Connection conn = null;
        PreparedStatement stmt = null;
        String updateAccountSQL = "update accounts set balance=?,updated=? where id=?";

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);// close auto commit for rollback

            Date nowDate = new Date();
            Timestamp updated = new Timestamp(nowDate.getTime());

            stmt = conn.prepareStatement(updateAccountSQL);
            stmt.setBigDecimal(1, newBalance);
            stmt.setTimestamp(2, updated);
            stmt.setInt(3, id);
            stmt.executeUpdate();
            conn.commit();
        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, "Update account error", ex);

            // When error occurs it need rollback the SQL just execute
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    LOG.log(Level.SEVERE, "Error occur when close connection!", ex1);
                }
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if(conn != null){
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error occur when close statement!", ex);
            }
        }
    }

    /**
     * Flows of create a transaction
     * 1. Checking if the account has enough money
     * 2. Deduct the amount from source account
     * 3. Create a transaction.
     * 
     */
    public static void createTransaction(int source, int target, BigDecimal amount, String description) {
        Connection conn = null;
        PreparedStatement stmt = null;
        
        String sqlGetBalance = "select balance from accounts where id=?";
        
        String sqlUpdateAccount = "update accounts set balance=? where id=?";
        
        String sqlCreateTransaction = "insert into transactions(id,source_account_id,target_account_id,amount,description,created_time) "
                + "values (next value for seq_transactions_id,?,?,?,?,?)";

        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false);// close auto commit for rollback
            
            //1. checking enough balance
            PreparedStatement getBalanceStmt = conn.prepareStatement(sqlGetBalance);
            ResultSet rs = getBalanceStmt.executeQuery();
            BigDecimal balance = null;
            while(rs.next()){
                balance = rs.getBigDecimal(1);
                break;
            }
            
            if(balance == null){
                throw new BusinessException("Account[" + source + "] is not existing!");
            }
            
            LOG.info("Balance in account[" + source + "]: " + balance);
            
            if(balance.compareTo(amount) < 0){
                // There is no enough money in account
                throw new BusinessException("Account[" + source + "] does not have enough money, current balance: " + balance + ".");
            }
            
            
            
            
            
            
            
            
            
            Date nowDate = new Date();
            Timestamp created = new Timestamp(nowDate.getTime());

            stmt = conn.prepareStatement(sqlCreateTransaction);
            stmt.setInt(1, source);
            stmt.setInt(2, target);
            stmt.setBigDecimal(3, amount);
            stmt.setString(4, description);
            stmt.setTimestamp(5, created);
            stmt.executeUpdate();
            
            conn.commit();
        } catch (BusinessException | SQLException ex) {
            LOG.log(Level.SEVERE, "Create transaction error", ex);

            // When error occurs it need rollback the SQL just execute
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex1) {
                    LOG.log(Level.SEVERE, "Error occur when close connection!", ex1);
                }
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if(conn != null){
                    conn.setAutoCommit(true);
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, "Error occur when close statement!", ex);
            }
        }
    }

}
