/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.util.HashMap;
import java.util.Map;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Dell
 */
public class TableColumnHider {
    private final JTable table;
    private final TableColumnModel tcm;
    private final Map hiddenColumns;

    public TableColumnHider(JTable table) {
        this.table = table;
        tcm = table.getColumnModel();
        hiddenColumns = new HashMap();
    }

    public void hide(String columnName, String keySig) {
        int index = tcm.getColumnIndex(columnName);
        TableColumn column = tcm.getColumn(index);
        hiddenColumns.put(columnName, column);
        hiddenColumns.put(keySig + columnName, index);
        tcm.removeColumn(column);
    }

    public void show(String columnName, String keySig, String[] columns) {
        int index = 0;
        for(int i = 0; i< columns.length; i++){
            if(columnName.equalsIgnoreCase(columns[i])){
                index = i;
            }
        }
        Object o = hiddenColumns.remove(columnName);
        if (o == null) {
            return;
        }
        tcm.addColumn((TableColumn) o);
        o = hiddenColumns.remove(keySig + columnName);
        if (o == null) {
            return;
        }
//        int column = (Integer) o;
        int lastColumn = tcm.getColumnCount() - 1;
        if (index < lastColumn) {
            tcm.moveColumn(lastColumn, index);
        }
        else{
            tcm.moveColumn(lastColumn, lastColumn);
        }
    }
}
