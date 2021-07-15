/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class PTCT {

    private int maPhieuTra, maQuyenSach, trangThai;
    private String ghiChu;
    public int getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(int maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
    }

    public int getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(int maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PTCT{maPhieuTra=").append(maPhieuTra);
        sb.append(", maQuyenSach=").append(maQuyenSach);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", ghiChu=").append(ghiChu);
        sb.append('}');
        return sb.toString();
    }


    
}
