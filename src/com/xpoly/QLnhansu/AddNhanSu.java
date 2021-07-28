/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.QLnhansu;

import com.xpoly.DAO.NhanVienDao;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.NguoiDung;
import java.io.File;
import java.util.Date;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Admin
 */
public class AddNhanSu extends javax.swing.JFrame implements IService<NguoiDung>{
     String role[] = {"ADMIN", "THỦ THƯ", "BẠN ĐỌC"};
    DefaultComboBoxModel<Object> combo = new DefaultComboBoxModel<>(role);
String keyword = "";
    JFileChooser chooser =new JFileChooser();; 
    File f = null;
    NhanVienDao nhanvienDAO = new NhanVienDao();
    NguoiDung nguoidung = new NguoiDung();
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
    /**
     * Creates new form AddNhanSu
     */
    public AddNhanSu() {
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
        jPanel3 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        txtMand = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtghichu = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        txtdiachi = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        rdbnam = new javax.swing.JRadioButton();
        rdbNu = new javax.swing.JRadioButton();
        txtvitien = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        combovaitro = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jdatengaysinh = new com.toedter.calendar.JDateChooser();
        lblIMG = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnclear = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin"));

        jLabel24.setText("Mã ND");

        jLabel25.setText("Email");

        jLabel26.setText("Họ Tên");

        jLabel27.setText("Ghi chú");

        jLabel28.setText("Địa chỉ");

        jLabel29.setText("SĐT");

        jLabel30.setText("Ngày Sinh");

        jLabel31.setText("Giới Tính");

        buttonGroup1.add(rdbnam);
        rdbnam.setText("Nam");

        buttonGroup1.add(rdbNu);
        rdbNu.setText("Nữ");

        jLabel32.setText("Ví Tiền");

        jLabel33.setText("Vai Trò");

        combovaitro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        combovaitro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combovaitroActionPerformed(evt);
            }
        });

        jLabel35.setText("Ảnh");

        lblIMG.setText("Tải ảnh");
        lblIMG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIMGMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdbNu)
                        .addGap(39, 39, 39)
                        .addComponent(rdbnam)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtvitien)
                                    .addComponent(txthoten, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtMand, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jdatengaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(combovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, 429, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtdiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                                .addGap(1, 1, 1))
                            .addComponent(txtghichu)
                            .addComponent(txtEmail)
                            .addComponent(txtsdt)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 196, Short.MAX_VALUE)))))
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtMand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel28, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel30))
                    .addComponent(txtdiachi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jdatengaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtghichu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtvitien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblIMG, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(rdbNu)
                                    .addComponent(rdbnam)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel32)))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(combovaitro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35))
                        .addGap(200, 200, 200))))
        );

        jPanel4.setLayout(new java.awt.GridBagLayout());

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
        jPanel4.add(jButton1, gridBagConstraints);

        btnclear.setText("refersh");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 0);
        jPanel4.add(btnclear, gridBagConstraints);

        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 223);
        jPanel4.add(btnExit, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(265, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(461, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(74, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            insert();
        } catch (Exception e) {
            DialogHelper.alert(this, "Mã Nhân viên đã tồn tại !");
        }
        
       nhanvienDAO.SendMail(txtEmail.getText(), "Đăng kí tài Khoản thành công !", "Mật khẩu của bạn là : " +randomString(numberOfCharactor)+ "\n Số tiền bạn nạp lần đầu là : "+ txtvitien.getText()
       + "\n bạn hãy đổi mật khẩu khi đọc được Email này để đảm bảo tính bảo mật cho tài khoản của bạn !");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
         // TODO add your handling code here:
         clear();
        
    }//GEN-LAST:event_btnclearActionPerformed

    private void combovaitroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combovaitroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combovaitroActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnExitActionPerformed
EzHelper ez = new EzHelper();
    private void lblIMGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIMGMouseClicked
        // TODO add your handling code here:
        ez.selectImage(lblIMG);
    }//GEN-LAST:event_lblIMGMouseClicked

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
            java.util.logging.Logger.getLogger(AddNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddNhanSu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddNhanSu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnclear;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combovaitro;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private com.toedter.calendar.JDateChooser jdatengaysinh;
    private javax.swing.JLabel lblIMG;
    private javax.swing.JRadioButton rdbNu;
    private javax.swing.JRadioButton rdbnam;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMand;
    private javax.swing.JTextField txtdiachi;
    private javax.swing.JTextField txtghichu;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtsdt;
    private javax.swing.JTextField txtvitien;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
     setLocationRelativeTo(this);      
        combovaitro.setModel((DefaultComboBoxModel) combo);
        
        pack();
                }

    @Override
    public void loadTable() {
    }

    @Override
    public void insert() {
         try {
            if(nguoidung != null){
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
    txtEmail.setText("");
    txtMand.setText("");
    txtdiachi.setText("");
    txtghichu.setText("");
    txthoten.setText("");
    
    txtsdt.setText("");
    txtvitien.setText("");
    rdbnam.setSelected(true);
    combovaitro.setSelectedIndex(1);
    lblIMG.setText("Tải lên");
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
        String matkhau = randomString(numberOfCharactor);
        Double vitien = EzHelper.isDouble(txtvitien, "Ví tiền", this);
        String vitien2 = txtvitien.getText();
        if (mand.isBlank()) {
            
           
            return sb.append("Mã Nhân viên không được để trống !");
        }
        if(!mand.matches(reMaNV)){
       return sb.append(" \n Bạn nhập định dạng mã nhân viên sai \n xin Nhập theo định dạng NV12345");
        }
        if (hoten.isBlank()) {
           return sb.append("\n Họ tên không được để trống!");
        }
        if (sdt.isBlank()) {
            return sb.append("\n SĐT không được để trống !");
        }
        if(!sdt.matches(resdt)){
          return sb.append("\n SĐT phải bắt đầu bằng số 0 và có độ dài là 10 số ! \"");
        }
        if (email.isBlank()) {
            return sb.append(" \n Email Không được để trống ! ");
        }
        if (diachi.isBlank()) {
           return sb.append(" \n Địa chỉ Không được để trống ! ");
        }
        if (matkhau.isBlank()) {
            return sb.append("\n mật khẩu không được để trống !");
        }
        if (vitien2.isBlank()) {
            return sb.append("\n Ví tiền Không được để trống ! ");
        }
        if(vitien < 50000 && vitien/1000 ==0){
        return sb.append("Số tiền phải lớn hơn 50.000 và phải chia hết cho 1000");
        }
        return sb;}

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
        String anh = nhanvienDAO.selectIMG(lblIMG);
    return new NguoiDung(mand, hoten, ngaysinh, gioitinh, sdt, email, diachi,selectrole() , ghichu, matkhau, vitien, "",trangthai);
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
    public void setModel(NguoiDung model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
       
}
