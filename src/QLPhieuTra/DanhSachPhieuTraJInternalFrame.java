/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLPhieuTra;

/**
 *
 * @author Dell
 */
import com.xpoly.helper.JdbcHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

public class DanhSachPhieuTraJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form DanhSachPhieuTraJInternalFrame
     */
    Connection connection = JdbcHelper.ketNoi();
    DefaultTableModel defaultTableModelA = new DefaultTableModel();
    DefaultTableModel defaultTableModelB = new DefaultTableModel();

    int index = 0;

    public DanhSachPhieuTraJInternalFrame() {
        initComponents();
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);
        
        defaultTableModelA.setColumnIdentifiers(new String[]{"Mã Phiếu Trả", "Mã Bạn Đọc", "Tên Bạn Đọc", "Ngày Trả", "Mã Người Tạo Phiếu", "Tên Người Tạo Phiếu"});
        defaultTableModelB.setColumnIdentifiers(new String[]{"Mã Phiếu Trả", "Mã Quyển Sách", "Tên Tựa Sách", "Trạng Thái", "Ghi Chú", "Tình Trạng Sách", "Vị Trí Quyển Sách"});
        tblA.setModel(defaultTableModelA);
        tblB.setModel(defaultTableModelB);
        fillToTable();
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblA = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblB = new javax.swing.JTable();
        txtSearch = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tbnSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtSearchByMaSach = new javax.swing.JTextField();
        tbnSearchByMaSach = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("THÔNG TIN PHIẾU TRẢ");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Trả", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 224, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phiếu Trả Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1004, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        txtSearch.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel2.setText("Mã Phiếu Trả");

        tbnSearch.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbnSearch.setText("Search");
        tbnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSearchActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Mã Sách");

        txtSearchByMaSach.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        tbnSearchByMaSach.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tbnSearchByMaSach.setText("Search");
        tbnSearchByMaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnSearchByMaSachActionPerformed(evt);
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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSearchByMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                            .addComponent(txtSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tbnSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                            .addComponent(tbnSearchByMaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tbnSearch, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSearchByMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tbnSearchByMaSach)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAMouseClicked
        // TODO add your handling code here:
        index = tblA.getSelectedRow();
        String maPhieuTra = (String) (defaultTableModelA.getValueAt(index, 0));
        defaultTableModelB.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT maphieutra,ptct.maquyensach,(SELECT tentuasach FROM dbo.tuasach WHERE matuasach =(dbo.quyensach.matuasach)),ptct.trangthai,ptct.ghichu,tinhtrang,vitri FROM\n"
                + "dbo.ptct INNER JOIN dbo.quyensach ON quyensach.maquyensach = ptct.maquyensach WHERE maphieutra=?");) {
            preparedStatement.setString(1, maPhieuTra);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                //--(mat = 0, datra = 1, quahan = 2)
                int x = Integer.parseInt(resultSet.getString(4));
                System.out.println("x : " + x);
                String trangThai = (x == 0) ? "Mất" : ((x == 1) ? "Đã Trả" : "Quá Hạn");

                //-- (dangphucvu = 0, hong = 1, mat = 2, ngungphucvu = 3)
                int xx = Integer.parseInt(resultSet.getString(6));

                String tinhTrang = "";
                if (xx == 0) {
                    tinhTrang = "Đang Phục Vụ";
                } else if (xx == 1) {
                    tinhTrang = "hỏng";
                } else if (xx == 2) {
                    tinhTrang = "mất";
                } else if (xx == 3) {
                    tinhTrang = "Ngừng Phục vụ";
                }
                System.out.println("tình trang" + tinhTrang);
                defaultTableModelB.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), trangThai, resultSet.getString(5), tinhTrang, resultSet.getString(7)});
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_tblAMouseClicked

    private void tbnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSearchActionPerformed
        // TODO add your handling code here:
        defaultTableModelA.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT maphieutra,mabandoc,hoten,ngaytra,nguoitaophieu,(SELECT hoten FROM dbo.nguoidung WHERE mand =nguoitaophieu) FROM "
                + " dbo.phieutra INNER JOIN dbo.nguoidung ON nguoidung.mand = phieutra.mabandoc WHERE maphieutra=?");) {
            preparedStatement.setString(1, txtSearch.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }//GEN-LAST:event_tbnSearchActionPerformed

    private void tbnSearchByMaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnSearchByMaSachActionPerformed
        // TODO add your handling code here:
        defaultTableModelA.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT phieutra.maphieutra,mabandoc,hoten,ngaytra,nguoitaophieu,(SELECT hoten FROM dbo.nguoidung WHERE mand =nguoitaophieu) FROM \n"
                + "                 dbo.phieutra INNER JOIN dbo.nguoidung ON nguoidung.mand = phieutra.mabandoc INNER JOIN dbo.ptct  ON ptct.maphieutra = phieutra.maphieutra\n"
                + "				 WHERE maquyensach=?");) {
            preparedStatement.setString(1, txtSearchByMaSach.getText());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }//GEN-LAST:event_tbnSearchByMaSachActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblA;
    private javax.swing.JTable tblB;
    private javax.swing.JButton tbnSearch;
    private javax.swing.JButton tbnSearchByMaSach;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSearchByMaSach;
    // End of variables declaration//GEN-END:variables

    public void fillToTable() {

        defaultTableModelA.setRowCount(0);

        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT maphieutra,mabandoc,hoten,ngaytra,nguoitaophieu,(SELECT hoten FROM dbo.nguoidung WHERE mand =nguoitaophieu) FROM "
                + " dbo.phieutra INNER JOIN dbo.nguoidung ON nguoidung.mand = phieutra.mabandoc");) {

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                defaultTableModelA.addRow(new String[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getString(6)});
            }
        } catch (Exception e) {
            System.out.println("ERROR : " + e);
        }
    }

}
