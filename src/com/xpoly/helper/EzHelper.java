/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
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

    public ImageIcon readImg(String fileName) {
        File path = new File("images", fileName);
        return new ImageIcon(path.getAbsolutePath());
    }

    public void selectImage(JLabel lbl_image) {
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
}
