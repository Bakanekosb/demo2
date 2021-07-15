/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.model;

/**
 *
 * @author Admin
 */
public class Sach_Tg {
   private int maTuaSach,maTacGia;

    public Sach_Tg() {
    }

    public Sach_Tg(int maTuaSach, int maTacGia) {
        this.maTuaSach = maTuaSach;
        this.maTacGia = maTacGia;
    }

    public int getMaTuaSach() {
        return maTuaSach;
    }

    public void setMaTuaSach(int maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    public int getMaTacGia() {
        return maTacGia;
    }

    public void setMaTacGia(int maTacGia) {
        this.maTacGia = maTacGia;
    }

    @Override
    public String toString() {
        return "Sach_Tg{" + "maTuaSach=" + maTuaSach + ", maTacGia=" + maTacGia + '}';
    }
    
}
