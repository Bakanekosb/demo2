/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui.PhieuMuon;

import QLPhieuTra.PhieuTra;
import com.xpoly.DAO.PhieuMuonCT_DAO;
import com.xpoly.DAO.PhieuMuon_DAO;
import com.xpoly.DAO.QuyenSachDAO;
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.Service.PhieuMuon_Service;
import com.xpoly.helper.Constant;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.PMCT;
import com.xpoly.ui.MainJFrame;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class PhieuMuonDangMuonJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form PhieuMuonDangMuonJInternalFrame
     */
    
    Connection connection = JdbcHelper.ketNoi();
    DefaultTableModel defaultTableModelA = new DefaultTableModel();
    DefaultTableModel defaultTableModelB = new DefaultTableModel();
    DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
    int index = 0;
    int cboIndex = 0;
    PhieuMuon_DAO phieuMuonDAO = new PhieuMuon_DAO();
    String ngayHenTra;
    Date ngayMuon;
    int indexPMCT = 0;
    PhieuMuon_Service service = new PhieuMuon_Service();

    public PhieuMuonDangMuonJInternalFrame() {
        initComponents();
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        defaultTableModelA.setColumnIdentifiers(new String[]{"Mã Phiếu Mượn", "Mã Bạn Đọc", "Tên Bạn Đọc", "Ngày Mượn", "Mã Người Tạo Phiếu", "Đã trả"});
        defaultTableModelB.setColumnIdentifiers(new String[]{"Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Tựa Sách", "Ngày Gia Hạn", "Ngày hẹn trả", "Số Lần Gia Hạn", "Ghi Chú", "Trạng thái"});
        tblA.setModel(defaultTableModelA);
        tblB.setModel(defaultTableModelB);
        cbo_findBy.setModel(cboModel);
        cbo_findBy.addItem("Mã phiếu mượn");
        cbo_findBy.addItem("Mã người dùng");
        cbo_findBy.addItem("Mã tựa sách");
        cbo_findBy.addItem("Mã quyển sách");
        fillToTable();
    }

    public String ngayHenTra(Date d, Date d0) {
        d = (d == null ? d0 : d);
        System.out.println(d);
        Date ngayHen = Date.from(d.toInstant().plus(7, ChronoUnit.DAYS));
        return EzHelper.toString(ngayHen);

    }

    public void fillToTable() {

        defaultTableModelA.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT distinct dbo.phieumuon.maphieumuon,mabandoc,hoten,ngaymuon,nguoitaophieu,(SELECT hoten FROM dbo.nguoidung WHERE mand=nguoitaophieu)"
                + "maquyensach \n"
                + "                 FROM dbo.pmct INNER JOIN dbo.phieumuon ON phieumuon.maphieumuon = pmct.maphieumuon INNER JOIN dbo.nguoidung ON nguoidung.mand = phieumuon.mabandoc WHERE pmct.trangthai=0");) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int matuasach = Integer.parseInt(resultSet.getString(1));
                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getString(5),
                    phieuMuonDAO.soSachDaTra(matuasach)[0] + "/" + phieuMuonDAO.soSachDaTra(matuasach)[1]
                });
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }

    void loadTablePMCT(int maphieumuon) {

        PhieuMuonCT_DAO pmctDAO = new PhieuMuonCT_DAO();
        List<PMCT> lst_pmct = pmctDAO.selectByMaPhieuMuon(maphieumuon);
        defaultTableModelB.setRowCount(0);
        for (PMCT x : lst_pmct) {
            defaultTableModelB.addRow(new Object[]{x.getMaPhieuMuon(), x.getMaQuyenSach(),
                new TuaSachDAO().selectById(new QuyenSachDAO().selectById(x.getMaQuyenSach()).getMaTuaSach()).getTenTuaSach(),
                x.getNgayGiaHan(), x.getSoLanGiaHan(), ngayHenTra(x.getNgayGiaHan(), ngayMuon), x.getGhiChu(), trangThaiPMCT(x.getTrangThai())
            });
        }
//                defaultTableModelB.setColumnIdentifiers(new String[]{"Mã Phiếu Mượn", "Mã Quyển Sách", "Tên Tựa Sách", "Ngày Gia Hạn", "Số Lần Gia Hạn", "Ghi Chú", "Vị Trí Quyển Sách"});
    }

    String trangThaiPMCT(int trangThai) {
        return trangThai == 0 ? "Đang mượn" : trangThai == 1 ? "Đã trả" : "Quá hạn trả";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblA = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        btn_search = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblB = new javax.swing.JTable();
        cbo_findBy = new javax.swing.JComboBox<>();
        btn_giaHan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Phiếu Đang Mượn");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu trả"));

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
        tblA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblA);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

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

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Phiếu trả chi tiết"));

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
        tblB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblB);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 847, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cbo_findBy.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã phiếu mượn", "Mã người dùng", "Mã quyển sách" }));
        cbo_findBy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_findByActionPerformed(evt);
            }
        });

        btn_giaHan.setText("Gia hạn");
        btn_giaHan.setEnabled(false);
        btn_giaHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_giaHanActionPerformed(evt);
            }
        });

        jButton1.setText("Thêm phiếu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(cbo_findBy, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_search)
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_giaHan, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(btn_search)
                    .addComponent(cbo_findBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_giaHan)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAMouseClicked
        // TODO add your handling code here:
        index = tblA.getSelectedRow();
        String maPhieuMuon = (String) (defaultTableModelA.getValueAt(index, 0));
        defaultTableModelB.setRowCount(0);
        String d1 = (String) defaultTableModelA.getValueAt(index, 3);
        ngayMuon = EzHelper.toDate2(d1);
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT maphieumuon,pmct.maquyensach,(SELECT tentuasach FROM dbo.tuasach WHERE matuasach=dbo.quyensach.matuasach),ngaygiahan,solangiahan,pmct.ghichu, pmct.trangthai  FROM dbo.pmct INNER JOIN dbo.quyensach ON quyensach.maquyensach = pmct.maquyensach WHERE maphieumuon=?");) {
            preparedStatement.setString(1, maPhieuMuon);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                String d = resultSet.getString(4);
                Date date = d == null ? null : EzHelper.toDate2(d);
                defaultTableModelB.addRow(new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
                    ngayHenTra(date, ngayMuon),
                    resultSet.getString(5), resultSet.getString(6), trangThaiPMCT(Integer.parseInt(resultSet.getString(7)))});
        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }//GEN-LAST:event_tblAMouseClicked

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased

    }//GEN-LAST:event_txt_timKiemKeyReleased

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:

        defaultTableModelA.setRowCount(0);
        defaultTableModelB.setRowCount(0);
        String findBy = (cboIndex == 0 ? " phieumuon.maphieumuon=?" : (cboIndex == 1) ? " phieumuon.mabandoc=?" : (cboIndex == 2) ? " matuasach = ? ": "pmct.maquyensach=?");

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT distinct dbo.phieumuon.maphieumuon,mabandoc,hoten,ngaymuon,nguoitaophieu,(SELECT hoten FROM dbo.nguoidung WHERE mand=nguoitaophieu)"
            + "                 FROM dbo.pmct INNER JOIN dbo.phieumuon ON phieumuon.maphieumuon = pmct.maphieumuon INNER JOIN dbo.nguoidung ON nguoidung.mand = phieumuon.mabandoc "
            + " INNER JOIN dbo.quyensach ON pmct.maquyensach = quyensach.maquyensach"
            + " WHERE pmct.trangthai=0 AND " + findBy);) {
        preparedStatement.setString(1, txt_timKiem.getText());
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int matuasach = Integer.parseInt(resultSet.getString(1));
            ngayMuon = EzHelper.toDate2(resultSet.getString(4));
            defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2),
                resultSet.getString(3), resultSet.getString(4),
                resultSet.getString(5),
                phieuMuonDAO.soSachDaTra(matuasach)[0] + "/" + phieuMuonDAO.soSachDaTra(matuasach)[1]
            });
        }
        if (defaultTableModelA.getRowCount() > 0) {
            loadTablePMCT(Integer.parseInt(defaultTableModelA.getValueAt(0, 0).toString()));
        }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tblBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBMouseClicked
        // TODO add your handling code here:
        indexPMCT = tblB.getSelectedRow();
        btn_giaHan.setEnabled(true);
    }//GEN-LAST:event_tblBMouseClicked

    private void cbo_findByActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_findByActionPerformed
        // TODO add your handling code here:
        cboIndex = cbo_findBy.getSelectedIndex();
    }//GEN-LAST:event_cbo_findByActionPerformed

    private void btn_giaHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_giaHanActionPerformed
        // TODO add your handling code here:
        int soLanGiaHan = Integer.parseInt(defaultTableModelB.getValueAt(indexPMCT, 5).toString());
        int maPhieuMuon = Integer.parseInt(defaultTableModelB.getValueAt(indexPMCT, 0).toString());
        int maQuyenSach = Integer.parseInt(defaultTableModelB.getValueAt(indexPMCT, 1).toString());
        System.out.println(maPhieuMuon);
        System.out.println(maQuyenSach);
        if(soLanGiaHan >= Constant.SO_LAN_GIA_HAN_TOI_DA){
            DialogHelper.alert(jPanel1, "Đã đạt số lần gia hạn tối đa");
            return;
        }
        if(service.giaHanDuoc(maPhieuMuon, maQuyenSach)){
            service.giaHanSach(maPhieuMuon, maQuyenSach);
            defaultTableModelB.setValueAt(soLanGiaHan + 1, indexPMCT, 5);
            defaultTableModelB.setValueAt(EzHelper.now(), indexPMCT, 3);
            defaultTableModelB.setValueAt(EzHelper.addDate(EzHelper.now(), 7), indexPMCT, 4);
            DialogHelper.alert(jPanel1, "Gia hạn thành công");
        }

    }//GEN-LAST:event_btn_giaHanActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        MainJFrame.showChucNang(new ThemPhieuMuonJInternalFrame());
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String[] args) {

//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new PhieuMuonDangMuonJInternalFrame().setVisible(true);
//            }
//        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_giaHan;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cbo_findBy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblA;
    private javax.swing.JTable tblB;
    private javax.swing.JTextField txt_timKiem;
    // End of variables declaration//GEN-END:variables
}
