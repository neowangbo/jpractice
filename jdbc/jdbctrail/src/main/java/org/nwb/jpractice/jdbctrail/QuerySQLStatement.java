/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.nwb.jpractice.jdbctrail.model.Account;

/**
 * 1. Create connection
 * 
 * 2. Create statement
 *     a. Statement: Used to implement simple SQL statements with no parameters.
 *     b. PreparedStatement: (Extends Statement.) Used for pre-compiling SQL statements (camparing with statement) that might contain input parameters. 
 * See Using Prepared Statements for more information.
 *     c. CallableStatement: (Extends PreparedStatement.) Used to execute stored procedures that may contain both input and output parameters. 
 * See Stored Procedures for more information.
 * 
 * 3. Executing query
 *     a. execute: Returns true if the first object that the query returns is a ResultSet object. 
 * Use this method if the query could return one or more ResultSet objects. Retrieve the ResultSet objects returned from the query by repeatedly calling Statement.getResultSet.
 *     b. executeQuery: Returns one ResultSet object.
 *     c. executeUpdate: Returns an integer representing the number of rows affected by the SQL statement.
 * Use this method if you are using INSERT, DELETE, or UPDATE SQL statements.
 * 
 * Select statement should use executeQuery to return a ResultSet
 * 
 * @author b5wang
 */
public class QuerySQLStatement {

    private final static Logger LOG = Logger.getLogger(QuerySQLStatement.class.getName());

    public static void main(String[] args) {
        // Statement
        List<Account> accounts = selectAll();
        LOG.info(accounts.toString());
        
        // PreparedStatement
        accounts = selectByOwner("Tom");
        LOG.info(accounts.toString());
    }

    public static List<Account> selectAll() {

        final String queryStmt = "SELECT ID,OWNER,BALANCE,UPDATED FROM ACCOUNTS ORDER BY UPDATED DESC";

        Statement stmt = null;
        List<Account> accounts = new LinkedList<>();// diamand 1.7
        try {

            try {
                Connection conn = DBConnection.getConnection();
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(queryStmt);

                while (rs.next()) {
                    Account account = new Account();
                    
                    // By column index
//                    account.setId(rs.getInt(1));
//                    account.setOwner(rs.getString(2));
//                    account.setBalance(rs.getBigDecimal(3));
//                    account.setUpdated(rs.getTimestamp(4));
                    
                    // By column label
                    account.setUpdated(rs.getTimestamp("UPDATED"));
                    account.setBalance(rs.getBigDecimal("BALANCE"));
                    account.setOwner(rs.getString("OWNER"));
                    account.setId(rs.getInt("ID"));
                    
                    accounts.add(account);
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return accounts;
    }

    
    public static List<Account> selectByOwner(String owner) {

        final String queryStmt = "SELECT ID,OWNER,BALANCE,UPDATED FROM ACCOUNTS WHERE OWNER=?";

        PreparedStatement stmt = null;
        List<Account> accounts = new LinkedList<>();// diamand 1.7
        try {

            try {
                Connection conn = DBConnection.getConnection();
                stmt = conn.prepareStatement(queryStmt);
                stmt.setString(1, owner);
                
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Account account = new Account();
                    
                    // By column index
                    account.setId(rs.getInt(1));
                    account.setOwner(rs.getString(2));
                    account.setBalance(rs.getBigDecimal(3));
                    account.setUpdated(rs.getTimestamp(4));
                    
                    accounts.add(account);
                }
            } catch (SQLException ex) {
                LOG.log(Level.SEVERE, null, ex);
            } finally {
                if (stmt != null) {
                    stmt.close();
                }
            }

        } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        
        return accounts;
    }
}
