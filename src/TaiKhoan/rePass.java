/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TaiKhoan;

import com.xpoly.DAO.NguoiDungDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.HelpSendEmail;
import com.xpoly.model.NguoiDung;
import java.util.Arrays;

/**
 *
 * @author Admin
 */
public class rePass extends javax.swing.JFrame implements IService<NguoiDung> {

    String CODE;
    String Email;
    String paSs;

    /**
     * Creates new form ChangePass
     */
    public rePass() {
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

        jLabel1 = new javax.swing.JLabel();
        txtCODE = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnchangpass = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        btnsendMail = new javax.swing.JButton();
        btncheckCODE = new javax.swing.JButton();
        txtNewPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Lấy Lại Mật Khẩu");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Nhập CODE");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Nhập Email");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Nhập Mật Khẩu Mới");

        btnchangpass.setText("Đổi Mật Khẩu");
        btnchangpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangpassActionPerformed(evt);
            }
        });

        btnExit.setText("Thoát");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        btnsendMail.setText("Lấy CODE");
        btnsendMail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsendMailActionPerformed(evt);
            }
        });

        btncheckCODE.setText("Check CODE");
        btncheckCODE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncheckCODEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addGap(243, 243, 243)))
                        .addGap(153, 153, 153))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(97, 97, 97)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtCODE, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(txtNewPass)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnchangpass)
                                    .addGap(144, 144, 144)
                                    .addComponent(btnExit)))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btncheckCODE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsendMail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 41, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(77, 77, 77)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsendMail))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCODE, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncheckCODE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(txtNewPass))
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnchangpass)
                    .addComponent(btnExit))
                .addContainerGap(72, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        this.dispose();
        
        // TODO add your handling code here:
    }//GEN-LAST:event_btnExitActionPerformed
    NguoiDung nd = new NguoiDung();
    NguoiDungDAO nguoidungDAO = new NguoiDungDAO();
    private void btnsendMailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsendMailActionPerformed
        // TODO add your handling code here:
        if (checkmail()) {
            DialogHelper.alert(this, "mail không tồn tại mời nhập lại email khác !");
        }

        System.out.println(CODE);
    }//GEN-LAST:event_btnsendMailActionPerformed

    private void btncheckCODEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncheckCODEActionPerformed
        // TODO add your handling code here:
        if (txtCODE.getText().isBlank()) {
            DialogHelper.alert(this, "Bạn chưa nhập mã CODE");
            return;
        }
        try {
            if (CODE.equals(txtCODE.getText())) {
                txtNewPass.setEnabled(true);
            } else {
                DialogHelper.alert(this, "Mã CODE sai mời nhập lại mã CODE");
                txtNewPass.setEnabled(false);
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_btncheckCODEActionPerformed

    private void btnchangpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangpassActionPerformed
        // TODO add your handling code here:
        try {
            update();
            this.dispose();
            new DangNhap().setVisible(true);
        } catch (Exception e) {
        }

    }//GEN-LAST:event_btnchangpassActionPerformed

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
            java.util.logging.Logger.getLogger(rePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(rePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(rePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(rePass.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new rePass().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnchangpass;
    private javax.swing.JButton btncheckCODE;
    private javax.swing.JButton btnsendMail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtCODE;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtNewPass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        txtNewPass.setEnabled(false);
        txtCODE.setEnabled(false);
        setLocationRelativeTo(this);
    }

    @Override
    public void loadTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert() {

    }

    @Override
    public void update() {
        Email = txtEmail.getText();
        paSs = new String(txtNewPass.getPassword());

        try {
            if (nd != null) {
                nguoidungDAO.updateMatKhau(Email, paSs);
                DialogHelper.alert(this, "Thay đổi mật khẩu thành công !");
            }

        } catch (Exception e) {
            e.printStackTrace();
            DialogHelper.alert(this, "Thay đổi mật khẩu Không thành công !");
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        txtCODE.setText("");
        txtEmail.setText("");
        txtNewPass.setText("");
    }

    @Override
    public StringBuilder validateForm() {
        StringBuilder sb = new StringBuilder();
        String email = txtEmail.getText();
        String code = txtCODE.getText();
        String newpass = txtNewPass.getText();
        if (email.isBlank()) {
            sb.append("Email không được để trống ! ");
        }
        if (code.isBlank()) {
            sb.append("code không được để trống ! ");
        }
        if (email.isBlank()) {
            sb.append("mật khẩu không được để trống ! ");
        }
        return sb;
    }

    public boolean checkmail() {
        String code = HelpSendEmail.randomString(8);
        for (NguoiDung x : nguoidungDAO.selectAll()) {
            if (x.getEmail().equalsIgnoreCase(txtEmail.getText())) {
                HelpSendEmail.SendMail(txtEmail.getText(), "Lấy lại mật khẩu ! ", "Mã CODE của bạn là : " + code);
                CODE = code;
                txtCODE.setEnabled(true);
                return false;
            }
        }
        return true;
    }

    @Override
    public NguoiDung getModel() {
        if (validateForm() != null) {
            DialogHelper.alert(this, validateForm().toString());
            return null;
        }
        Email = txtEmail.getText();
        String code = txtCODE.getText();
        paSs = new String(txtNewPass.getPassword());
        System.out.println(paSs);
        return new NguoiDung(paSs, Email);
    }

    @Override
    public void setModel(NguoiDung model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
