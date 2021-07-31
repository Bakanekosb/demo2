/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui.QLSach;

import com.xpoly.DAO.DanhMucDAO;
import com.xpoly.DAO.DatSachDAO;
import com.xpoly.DAO.QuyenSachDAO;
import com.xpoly.DAO.SachUaThichDAO;
import com.xpoly.DAO.Sach_TacGiaDAO;
import com.xpoly.DAO.TacGiaDAO;
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.LoginHelper;
import com.xpoly.helper.TableColumnHider;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.DatSach;
import com.xpoly.model.NguoiDung;
import com.xpoly.model.QuyenSach;
import com.xpoly.model.SachUaThich;
import com.xpoly.model.Sach_Tg;
import com.xpoly.model.TacGia;
import com.xpoly.model.TuaSach;
import java.awt.GridLayout;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import jdk.jshell.Diag;

/**
 *
 * @author Dell
 */
public class QLTuaSachJFrame extends javax.swing.JFrame implements IService<Integer> {

    /**
     * Creates new form QLTuaSachJFrame
     */
    DanhMucDAO danhMucDAO = new DanhMucDAO();

    int pageNumber = 1, rowsOfPage = 6, rowIndex = 0;
    String keyword = "";
    int totalPage;
    DanhMuc danhMuc = new DanhMuc();
    static int maTuaSachChiTiet;

    DefaultComboBoxModel<DanhMuc> cboModel = new DefaultComboBoxModel<>();
    String[] columns = {"Mã tựa sách", "Tên tựa sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Giá tiền",
        "Mô tả", "Ghi chú", "Số lượng", "Danh mục", "Số lượng thích", "Like", "Đặt sách"};

    DefaultTableModel tblModel = new DefaultTableModel(columns, 0) {

        @Override
        public boolean isCellEditable(int row, int column) {
            //all cells false
            return false;
        }
    };
    TableColumnHider tblHider;
    JCheckBox hideCols[] = new JCheckBox[columns.length - 2];
    List<TuaSach> lst_tuaSach = new ArrayList<>();
    List<Sach_Tg> lst_stg;
    List<Integer> lst_sachUaThich;
    List<DatSach> lst_datSach;
    List<QuyenSach> lst_quyenSach;

    TuaSachDAO tuaSachDAO = new TuaSachDAO();
    SachUaThichDAO sachUaThichDAO = new SachUaThichDAO();
    DatSachDAO datSachDAO = new DatSachDAO();
    QuyenSachDAO quyenSachDAO = new QuyenSachDAO();

    String madm = "";

    public QLTuaSachJFrame() {
        LoginHelper.USER = new NguoiDung("ND001");
        lst_sachUaThich = sachUaThichDAO.selectMaTuaSachFromSachUaThichByMaND(LoginHelper.USER.getMaND());
        lst_datSach = datSachDAO.selectByMand(LoginHelper.USER.getMaND());
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
        jPanel2 = new javax.swing.JPanel();
        Panel_list = new javax.swing.JPanel();
        panel_chk = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_themSL = new javax.swing.JButton();
        btn_like = new javax.swing.JButton();
        btn_datSach = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tuaSach = new javax.swing.JTable();
        btn_last1 = new javax.swing.JButton();
        btn_next1 = new javax.swing.JButton();
        btn_prev1 = new javax.swing.JButton();
        btn_first1 = new javax.swing.JButton();
        Panel_grid = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        cbo_danhMuc = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btn_reload = new javax.swing.JButton();
        btn_chiTiet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ SÁCH");

        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panel_chkLayout = new javax.swing.GroupLayout(panel_chk);
        panel_chk.setLayout(panel_chkLayout);
        panel_chkLayout.setHorizontalGroup(
            panel_chkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 948, Short.MAX_VALUE)
        );
        panel_chkLayout.setVerticalGroup(
            panel_chkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jLabel3.setText("Ẩn/Hiện cột:");

        btn_themSL.setText("Thêm SL");
        btn_themSL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themSLActionPerformed(evt);
            }
        });

        btn_like.setText("Like");
        btn_like.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_likeActionPerformed(evt);
            }
        });

        btn_datSach.setText("Đặt sách");
        btn_datSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_datSachActionPerformed(evt);
            }
        });

        tbl_tuaSach.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_tuaSach.setRowHeight(30);
        tbl_tuaSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_tuaSachMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_tuaSach);

        btn_last1.setText(">|");
        btn_last1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_last1ActionPerformed(evt);
            }
        });

        btn_next1.setText(">>");
        btn_next1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_next1ActionPerformed(evt);
            }
        });

        btn_prev1.setText("<<");
        btn_prev1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prev1ActionPerformed(evt);
            }
        });

        btn_first1.setText("|<");
        btn_first1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_first1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panel_listLayout = new javax.swing.GroupLayout(Panel_list);
        Panel_list.setLayout(Panel_listLayout);
        Panel_listLayout.setHorizontalGroup(
            Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_listLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Panel_listLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(panel_chk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_listLayout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(btn_first1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_prev1)
                        .addGap(38, 38, 38)
                        .addComponent(btn_next1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_last1)
                        .addGap(91, 91, 91)
                        .addComponent(btn_themSL)
                        .addGap(18, 18, 18)
                        .addComponent(btn_datSach)
                        .addGap(18, 18, 18)
                        .addComponent(btn_like)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        Panel_listLayout.setVerticalGroup(
            Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_listLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(panel_chk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_first1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_prev1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_next1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_datSach)
                            .addComponent(btn_like)
                            .addComponent(btn_themSL))
                        .addComponent(btn_last1)))
                .addGap(21, 21, 21))
        );

        jPanel2.add(Panel_list, "card3");

        Panel_grid.setLayout(new java.awt.GridLayout(2, 5, 15, 15));
        jPanel2.add(Panel_grid, "card2");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Add");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        txt_timKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        cbo_danhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_danhMucActionPerformed(evt);
            }
        });

        jLabel8.setText("Danh mục:");

        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        btn_chiTiet.setText("Chi tiết");
        btn_chiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chiTietActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(21, 21, 21)
                .addComponent(cbo_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_search)
                .addGap(68, 68, 68))
            .addGroup(layout.createSequentialGroup()
                .addGap(648, 648, 648)
                .addComponent(btn_chiTiet)
                .addGap(18, 18, 18)
                .addComponent(btn_reload)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(cbo_danhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(btn_search)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(btn_reload)
                    .addComponent(btn_chiTiet))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased

    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        keyword = txt_timKiem.getText();
        loadTable();
    }//GEN-LAST:event_btn_searchActionPerformed

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

    private void cbo_danhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_danhMucActionPerformed
        // TODO add your handling code here:
        try {
            if (cbo_danhMuc.getSelectedIndex() >= 0) {
                danhMuc = (DanhMuc) cboModel.getSelectedItem();
                loadTable();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_cbo_danhMucActionPerformed

    private void tbl_tuaSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tuaSachMouseClicked
        // TODO add your handling code here:
        rowIndex = tbl_tuaSach.getSelectedRow();
        System.out.println(rowIndex);
        if (tblModel.getValueAt(rowIndex, tbl_tuaSach.getColumn("Like").getModelIndex()).toString().equals("Like")) {
            btn_like.setText("Unlike");
        } else {
            btn_like.setText("Like");
        }
        if (datSachDAO.datDuocKhong(LoginHelper.USER.getMaND(), (Integer) tblModel.getValueAt(rowIndex, 0))) {
            btn_datSach.setEnabled(true);
        } else {
            btn_datSach.setEnabled(false);
        }
    }//GEN-LAST:event_tbl_tuaSachMouseClicked

    private void btn_likeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_likeActionPerformed
        // TODO add your handling code here:        
        int maTuaSach = (Integer) tblModel.getValueAt(rowIndex, 0);
        int soLuongLike = 0;
        if (btn_like.getText().equals("Like")) {
            try {
                sachUaThichDAO.insert(new SachUaThich(LoginHelper.USER.getMaND(), maTuaSach));
                tblModel.setValueAt("Like", rowIndex, tbl_tuaSach.getColumn("Like").getModelIndex());
                tblModel.setValueAt(sachUaThichDAO.getSoLuongLike(maTuaSach), rowIndex, tbl_tuaSach.getColumn("Số lượng thích").getModelIndex());
                btn_like.setText("Unlike");
                soLuongLike = sachUaThichDAO.getSoLuongLike(maTuaSach);
                tuaSachDAO.updateSoLuongLike(soLuongLike, maTuaSach);
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            try {
                sachUaThichDAO.deleteByND(maTuaSach, LoginHelper.USER.getMaND());
                tblModel.setValueAt("", rowIndex, tbl_tuaSach.getColumn("Like").getModelIndex());
                tblModel.setValueAt(sachUaThichDAO.getSoLuongLike(maTuaSach), rowIndex, tbl_tuaSach.getColumn("Số lượng thích").getModelIndex());
                btn_like.setText("Like");
                soLuongLike = sachUaThichDAO.getSoLuongLike(maTuaSach);
                tuaSachDAO.updateSoLuongLike(soLuongLike, maTuaSach);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_btn_likeActionPerformed
//trangthai int default 0  not null, -- (sansangchomuon = 0, dangmuon = 1, duocdat = 2 )
//    trangthai int not null, --(dangdat = 0, cholaysach = 1, huydat = 2 )
    private void btn_datSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_datSachActionPerformed
        // TODO add your handling code here:
        try {
            int trangThai = 0;
            Date ngayHen = null;
            int maTuaSach = (Integer) tblModel.getValueAt(rowIndex, 0);
            lst_quyenSach = quyenSachDAO.selectSachSanSangChoMuonByTuaSach(maTuaSach);
            if (!lst_quyenSach.isEmpty()) {
                trangThai = 1;
                ngayHen = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
                
            }

            datSachDAO.insert(new DatSach(maTuaSach, trangThai, LoginHelper.USER.getMaND(), EzHelper.now(), ngayHen));
            JOptionPane.showMessageDialog(this, "dat sach thanh cong");
            tblModel.setValueAt(ngayHen == null ? "Đang đặt" : ngayHen, rowIndex, tbl_tuaSach.getColumn("Đặt sách").getModelIndex());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_datSachActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_btn_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int maTuaSach = (Integer) tblModel.getValueAt(rowIndex, 0);
        int soSachDocTaiCho = quyenSachDAO.soSachDocTaiCho(maTuaSach);
        String tacGia = (String) tblModel.getValueAt(rowIndex, 2);

        new UpdateSach(tuaSachDAO.selectById(maTuaSach), tacGia, soSachDocTaiCho).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void btn_themSLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themSLActionPerformed
        // TODO add your handling code here:
        nhapThemSoLuongSach();

    }//GEN-LAST:event_btn_themSLActionPerformed

    private void btn_chiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chiTietActionPerformed
        // TODO add your handling code here:
        maTuaSachChiTiet = (Integer) tblModel.getValueAt(rowIndex, 0);
        System.out.println(maTuaSachChiTiet);
        new ChiTietSachJFrame(maTuaSachChiTiet).setVisible(true);
    }//GEN-LAST:event_btn_chiTietActionPerformed

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
            java.util.logging.Logger.getLogger(QLTuaSachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTuaSachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTuaSachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTuaSachJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLTuaSachJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_grid;
    private javax.swing.JPanel Panel_list;
    private javax.swing.JButton btn_chiTiet;
    private javax.swing.JButton btn_datSach;
    private javax.swing.JButton btn_first1;
    private javax.swing.JButton btn_last1;
    private javax.swing.JButton btn_like;
    private javax.swing.JButton btn_next1;
    private javax.swing.JButton btn_prev1;
    public static javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_themSL;
    private javax.swing.JComboBox<String> cbo_danhMuc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel panel_chk;
    private javax.swing.JTable tbl_tuaSach;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables

    @Override
    public void init() {

        for (int i = 0; i < 10; i++) {
            JPanel jpanel = new JPanel();
            jpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

            javax.swing.GroupLayout jpanelLayout = new javax.swing.GroupLayout(jpanel);
            jpanel.setLayout(jpanelLayout);
            jpanelLayout.setHorizontalGroup(
                    jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 162, Short.MAX_VALUE)
            );
            jpanelLayout.setVerticalGroup(
                    jpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGap(0, 227, Short.MAX_VALUE)
            );

            Panel_grid.add(jpanel);
        }

        cbo_danhMuc.setModel((DefaultComboBoxModel) cboModel);
        loadComboboxDanhMuc();
        tbl_tuaSach.setModel(tblModel);
        tblHider = new TableColumnHider(tbl_tuaSach);

        for (int i = 2; i < columns.length - 2; i++) {
            hideCols[i - 2] = new JCheckBox(columns[i], true);
            hideCols[i - 2].addActionListener(new java.awt.event.ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent e) {
                    try {
                        for (int i = 2; i < columns.length - 2; i++) {
                            if (e.getActionCommand().contains(columns[i]) && hideCols[i - 2].isSelected()) {
                                tblHider.show(columns[i], i + "", columns);
                            } else if (e.getActionCommand().contains(columns[i]) && !hideCols[i - 2].isSelected()) {
                                tblHider.hide(columns[i], i + "");
                            }
                            System.out.println(columns.length);
                        }
                    } catch (Exception ex) {
                    }

                }
            });
            panel_chk.add(hideCols[i - 2]);
        }
        panel_chk.setLayout(new GridLayout(1, 10));

        lst_datSach = datSachDAO.selectByMand(LoginHelper.USER.getMaND());

        loadTable();
    }
//{"Mã tựa sách", "Tên tựa sách", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Giá tiền",
//        "Mô tả", "Ghi chú", "Số lượng", "Danh mục", "Số lượng thích"};

    @Override
    public void loadTable() {
        tblModel.setRowCount(0);
        try {
            int total = (int) Math.ceil((float) tuaSachDAO.getTotalRows(keyword, 0, danhMuc.getMaDanhMuc()) / rowsOfPage);
            totalPage = total > 0 ? total : 1;
            pageNumber = pageNumber > totalPage ? 1 : pageNumber;
            lst_tuaSach = tuaSachDAO.selectByKeyword(keyword, pageNumber, rowsOfPage, 0, danhMuc.getMaDanhMuc());
            int i = 0;
            if (!lst_tuaSach.isEmpty()) {
                for (TuaSach x : lst_tuaSach) {

                    String like = lst_sachUaThich.contains(x.getMaTuaSach()) ? "Like" : "";
                    btn_like.setText(like.equals("Like") ? "Like" : "Unlike");
                    String datSach = "";
                    String tacGia = new Sach_TacGiaDAO().selectTacgia(x.getMaTuaSach());

                    for (DatSach y : lst_datSach) {
                        if (y.getMaTuaSach() == x.getMaTuaSach()) {
                            if (y.getTrangThai() == 0) {
                                datSach = "Đang đặt";
                            } else if (y.getTrangThai() == 1) {
                                datSach = EzHelper.toString(y.getNgayHenLaySach());
                            } else {
                                datSach = "Đã hủy";
                            }
                        }
                    }
                    x.setSoLuotThich(sachUaThichDAO.getSoLuongLike(x.getMaTuaSach()));
                    System.out.println("so luong thich = " + x.getSoLuotThich() + " matuasach = " + x.getMaTuaSach());
                    tblModel.addRow(new Object[]{
                        x.getMaTuaSach(), x.getTenTuaSach(), tacGia, x.getNxb(), x.getNamxb(),
                        x.getSoTrang(), x.getGiaTien(), x.getMoTa(), x.getGhiChu(), x.getSoLuong(),
                        EzHelper.MAP_DANHMUC.get(x.getMadm()), x.getSoLuotThich(), like, datSach});

                }
            }
            System.out.println(pageNumber);
            buttonEnabled();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("loi loadtable");
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
    public Integer getModel() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setModel(Integer model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void buttonEnabled() {
        System.out.println(pageNumber + " in button enabled");
        btn_first1.setEnabled(pageNumber > 1);
        btn_prev1.setEnabled(pageNumber > 1);
        btn_last1.setEnabled(pageNumber < totalPage);
        btn_next1.setEnabled(pageNumber < totalPage);
    }

    private void loadComboboxDanhMuc() {
        cboModel.addElement(new DanhMuc("", "All"));
        for (DanhMuc x : danhMucDAO.selectAll()) {
            cboModel.addElement(x);
        }
    }

    private void nhapThemSoLuongSach() {
        int maTuaSach = (Integer) tblModel.getValueAt(rowIndex, 0);
        TuaSach model = tuaSachDAO.selectById(maTuaSach);
        try {
            int slthem = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập thêm số lượng sách"));
            int soLuong = model.getSoLuong();
            soLuong += slthem;
            tuaSachDAO.updateSL(maTuaSach, soLuong);
            for (int i = 0; i < slthem; i++) {
                quyenSachDAO.insert(new QuyenSach("", true, model.getGhiChu(), maTuaSach));
                System.out.println("something");

            }
            loadTable();
        } catch (Exception e) {
            DialogHelper.alert(jPanel2, "Error");
        }
    }
}
