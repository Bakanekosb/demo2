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
public class PhieuTra {
    private int maPhieuTra;
    private String maBanDoc,nguoiTaoPhieu;
    private Date ngayTra;

    public PhieuTra() {
    }

    public PhieuTra(int maPhieuTra, String maBanDoc, String nguoiTaoPhieu, Date ngayTra) {
        this.maPhieuTra = maPhieuTra;
        this.maBanDoc = maBanDoc;
        this.nguoiTaoPhieu = nguoiTaoPhieu;
        this.ngayTra = ngayTra;
    }

    public int getMaPhieuTra() {
        return maPhieuTra;
    }

    public void setMaPhieuTra(int maPhieuTra) {
        this.maPhieuTra = maPhieuTra;
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

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PhieuTra{maPhieuTra=").append(maPhieuTra);
        sb.append(", maBanDoc=").append(maBanDoc);
        sb.append(", nguoiTaoPhieu=").append(nguoiTaoPhieu);
        sb.append(", ngayTra=").append(ngayTra);
        sb.append('}');
        return sb.toString();
    }
    
    
}
