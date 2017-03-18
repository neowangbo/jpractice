/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.nwb.jpractice.designpattern.interfacepattern.adapter.classadapter;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

/**
 * Class Adapter: JTable require TableModel interface, and 
 * 
 * @author wangbo
 */
public class ShowRocketTable {
    
    private static void setFonts(){
        Font font = new Font("Dialog", Font.PLAIN, 18);
        UIManager.put("Table.font", font);
        UIManager.put("TableHeader.font", font);
    }
    
    public static RocketTableModel getRocketTable(){
        
        String[] row0 = {"Shooter" , "$3.95", "50.0"};
        String[] row1 = {"Orbit" , "$29.03", "5000.0"};
        
        List<String[]> rows = new ArrayList<String[]>();
        rows.add(row0);
        rows.add(row1);
        
        return new RocketTableModel(rows);
    }
    
    public static void main(String[] args){
        setFonts();
        
        JTable table = new JTable(getRocketTable());
        table.setRowHeight(40);
        
        JScrollPane pane = new JScrollPane(table);
        pane.setPreferredSize(new java.awt.Dimension(300, 100));
        
        JFrame frame = new JFrame("Rocket");
        frame.getContentPane().add(pane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
    
}
