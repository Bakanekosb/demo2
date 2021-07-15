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
public class DatSach {
    private int maDatSach,maTuaSach,trangThai;
    private  String mand;
    private Date ngayDat,ngayHenLaySach;

    public DatSach() {
    }

    public DatSach(int maDatSach, int maTuaSach, int trangThai, String mand, Date ngayDat, Date ngayHenLaySach) {
        this.maDatSach = maDatSach;
        this.maTuaSach = maTuaSach;
        this.trangThai = trangThai;
        this.mand = mand;
        this.ngayDat = ngayDat;
        this.ngayHenLaySach = ngayHenLaySach;
    }

    public int getMaDatSach() {
        return maDatSach;
    }

    public void setMaDatSach(int maDatSach) {
        this.maDatSach = maDatSach;
    }

    public int getMaTuaSach() {
        return maTuaSach;
    }

    public void setMaTuaSach(int maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getMand() {
        return mand;
    }

    public void setMand(String mand) {
        this.mand = mand;
    }

    public Date getNgayDat() {
        return ngayDat;
    }

    public void setNgayDat(Date ngayDat) {
        this.ngayDat = ngayDat;
    }

    public Date getNgayHenLaySach() {
        return ngayHenLaySach;
    }

    public void setNgayHenLaySach(Date ngayHenLaySach) {
        this.ngayHenLaySach = ngayHenLaySach;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DatSach{maDatSach=").append(maDatSach);
        sb.append(", maTuaSach=").append(maTuaSach);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", mand=").append(mand);
        sb.append(", ngayDat=").append(ngayDat);
        sb.append(", ngayHenLaySach=").append(ngayHenLaySach);
        sb.append('}');
        return sb.toString();
    }
    
            
}
