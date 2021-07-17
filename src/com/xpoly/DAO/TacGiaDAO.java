/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.TacGia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class TacGiaDAO implements IDAO<TacGia, Integer> {

    @Override
    public void insert(TacGia model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(TacGia model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TacGia selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TacGia> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    public List<TacGia> selectByKeyword(String keyword, int pageNumber, int rowsOfPage) throws SQLException {
        String sql = "{call SP_SELECTTG (?,?,?)}";
        List<TacGia> lst = new ArrayList<>();
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
                String sql = "{call SP_TGTOTALROWS (?)}";
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
    public List<TacGia> selectBySql(String sql, Object... args) {
        List<TacGia> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    TacGia model = readFromResultSet(rs);
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
    public TacGia readFromResultSet(ResultSet rs) throws SQLException {
        TacGia model = new TacGia();
        model.setMaTg(rs.getInt(1));
        model.setTenTg(rs.getString(2));
        model.setNgaySinh(rs.getDate(3));
        model.setQuocTich(rs.getString(4));
        return model;
    }

}
