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
public class TacGia {
       private int maTg  ;
  private String tenTg;
  private Date ngaySinh;
 private  String quocTich;

    public TacGia() {
    }

    public TacGia(int maTg, String tenTg, Date ngaySinh, String quocTich) {
        this.maTg = maTg;
        this.tenTg = tenTg;
        this.ngaySinh = ngaySinh;
        this.quocTich = quocTich;
    }

    public int getMaTg() {
        return maTg;
    }

    public void setMaTg(int maTg) {
        this.maTg = maTg;
    }

    public String getTenTg() {
        return tenTg;
    }

    public void setTenTg(String tenTg) {
        this.tenTg = tenTg;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getQuocTich() {
        return quocTich;
    }

    public void setQuocTich(String quocTich) {
        this.quocTich = quocTich;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TacGia{maTg=").append(maTg);
        sb.append(", tenTg=").append(tenTg);
        sb.append(", ngaySinh=").append(ngaySinh);
        sb.append(", quocTich=").append(quocTich);
        sb.append('}');
        return sb.toString();
    }
}
