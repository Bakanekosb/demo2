/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.LSGD;

import com.xpoly.DAO.LsgdDAO;
import com.xpoly.DAO.NguoiDungDAO;
import com.xpoly.Interface.IService;
import com.xpoly.model.LichSuGiaoDich;
import com.xpoly.model.NguoiDung;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class QLLichSuGiaoDichJInternalFrame extends javax.swing.JInternalFrame implements IService<LichSuGiaoDich> {

    String ListRole[] = {"Bạn Đọc", "Thủ Thư"};
    String head[] = {"Mã Giao Dịch ", "Mã Bạn Đọc ", "Tên Bạn Đọc", "Ngày Giao Dịch", "Số tiền ", "Nội Dung ", "Người Nạp tiền ", "Tên Người Nạp tiền "};
    DefaultComboBoxModel<Object> combo = new DefaultComboBoxModel(ListRole);
    DefaultTableModel modelTable = new DefaultTableModel(head, 0);
    List<Object> lstMaBD = new ArrayList<>();
    List<Object> lstMaTT = new ArrayList<>();
    NguoiDungDAO nguoidungDAO = new NguoiDungDAO();
    String keyword = "";

    /**
     * Creates new form QLLichSuGiaoDichJInternalFrame
     */
    public QLLichSuGiaoDichJInternalFrame() {
        initComponents();
        init();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableList = new javax.swing.JTable();
        txtseach = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Comborole = new javax.swing.JComboBox<>();
        btnexit = new javax.swing.JButton();

        TableList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TableList);

        jButton1.setText("Seach");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Lịch Sử Giao Dịch");

        Comborole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Comborole.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboroleItemStateChanged(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 0, 0));
        btnexit.setText("THoát");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(Comborole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(94, 94, 94)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(jButton1)
                        .addGap(199, 199, 199)
                        .addComponent(btnexit)
                        .addGap(14, 14, 14)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1)
                    .addComponent(Comborole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnexit))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_jButton1ActionPerformed

    private void ComboroleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboroleItemStateChanged
        // TODO add your handling code here:
        modelTable.setRowCount(0);

        for (LichSuGiaoDich x : ls.selectTT(selectrole())) {

            modelTable.addRow(new Object[]{x.getMagd(), x.getMand(), nguoidungDAO.selectById(x.getMand()).getHoTen(),
                x.getNgayGiaoDich(), x.getSoTien(), x.getNoiDung(), x.getNguoiTaoGiaoDich(), nguoidungDAO.selectById(x.getNguoiTaoGiaoDich()).getHoTen()});

        }

    }//GEN-LAST:event_ComboroleItemStateChanged

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> Comborole;
    private javax.swing.JTable TableList;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtseach;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
//        setLocationRelativeTo(this);
        Comborole.setModel((DefaultComboBoxModel) combo);
        TableList.setModel(modelTable);
        loadTable();

    }
    LsgdDAO ls = new LsgdDAO();

    @Override
    public void loadTable() {
        modelTable.setRowCount(0);
        for (LichSuGiaoDich x : ls.selectAll()) {

            modelTable.addRow(new Object[]{x.getMagd(), x.getMand(), nguoidungDAO.selectById(x.getMand()).getHoTen(),
                x.getNgayGiaoDich(), x.getSoTien(), x.getNoiDung(), x.getNguoiTaoGiaoDich(), nguoidungDAO.selectById(x.getNguoiTaoGiaoDich()).getHoTen()});

        }

    }

    @Override
    public void insert() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public StringBuilder validateForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LichSuGiaoDich getModel() {
        return null;
    }

    @Override
    public void setModel(LichSuGiaoDich model) {
    }

    public int selectrole() {

        if (Comborole.getSelectedItem().toString().trim() == "Thủ Thư") {
            return 1;
        }
        if (Comborole.getSelectedItem().toString().trim() == "Bạn Đọc") {
            return 2;
        }
        return 0;
    }
}
