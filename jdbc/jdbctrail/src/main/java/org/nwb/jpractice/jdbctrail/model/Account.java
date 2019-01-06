/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.jdbctrail.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Derby data type and corresponding java class:
 * https://docs.oracle.com/cd/E19501-01/819-3659/gcmaz/
 * 
 * @author b5wang
 */
public class Account {
    
    private Integer id;
    
    private String owner;
    
    private BigDecimal balance;
    
    private Timestamp updated;

    public Integer getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }
    
    @Override
    public String toString(){
        return "{ id=" + id + ", owner=" + owner + ", balance=" + balance + ", updated=" + updated + " }";
    }
}
