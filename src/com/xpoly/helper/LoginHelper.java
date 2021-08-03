/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import com.xpoly.model.NguoiDung;

/**
 *
 * @author Dell
 */
public class LoginHelper {
    public static NguoiDung USER = null;

    public static void logoff() {
        LoginHelper.USER = null;
    }

    public static boolean authenticated() {
        return LoginHelper.USER != null;
    }
    
    public static int phanQuyen(){
        return LoginHelper.USER.getVaiTro(); // 0: thu thu, 1: admin, 2: ban doc
    }
    
    public static boolean quyenQuanTri(){
        return LoginHelper.USER.getVaiTro() < 2; // 0: thu thu, 1: admin, 2: ban doc
    }
}
