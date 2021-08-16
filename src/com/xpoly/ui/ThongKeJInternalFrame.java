/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.ui;


import com.xpoly.DAO.ThongKeDAO;
import com.xpoly.helper.EzHelper;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Dell
 */
public class ThongKeJInternalFrame extends javax.swing.JInternalFrame {

    /**
     * Creates new form ThongKeJInternalFrame
     */
    
    ThongKeDAO thongKeDAO = new ThongKeDAO();

    List<Object[]> lst_nam;
    List<Object[]> lst_thang;

    int year;

    
    public ThongKeJInternalFrame() {
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        lbl_chartByYear = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cbo_year = new javax.swing.JComboBox<>();
        lbl_chartByMonth = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("THỐNG KÊ");

        jLabel3.setText("Năm:");

        cbo_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbo_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_yearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_chartByMonth, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(lbl_chartByYear, javax.swing.GroupLayout.PREFERRED_SIZE, 559, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbo_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_chartByYear, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(lbl_chartByMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 119, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Lượt mượn", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbo_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_yearActionPerformed
        // TODO add your handling code here:
        if (cbo_year.getSelectedIndex() != 0) {
            year = (int) cbo_year.getSelectedItem();
            try {
                loadBieuDo_luotMuonTheoThang();
            } catch (IOException ex) {
                Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_cbo_yearActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbo_year;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbl_chartByMonth;
    private javax.swing.JLabel lbl_chartByYear;
    // End of variables declaration//GEN-END:variables


    private void init() {
        loadCombobox_nam();
        loadBieuDo_luotMuonTheoNam();
    }

    void loadCombobox_nam() {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        lst_nam = thongKeDAO.getNamVaSoSachMuon();
        cboModel.addElement("Năm");
        for (Object[] i : lst_nam) {
            cboModel.addElement(i[0]);
        }
        cbo_year.setModel(cboModel);
    }

    private void loadBieuDo_luotMuonTheoNam() {
        DefaultCategoryDataset line_chart_dataset = new DefaultCategoryDataset();

        for (int i = 0; i < lst_nam.size(); i++) {
            line_chart_dataset.addValue((Number) lst_nam.get(i)[1], "số lượt mượn từng năm", (Comparable) lst_nam.get(i)[0]);
        }

        JFreeChart lineChartObject = ChartFactory.createLineChart(
                "", "Năm",
                "Số lượt mượn",
                line_chart_dataset, PlotOrientation.VERTICAL,
                true, true, false);

        int width = 600;
        /* Width of the image */
        int height = 220;
        /* Height of the image */
        File lineChart = new File("images", "LineChart" + cbo_year.getSelectedItem() + ".png");
        try {
            ChartUtilities.saveChartAsPNG(lineChart, lineChartObject, width, height);
        } catch (IOException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbl_chartByYear.setIcon(EzHelper.readImg(lineChart.getName()));
    }

    private void loadBieuDo_luotMuonTheoThang() throws IOException {
        // 
        lst_thang = thongKeDAO.getSachMuonTheoThang(year);

        // bat dau tao chart
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        System.out.println("lst thang .size " + lst_thang.size());
        for (int i = 0; i < lst_thang.size(); i++) {
            dataset.addValue((int) lst_thang.get(i)[0], "Tháng", (Comparable) lst_thang.get(i)[1]);
        }

        JFreeChart chart = ChartFactory.createBarChart("Số sách mượn theo tháng", "", "Số sách mượn", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        int width = 600;
        /* Width of the image */
        int height = 250;
        /* Height of the image */
        File barChart = new File("images", "BarChart_" + year + ".png");
        ChartUtilities.saveChartAsPNG(barChart, chart, width, height);
        lbl_chartByMonth.setIcon(EzHelper.readImg(barChart.getName()));
    }
}
