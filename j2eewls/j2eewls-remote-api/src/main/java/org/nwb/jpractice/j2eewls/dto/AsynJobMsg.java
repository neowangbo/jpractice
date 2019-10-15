/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.j2eewls.dto;

import java.io.Serializable;

/**
 *
 * @author b5wang
 */
public class AsynJobMsg implements Serializable{
    
    private String id;
    
    private int duration;
    
    private boolean isSuccess = true;

    public void setId(String id) {
        this.id = id;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setIsSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }
    
    public String getId() {
        return id;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isIsSuccess() {
        return isSuccess;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        return sb.append("AsynJobMsg{id=").append(id)
                .append(", duration=").append(duration).append("seconds")
                .append(", status=").append(isSuccess).append("}").toString();
    }
    
}
