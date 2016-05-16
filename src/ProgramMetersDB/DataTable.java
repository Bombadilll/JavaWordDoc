/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramMetersDB;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
 
public class DataTable extends JFrame {
 
 
 
    public DataTable(TreeMap<Integer,HashMap> dataSql) {
 
        super("Table data");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TableModel model = new MyTableModel(dataSql);
        JTable table = new JTable(model);
        getContentPane().add(new JScrollPane(table));
        JFrame.setDefaultLookAndFeelDecorated(true);
        setPreferredSize(new Dimension(260, 220));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
 
  
    
    public class MyTableModel implements TableModel {
 
        private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
 
        private TreeMap<Integer,HashMap> beans;
 
        public MyTableModel(TreeMap<Integer,HashMap> beans) {
            this.beans = beans;
        }
 
        @Override
        public void addTableModelListener(TableModelListener listener) {
            listeners.add(listener);
        }
 
        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
 
        @Override
        public int getColumnCount() {
            return 8;
        }
 
        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                     case 0:return  WriteExel.DATA_PROTOCOL;
                     case 1:return  WriteExel.POTREBITEL;
                     case 2:return  WriteExel.ZAVODSK_NUBBER;
                     case 3:return  WriteExel.TIP_COUNTER;
                     case 4:return  WriteExel.ZNAC_COUNTER;
                     case 5:return  WriteExel.YEAR_COUNTER;
                     case 6:return  WriteExel.PLACE;
                     case 7:return  WriteExel.SEAL;
                     case 8:return  WriteExel.ANNATATION;  
             }
            return "";
        }
 
        @Override
        public int getRowCount() {
           return beans.size();
        }
 
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
                HashMap getVal=new HashMap<>();
                getVal=beans.get(rowIndex);
                return getVal.get(columnIndex);
           
        }
 
        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
 
        @Override
        public void removeTableModelListener(TableModelListener listener) {
            listeners.remove(listener);
        }
 
        @Override
        public void setValueAt(Object value, int rowIndex, int columnIndex) {
 
        }
 
    }
}
  