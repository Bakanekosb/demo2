/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class PhieuMuon_DAO implements IDAO<PhieuMuon, Integer>{

    @Override
    public void insert(PhieuMuon model) {
        String sql = "insert into phieumuon (mabandoc ,ngaymuon ,nguoitaophieu ) values (?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaBanDoc(), model.getNgayMuon(), model.getNguoiTaoPhieu());
    }

    @Override
    public void update(PhieuMuon model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhieuMuon selectById(Integer id) {
        String sql = "select * from phieumuon where maphieumuon = ?";
        List<PhieuMuon> lst = selectBySql(sql,id); 
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public List<PhieuMuon> selectAll() {
        String sql = "select * from phieumuon";
        return selectBySql(sql);
    }
    
    public int soSachDangMuon(String mand){
       int soSachDangMuon = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_SOSACHDANGMUON (?)}";
                rs = JdbcHelper.executeQuery(sql, mand);
                while (rs.next()) {
                    soSachDangMuon = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return soSachDangMuon;
    }    
    
    public boolean tuaSachDangDuocMuon(int matuaSach, String mand){
       int tuaSachDangDuocMuon = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_tuaSachDangMuon (?, ?)}";
                rs = JdbcHelper.executeQuery(sql, matuaSach, mand);
                while (rs.next()) {
                    tuaSachDangDuocMuon = rs.getInt(1);
                    System.out.println("count = " + tuaSachDangDuocMuon);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return tuaSachDangDuocMuon > 0;
    } 
    
    public int soSachChuaTraTrongPhieuMuon(int maphieumuon){
       int soSachChuaTraTrongPhieuMuon = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_soSachChuaTraTrongPhieuMuon (?)}";
                rs = JdbcHelper.executeQuery(sql, maphieumuon);
                while (rs.next()) {
                    soSachChuaTraTrongPhieuMuon = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return soSachChuaTraTrongPhieuMuon;
    }    
    
    public int soSanhNgay(Date date){
       int soSanhNgay = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_soSanhNgay (?)}";
                rs = JdbcHelper.executeQuery(sql, date);
                while (rs.next()) {
                    soSanhNgay = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return soSanhNgay;
    }    
    
    public int[] soSachDaTra(int maphieumuon){
        int soSachDaTra = 0;
        int soSachMuon = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "select count(*) from pmct where maphieumuon = ? and trangthai = 1";
                rs = JdbcHelper.executeQuery(sql, maphieumuon);
                while (rs.next()) {
                    soSachDaTra = rs.getInt(1);
                }
                sql = "select count(*) from pmct where maphieumuon = ?";
                rs = JdbcHelper.executeQuery(sql, maphieumuon);
                while (rs.next()) {
                    soSachMuon = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return new int[]{soSachDaTra,soSachMuon};
    }

    @Override
    public List<PhieuMuon> selectBySql(String sql, Object... args) {
        List<PhieuMuon> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PhieuMuon model = readFromResultSet(rs);
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
    public PhieuMuon readFromResultSet(ResultSet rs) throws SQLException {
        PhieuMuon model = new PhieuMuon();
        model.setMaPhieuMuon(rs.getInt(1));
        model.setMaBanDoc(rs.getString(2));
        model.setNgayMuon(rs.getDate(3));
        model.setNguoiTaoPhieu(rs.getString(4));
        return model;
    }
    
}
