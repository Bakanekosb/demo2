/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import java.awt.Component;
import javax.swing.JTextField;

/**
 *
 * @author Dell
 */
public class EzHelper extends javax.swing.JFrame{
    public static boolean blank(JTextField txt, String tenTruong,Component parent){
        if(txt.getText().isBlank()){
            txt.requestFocus();
            DialogHelper.alert(parent, tenTruong + " không được để trống");
            return true;
        }
        return false;
    }
}
