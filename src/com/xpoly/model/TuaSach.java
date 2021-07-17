/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.model;

/**
 *
 * @author Dell
 */
public class TuaSach {
    private int maTuaSach;
  private String tenTuaSach;
  private String nxb;
  private int namxb;
  private int soTrang;
  private double giaTien;
  private String moTa;
  private String ghiChu;
  private int trangThai;
  private int soLuong;
  private String madm;
  private String anh;

    public TuaSach() {
    }

    public TuaSach(String tenTuaSach, String nxb, int namxb, int soTrang, double giaTien, String moTa, String ghiChu, int soLuong, String madm, String anh) {
        this.tenTuaSach = tenTuaSach;
        this.nxb = nxb;
        this.namxb = namxb;
        this.soTrang = soTrang;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.soLuong = soLuong;
        this.madm = madm;
        this.anh = anh;
    }

    public TuaSach(int maTuaSach, String tenTuaSach, String nxb, int namxb, int soTrang, double giaTien, String moTa, String ghiChu, int trangThai, int soLuong, String madm, String anh) {
        this.maTuaSach = maTuaSach;
        this.tenTuaSach = tenTuaSach;
        this.nxb = nxb;
        this.namxb = namxb;
        this.soTrang = soTrang;
        this.giaTien = giaTien;
        this.moTa = moTa;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.soLuong = soLuong;
        this.madm = madm;
        this.anh = anh;
    }
    
    

    

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    

    public int getNamxb() {
        return namxb;
    }

    public void setNamxb(int namxb) {
        this.namxb = namxb;
    }
    
    public int getMaTuaSach() {
        return maTuaSach;
    }

    public void setMaTuaSach(int maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    public String getTenTuaSach() {
        return tenTuaSach;
    }

    public void setTenTuaSach(String tenTuaSach) {
        this.tenTuaSach = tenTuaSach;
    }

    public String getNxb() {
        return nxb;
    }

    public void setNxb(String nxb) {
        this.nxb = nxb;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getMadm() {
        return madm;
    }

    public void setMadm(String madm) {
        this.madm = madm;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TuaSach{maTuaSach=").append(maTuaSach);
        sb.append(", tenTuaSach=").append(tenTuaSach);
        sb.append(", nxb=").append(nxb);
        sb.append(", soTrang=").append(soTrang);
        sb.append(", giaTien=").append(giaTien);
        sb.append(", moTa=").append(moTa);
        sb.append(", ghiChu=").append(ghiChu);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", soLuong=").append(soLuong);
        sb.append(", madm=").append(madm);
        sb.append('}');
        return sb.toString();
    }

   
  
  
  
   
}
