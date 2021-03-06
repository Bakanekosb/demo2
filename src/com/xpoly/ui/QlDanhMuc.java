/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui;

import com.xpoly.DAO.DanhMucDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.DanhMuc;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QlDanhMuc extends javax.swing.JFrame implements IService<DanhMuc> {

    String head[] = {"STT", "Mã Danh Mục", "Tên Danh Mục"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    DanhMucDAO danhmucDAO = new DanhMucDAO();

    /**
     * Creates new form QlDanhMuc
     */
    public QlDanhMuc() {
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtmadm = new javax.swing.JTextField();
        txttendanhmuc = new javax.swing.JTextField();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        TableList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableList);

        jLabel1.setText("Mã Danh Mục");

        jLabel2.setText("Tên Danh Mục");

        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });

        btnupdate.setText("Sửa");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btnexit.setText("Thoát");
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Quản Lý Danh Mục");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtmadm)
                            .addComponent(txttendanhmuc, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                        .addGap(79, 79, 79)
                        .addComponent(btnadd)
                        .addGap(33, 33, 33)
                        .addComponent(btnupdate)
                        .addGap(36, 36, 36)
                        .addComponent(btnexit))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(179, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtmadm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnadd)
                    .addComponent(btnupdate)
                    .addComponent(btnexit))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txttendanhmuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        insert();
        loadTable();
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        update();
        loadTable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void TableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListMouseClicked
        // TODO add your handling code here:
        int i = TableList.getSelectedRow();
        if(i>= 0){
        txtmadm.setText(TableList.getValueAt(i, 1).toString());
        txttendanhmuc.setText(TableList.getValueAt(i, 2).toString());
        }
    }//GEN-LAST:event_TableListMouseClicked

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnexitActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QlDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QlDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QlDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QlDanhMuc.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QlDanhMuc().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableList;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtmadm;
    private javax.swing.JTextField txttendanhmuc;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        setLocationRelativeTo(this);
        TableList.setModel(model);
        loadTable();
    }

    @Override
    public void loadTable() {
        model.setRowCount(0);
        int i = 0;
        for (DanhMuc x : danhmucDAO.selectAll()) {
            model.addRow(new Object[]{i++, x.getMaDanhMuc(), x.getTenDanhMuc()});
        }
    }

    @Override
    public void insert() {
        try {
            if (getModel() != null) {
            danhmucDAO.insert(getModel());
            DialogHelper.alert(jLabel1, "thêm thành Công !");
        }
        } catch (Exception e) {
            DialogHelper.alert(this, "lưu Không thành công !");
        }
        
    }

    @Override
    public void update() {
        if (getModel() != null) {
            danhmucDAO.update(getModel());
            DialogHelper.alert(jLabel1, "Sửa  thành Công !");
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        txtmadm.setText("");
        txttendanhmuc.setText("");
    }

    @Override
    public StringBuilder validateForm() {
        StringBuilder sb = new StringBuilder();
        String madm = txtmadm.getText();
        String tendm = txttendanhmuc.getText();
        if (madm.isBlank()) {
            EzHelper.blank(txtmadm, " không được để trống !", btnexit);
            return null;
        }
        if (tendm.isBlank()) {
            EzHelper.blank(txttendanhmuc, " không được để trống !", btnexit);
            return null;
        }
        return sb;
    }

    @Override
    public DanhMuc getModel() {
        if (validateForm().length() > 0) {
            DialogHelper.alert(btnexit, "");
        }
        String madm = txtmadm.getText();
        String tendm = txttendanhmuc.getText();
        return new DanhMuc(madm, tendm);
    }

    @Override
    public void setModel(DanhMuc model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
