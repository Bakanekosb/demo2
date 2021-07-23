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
public class NguoiDung {
    private String maND;
    private String hoTen;
    private Date ngaySinh;
    private boolean gioiTinh;
    private String sdt;
    private String email;
    private String diaChi;
    private int vaiTro;
    private String ghiChu;
    private String matKhau;
    private double viTien;
    private String anh;
    private  int trangthai;

    public NguoiDung() {
    }

    public NguoiDung(String maND) {
        this.maND = maND;
    }   

    public NguoiDung(String maND, double viTien) {
        this.maND = maND;
        this.viTien = viTien;
    }
    
    public NguoiDung(String maND, String hoTen, Date ngaySinh, boolean gioiTinh, String sdt, String email, String diaChi, int vaiTro, String ghiChu, String matKhau, double viTien, String anh, int trangthai) {
        this.maND = maND;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
        this.sdt = sdt;
        this.email = email;
        this.diaChi = diaChi;
        this.vaiTro = vaiTro;
        this.ghiChu = ghiChu;
        this.matKhau = matKhau;
        this.viTien = viTien;
        this.anh = anh;
        this.trangthai = trangthai;
    }
    

 
    public String getMaND() {
        return maND;
    }

    public void setMaND(String maND) {
        this.maND = maND;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public boolean isGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getVaiTro() {
        return vaiTro;
    }

    public void setVaiTro(int vaiTro) {
        this.vaiTro = vaiTro;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public double getViTien() {
        return viTien;
    }

    public void setViTien(double viTien) {
        this.viTien = viTien;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public int getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(int trangthai) {
        this.trangthai = trangthai;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("NguoiDung{maND=").append(maND);
        sb.append(", hoTen=").append(hoTen);
        sb.append(", ngaySinh=").append(ngaySinh);
        sb.append(", gioiTinh=").append(gioiTinh);
        sb.append(", sdt=").append(sdt);
        sb.append(", email=").append(email);
        sb.append(", diaChi=").append(diaChi);
        sb.append(", vaiTro=").append(vaiTro);
        sb.append(", ghiChu=").append(ghiChu);
        sb.append(", matKhau=").append(matKhau);
        sb.append(", viTien=").append(viTien);
        sb.append(", anh=").append(anh);
        sb.append('}');
        return sb.toString();
    }

   
    
    
}
