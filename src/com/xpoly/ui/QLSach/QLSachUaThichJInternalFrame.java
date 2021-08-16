/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui.QLSach;

/**
 *
 * @author Dell
 */
import com.xpoly.helper.JdbcHelper;
import com.xpoly.helper.LoginHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class QLSachUaThichJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form QLSachUaThichJInternalFrame
     */
    Connection connection = JdbcHelper.ketNoi();
    DefaultTableModel defaultTableModelA = new DefaultTableModel();
    DefaultTableModel defaultTableModelB = new DefaultTableModel();
    int index = 0;

    public QLSachUaThichJInternalFrame() {
        initComponents();
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        defaultTableModelA.setColumnIdentifiers(new String[]{"Mã Tựa Sách", "Tên Tựa Sách", "Mô Tả", "Số Lượt Thích"});
        defaultTableModelB.setColumnIdentifiers(new String[]{"Mã Người Dùng", "Họ Và Tên", "Email", "Số Điện Thoại"});
        tblA.setModel(defaultTableModelA);
        tblB.setModel(defaultTableModelB);
        btnSearchNguoiDung.setVisible(false);
        txtMaNguoiDung.setEnabled(false);
        txtMaNguoiDung.setText(LoginHelper.USER.getMaND());
        timKiemByUser();
        jPanel2.setVisible(LoginHelper.quyenQuanTri());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblA = new javax.swing.JTable();
        btnUnlike = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMaNguoiDung = new javax.swing.JTextField();
        btnSearchNguoiDung = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblB = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        btnSearchMaSach = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sách Người Dùng Yêu Thích", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        tblA.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblA);

        btnUnlike.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        btnUnlike.setText("Unlike");
        btnUnlike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUnlikeActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("DANH SÁCH SÁCH BẠN  ĐÃ LIKE");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Mã người dùng");

        btnSearchNguoiDung.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearchNguoiDung.setText("Search");
        btnSearchNguoiDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchNguoiDungActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 160, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSearchNguoiDung)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnUnlike, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchNguoiDung))
                    .addComponent(txtMaNguoiDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUnlike)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Người Dùng Yêu Thích Sách", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 12))); // NOI18N

        tblB.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblB);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("DANH SÁCH NGƯỜI DÙNG LIKE SÁCH");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("MÃ SÁCH");

        txtMaSach.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        btnSearchMaSach.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSearchMaSach.setText("search");
        btnSearchMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchMaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(65, 65, 65)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSearchMaSach)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnSearchMaSach)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(87, 87, 87))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUnlikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUnlikeActionPerformed
        // TODO add your handling code here:
        index = tblA.getSelectedRow();
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.tuasach SET soluongthich=soluongthich-1 WHERE matuasach=?")) {

            preparedStatement.setString(1, (String) (defaultTableModelA.getValueAt(index, 0)));
            int ii = preparedStatement.executeUpdate();
            if (ii > 0) {

            } else {
                System.out.println("UnlikeActionPerformed thất bại.");
                return;
            }
        } catch (Exception e) {
            System.out.println("UnlikeActionPerformed thất bại." + e.toString());
        }
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM dbo.sachuathich WHERE mand =? AND matuasach=?")) {
            preparedStatement.setString(1, txtMaNguoiDung.getText());
            preparedStatement.setString(2, (String) (defaultTableModelA.getValueAt(index, 0)));

            int i = preparedStatement.executeUpdate();
            if (i > 0) {

                timKiemByUser();

            } else {
                JOptionPane.showMessageDialog(this, "UnlikeActionPerformed thất bại.");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "UnlikeActionPerformed thất bại. loi : " + e);
        }
    }//GEN-LAST:event_btnUnlikeActionPerformed

    private void btnSearchNguoiDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchNguoiDungActionPerformed
        // TODO add your handling code here:
        timKiemByUser();
    }//GEN-LAST:event_btnSearchNguoiDungActionPerformed

    private void btnSearchMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchMaSachActionPerformed
        // TODO add your handling code here:
        defaultTableModelB.setRowCount(0);
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT sachuathich.mand,hoten,email,sdt FROM dbo.nguoidung INNER JOIN dbo.sachuathich ON sachuathich.mand = nguoidung.mand WHERE matuasach=?");) {
            preparedStatement.setString(1, txtMaSach.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                defaultTableModelB.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)});
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }//GEN-LAST:event_btnSearchMaSachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSearchMaSach;
    private javax.swing.JButton btnSearchNguoiDung;
    private javax.swing.JButton btnUnlike;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblA;
    private javax.swing.JTable tblB;
    private javax.swing.JTextField txtMaNguoiDung;
    private javax.swing.JTextField txtMaSach;
    // End of variables declaration//GEN-END:variables

    public void timKiemByUser() {
        defaultTableModelA.setRowCount(0);
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT tuasach.matuasach,tentuasach,mota,soluongthich  FROM dbo.sachuathich INNER JOIN dbo.tuasach ON tuasach.matuasach = sachuathich.matuasach WHERE mand=?");) {
            preparedStatement.setString(1, txtMaNguoiDung.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)});
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }
}