/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.NguoiDung;
import com.xpoly.model.TuaSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class NguoiDungDAO implements IDAO<NguoiDung, String> {

    @Override
    public void insert(NguoiDung model) {
        String sql = "insert into nguoidung (mand,hoten,ngaysinh,gioitinh,sdt,email,diachi,vaitro,ghichu,matkhau,vitien,anh,trangthai)\n"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaND(), model.getHoTen(), model.getNgaySinh(),
                model.isGioiTinh(), model.getSdt(), model.getEmail(), model.getDiaChi(),
                model.getVaiTro(), model.getGhiChu(), model.getMatKhau(), model.getViTien(),
                model.getAnh(), model.getTrangthai());
    }

    public List<NguoiDung> selectMand(String mand) {

        String sql = "select * from nguoidung where mand = ?";
        return selectBySql(sql, mand);
    }

    @Override
    public void update(NguoiDung model) {
        String sql = "update nguoidung set hoten = ? ,ngaysinh = ? ,gioitinh = ? ,sdt = ?, email = ? ,diachi = ?"
                + " ,vaitro = ? ,ghichu = ? , matkhau = ? where mand = ?";
        JdbcHelper.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(),
                model.isGioiTinh(), model.getSdt(), model.getEmail(), model.getDiaChi(),
                 model.getVaiTro(), model.getGhiChu(), model.getMatKhau(), model.getMaND()
        );
    }

    public void updatevitien(NguoiDung model) {
        String sql = "update nguoidung set vitien = ? where mand = ? ";
        JdbcHelper.executeUpdate(sql, model.getViTien(), model.getMaND());
    }

    public void updateMatKhau(String Email, String Pass) {
        System.out.println(Email+  Pass);
        String sql = "update nguoidung set matkhau = ? where email =?";
        JdbcHelper.executeUpdate(sql, Pass, Email);
        
    }
    
    public boolean kiemTraEmail(String email){
        String sql = "select * from nguoidung where email = ?";
        return selectBySql(sql, email).isEmpty();
    }

    @Override
    public void delete(String id) {
        String sql = "update nguoidung set trangthai = 1 where mand = ?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public NguoiDung selectById(String id) {
        String sql = "select * from nguoidung where mand = ?";
        List<NguoiDung> lst = selectBySql(sql, id);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public List<NguoiDung> selectAll() {
        String sql = "select * from nguoidung where vaitro  = 2 and trangthai = 0";
        return selectBySql(sql);
    }

    @Override
    public List<NguoiDung> selectBySql(String sql, Object... args) {
        List<NguoiDung> lst = new ArrayList<>();
        try {
            System.out.println("select");
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiDung model = readFromResultSet(rs);
                    lst.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return lst;
    }

    @Override
    public NguoiDung readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDung model = new NguoiDung();
        model.setMaND(rs.getString(1));
        model.setHoTen(rs.getString(2));
        model.setNgaySinh(rs.getDate(3));
        model.setGioiTinh(rs.getBoolean(4));
        model.setSdt(rs.getString(5));
        model.setEmail(rs.getString(6));
        model.setDiaChi(rs.getString(7));
        model.setVaiTro(rs.getInt(8));
        model.setGhiChu(rs.getString(9));
        model.setMatKhau(rs.getString(10));
        model.setViTien(rs.getDouble(11));
        model.setAnh(rs.getString(12));
        return model;
    }

    public List<NguoiDung> thongke() {
        String sql = "SELECT mand, COUNT(*) as so_luong FROM nguoidung GROUP BY mand ";
        return selectBySql(sql);
    }

    public int getTotalRows(String keyword) {
        int total = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_TGTOTALROWSNGUOIDUNG (?)}";
                rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%");
                while (rs.next()) {
                    total = rs.getInt("Total");
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return total;
    }

    public List<NguoiDung> selectByKeyword(String keyword, int pageNumber, int rowsOfPage) throws SQLException {
        String sql = "{call SP_SELECTNGUOIDUNG (?,?,?)}";
        List<NguoiDung> lst = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%", pageNumber, rowsOfPage);
            while (rs.next()) {
                lst.add(readFromResultSet(rs));
            }
        } finally {
            rs.getStatement().getConnection().close();
        }
        return lst;
    }

 
}
