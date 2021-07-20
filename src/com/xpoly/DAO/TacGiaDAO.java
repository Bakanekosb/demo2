/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.TacGia;
import com.xpoly.ui.QLSach.ThemSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class TacGiaDAO implements IDAO<TacGia, Integer> {
    
     public TacGiaDAO() {
        List<TacGia> lst_tg = selectAll();
        for (int i = 0; i < lst_tg.size(); i++) {
            EzHelper.MAP_TG.put(lst_tg.get(i).getMaTg(), lst_tg.get(i).getTenTg());
        }
    }

    @Override
    public void insert(TacGia model) {
    String sql = "insert into tacgia (tentg, ngaysinh, quoctich) values (?,?,?)";
    JdbcHelper.executeUpdate(sql, model.getTenTg(),model.getNgaySinh(),model.getQuocTich());
    }

    @Override
    public void update(TacGia model) {
          String sql = "update tacgia set tentg = N'? , ngaysinh = '?' ,quoctich = N'?'  where tentg =  N'?'";
          JdbcHelper.executeUpdate(sql, model.getTenTg(), model.getNgaySinh(),model.getQuocTich(),model.getTenTg());
   }

    @Override
    public void delete(Integer id) {
        String sql = "update tacgia set trangthai = 1 where tentg =  ?";
        JdbcHelper.executeUpdate(sql, 1);
    }

    @Override
    public TacGia selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TacGia> selectAll() {
        String selectAll_sql = "SELECT * FROM TACGIA";
        return selectBySql(selectAll_sql);

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
