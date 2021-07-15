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
public class PhieuMuon {
    private int maPhieuMuon;
    private String maBanDoc,nguoiTaoPhieu;
    private Date ngayMuon;

    public PhieuMuon() {
    }

    public PhieuMuon(int maPhieuMuon, String maBanDoc, String nguoiTaoPhieu, Date ngayMuon) {
        this.maPhieuMuon = maPhieuMuon;
        this.maBanDoc = maBanDoc;
        this.nguoiTaoPhieu = nguoiTaoPhieu;
        this.ngayMuon = ngayMuon;
    }

    public int getMaPhieuMuon() {
        return maPhieuMuon;
    }

    public void setMaPhieuMuon(int maPhieuMuon) {
        this.maPhieuMuon = maPhieuMuon;
    }

    public String getMaBanDoc() {
        return maBanDoc;
    }

    public void setMaBanDoc(String maBanDoc) {
        this.maBanDoc = maBanDoc;
    }

    public String getNguoiTaoPhieu() {
        return nguoiTaoPhieu;
    }

    public void setNguoiTaoPhieu(String nguoiTaoPhieu) {
        this.nguoiTaoPhieu = nguoiTaoPhieu;
    }

    public Date getNgayMuon() {
        return ngayMuon;
    }

    public void setNgayMuon(Date ngayMuon) {
        this.ngayMuon = ngayMuon;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PhieuMuon{maPhieuMuon=").append(maPhieuMuon);
        sb.append(", maBanDoc=").append(maBanDoc);
        sb.append(", nguoiTaoPhieu=").append(nguoiTaoPhieu);
        sb.append(", ngayMuon=").append(ngayMuon);
        sb.append('}');
        return sb.toString();
    }
    
}
