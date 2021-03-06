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
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.LoginHelper;
import com.xpoly.helper.TableColumnHider;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.DatSach;
import com.xpoly.model.QuyenSach;
import com.xpoly.model.Sach_Tg;
import com.xpoly.model.TuaSach;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dell
 */
public class QLSachLuuTruJInternalFrame extends javax.swing.JInternalFrame  implements IService<Integer> {

    /**
     * Creates new form QLSachLuuTruJInternalFrame
     */
     DanhMucDAO danhMucDAO = new DanhMucDAO();

    int pageNumber = 1, rowsOfPage = 6, rowIndex = 0;
    String keyword = "";
    int totalPage;
    DanhMuc danhMuc = new DanhMuc();
    static int maTuaSachChiTiet;

    DefaultComboBoxModel<DanhMuc> cboModel = new DefaultComboBoxModel<>();
    String[] columns = {"Mã tựa sách", "Tên tựa sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Giá tiền",
        "Mô tả", "Ghi chú", "Số lượng", "Danh mục", "Số lượng thích"};

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
    
    public QLSachLuuTruJInternalFrame() {
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

        btn_search = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_timKiem = new javax.swing.JTextField();
        cbo_danhMuc = new javax.swing.JComboBox<>();
        btn_chiTiet = new javax.swing.JButton();
        btn_reload = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Panel_list = new javax.swing.JPanel();
        panel_chk = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tuaSach = new javax.swing.JTable();
        btn_last1 = new javax.swing.JButton();
        btn_next1 = new javax.swing.JButton();
        btn_prev1 = new javax.swing.JButton();
        btn_first1 = new javax.swing.JButton();

        btn_search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ LƯU TRỮ SÁCH");

        jLabel8.setText("Danh mục:");

        txt_timKiem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_timKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_timKiemKeyReleased(evt);
            }
        });

        cbo_danhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_danhMucActionPerformed(evt);
            }
        });

        btn_chiTiet.setText("Chi tiết");
        btn_chiTiet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chiTietActionPerformed(evt);
            }
        });

        btn_reload.setText("Reload");
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tìm kiếm");

        jPanel2.setLayout(new java.awt.CardLayout());

        javax.swing.GroupLayout panel_chkLayout = new javax.swing.GroupLayout(panel_chk);
        panel_chk.setLayout(panel_chkLayout);
        panel_chkLayout.setHorizontalGroup(
            panel_chkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 886, Short.MAX_VALUE)
        );
        panel_chkLayout.setVerticalGroup(
            panel_chkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 42, Short.MAX_VALUE)
        );

        jLabel3.setText("Ẩn/Hiện cột:");

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addGroup(Panel_listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_first1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_prev1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_next1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_last1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(21, 21, 21))
        );

        jPanel2.add(Panel_list, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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
                    .addComponent(btn_reload)
                    .addComponent(btn_chiTiet))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here:
        keyword = txt_timKiem.getText();
        loadTable();
    }//GEN-LAST:event_btn_searchActionPerformed

    private void txt_timKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_timKiemKeyReleased

    }//GEN-LAST:event_txt_timKiemKeyReleased

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

    private void btn_chiTietActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chiTietActionPerformed
        // TODO add your handling code here:
        maTuaSachChiTiet = (Integer) tblModel.getValueAt(rowIndex, 0);
        System.out.println(maTuaSachChiTiet);
        new ChiTietSachJFrame(maTuaSachChiTiet).setVisible(true);
    }//GEN-LAST:event_btn_chiTietActionPerformed

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        // TODO add your handling code here:
        loadTable();
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void tbl_tuaSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_tuaSachMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tbl_tuaSachMouseClicked

    private void btn_last1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_last1ActionPerformed
        pageNumber = totalPage;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_last1ActionPerformed

    private void btn_next1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_next1ActionPerformed
        pageNumber++;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_next1ActionPerformed

    private void btn_prev1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prev1ActionPerformed
        pageNumber--;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_prev1ActionPerformed

    private void btn_first1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_first1ActionPerformed
        pageNumber = 1;
        loadTable();
        buttonEnabled();
    }//GEN-LAST:event_btn_first1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_list;
    private javax.swing.JButton btn_chiTiet;
    private javax.swing.JButton btn_first1;
    private javax.swing.JButton btn_last1;
    private javax.swing.JButton btn_next1;
    private javax.swing.JButton btn_prev1;
    public static javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_search;
    private javax.swing.JComboBox<String> cbo_danhMuc;
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
        putClientProperty("JInternalFrame.isPalette", Boolean.TRUE);
        getRootPane().setWindowDecorationStyle(JRootPane.NONE);
        ((BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(null);

       
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
            int total = (int) Math.ceil((float) tuaSachDAO.getTotalRows(keyword, 1, danhMuc.getMaDanhMuc()) / rowsOfPage);
            totalPage = total > 0 ? total : 1;
            pageNumber = pageNumber > totalPage ? 1 : pageNumber;
            lst_tuaSach = tuaSachDAO.selectByKeyword(keyword, pageNumber, rowsOfPage, 1, danhMuc.getMaDanhMuc());
            int i = 0;
            if (!lst_tuaSach.isEmpty()) {
                for (TuaSach x : lst_tuaSach) {                    
                    String tacGia = new Sach_TacGiaDAO().selectTacgia(x.getMaTuaSach());                    
                    x.setSoLuotThich(sachUaThichDAO.getSoLuongLike(x.getMaTuaSach()));
                    System.out.println("so luong thich = " + x.getSoLuotThich() + " matuasach = " + x.getMaTuaSach());
                    tblModel.addRow(new Object[]{
                        x.getMaTuaSach(), x.getTenTuaSach(), tacGia, x.getNxb(), x.getNamxb(),
                        x.getSoTrang(), x.getGiaTien(), x.getMoTa(), x.getGhiChu(), x.getSoLuong(),
                        com.xpoly.helper.EzHelper.MAP_DANHMUC.get(x.getMadm()), x.getSoLuotThich(),});

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
}
