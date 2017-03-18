/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.designpattern.interfacepattern.adapter.classadapter;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author wangbo
 */
public class RocketTableModel extends AbstractTableModel{

    private List<String[]> rows;
    
    private String[] columnNames = {"Name", "Price", "Apogee"};
    
    public RocketTableModel(List<String[]> rows){
        this.rows = rows;
    }
    
    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    public int getRowCount() {
        return rows.size();
    }

    public int getColumnCount() {
        return columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex)[columnIndex];
    }
    
    
    
}
