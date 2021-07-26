/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui;

import com.xpoly.addTacGia.QLTacGia;
import com.xpoly.helper.DialogHelper;
import com.xpoly.ui.QLSach.QLTuaSachJInternalFrame;
import com.xpoly.ui.QLSach.ThemSachJInternalFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;
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
//                panel_body.repaint();
//                panel_body.revalidate();
            }
        });
        MenuItem menuSach_them = new MenuItem(iconItem, "Thêm tựa sách",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showChucNang(new ThemSachJInternalFrame());
//                panel_body.repaint();
//                panel_body.revalidate();
            }
        });
        MenuItem menuSach_uaThich = new MenuItem(iconItem, "Sách ưa thích", null);
        MenuItem menuSach_datSach = new MenuItem(iconItem, "Đặt sách", null);

//        // create submenu bandoc
        MenuItem menuBanDoc_danhSach = new MenuItem(iconItem, "Danh sách", null);
        MenuItem menuBanDoc_them = new MenuItem(iconItem, "Thêm bạn đọc", null);
//        
//         //create submenu NguoiDung
        MenuItem menuNguoiDung_banDoc = new MenuItem(iconSubMenu, "Bạn đọc", null, menuBanDoc_danhSach, menuBanDoc_them);
        MenuItem menuNguoiDung_nhanSu = new MenuItem(iconSubMenu, "Nhân sự", null);
        MenuItem menuNguoiDung_taiKhoan = new MenuItem(iconSubMenu, "Tài khoản", null);

        MenuItem menuSach = new MenuItem(iconSach, "Sách", null, menuSach_danhSach, menuSach_them, menuSach_uaThich, menuSach_datSach);

        MenuItem menuTacGia = new MenuItem(iconTacGia, "Tác giả",new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                QLTacGia frame = new QLTacGia();
                frame.setVisible(true);
//                panel_body.repaint();
//                panel_body.revalidate();
            }
        });
        MenuItem menuNguoiDung = new MenuItem(iconNguoiDung, "Người dùng", null, menuNguoiDung_banDoc, menuNguoiDung_nhanSu, menuNguoiDung_taiKhoan);
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

    public void showChucNang(JInternalFrame newJIF) {
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
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        panel_menu = new javax.swing.JPanel();
        panel_body = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel_header.setBackground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout panel_headerLayout = new javax.swing.GroupLayout(panel_header);
        panel_header.setLayout(panel_headerLayout);
        panel_headerLayout.setHorizontalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1131, Short.MAX_VALUE)
        );
        panel_headerLayout.setVerticalGroup(
            panel_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 49, Short.MAX_VALUE)
        );

        getContentPane().add(panel_header, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(220, 476));

        jScrollPane1.setBorder(null);

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
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
            .addGap(0, 476, Short.MAX_VALUE)
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JDesktopPane panel_body;
    private javax.swing.JPanel panel_header;
    private javax.swing.JPanel panel_menu;
    // End of variables declaration//GEN-END:variables
}
