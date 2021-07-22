/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.DatSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DatSachDAO implements IDAO<DatSach, Integer> {

    @Override
    public void insert(DatSach model) {
        String insert_sql = "insert into datsach (mand, matuasach, ngaydat, trangthai, ngayhenlaysach) values "
                + "(?,?,?,?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getMand(), model.getMaTuaSach(), model.getNgayDat(),
                model.getTrangThai(), model.getNgayHenLaySach());
    }

    @Override
    public void update(DatSach model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DatSach selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DatSach> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<DatSach> selectByMand(String id) {
        String selectByMand = "SELECT * FROM DatSach WHERE mand = ?";
        return selectBySql(selectByMand, id);
    }
    
    public boolean datDuocKhong(String mand, int maTuaSach){
        String sql = "SELECT * FROM DatSach WHERE mand = ? and matuasach = ? and (trangthai = 0 or trangthai = 1)";
        return selectBySql(sql, mand, maTuaSach).isEmpty();
    }

    @Override
    public List<DatSach> selectBySql(String sql, Object... args) {
        List<DatSach> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    DatSach model = readFromResultSet(rs);
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
    public DatSach readFromResultSet(ResultSet rs) throws SQLException {
        DatSach model = new DatSach();
        model.setMaDatSach(rs.getInt(1));
        model.setMand(rs.getString(2));
        model.setMaTuaSach(rs.getInt(3));
        model.setNgayDat(rs.getDate(4));
        model.setTrangThai(rs.getInt(5));
        model.setNgayHenLaySach(rs.getDate(6));
        return model;
    }

//    this.maDatSach = maDatSach;
//        this.maTuaSach = maTuaSach;
//        this.trangThai = trangThai;
//        this.mand = mand;
//        this.ngayDat = ngayDat;
//        this.ngayHenLaySach = ngayHenLaySach;
}