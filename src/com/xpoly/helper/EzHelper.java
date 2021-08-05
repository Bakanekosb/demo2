/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import com.toedter.calendar.JDateChooser;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class EzHelper extends javax.swing.JFrame {

    public static HashMap<String, String> MAP_DANHMUC = new HashMap<>();
    public static HashMap<Integer, String> MAP_TG = new HashMap<>();

    public static boolean blank(JTextField txt, String tenTruong, Component parent) {
        if (txt.getText().isBlank()) {
            txt.requestFocus();
            DialogHelper.alert(parent, tenTruong + " không được để trống");
            return true;
        }
        return false;
    }

    public static Integer isInt(JTextField txt, String message, Component parent) {
        try {
            if (blank(txt, message, parent)) {
                return -1;
            }
            if (Integer.parseInt(txt.getText()) < 0) {
                txt.requestFocus();
                DialogHelper.alert(parent, message + " phải >= 0");
                return -1;
            }
            return Integer.parseInt(txt.getText());
        } catch (Exception e) {
            txt.requestFocus();
            DialogHelper.alert(parent, message + " phải là số nguyên");
            return -1;
        }
    }

    public static Double isDouble(JTextField txt, String message, Component parent) {
        try {
            if (blank(txt, message, parent)) {
                return -1.0;
            }
            if (Double.parseDouble(txt.getText()) < 0) {
                txt.requestFocus();
                DialogHelper.alert(parent, message + " phải >= 0");
                return -1.0;
            }
            return Double.parseDouble(txt.getText());
        } catch (Exception e) {
            txt.requestFocus();
            DialogHelper.alert(parent, message + " phải là số");
            return -1.0;
        }
    }

    public static boolean blankdate(JDateChooser jdate, String tenTruong, JLabel jLabel1) {
    if (jdate.getDateFormatString().isBlank()) {
            jdate.requestFocus();
            DialogHelper.alert(jdate, tenTruong + " không được để trống");
            return true;
        }
        return false;}

    public boolean saveImg(File file) {
        File dir = new File("images");
        if (!dir.exists()) {
            dir.mkdirs();
        }
        File newFile = new File(dir, file.getName());
        try {
            Path source = Paths.get(file.getAbsolutePath());
            Path destination = Paths.get(newFile.getAbsolutePath());
            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (Exception ex) {
            DialogHelper.alert(this, "Lỗi save ảnh");
            return false;
        }
    }

    public static ImageIcon readImg(String fileName) {
        File path = new File("images", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public  void selectImage(JLabel lbl_image) {
        try {
            JFileChooser fc = new JFileChooser("images\\");
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                if (saveImg(file)) {
                    lbl_image.setIcon(readImg(file.getName()));
                    lbl_image.setToolTipText(file.getName());
                }
            }
        } catch (Exception e) {
            DialogHelper.alert(this, "Lỗi save ảnh");
        }

    }
    
    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    
    // VD: EzHelper.toDate(txt_ngaySinh.getText())
    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return EzHelper.now();
            }
            return DATE_FORMATER.parse(date);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    
    // VD: DateHelper.toString(model.getNgaySinh())
    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = EzHelper.now();
        }
        return DATE_FORMATER.format(date);
    }
    
    public static Date now() {
        return new Date();
    }
    
    
}
