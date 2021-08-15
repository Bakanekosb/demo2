/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui.QLSach;

import com.xpoly.DAO.DanhMucDAO;
import com.xpoly.DAO.NguoiDungDAO;
import com.xpoly.DAO.QuyenSachDAO;
import com.xpoly.DAO.Sach_TacGiaDAO;
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.LoginHelper;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.NguoiDung;
import com.xpoly.model.QuyenSach;
import com.xpoly.model.Sach_Tg;
import com.xpoly.model.TacGia;
import com.xpoly.model.TuaSach;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Dell
 */
public class UpdateSach extends javax.swing.JFrame implements IService<TuaSach> {

    TuaSachDAO tuaSachDAO = new TuaSachDAO();
    QuyenSachDAO quyenSachDAO = new QuyenSachDAO();
    DanhMucDAO danhMucDAO = new DanhMucDAO();
    Sach_TacGiaDAO stgDAO = new Sach_TacGiaDAO();

    DanhMuc danhMuc = new DanhMuc();
    static TuaSach tuaSachUpdate = new TuaSach();
    QuyenSach quyenSach = new QuyenSach();
    Sach_Tg stg = new Sach_Tg();
    List<QuyenSach> lst_qSach = new ArrayList<>();
    List<TuaSach> lst_tSach = new ArrayList<>();
    List<Sach_Tg> lst_stg = new ArrayList<>();

    String viTriXep;
    int docTaiCho;
    boolean isAD = true;
    int soLuong;
    int indexCombobox = 0;
    boolean chonTacGia = false;

    DefaultComboBoxModel<DanhMuc> cboModel = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> cboModelNam = new DefaultComboBoxModel<>(new String[]{"AD", "BC"});

    /**
     * Creates new form ThemSach
     */
    public UpdateSach(TuaSach model, String tacGia, int soSachDocTaiCho) {
//        LoginHelper.USER = new NguoiDungDAO().selectById("ND001");
        initComponents();
        setLocationRelativeTo(null);
        tuaSachUpdate = model;
        init();
        setModel(model, tacGia, soSachDocTaiCho);
        System.out.println(model.toString());
        System.out.println(tacGia);
        System.out.println(soSachDocTaiCho);
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
        lbl_cover = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbo_danhMuc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txt_tenSach = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_tgupdate = new javax.swing.JTextField();
        btn_chonTg = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txt_nxb = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_namxb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_gia = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_soTrang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_soLuong = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_ghiChu = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_moTa = new javax.swing.JTextArea();
        txt_docTaiCho = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_viTri = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cbo_namxb = new javax.swing.JComboBox<>();
        btn_clear = new javax.swing.JButton();
        btn_save = new javax.swing.JButton();
        btn_cancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THÔNG TIN SÁCH");

        lbl_cover.setBackground(new java.awt.Color(255, 255, 255));
        lbl_cover.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_coverMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sách", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel8.setText("Danh mục:");

        cbo_danhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_danhMucActionPerformed(evt);
            }
        });

        jLabel4.setText("Tên sách:");

        jLabel5.setText("Tác giả:");

        txt_tgupdate.setEditable(false);

        btn_chonTg.setText("+");
        btn_chonTg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonTgActionPerformed(evt);
            }
        });

        jLabel6.setText("Nhà xuất bản:");

        jLabel7.setText("Năm xuất bản:");

        jLabel2.setText("Giá tiền: (ngàn VND)");

        jLabel9.setText("Số trang:");

        jLabel10.setText("Số lượng:");

        txt_soLuong.setEnabled(false);

        txt_ghiChu.setColumns(20);
        txt_ghiChu.setRows(5);
        jScrollPane1.setViewportView(txt_ghiChu);

        jLabel11.setText("Mô tả:");

        jLabel12.setText("Ghi chú:");

        txt_moTa.setColumns(20);
        txt_moTa.setRows(5);
        jScrollPane2.setViewportView(txt_moTa);

        txt_docTaiCho.setEnabled(false);

        jLabel13.setText("Đọc tại chỗ:");

        txt_viTri.setEnabled(false);

        jLabel3.setText("Vị trí xếp:");

        cbo_namxb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AD", "BC" }));
        cbo_namxb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_namxbActionPerformed(evt);
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
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tenSach)
                            .addComponent(cbo_danhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel10)))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_tgupdate)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addComponent(txt_nxb)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_namxb, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbo_namxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_soTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_docTaiCho, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_gia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_viTri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_chonTg)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbo_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_tenSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txt_tgupdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_chonTg))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txt_nxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_namxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_gia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbo_namxb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txt_soLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_viTri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_soTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txt_docTaiCho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        btn_clear.setText("Clear");

        btn_save.setText("Save");
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });

        btn_cancel.setText("Cancel");
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_cover, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btn_cancel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                        .addComponent(btn_save, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_clear, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_cover, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_clear)
                        .addGap(18, 18, 18)
                        .addComponent(btn_save)
                        .addGap(18, 18, 18)
                        .addComponent(btn_cancel)
                        .addGap(34, 34, 34))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_danhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_danhMucActionPerformed
        // TODO add your handling code here:
        try {
            if (cbo_danhMuc.getSelectedIndex() >= 0) {
                danhMuc = (DanhMuc) cboModel.getSelectedItem();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_danhMucActionPerformed

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed
        // TODO add your handling code here:
        update();
        this.dispose();
    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_chonTgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonTgActionPerformed
        // TODO add your handling code here:
        ChonTacGiaJFrame chonTG = new ChonTacGiaJFrame(0);
        chonTG.setVisible(true);
        chonTacGia = true;
    }//GEN-LAST:event_btn_chonTgActionPerformed

    private void lbl_coverMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_coverMouseClicked
        // TODO add your handling code here:
        EzHelper ez = new EzHelper();
        ez.selectImage(lbl_cover);
    }//GEN-LAST:event_lbl_coverMouseClicked

    private void cbo_namxbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_namxbActionPerformed
        // TODO add your handling code here:
        if (cbo_namxb.getSelectedIndex() == 0) {
            isAD = true;
        } else {
            isAD = false;
        }
    }//GEN-LAST:event_cbo_namxbActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btn_cancelActionPerformed

    public static void hienThiTG(List<TacGia> lst) {
        List<String> namesList = lst.stream().map(p -> p.getTenTg()).collect(Collectors.toList());
        String s = String.join(";", namesList);

        txt_tgupdate.setText(s);

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
            java.util.logging.Logger.getLogger(UpdateSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UpdateSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UpdateSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UpdateSach.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new UpdateSach().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_chonTg;
    private javax.swing.JButton btn_clear;
    private javax.swing.JButton btn_save;
    private javax.swing.JComboBox<String> cbo_danhMuc;
    private javax.swing.JComboBox<String> cbo_namxb;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_cover;
    private javax.swing.JTextField txt_docTaiCho;
    private javax.swing.JTextArea txt_ghiChu;
    private javax.swing.JTextField txt_gia;
    private javax.swing.JTextArea txt_moTa;
    private javax.swing.JTextField txt_namxb;
    private javax.swing.JTextField txt_nxb;
    private javax.swing.JTextField txt_soLuong;
    private javax.swing.JTextField txt_soTrang;
    private javax.swing.JTextField txt_tenSach;
    public static javax.swing.JTextField txt_tgupdate;
    private javax.swing.JTextField txt_viTri;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {
        cbo_danhMuc.setModel((DefaultComboBoxModel) cboModel);
        loadComboboxDanhMuc();
        lst_tSach = tuaSachDAO.selectAll();
        cbo_namxb.setModel(cboModelNam);
        cbo_danhMuc.setEnabled(false);
        txt_tenSach.setEditable(false);
        txt_nxb.setEditable(false);
        txt_namxb.setEditable(false);
        txt_soTrang.setEditable(false);
        txt_gia.setEditable(false);
        txt_moTa.setEditable(false);
        txt_nxb.setEditable(false);
        txt_nxb.setEditable(false);
        btn_chonTg.setVisible(false);
        btn_clear.setVisible(false);
        btn_save.setVisible(false);
        lbl_cover.setEnabled(false);
    }

    @Override
    public void loadTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insert() {

    }

    public void themQuyenSach() {

    }

    @Override
    public void update() {
        if (tuaSachUpdate != null) {
            try {
                tuaSachDAO.update(getModel());

                if (chonTacGia) {
                    stgDAO.delete(tuaSachUpdate.getMaTuaSach());
                    for (TacGia x : ChonTacGiaJFrame.lst_chonTG) {
                        System.out.println("chon tac gia");
                        stgDAO.insert(new Sach_Tg(tuaSachUpdate.getMaTuaSach(), x.getMaTg()));
                    }
                }
                if (soLuong > tuaSachUpdate.getSoLuong()) {
                    for (int i = 0; i < soLuong - tuaSachUpdate.getSoLuong(); i++) {
                        quyenSach = new QuyenSach(viTriXep, i >= (docTaiCho - new QuyenSachDAO().soSachDocTaiCho(tuaSachUpdate.getMaTuaSach())),
                                tuaSachUpdate.getGhiChu(), tuaSachUpdate.getMaTuaSach());
                        quyenSachDAO.insert(quyenSach);
                    }
                }
                DialogHelper.alert(jPanel1, "Thêm thành công");
            } catch (Exception e) {
                DialogHelper.alert(jPanel1, "Thêm không thành công");
            }
        } else {
            DialogHelper.alert(jPanel1, "Fail");
        }
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        cbo_danhMuc.setSelectedIndex(0);
        txt_tenSach.setText("");
        txt_tgupdate.setText("");
        txt_nxb.setText("");
        txt_namxb.setText("");
        txt_soTrang.setText("");
        txt_gia.setText("");
        txt_soLuong.setText("");
        txt_docTaiCho.setText("");
        txt_viTri.setText("");
        txt_soTrang.setText("");
    }

    @Override
    public StringBuilder validateForm() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TuaSach getModel() {
        String maDanhMuc = danhMuc.getMaDanhMuc();
        String tenSach = txt_tenSach.getText();
        String tacGia = txt_tgupdate.getText();
        String nxb = txt_nxb.getText();
        viTriXep = txt_viTri.getText();
        String moTa = txt_moTa.getText();
        String ghiChu = txt_ghiChu.getText();

        if (EzHelper.blank(txt_tenSach, "Tên sách", jPanel1)
                || EzHelper.blank(txt_tgupdate, "Tên tác giả", jPanel1)) {
            return null;
        }

        int namxb = EzHelper.isInt(txt_namxb, "Năm xuất bản", jPanel1);
        if (namxb < 0) {
            return null;
        }
        int soTrang = EzHelper.isInt(txt_soTrang, "Số trang", jPanel1);
        if (soTrang < 0) {
            return null;
        }
        soLuong = EzHelper.isInt(txt_soLuong, "Số lượng", jPanel1);
        if (soLuong < 0) {
            return null;
        }
        docTaiCho = EzHelper.isInt(txt_docTaiCho, "Số sách đọc tại chỗ", jPanel1);
        if (docTaiCho < 0) {
            return null;
        }
        double gia = EzHelper.isDouble(txt_gia, "Giá tiền", jPanel1);
        if (gia < 0) {
            return null;
        };
        Calendar calendar = Calendar.getInstance();

        if (namxb > (calendar.get(Calendar.YEAR))) {
            DialogHelper.alert(jPanel1, "Năm xuất bản không được lớn hơn năm hiện tại");
            return null;
        }

        if (docTaiCho > soLuong) {
            DialogHelper.alert(jPanel1, "Số lượng sách đọc tại chỗ không được lớn hơn số lượng sách");
            return null;
        }

        if (soLuong > 0 && docTaiCho == 0) {
            DialogHelper.alert(jPanel1, "Cần tối thiểu 1 quyển sách đọc tại chỗ");
            return null;
        }

        String anh = lbl_cover.getToolTipText();
        System.out.println(anh);

        for (TuaSach x : lst_tSach) {
            if (x.getTenTuaSach().equalsIgnoreCase(tenSach)
                    && x.getNxb().equalsIgnoreCase(nxb)
                    && x.getNamxb() == namxb
                    && x.getSoTrang() == soTrang) {
                lst_stg = stgDAO.selectAll();
            }
        }

        namxb = isAD ? namxb : namxb * (-1);

        return new TuaSach(tuaSachUpdate.getMaTuaSach(), tenSach, nxb, namxb, soTrang, gia, moTa, ghiChu, soLuong, maDanhMuc, anh);
// public TuaSach(String tenTuaSach, String nxb, int namxb, int soTrang, double giaTien, String moTa, String ghiChu, int soLuong, String madm) 

    }

    private void loadComboboxDanhMuc() {
        List<DanhMuc> lst = danhMucDAO.selectAll();
        for (DanhMuc x : lst) {
            cboModel.addElement(x);
            if (x.getMaDanhMuc().equalsIgnoreCase(tuaSachUpdate.getMadm())) {
                indexCombobox = lst.indexOf(x);
            }
        }
    }

    public void setModel(TuaSach model, String tacGia, int soSachDocTaiCho) {
        cbo_danhMuc.setSelectedIndex(indexCombobox);
        txt_tenSach.setText(model.getTenTuaSach());
        txt_tgupdate.setText(tacGia);
        txt_nxb.setText(model.getNxb());
        txt_namxb.setText(model.getNamxb() + "");
        txt_soTrang.setText(model.getSoTrang() + "");
        txt_gia.setText(model.getGiaTien() + "");
        txt_soLuong.setText(model.getSoLuong() + "");
        txt_docTaiCho.setText(soSachDocTaiCho + "");
        if (model.getAnh() != null) {
            lbl_cover.setIcon(EzHelper.readImg(model.getAnh()));
        }else{
            lbl_cover.setIcon(EzHelper.readImg("2.png"));
        }
    }

    @Override
    public void setModel(TuaSach model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
