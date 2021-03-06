/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.SachUaThich;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class SachUaThichDAO implements IDAO<SachUaThich, String> {

    @Override
    public void insert(SachUaThich model) {
        String insert_sql = "INSERT INTO Sachuathich (matuasach, mand) "
                + "VALUES (?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getMaTuaSach(), model.getMand());
        int soLuongLike = getSoLuongLike(model.getMaTuaSach());
        String update_sl = "update tuasach set soluongthich = ? where matuasach = ?";
        JdbcHelper.executeUpdate(update_sl, soLuongLike, model.getMaTuaSach());
    }

    @Override
    public void update(SachUaThich model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void deleteByND(int maTuaSach, String mand) {
        String delete = "delete from Sachuathich where maTuaSach = ? and mand = ?";
        JdbcHelper.executeUpdate(delete, maTuaSach, mand);
        int soLuongLike = getSoLuongLike(maTuaSach);
        String update_sl = "update tuasach set soluongthich = ? where matuasach = ?";
        JdbcHelper.executeUpdate(update_sl, soLuongLike, maTuaSach);
    }

    @Override
    public SachUaThich selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<SachUaThich> selectAllById(String id) {
        String selectById_sql = "SELECT * FROM sachuathich WHERE mand = ?";
        return selectBySql(selectById_sql, id);
    }

    public int getSoLuongLike(int id) {
        String sql = "select count(*) from sachuathich where matuasach = ?";
        int soLuongLike = 0;
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, id);
            while (rs.next()) {
                soLuongLike = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return soLuongLike;
    }

    public List<Integer> selectMaTuaSachFromSachUaThichByMaND(String id) {
        String sql = "SELECT * FROM sachuathich WHERE mand = ?";
        List<Integer> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, id);
                while (rs.next()) {
                    SachUaThich model = readFromResultSet(rs);
                    lst.add(model.getMaTuaSach());
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
    public List<SachUaThich> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<SachUaThich> selectBySql(String sql, Object... args) {
        List<SachUaThich> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    SachUaThich model = readFromResultSet(rs);
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
    public SachUaThich readFromResultSet(ResultSet rs) throws SQLException {
        SachUaThich model = new SachUaThich();
        model.setMaTuaSach(rs.getInt(2));
        model.setMand(rs.getString(1));
        return model;
    }

}
