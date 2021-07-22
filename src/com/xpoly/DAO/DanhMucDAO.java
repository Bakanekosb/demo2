/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.DanhMuc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DanhMucDAO implements IDAO<DanhMuc, String>{

    public DanhMucDAO() {
        List<DanhMuc> lst_danhMuc = selectAll();
        for (int i = 0; i < lst_danhMuc.size(); i++) {
            EzHelper.MAP_DANHMUC.put(lst_danhMuc.get(i).getMaDanhMuc(), lst_danhMuc.get(i).getTenDanhMuc());
        }
    }

    
    
    @Override
    public void insert(DanhMuc model) {
        String sql = "insert into danhmuc (madm,tendm)\n" +
" values (?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaDanhMuc(),model.getTenDanhMuc());
    }

    @Override
    public void update(DanhMuc model) {
        String sql = "update danhmuc set tendm = ? where madm = ? ";
        JdbcHelper.executeUpdate(sql, model.getTenDanhMuc(),model.getMaDanhMuc());
   }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DanhMuc selectById(String id) {
        return null;
    }

    @Override
    public List<DanhMuc> selectAll() {
        String selectAll_sql = "SELECT * FROM DANHMUC";
        return selectBySql(selectAll_sql);
    }

    @Override
    public List<DanhMuc> selectBySql(String sql, Object... args) {
        List<DanhMuc> lst = new ArrayList<>();
        try {
            System.out.println("select");
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DanhMuc model = readFromResultSet(rs);
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
    public DanhMuc readFromResultSet(ResultSet rs) throws SQLException {
        DanhMuc model = new DanhMuc();
        model.setMaDanhMuc(rs.getString(1));
        model.setTenDanhMuc(rs.getString(2));
        return model;
    }
    

}
