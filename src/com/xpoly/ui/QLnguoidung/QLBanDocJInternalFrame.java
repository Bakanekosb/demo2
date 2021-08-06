/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui.QLnguoidung;



/**
 *
 * @author Dell
 */


import com.xpoly.DAO.NguoiDungDAO;
import com.xpoly.DAO.NhanVienDao;
import com.xpoly.Interface.IService;
import com.xpoly.QLnhansu.NapTien;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.NguoiDung;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class QLBanDocJInternalFrame extends javax.swing.JInternalFrame implements IService<NguoiDung>  {

    /**
     * Creates new form QLBanDocJInternalFrame
     */
    String keyword = "";
    EzHelper ez = new EzHelper();
    String head[] = {"STT", "Mã Người Dùng", "Họ Tên", "Ngày Sinh", "Giới Tính", "SĐT", "Email", "Địa Chỉ", "Vai Trò", "Ghi Chú", "Mật Khẩu", "Ví Tiền", "Ảnh"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    String role[] = {"ADMIN", "THỦ THƯ", "BẠN ĐỌC"};
    DefaultComboBoxModel<Object> combo = new DefaultComboBoxModel<>(role);
    NhanVienDao nhanvienDAO = new NhanVienDao();
    NguoiDung nguoidung = new NguoiDung();
    NguoiDungDAO nguoidungDAO = new NguoiDungDAO();
    double vitien;
    int trangthai = 0;
    String reMaNV = "[n,N]{1}[v,V]{1}[0-9]{5}";
    String resdt = "0[0-9]{9}";
    private static final String alpha = "abcdefghijklmnopqrstuvwxyz"; // a-z
    private static final String alphaUpperCase = alpha.toUpperCase(); // A-Z
    private static final String digits = "0123456789"; // 0-9
    private static final String specials = "~=+%^*/()[]{}/!@#$?|";
    private static final String ALPHA_NUMERIC = alpha + alphaUpperCase + digits;
    private static Random generator = new Random();
    int numberOfCharactor = 8;
    ADDnguoiDung add = new ADDnguoiDung();
//        UPDATEnguoidung update = new UPDATEnguoidung();
    int pageNumber = 1, rowsOfPage = 6, rowIndex = 0;

    int totalPage;
    NapTien nt = new NapTien();
    
    public QLBanDocJInternalFrame() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        txtseach = new javax.swing.JTextField();
        btnseach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableList = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMand = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtghichu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        rdbnam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        txtmatkhau = new javax.swing.JPasswordField();
        txtvitien = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        combovaitro = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jdatengaysinh = new com.toedter.calendar.JDateChooser();
        lblImg = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnadd = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btn_first1 = new javax.swing.JButton();
        btn_prev1 = new javax.swing.JButton();
        btn_next1 = new javax.swing.JButton();
        btn_last1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Bạn Đọc");

        btnseach.setText("Tìm Kiếm");
        btnseach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseachActionPerformed(evt);
            }
        });

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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel2.setText("Mã ND");

        jLabel3.setText("Email");

        jLabel4.setText("Họ Tên");

        jLabel5.setText("Ghi chú");

        jLabel6.setText("Địa chỉ");

        jLabel7.setText("SĐT");

        jLabel8.setText("Ngày Sinh");

        jLabel9.setText("Giới Tính");

        rdbnam.setText("Nam");

        rdbNu.setText("Nữ");

        txtmatkhau.setText("jPasswordField1");

        jLabel11.setText("Ví Tiền");

        jLabel12.setText("Vai Trò");

        combovaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Mật Khẩu");

        jLabel13.setText("Ảnh");

        lblImg.setText("Click vào để tải ảnh");
        lblImg.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblImgMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(combovaitro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtvitien, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdatengaysinh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMand, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbNu)
                        .addGap(39, 39, 39)
                        .addComponent(rdbnam)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtghichu, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdiachi, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEmail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblImg, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jdatengaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(rdbNu)
                                    .addComponent(rdbnam)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(56, 56, 56)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtvitien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(lblImg)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridBagLayout());

        btnadd.setText("Add");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 222, 0, 0);
        jPanel2.add(btnadd, gridBagConstraints);

        btnupdate.setText("update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(btnupdate, gridBagConstraints);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jButton3, gridBagConstraints);

        jButton4.setText("refersh");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel2.add(jButton4, gridBagConstraints);

        jButton5.setText("Exit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 223);
        jPanel2.add(jButton5, gridBagConstraints);

        jButton6.setText("Nạp Tiền");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btn_first1.setText("|<");
        btn_first1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_first1ActionPerformed(evt);
            }
        });

        btn_prev1.setText("<<");
        btn_prev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prev1ActionPerformed(evt);
            }
        });

        btn_next1.setText(">>");
        btn_next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_next1ActionPerformed(evt);
            }
        });

        btn_last1.setText(">|");
        btn_last1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_last1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 296, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(27, 27, 27)
                        .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnseach))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btn_first1)
                .addGap(26, 26, 26)
                .addComponent(btn_prev1)
                .addGap(31, 31, 31)
                .addComponent(btn_next1)
                .addGap(36, 36, 36)
                .addComponent(btn_last1)
                .addGap(250, 250, 250))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnseach)
                        .addComponent(jButton6)))
                .addGap(3, 3, 3)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_first1)
                    .addComponent(btn_prev1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_next1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_last1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnseachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseachActionPerformed
        // TODO add your handling code here:
        keyword = txtseach.getText();
        loadTable();
    }//GEN-LAST:event_btnseachActionPerformed

    private void TableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListMouseClicked
        // TODO add your handling code here:
        mouseCLick();
    }//GEN-LAST:event_TableListMouseClicked

    private void lblImgMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblImgMouseClicked
        // TODO add your handling code here:
        ez.selectImage(lblImg);
    }//GEN-LAST:event_lblImgMouseClicked

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
        // TODO add your handling code here:
        add.setVisible(true);
    }//GEN-LAST:event_btnaddActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        //      update.setVisible(true);
        update();
        loadTable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
        loadTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        nt.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btn_first1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_first1ActionPerformed
        pageNumber = 1;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_first1ActionPerformed

    private void btn_prev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prev1ActionPerformed
        pageNumber--;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_prev1ActionPerformed

    private void btn_next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_next1ActionPerformed
        pageNumber++;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_next1ActionPerformed

    private void btn_last1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_last1ActionPerformed
        pageNumber = totalPage;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_last1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableList;
    private javax.swing.JButton btn_first1;
    private javax.swing.JButton btn_last1;
    private javax.swing.JButton btn_next1;
    private javax.swing.JButton btn_prev1;
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnseach;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> combovaitro;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdatengaysinh;
    private javax.swing.JLabel lblImg;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JRadioButton rdbnam;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMand;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txthoten;
    private javax.swing.JPasswordField txtmatkhau;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtseach;
    private javax.swing.JTextField txtvitien;
    // End of variables declaration//GEN-END:variables

 @Override
    public void init() {
//        setLocationRelativeTo(this);
 putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);

        TableList.setModel(model);
        combovaitro.setModel((DefaultComboBoxModel) combo);
        loadTable();
        pack();
    }
    List<NguoiDung> lst_tg = null;

    @Override
    public void loadTable() {
        model.setRowCount(0);
        int total = (int) Math.ceil((float) nguoidungDAO.getTotalRows(keyword) / rowsOfPage);
        totalPage = total > 0 ? total : 1;
        pageNumber = pageNumber > totalPage ? 1 : pageNumber;
        try {
            lst_tg = nguoidungDAO.selectByKeyword(keyword, pageNumber, rowsOfPage);
        } catch (SQLException ex) {
            Logger.getLogger(QLnguoidung.class.getName()).log(Level.SEVERE, null, ex);
        }
        int i = 0;
        for (NguoiDung x : lst_tg) {
            model.addRow(new Object[]{
                i++, x.getMaND(), x.getHoTen(), x.getNgaySinh(), gioitinh(x.isGioiTinh()), x.getSdt(), x.getEmail(), x.getDiaChi(),
                vaitro(x.getVaiTro()), x.getGhiChu(), x.getMatKhau(), x.getViTien(), x.getAnh()
            });
        }
    }

    @Override
    public void insert() {
        try {
            if (nguoidung != null) {
                nhanvienDAO.insert(getModel());
                DialogHelper.alert(this, "Thêm Thành Công!");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Thêm thất bại !");
            e.printStackTrace();
            return;
        }
    }

    @Override
    public void update() {
        try {
            if (nguoidung != null) {
                nhanvienDAO.update(getModel());
                DialogHelper.alert(this, "Sửa Thành Công!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "sửa thất bại !");
            return;
        }
    }

    @Override
    public void delete() {
        try {
            if (nguoidung != null) {
                nhanvienDAO.delete(txtMand.getText());
//            TableList.remove(TableList.getSelectedRow());
                DialogHelper.alert(this, "xóa Thành Công!");
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Xóa Thất bại!");
            e.printStackTrace();
        }
    }

    @Override
    public void clear() {
        txtEmail.setText("");
        txtMand.setText("");
        txtdiachi.setText("");
        txtghichu.setText("");
        txthoten.setText("");
        txtmatkhau.setText("");
        txtsdt.setText("");
        txtvitien.setText("");
        rdbnam.setSelected(true);
        combovaitro.setSelectedIndex(1);
        lblImg.setText("Tải lên");
    }

    @Override
    public StringBuilder validateForm() {
        StringBuilder sb = new StringBuilder();
        String mand = txtMand.getText();
        String hoten = txthoten.getText();
        Date ngaysinh = jdatengaysinh.getDate();
        boolean gioitinh = rdbnam.isSelected() ? true : false;
        String sdt = txtsdt.getText();
        String email = txtEmail.getText();
        String diachi = txtdiachi.getText();
//    String vaitro = txtMand.getText();
        String ghichu = txtghichu.getText();
        String matkhau = txtmatkhau.getText();
        String vitien = txtvitien.getText();
        if (mand.isBlank()) {
            DialogHelper.alert(this, "Mã Người dùng Không được để trống ! ");
            return null;
        }
        if (hoten.isBlank()) {
            DialogHelper.alert(this, "Họ tên Không được để trống ! ");
            return null;
        }
        if (mand.isBlank()) {
            DialogHelper.alert(this, "Mã Người dùng Không được để trống ! ");
            return null;
        }
        if (sdt.isBlank()) {
            DialogHelper.alert(this, "SĐT Không được để trống ! ");
            return null;
        }
        if (email.isBlank()) {
            DialogHelper.alert(this, "Email Không được để trống ! ");
            return null;
        }
        if (diachi.isBlank()) {
            DialogHelper.alert(this, "Địa chỉ Không được để trống ! ");
            return null;
        }
        if (matkhau.isBlank()) {
            DialogHelper.alert(this, "Mật khẩu Không được để trống ! ");
            return null;
        }
        if (vitien.isBlank()) {
            DialogHelper.alert(this, "Ví tiền Không được để trống ! ");
            return null;
        }
        return sb;
    }

    @Override
    public NguoiDung getModel() {
        if (validateForm().length() > 0) {
            DialogHelper.alert(this, validateForm().toString());
            return null;
        }
        String mand = txtMand.getText().toUpperCase();
        String hoten = txthoten.getText();
        Date ngaysinh = jdatengaysinh.getDate();
        boolean gioitinh = rdbnam.isSelected() ? true : false;
        String sdt = txtsdt.getText();
        String email = txtEmail.getText();
        String diachi = txtdiachi.getText();
//    String vaitro = txtMand.getText();
        String ghichu = txtghichu.getText();
        String matkhau = randomString(numberOfCharactor);
        vitien = EzHelper.isDouble(txtvitien, "Ví tiền !", this);
        String anh = lblImg.getToolTipText();
        return new NguoiDung(mand, hoten, ngaysinh, gioitinh, sdt, email, diachi, selectrole(), ghichu, matkhau, vitien, "", trangthai);
    }

    public String randomString(int numberOfCharactor) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numberOfCharactor; i++) {
            int number = randomNumber(0, ALPHA_NUMERIC.length() - 1);
            char ch = ALPHA_NUMERIC.charAt(number);
            sb.append(ch);
        }
        return sb.toString();
    }

    public static int randomNumber(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    @Override
    public void setModel(NguoiDung model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String gioitinh(boolean i) {
        String gt;
        if (i == true) {
            return gt = "nam";
        }
        return gt = "nữ";
    }

    public boolean gioitinhbo(String i) {
        boolean gt;
        if (i.equals("nam")) {
            return gt = true;
        }
        return gt = false;
    }

    public String vaitro(int i) {
        String gt;
        if (i == 0) {
            return gt = "ADMIN";
        }
        if (i == 1) {
            return gt = "Thủ Thư";
        }
        if (i == 2) {
            return gt = "Bạn Đọc";
        }
        return null;

    }

    public int selectrole() {
        if (combovaitro.getSelectedIndex() == 1) {
            return 1;
        }
        if (combovaitro.getSelectedIndex() == 2) {
            return 2;
        }
        if (combovaitro.getSelectedIndex() == 3) {
            return 3;
        }
        return 0;
    }

    public void mouseCLick() {
        List<NguoiDung> lst = new ArrayList<>();
        int i = TableList.getSelectedRow();
        if (i >= 0) {
            txtMand.setText(TableList.getValueAt(i, 1).toString());
            txtMand.setEditable(false);
            txthoten.setText(TableList.getValueAt(i, 2).toString());
            jdatengaysinh.setDate((Date) TableList.getValueAt(i, 3));
            if (TableList.getValueAt(i, 4) == "Nam") {
                rdbnam.setSelected(true);
            } else {
                rdbNu.setSelected(true);
            }
            txtsdt.setText(TableList.getValueAt(i, 5).toString());
            txtEmail.setText(TableList.getValueAt(i, 6).toString());
            txtdiachi.setText(TableList.getValueAt(i, 7).toString());
            combovaitro.setSelectedItem(TableList.getValueAt(i, 8).toString());
            txtghichu.setText(TableList.getValueAt(i, 9).toString());
            txtmatkhau.setText(TableList.getValueAt(i, 10).toString());
            txtvitien.setText(TableList.getValueAt(i, 11).toString());
            txtvitien.setEditable(false);
            combovaitro.setSelectedItem(TableList.getValueAt(i, (9)));

        }
    }

    void buttonEnabled() {
        System.out.println(pageNumber + " in button enabled");
        btn_first1.setEnabled(pageNumber > 1);
        btn_prev1.setEnabled(pageNumber > 1);
        btn_last1.setEnabled(pageNumber < totalPage);
        btn_next1.setEnabled(pageNumber < totalPage);
    }
}
