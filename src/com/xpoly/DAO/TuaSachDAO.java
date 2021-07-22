/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.Sach_Tg;
import com.xpoly.model.TuaSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Dell
 */
public class TuaSachDAO implements IDAO<TuaSach, Integer>{

    @Override
    public void insert(TuaSach model) {
        String insert_sql = "INSERT INTO TUASACH (tentuasach,nxb,namxuatban,sotrang,giatien,mota,ghichu,soluong,madm,anh) "
                + "VALUES(?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getTenTuaSach(),
                model.getNxb(),model.getNamxb(),
                model.getSoTrang(),model.getGiaTien(),
                model.getMoTa(),model.getGhiChu(),
                model.getSoLuong(),model.getMadm(), model.getAnh()
        );
    }
    
//    public int insertCheckExist(TuaSach model) {
//        String insert_sql = "INSERT INTO TUASACH (tentuasach,nxb,namxb,sotrang,giatien,mota,ghichu,soluong,anh,madm) "
//                + "VALUES(?,?,?,?,?,?,?,?,?)";
//        JdbcHelper.executeUpdate(insert_sql, model.getMaTuaSach(),
//                model.getNxb(),model.getNamxb(),
//                model.getSoLuong(),model.getGiaTien(),
//                model.getMoTa(),model.getGhiChu(),
//                model.getSoLuong(),model.getAnh(),model.getMadm()        
//        );
//    }
    
    @Override
    public void update(TuaSach model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TuaSach> selectAll() {
        String selectAll_sql = "SELECT * FROM TUASACH";
        return selectBySql(selectAll_sql);
    }
    

    
     public List<TuaSach> selectByKeyword(String keyword, int pageNumber, int rowsOfPage) throws SQLException {
        String sql = "{call SP_SELECTTUASACH (?,?,?)}";
        List<TuaSach> lst = new ArrayList<>();
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
     
     public int getTotalRows(String keyword){
        int total = 0;
        try {
            ResultSet rs = null;
            try {
                String sql = "{call SP_TuaSachTOTALROWS (?)}";
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

    @Override
    public List<TuaSach> selectBySql(String sql, Object... args) {
        List<TuaSach> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TuaSach model = readFromResultSet(rs);
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
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TuaSach selectById(Integer id) {
        String selectById_sql = "SELECT * FROM TUASACH where matuasach = ?";
        List<TuaSach> lst = selectBySql(selectById_sql, id);
        return lst.isEmpty() ? null : lst.get(0);
    }
    
    public TuaSach selectLastItem(){
        String selectById_sql = "SELECT * FROM TUASACH where matuasach = (select max(matuasach) from tuasach)";
        List<TuaSach> lst = selectBySql(selectById_sql);
        return lst.isEmpty() ? null : lst.get(0);
    }
    

    @Override
    public TuaSach readFromResultSet(ResultSet rs) throws SQLException {
        TuaSach model = new TuaSach();
        model.setMaTuaSach(rs.getInt("matuasach"));
        model.setTenTuaSach(rs.getString("tentuasach"));
        model.setNxb(rs.getString("nxb"));
        model.setNamxb(rs.getInt("namxuatban"));
        model.setSoTrang(rs.getInt("sotrang"));
        model.setGiaTien(rs.getDouble("giatien"));
        model.setMoTa(rs.getString("mota"));
        model.setTrangThai(rs.getInt("trangthai"));
        model.setGhiChu(rs.getString("GHICHU"));
        model.setSoLuong(rs.getInt("soluong"));
        model.setAnh(rs.getString("anh"));
        model.setMadm(rs.getString("madm"));        
        return model;
    }
//    
//    matuasach int identity(10000,1) not null primary key,
//tentuasach nvarchar(100) not null,
//nxb nvarchar(50),
//namxuatban int,
//sotrang int not null,
//giatien money not null,
//mota nvarchar(200),
//ghichu nvarchar(200),
//trangthai int default 0 not null,
//soluong int not null,
//anh nvarchar(max),
//madm varchar(10)
}
