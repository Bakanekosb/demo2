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
public class QuyenSach {
    private int maQuyenSach;
    private String viTri;
    private boolean duocMuonVe;
    private int tinhTrang;
    private int trangThai;
    private String ghiChu;
    int maTuaSach;

    public QuyenSach() {
    }

    public QuyenSach(String viTri, boolean duocMuonVe, String ghiChu, int maTuaSach) {
        this.viTri = viTri;
        this.duocMuonVe = duocMuonVe;
        this.ghiChu = ghiChu;
        this.maTuaSach = maTuaSach;
    }
    
   

    public int getMaQuyenSach() {
        return maQuyenSach;
    }

    public void setMaQuyenSach(int maQuyenSach) {
        this.maQuyenSach = maQuyenSach;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public boolean isDuocMuonVe() {
        return duocMuonVe;
    }

    public void setDuocMuonVe(boolean duocMuonVe) {
        this.duocMuonVe = duocMuonVe;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
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

    public int getMaTuaSach() {
        return maTuaSach;
    }

    public void setMaTuaSach(int maTuaSach) {
        this.maTuaSach = maTuaSach;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("QuyenSach{maQuyenSach=").append(maQuyenSach);
        sb.append(", viTri=").append(viTri);
        sb.append(", duocMuonVe=").append(duocMuonVe);
        sb.append(", tinhTrang=").append(tinhTrang);
        sb.append(", trangThai=").append(trangThai);
        sb.append(", ghiChu=").append(ghiChu);
        sb.append(", maTuaSach=").append(maTuaSach);
        sb.append('}');
        return sb.toString();
    }


  
}
