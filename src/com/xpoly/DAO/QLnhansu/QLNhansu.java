/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO.QLnhansu;

import java.lang.Object;
import com.xpoly.DAO.NhanVienDao;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.NguoiDung;
import java.awt.Button;
import java.awt.MenuContainer;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.Serializable;
import java.util.Date;
import javax.accessibility.Accessible;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class QLNhansu extends javax.swing.JFrame implements IService<NguoiDung>, Accessible, Serializable, MenuContainer, ImageObserver {

    String head[] = {"STT", "Mã Người Dùng", "Họ Tên", "Ngày Sinh", "Giới Tính", "SĐT", "Email", "Địa Chỉ", "Vai Trò", "Ghi Chú", "Mật Khẩu", "Ví Tiền","Ảnh"};
    DefaultTableModel model = new DefaultTableModel(head, 0);
    String role[] = {"ADMIN", "THỦ THƯ", "BẠN ĐỌC"};
    DefaultComboBoxModel<Object> combo = new DefaultComboBoxModel<>(role);
    NhanVienDao nguoidungDAO = new NhanVienDao();
    String keyword = "";
    JFileChooser chooser ; 
    File f = null;
    NguoiDung nguoidung = new NguoiDung();
    double vitien;
    int trangthai = 0;

    /**
     * Creates new form QLNhansu
     */
    public QLNhansu() {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
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
        btnimg = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jdatengaysinh = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtseach = new javax.swing.JTextField();
        btnseach = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Quản Lý Nhân Sự");

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

        buttonGroup1.add(rdbnam);
        rdbnam.setText("Nam");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        txtmatkhau.setText("jPasswordField1");

        jLabel11.setText("Ví Tiền");

        jLabel12.setText("Vai Trò");

        combovaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Mật Khẩu");

        btnimg.setText("Tải lên");
        btnimg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimgActionPerformed(evt);
            }
        });

        jLabel13.setText("Ảnh");

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
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbNu)
                        .addGap(39, 39, 39)
                        .addComponent(rdbnam)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(combovaitro, 0, 429, Short.MAX_VALUE)
                            .addComponent(txtvitien)
                            .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMand, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jdatengaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnimg)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtdiachi)
                                .addGap(1, 1, 1))
                            .addComponent(txtghichu)
                            .addComponent(txtEmail)
                            .addComponent(txtsdt)
                            .addComponent(txtmatkhau, javax.swing.GroupLayout.DEFAULT_SIZE, 413, Short.MAX_VALUE))))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel8))
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdatengaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(rdbNu)
                            .addComponent(rdbnam)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmatkhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(txtvitien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel12))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(btnimg))))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 222, 0, 0);
        jPanel2.add(jButton1, gridBagConstraints);

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

        btnseach.setText("Tìm Kiếm");
        btnseach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnseachActionPerformed(evt);
            }
        });

        jButton6.setText("Nạp Tiền");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 308, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton6)
                                .addGap(69, 69, 69)
                                .addComponent(txtseach, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnseach))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnseachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnseachActionPerformed
        // TODO add your handling code here:
        keyword = txtseach.getText();
        loadTable();
    }//GEN-LAST:event_btnseachActionPerformed
    AddNhanSu add = new AddNhanSu();
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        add.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnimgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimgActionPerformed
        // TODO add your handling code here:
        
        selectImage(btnimg);
//        chooser = new JFileChooser();
//        FileNameExtensionFilter filter = new FileNameExtensionFilter(
//                "JPG & GIF Images", "jpg", "gif");
//        chooser.setFileFilter(filter);
//        chooser.setMultiSelectionEnabled(false);
//        int x = chooser.showDialog(this, "chọn file");
//        if (x == chooser.APPROVE_OPTION) {
//          File  f = (File)chooser.getSelectedFile();
//            DialogHelper.alert(this, "tải thành công !");
//            System.out.println(f + " file ảnh");
//            System.out.println("chooser" + chooser);
//        }
    }//GEN-LAST:event_btnimgActionPerformed

    private void TableListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableListMouseClicked
        // TODO add your handling code here:
        int i = TableList.getSelectedRow();
        if(i>=0){
            txtMand.setText(TableList.getValueAt(i, 1).toString());
            txtMand.setEditable(false);
            txthoten.setText(TableList.getValueAt(i, 2).toString());
            jdatengaysinh.setDate((Date) TableList.getValueAt(i, 3));
            if(TableList.getValueAt(i, 4)== "Nam"){
            rdbnam.setSelected(true);
            }else {
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
            
            
        
        }
    }//GEN-LAST:event_TableListMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        delete();
        loadTable();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_jButton4ActionPerformed
NapTien nt = new NapTien();
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        nt.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        update();
        loadTable();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed
    public void selectImage(JButton btn) {
        EzHelper ez = new EzHelper();
        try {
            JFileChooser fc = new JFileChooser("images\\");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if (ez.saveImg(file)) {
                    btnimg.setIcon(ez.readImg(file.getName()));
                    btnimg.setToolTipText(file.getName());
                }
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi save ảnh");
        }

    }
    
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
            java.util.logging.Logger.getLogger(QLNhansu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLNhansu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLNhansu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLNhansu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNhansu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableList;
    private javax.swing.JButton btnimg;
    private javax.swing.JButton btnseach;
    private javax.swing.JButton btnupdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combovaitro;
    private javax.swing.JButton jButton1;
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

        setLocationRelativeTo(this);
        TableList.setModel(model);
        combovaitro.setModel((DefaultComboBoxModel) combo);
        loadTable();
        pack();
    }

    @Override
    public void loadTable() {
        model.setRowCount(0);
        int i = 0;
        for (NguoiDung x : nguoidungDAO.selectAll()) {
            model.addRow(new Object[]{
                i++, x.getMaND(), x.getHoTen(), x.getNgaySinh(), gioitinh(x.isGioiTinh()), x.getSdt(), x.getEmail(), x.getDiaChi(),
                 vaitro(x.getVaiTro()), x.getGhiChu(), x.getMatKhau(), x.getViTien(),x.getAnh()
            });
        }
    }

    public String gioitinh(boolean i) {
        String gt;
        if (i == true) {
            return gt = "nam";
        }
        return gt = "nữ";
    }

    public String vaitro(int i) {
        String gt;
        if (i == 0) {
            return gt = "ADMIN";
        }
        if (i == 1) {
            return gt = "Thủ Thư";
        }
        return gt = "Bạn Đọc";
    }

    @Override
    public void insert() {
        try {
            if(nguoidung != null){
        nguoidungDAO.insert(getModel());
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
            if(nguoidung != null){
            nguoidungDAO.update(getModel());
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
            if(nguoidung != null){
            nguoidungDAO.delete(txtMand.getText());
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
    btnimg.setText("Tải lên");
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

    @Override
    public NguoiDung getModel() {
        if (validateForm().length() > 0) {
            DialogHelper.alert(this, "");
            return null;
        }
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
        vitien = EzHelper.isDouble(txtvitien, "Ví tiền !", jPanel1);
        String anh = chooser.getName(f);
    return new NguoiDung(mand, hoten, ngaysinh, gioitinh, sdt, email, diachi,selectrole() , ghichu, matkhau, vitien,"",trangthai);
        
    }

    @Override
    public void setModel(NguoiDung model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
