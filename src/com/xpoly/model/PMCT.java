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
public class PMCT {
    private int maPhieuMuon,maQuyenSach,trangThai,soLanGiaHan;
    private Date ngayGiaHan;
    private String ghiChu;

    public PMCT() {
    }

    public PMCT(int maPhieuMuon, int maQuyenSach, int trangThai, int soLanGiaHan, Date ngayGiaHan, String ghiChu) {
        this.maPhieuMuon = maPhieuMuon;
        this.maQuyenSach = maQuyenSach;
        this.trangThai = trangThai;
        this.soLanGiaHan = soLanGiaHan;
        this.ngayGiaHan = ngayGiaHan;
        this.ghiChu = ghiChu;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
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

    public int getSoLanGiaHan() {
        return soLanGiaHan;
    }

    public void setSoLanGiaHan(int soLanGiaHan) {
        this.soLanGiaHan = soLanGiaHan;
    }

    public Date getNgayGiaHan() {
        return ngayGiaHan;
    }

    public void setNgayGiaHan(Date ngayGiaHan) {
        this.ngayGiaHan = ngayGiaHan;
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
        sb.append("PMCT{maPhieuMuon=").append(maPhieuMuon);
        sb.append(", maQuyenSach=").append(maQuyenSach);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", soLanGiaHan=").append(soLanGiaHan);
        sb.append(", ngayGiaHan=").append(ngayGiaHan);
        sb.append(", ghiChu=").append(ghiChu);
        sb.append('}');
        return sb.toString();
    }
    
    
}
