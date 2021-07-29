/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.LichSuGiaoDich;
import com.xpoly.model.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class LsgdDAO implements IDAO<LichSuGiaoDich, String> {

    @Override
    public void insert(LichSuGiaoDich model) {
        String sql = "insert into lichsugiaodich \n"
                + "values (?,?,?,N'nạp tiền',?)";
        JdbcHelper.executeUpdate(sql, model.getMand(), model.getNgayGiaoDich(), model.getSoTien(), model.getNguoiTaoGiaoDich());
    }

    @Override
    public void update(LichSuGiaoDich model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LichSuGiaoDich> selectAll() {
        String sql = "select * from lichsugiaodich";
        return selectBySql(sql);
    }



    @Override
    public List<LichSuGiaoDich> selectBySql(String sql, Object... args) {
        List<LichSuGiaoDich> lst = new ArrayList<>();
        try {
            System.out.println("select");
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    LichSuGiaoDich model = readFromResultSet(rs);
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
    public LichSuGiaoDich readFromResultSet(ResultSet rs) throws SQLException {
        LichSuGiaoDich model = new LichSuGiaoDich();
        model.setMagd(rs.getInt(1));
        model.setMand(rs.getString(2));
        model.setNgayGiaoDich(rs.getDate(3));
        model.setSoTien(rs.getFloat(4));
        model.setNoiDung(rs.getString(5));
        model.setNguoiTaoGiaoDich(rs.getString(6));

        return model;
    }

    @Override
    public void delete(String id) {
   
    }

    @Override
    public LichSuGiaoDich selectById(String id) {
        return null;
   
    }

}
