/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLPhieuTra;

import static QLPhieuTra.Mail.guiMail;
import com.xpoly.helper.JdbcHelper;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class QLPhieuTra extends javax.swing.JFrame {

    /**
     * Creates new form QLPhieuTra
     */
    Connection connection = JdbcHelper.ketNoi();
    DefaultTableModel defaultTableModelA = new DefaultTableModel();
    DefaultTableModel defaultTableModelB = new DefaultTableModel();
    ArrayList<Integer> arrayList = new ArrayList<>();
    int index;

    public QLPhieuTra() {
        initComponents();
        setLocationRelativeTo(null);
        defaultTableModelA.setColumnIdentifiers(new String[]{"Mã Sách", "Tên Người Mượn", "Mã Phiếu Mượn", "Ngày hẹn trả", "trang thái"});
        defaultTableModelB.setColumnIdentifiers(new String[]{"Mã Sách", "Tên Người Mượn", "Mã Phiếu Mượn", "Ngày hẹn trả", "trang thái"});
        tblSachMuon.setModel(defaultTableModelA);
        tblSachTra.setModel(defaultTableModelB);
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
        jPanel2 = new javax.swing.JPanel();
        txtMaNguoiMuon = new javax.swing.JTextField();
        tbnTimKiem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSachMuon = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        btnTraSach = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSachTra = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        btnXoaKhoiDS = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButton11 = new javax.swing.JButton();
        txtNguoiTaoPhieu = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnHoanTat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 195, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        tbnTimKiem.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tbnTimKiem.setText("Tìm kiếm");
        tbnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnTimKiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addComponent(txtMaNguoiMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(tbnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(170, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaNguoiMuon)
                    .addComponent(tbnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("thông tin hoá đơn"));

        tblSachMuon.setModel(new javax.swing.table.DefaultTableModel(
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
        tblSachMuon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMuonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSachMuon);

        jButton2.setText("|<");

        jButton3.setText("<");

        jButton4.setText(">");

        jButton5.setText(">|");

        btnTraSach.setText("Trả sách");
        btnTraSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTraSachMouseClicked(evt);
            }
        });
        btnTraSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)
                        .addGap(225, 225, 225)
                        .addComponent(btnTraSach, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 21, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(btnTraSach))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("danh sách sách trả"));

        tblSachTra.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblSachTra);

        jButton6.setText("|<");

        jButton7.setText("<");

        jButton8.setText(">");

        jButton9.setText(">|");

        btnXoaKhoiDS.setText("Xoá quyển sách");
        btnXoaKhoiDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaKhoiDSActionPerformed(evt);
            }
        });

        jButton10.setText("Xoá tất");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(btnXoaKhoiDS)
                .addGap(18, 18, 18)
                .addComponent(jButton10)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6)
                    .addComponent(jButton7)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(btnXoaKhoiDS)
                    .addComponent(jButton10))
                .addGap(21, 21, 21))
        );

        jButton11.setText("In Phiếu");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jLabel1.setText("Mã người tạo phiếu");

        btnHoanTat.setText("Hoàn tất");
        btnHoanTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHoanTatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnHoanTat, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButton11))
                    .addComponent(txtNguoiTaoPhieu)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNguoiTaoPhieu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton11)
                    .addComponent(btnHoanTat))
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
public void fillToTable() {
        arrayList.removeAll(arrayList);
        defaultTableModelA.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT maquyensach,hoten,phieumuon.maphieumuon,DATEADD(day, 7,ngaymuon ),pmct.trangthai FROM dbo.nguoidung INNER JOIN dbo.phieumuon ON phieumuon.mabandoc = nguoidung.mand\n"
                + " INNER JOIN dbo.pmct ON pmct.maphieumuon = phieumuon.maphieumuon WHERE mand =?");) {
            preparedStatement.setString(1, txtMaNguoiMuon.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int x = Integer.parseInt(resultSet.getString(5));
                arrayList.add(x);
                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), x == 0 ? "đang mượn" : (x == 1 ? "đã trả" : "quá hạn")});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    private void tbnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnTimKiemActionPerformed
        // TODO add your handling code here:
        fillToTable();
    }//GEN-LAST:event_tbnTimKiemActionPerformed

    private void btnTraSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraSachActionPerformed
        // TODO add your handling code here:
        //"Mã Sách", "Tên Người Mượn", "Mã Phiếu Mượn", "Ngày hẹn trả", "trang thái"

        String maSach = (String) (defaultTableModelA.getValueAt(index, 0));
        String tenNguoiMuon = (String) (defaultTableModelA.getValueAt(index, 1));
        String maPhieuMuon = (String) (defaultTableModelA.getValueAt(index, 2));
        String ngayHentra = (String) (defaultTableModelA.getValueAt(index, 3));
        String trangThai = (String) (defaultTableModelA.getValueAt(index, 4));
        defaultTableModelB.addRow(new String[]{maSach, tenNguoiMuon, maPhieuMuon, ngayHentra, trangThai});
    }//GEN-LAST:event_btnTraSachActionPerformed

    private void btnTraSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraSachMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_btnTraSachMouseClicked

    private void tblSachMuonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMuonMouseClicked
        // TODO add your handling code here:
        index = tblSachMuon.getSelectedRow();
        if (arrayList.get(index) == 1) {
            btnTraSach.setEnabled(false);
            return;
        }
        if (arrayList.get(index) == 0 || arrayList.get(index) == 2)
            btnTraSach.setEnabled(true);
    }//GEN-LAST:event_tblSachMuonMouseClicked
    public int tinhNgayMuon(String myDay) throws Exception {// tính ngày mượn sách
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(myDay);
        Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(year + "-" + month + "-" + day);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(date1);
        c2.setTime(date2);
        long noDay = (c2.getTime().getTime() - c1.getTime().getTime()) / (24 * 3600 * 1000);
        return (int) noDay;

    }

    public void truTienTrongVi(String maPhieuMuon, float tien) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.nguoidung SET vitien=vitien- ? WHERE mand =( "
                + " SELECT mand FROM dbo.nguoidung INNER JOIN dbo.phieumuon ON phieumuon.mabandoc = nguoidung.mand WHERE maphieumuon=?)")) {
            preparedStatement.setString(1, tien + "");
            preparedStatement.setString(2, maPhieuMuon);
            int ii = preparedStatement.executeUpdate();
            if (ii > 0) {

            } else {
                JOptionPane.showMessageDialog(this, "tru tien that bai");
                return;
            }
        } catch (Exception e) {
        }
    }

    public float timGiaSach(String maSach) {
        float tien = (float) 0.0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(" SELECT giatien FROM dbo.tuasach WHERE matuasach="
                + " (SELECT matuasach FROM dbo.quyensach WHERE maquyensach=?)");) {
            preparedStatement.setString(1, maSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                tien = Float.parseFloat(resultSet.getString(1));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return tien;
    }

    public void insertLichSuGD(String maPhieuMuon, Float soTien, String noiDung, String nguoiTaoGD) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.lichsugiaodich VALUES ((SELECT mand FROM dbo.nguoidung INNER JOIN dbo.phieumuon ON phieumuon.mabandoc = nguoidung.mand WHERE maphieumuon=?)+'',GETDATE(),?,?,?)")) {
            preparedStatement.setString(1, maPhieuMuon);
            preparedStatement.setString(2, soTien + "");
            preparedStatement.setString(3, noiDung);
            preparedStatement.setString(4, nguoiTaoGD);
            int x = preparedStatement.executeUpdate();
            if (x > 0) {

            } else {
                JOptionPane.showMessageDialog(this, "insert lịch sử giao dịch thất bại.");
                return;
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }

    public String timEmailND(String maPhieuMuon) {
        String email = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM dbo.nguoidung INNER JOIN dbo.phieumuon ON phieumuon.mabandoc = nguoidung.mand WHERE maphieumuon =?");) {
            preparedStatement.setString(1, maPhieuMuon);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                email = resultSet.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return email;
    }
//"Mã Sách", "Tên Người Mượn", "Mã Phiếu Mượn", "Ngày hẹn trả", "trang thái"

    public String getTrangThai(String maSach, String maPhieuMuon) {
        String s = "";
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT trangthai FROM dbo.pmct WHERE maquyensach=?  AND maphieumuon=?");) {
            preparedStatement.setString(1, maSach);
            preparedStatement.setString(2, maPhieuMuon);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                s = resultSet.getString(1);
                return s;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return s;
    }

    public void phatTien(String nguoiTaoGD) { // trừ tiền phạt ở ví, insert lịch sử gd,gửi mail do trả sách muộn vào ví người dùng
        for (int i = 0; i < tblSachTra.getRowCount(); i++) {
            String s = (String) (defaultTableModelB.getValueAt(i, 0));
            String ss = (String) (defaultTableModelB.getValueAt(i, 2));
            int trangThai = Integer.parseInt(getTrangThai(s, ss));

            if (trangThai == 2) {// ==2 =>quá hạn
                String ngayHenTra = (String) (defaultTableModelB.getValueAt(i, 3));
                try {
                    int ngayTreHen = tinhNgayMuon(ngayHenTra);
                    String maPhieu = (String) (defaultTableModelB.getValueAt(i, 2));
                    String maSach = (String) (defaultTableModelB.getValueAt(i, 0));

                    float tienBiTru = 0;
                    if (ngayTreHen > 0) {
                        if (ngayTreHen > 7) {

                            tienBiTru = timGiaSach(maSach);
                            truTienTrongVi(maPhieu, tienBiTru);

                        }
                        if (ngayTreHen <= 7) {
                            tienBiTru = (float) (timGiaSach(maSach) * ngayTreHen * 0.05);

                            truTienTrongVi(maPhieu, tienBiTru);
                        }

                        insertLichSuGD(maPhieu, -1 * tienBiTru, "bị trừ do trả sách muộn " + ngayTreHen + " ngày ", nguoiTaoGD);
                        Mail.guiMail("hunghvph12990@fpt.edu.vn", "Hunghoang1233", "hunghoang99666@gmail.com", "thông báo từ thư viện sách", "thông báo bạn đã bị phạt tiền do trả sách muộn "
                                + ngayTreHen + " ngày \n"+"Mã sách : "+maSach+"\nsố tiền phạt là : " + tienBiTru + " đ");//"hunghoang99666@gmail.com" thay bằng hàm timEmailND(maPhieu) khi test

                    }
                } catch (Exception e) {
                    System.out.println("ERROR IN tinhNgayMuon");
                }

            }

        }
    }

    public void guiMailToNguoiDatSach(String maNguoiDatSach, String maSach, String tenSach) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT email FROM dbo.nguoidung WHERE mand=?");) {
            preparedStatement.setString(1, maNguoiDatSach);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString(1);
                Mail.guiMail("hunghvph12990@fpt.edu.vn", "Hunghoang1233", "hunghoang99666@gmail.com", "thông báo từ thư viện sách", "mã sách bạn đặt từ thư viện đã có  \nMã người đặt sách : " + maNguoiDatSach + "\nMã Sách : " + maSach + " \nTên Sách : " + tenSach);//"hunghoang99666@gmail.com" thay bằng biến email khi test
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void setDangChoLaySach(String maDatSach) {

        try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.datsach SET trangthai=1 WHERE madatsach=?")) {

            preparedStatement.setString(1, maDatSach);
            int ii = preparedStatement.executeUpdate();
            if (ii > 0) {

            } else {
                System.out.println("setDangChoLaySach thất bại.");
                return;
            }
        } catch (Exception e) {
            System.out.println("setDangChoLaySach thất bại." + e.toString());
        }

    }

    public void threadHuyDatSach() {
        new Thread() {
            @Override
            public void run() {

            }

        }.start();
    }

    public void checkDatSach() {
        for (int i = 0; i < tblSachTra.getRowCount(); i++) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT mand,datsach.trangthai,tuasach.matuasach,tentuasach,madatsach FROM dbo.datsach INNER JOIN dbo.tuasach ON tuasach.matuasach = datsach.matuasach INNER JOIN dbo.quyensach ON quyensach.matuasach = tuasach.matuasach WHERE  maquyensach=?");) {
                preparedStatement.setString(1, (String) (defaultTableModelB.getValueAt(i, 0)));
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {

                    int trangThai = Integer.parseInt(resultSet.getString(2));
                    if (trangThai == 0) {
                        String maNguoiDatSach = resultSet.getString(1);
                        String maTuaSach = resultSet.getString(3);
                        String tenTuaSach = resultSet.getString(4);
                        guiMailToNguoiDatSach(maNguoiDatSach, maTuaSach, tenTuaSach);
                        String maDatSach = resultSet.getString(5);
                        setDangChoLaySach(maDatSach);
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void btnHoanTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHoanTatActionPerformed
        phatTien(txtNguoiTaoPhieu.getText());
        checkDatSach();
        insertIntoPhieuTra();
        insertIntoPhieuTraCT();
        for (int i = 0; i < tblSachTra.getRowCount(); i++) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("UPDATE dbo.pmct SET trangthai=1 WHERE maquyensach=?  AND maphieumuon=?")) {

                preparedStatement.setString(1, (String) (defaultTableModelB.getValueAt(i, 0)));
                preparedStatement.setString(2, (String) (defaultTableModelB.getValueAt(i, 2)));
                int ii = preparedStatement.executeUpdate();
                if (ii > 0) {

                } else {
                    JOptionPane.showMessageDialog(this, "trả sách thất bại.");
                    return;
                }
            } catch (Exception e) {
            }
        }
     
        JOptionPane.showMessageDialog(this, "trả sách thành công.");
        defaultTableModelB.setRowCount(0);
        fillToTable();
    }//GEN-LAST:event_btnHoanTatActionPerformed
    public void insertIntoPhieuTra() {

        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.phieutra VALUES(?,GETDATE(),?)")) {
            preparedStatement.setString(1, txtMaNguoiMuon.getText());
            preparedStatement.setString(2, txtNguoiTaoPhieu.getText());
            int x = preparedStatement.executeUpdate();
            if (x > 0) {

            } else {
                JOptionPane.showMessageDialog(this, "Tạo phiếu trả thất bại.");
                return;
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }

    }

    public void insertIntoPhieuTraCT() {
        for (int i = 0; i < tblSachTra.getRowCount(); i++) {
            try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO dbo.ptct VALUES((SELECT MAX(maphieutra) FROM dbo.phieutra),?,(SELECT trangthai FROM dbo.pmct WHERE maquyensach=?  AND maphieumuon=?),N'')")) {
                preparedStatement.setString(1, (String) (defaultTableModelB.getValueAt(i, 0)));
                preparedStatement.setString(2, (String) (defaultTableModelB.getValueAt(i, 0)));
                preparedStatement.setString(3, (String) (defaultTableModelB.getValueAt(i, 2)));

                int x = preparedStatement.executeUpdate();
                if (x > 0) {

                } else {
                    JOptionPane.showMessageDialog(this, "Tạo phiếu trả thất bại.");
                    return;
                }
            } catch (Exception e) {
                System.out.println("ERROR : " + e);
            }
        }
    }
    private void btnXoaKhoiDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaKhoiDSActionPerformed
        // TODO add your handling code here:
        int indexOfSachTra;
        indexOfSachTra = tblSachTra.getSelectedRow();
        defaultTableModelB.removeRow(indexOfSachTra);
    }//GEN-LAST:event_btnXoaKhoiDSActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        defaultTableModelB.setRowCount(0);

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

    }//GEN-LAST:event_jButton11ActionPerformed

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
            java.util.logging.Logger.getLogger(QLPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLPhieuTra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLPhieuTra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHoanTat;
    private javax.swing.JButton btnTraSach;
    private javax.swing.JButton btnXoaKhoiDS;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblSachMuon;
    private javax.swing.JTable tblSachTra;
    private javax.swing.JButton tbnTimKiem;
    private javax.swing.JTextField txtMaNguoiMuon;
    private javax.swing.JTextField txtNguoiTaoPhieu;
    // End of variables declaration//GEN-END:variables
}
