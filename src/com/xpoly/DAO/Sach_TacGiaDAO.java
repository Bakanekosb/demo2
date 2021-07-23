/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.Sach_Tg;
import com.xpoly.model.TacGia;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class Sach_TacGiaDAO implements IDAO<Sach_Tg, Integer> {

    public Sach_TacGiaDAO() {
        new TacGiaDAO();
    }

    @Override
    public void insert(Sach_Tg model) {
        String insert_sql = "INSERT INTO sach_tg (matuasach,matg) "
                + "VALUES (?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getMaTuaSach(), model.getMaTacGia());
    }

    @Override
    public void update(Sach_Tg model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        String sql = "delete from sach_tg where matuasach = ?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public Sach_Tg selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String selectTacgia(int id) {
        String sql = "SELECT * FROM SACH_TG WHERE MATUASACH = ?";
        List<String> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql,id);
                while (rs.next()) {
                    Sach_Tg model = readFromResultSet(rs);
                    lst.add(EzHelper.MAP_TG.get(model.getMaTacGia()));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
       
        return String.join(";", lst);
    }

    @Override
    public List<Sach_Tg> selectAll() {
        String selectAll_sql = "SELECT * FROM Sach_tg";
        return selectBySql(selectAll_sql);
    }

    @Override
    public List<Sach_Tg> selectBySql(String sql, Object... args) {
        List<Sach_Tg> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    Sach_Tg model = readFromResultSet(rs);
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
    public Sach_Tg readFromResultSet(ResultSet rs) throws SQLException {
        Sach_Tg model = new Sach_Tg();
        model.setMaTuaSach(rs.getInt(1));
        model.setMaTacGia(rs.getInt(2));
        return model;
    }

}
