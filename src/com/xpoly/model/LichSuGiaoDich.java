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
public class LichSuGiaoDich {
  private int magd;
  private String mand;
  private Date ngayGiaoDich;
  private double soTien;
  private String noiDung;
  private  String nguoiTaoGiaoDich;

    public LichSuGiaoDich() {
    }

    public LichSuGiaoDich(int magd, String mand, Date ngayGiaoDich, double soTien, String noiDung, String nguoiTaoGiaoDich) {
        this.magd = magd;
        this.mand = mand;
        this.ngayGiaoDich = ngayGiaoDich;
        this.soTien = soTien;
        this.noiDung = noiDung;
        this.nguoiTaoGiaoDich = nguoiTaoGiaoDich;
    }

    public LichSuGiaoDich(int magd, String mand, Date ngayGiaoDich, double soTien, String nguoiTaoGiaoDich) {
        this.magd = magd;
        this.mand = mand;
        this.ngayGiaoDich = ngayGiaoDich;
        this.soTien = soTien;
        this.nguoiTaoGiaoDich = nguoiTaoGiaoDich;
    }

   
    public int getMagd() {
        return magd;
    }

    public void setMagd(int magd) {
        this.magd = magd;
    }

    public String getMand() {
        return mand;
    }

    public void setMand(String mand) {
        this.mand = mand;
    }

    public Date getNgayGiaoDich() {
        return ngayGiaoDich;
    }

    public void setNgayGiaoDich(Date ngayGiaoDich) {
        this.ngayGiaoDich = ngayGiaoDich;
    }

    public double getSoTien() {
        return soTien;
    }

    public void setSoTien(double soTien) {
        this.soTien = soTien;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNguoiTaoGiaoDich() {
        return nguoiTaoGiaoDich;
    }

    public void setNguoiTaoGiaoDich(String nguoiTaoGiaoDich) {
        this.nguoiTaoGiaoDich = nguoiTaoGiaoDich;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LichSuGiaoDich{magd=").append(magd);
        sb.append(", mand=").append(mand);
        sb.append(", ngayGiaoDich=").append(ngayGiaoDich);
        sb.append(", soTien=").append(soTien);
        sb.append(", noiDung=").append(noiDung);
        sb.append(", nguoiTaoGiaoDich=").append(nguoiTaoGiaoDich);
        sb.append('}');
        return sb.toString();
    }
  
}
