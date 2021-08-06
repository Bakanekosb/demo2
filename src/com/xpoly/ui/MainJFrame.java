/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui;

import com.xpoly.DAO.QuyenSachDAO;
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.LSGD.QLLichSuGiaoDichJInternalFrame;
import com.xpoly.QLnhansu.QLNhanVienJInternalFrame;
import com.xpoly.QLnhansu.QLNhansu;
import com.xpoly.QLnhansu.ThemNhanVienJInternalFrame;
import com.xpoly.addTacGia.QLTacGia;
import com.xpoly.addTacGia.QLTacGiaJInternalFrame;
import com.xpoly.helper.DialogHelper;
import com.xpoly.helper.LoginHelper;
import com.xpoly.helper.MyTask;
import com.xpoly.model.NguoiDung;
import com.xpoly.ui.QLSach.QLSachLuuTruJInternalFrame;
import com.xpoly.ui.QLSach.QLTuaSachJInternalFrame;
import com.xpoly.ui.QLSach.ThemSachJInternalFrame;
import com.xpoly.ui.QLnguoidung.QLBanDocJInternalFrame;
import com.xpoly.ui.QLnguoidung.ThemBanDocJInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Dell
 */
public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    List<JInternalFrame> lst_internalFrame = new ArrayList<>();
     

    public MainJFrame() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        execute();
        init();

    }

    private void execute() {
        ImageIcon iconSach = new ImageIcon("icon\\icon.png");
        ImageIcon iconBanDoc = new ImageIcon("icon\\icon.png");
        ImageIcon iconNhanSu = new ImageIcon("icon\\icon.png");
        ImageIcon iconNguoiDung = new ImageIcon("icon\\icon.png");
        ImageIcon iconPhieuMuon = new ImageIcon("icon\\icon.png");
        ImageIcon iconPhieuTra = new ImageIcon("icon\\icon.png");
        ImageIcon iconTacGia = new ImageIcon("icon\\icon.png");
        ImageIcon iconSubMenu = new ImageIcon("icon\\subMenu.png");
        ImageIcon iconItem = new ImageIcon("icon\\item.png");

        //create submenu Sach
        MenuItem menuSach_danhSach = new MenuItem(iconItem, "Danh sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLTuaSachJInternalFrame());
            }
        });
        MenuItem menuSach_them = new MenuItem(iconItem, "Thêm tựa sách",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new ThemSachJInternalFrame());
            }
        });
        
        MenuItem menuSach_luuTru = new MenuItem(iconItem, "Sách lưu trữ",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLSachLuuTruJInternalFrame());
            }
        });
        MenuItem menuSach_uaThich = new MenuItem(iconItem, "Sách ưa thích", null);
        MenuItem menuSach_datSach = new MenuItem(iconItem, "Đặt sách", null);

//        // create submenu bandoc
        MenuItem menuBanDoc_danhSach = new MenuItem(iconItem, "Danh sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLBanDocJInternalFrame());
            }
        });
        MenuItem menuBanDoc_them = new MenuItem(iconItem, "Thêm bạn đọc", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new ThemBanDocJInternalFrame());
            }
        });
        
          // create submenu nhanvien
        MenuItem menuNhanVien_danhSach = new MenuItem(iconItem, "Danh sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLNhanVienJInternalFrame());
            }
        });
        MenuItem menuNhanVien_them = new MenuItem(iconItem, "Thêm nhân viên", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new ThemNhanVienJInternalFrame());
            }
        });
        
        //        // create submenu tacgia
        MenuItem menuTacGia_danhSach = new MenuItem(iconItem, "Danh sách", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLTacGiaJInternalFrame());
            }
        });
        MenuItem menuTacGia_them = new MenuItem(iconItem, "Thêm tác giả", null);
//        
//         //create submenu NguoiDung
        MenuItem menuNguoiDung_banDoc = new MenuItem(iconSubMenu, "Bạn đọc", null, menuBanDoc_danhSach, menuBanDoc_them);
        MenuItem menuNguoiDung_nhanSu = new MenuItem(iconSubMenu, "Nhân sự", null, menuNhanVien_danhSach, menuNhanVien_them);
        MenuItem menuNguoiDung_taiKhoan = new MenuItem(iconSubMenu, "Tài khoản", null);
        MenuItem menuNguoiDung_LSGD = new MenuItem(iconSubMenu, "Lịch sử giao dịch", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new QLLichSuGiaoDichJInternalFrame());
            }
        });

        MenuItem menuSach = new MenuItem(iconSach, "Sách", null, menuSach_danhSach, menuSach_them, menuSach_luuTru, menuSach_uaThich, menuSach_datSach);

        MenuItem menuTacGia = new MenuItem(iconTacGia, "Tác giả", null, menuTacGia_danhSach, menuTacGia_them);
        
        
        MenuItem menuNguoiDung = new MenuItem(iconNguoiDung, "Người dùng", null, menuNguoiDung_banDoc, menuNguoiDung_nhanSu, menuNguoiDung_taiKhoan,
                                                                                menuNguoiDung_LSGD
        );
        MenuItem menuPhieuMuon = new MenuItem(iconPhieuMuon, "Phiếu mượn", null);
        MenuItem menuPhieuTra = new MenuItem(iconPhieuTra, "Phiếu trả", null);
        addMenu(menuSach, menuTacGia, menuNguoiDung, menuPhieuMuon, menuPhieuTra);
    }

    private void addMenu(MenuItem... menu) {
        for (int i = 0; i < menu.length; i++) {
            panel_menu.add(menu[i]);
            ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        panel_menu.revalidate();
    }

    public static void showChucNang(JInternalFrame newJIF) {
        try {
//             if (!lst_internalFrame.isEmpty()) {
//                 for (JInternalFrame x : lst_internalFrame) {
//                     x.dispose();
//                 }
//             }
//             lst_internalFrame = new ArrayList<>();
//             lst_internalFrame.add(newJIF);
            panel_body.removeAll();
            panel_body.add(newJIF);
            panel_body.repaint();
            newJIF.setVisible(true);
            newJIF.setBorder(null);
            newJIF.setMaximum(true);
            newJIF.setBorder(null);
        } catch (PropertyVetoException propertyVetoException) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lbl_tuasach = new javax.swing.JLabel();
        lbl_quyensach = new javax.swing.JLabel();
        lbl_bandoc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_menu = new javax.swing.JPanel();
        panel_body = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_header.setBackground(new java.awt.Color(255, 255, 255));
        panel_header.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/xpoly/ui/libraria-logo-v2.png"))); // NOI18N

        lbl_tuasach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_tuasach.setText("Tựa sách");

        lbl_quyensach.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_quyensach.setText("Quyển sách");

        lbl_bandoc.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_bandoc.setText("Bạn đọc");

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(lbl_tuasach, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_quyensach, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbl_bandoc, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(133, Short.MAX_VALUE))
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_headerLayout.createSequentialGroup()
                .addGroup(panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
                    .addComponent(lbl_bandoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_tuasach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbl_quyensach, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(panel_header, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 476));

        jScrollPane1.setBorder(null);

        panel_menu.setBackground(new java.awt.Color(255, 255, 255));
        panel_menu.setLayout(new javax.swing.BoxLayout(panel_menu, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(panel_menu);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 457, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout panel_bodyLayout = new javax.swing.GroupLayout(panel_body);
        panel_body.setLayout(panel_bodyLayout);
        panel_bodyLayout.setHorizontalGroup(
            panel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 911, Short.MAX_VALUE)
        );
        panel_bodyLayout.setVerticalGroup(
            panel_bodyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        getContentPane().add(panel_body, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_bandoc;
    private javax.swing.JLabel lbl_quyensach;
    private javax.swing.JLabel lbl_tuasach;
    public static javax.swing.JDesktopPane panel_body;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables

    private void init() {
        LoginHelper.USER = new NguoiDung("ND004");
        
        MyTask myTask = new MyTask();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 5);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        Date dateSchedule = calendar.getTime();
        long period = 24 * 60 * 60 * 1000;

        Timer timer = new Timer();
        timer.schedule(myTask, dateSchedule, period);
        
        lbl_tuasach.setText("Tựa sách: " + new TuaSachDAO().getTotalTuaSach());
        lbl_quyensach.setText("Quyển sách: " + new QuyenSachDAO().getTotalQSach());
        lbl_bandoc.setText("Bạn đọc: " + new TuaSachDAO().getTotalBanDoc());
    }
}
