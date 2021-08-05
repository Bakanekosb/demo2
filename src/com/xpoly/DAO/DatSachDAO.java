/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.EzHelper;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.DatSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
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

    public void updateTrangThaiDatSach(int trangthai, int madatsach, Date ngayHen) {
        if (trangthai != 1) {
            String update_sql = "update Datsach set trangthai = ? where madatsach = ? ";
            System.out.println("huy dat");
            JdbcHelper.executeUpdate(update_sql, trangthai, madatsach);
        } else {
            System.out.println(trangthai + " " + ngayHen);
            String sql = "update Datsach set trangthai = ?, ngayhenlaysach = ? where madatsach = ? ";
            JdbcHelper.executeUpdate(sql, trangthai, ngayHen, madatsach);
        }
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

    public List<List<Object>> selectByKeyword(String keyword, int trangthai1, int trangthai2, String mand) throws SQLException {
        String sql = "{call sp_selecttuasachfromdatsach (?,?,?,?)}";
        List<List<Object>> lst = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = JdbcHelper.executeQuery(sql, "%" + keyword + "%", trangthai1, trangthai2, "%" + mand + "%");
            while (rs.next()) {
                List<Object> temp = new ArrayList();
                Date d = rs.getDate("ngayhenlaysach");

                if (d != null && d.before(EzHelper.now()) && rs.getInt(5) != 3) {
                    updateTrangThaiDatSach(3, rs.getInt("madatsach"),EzHelper.now());
                } else {
                    
                    temp.add(rs.getInt(3));
                    temp.add(rs.getString("tentuasach"));
                    temp.add(rs.getDate("ngaydat"));
                    temp.add(rs.getDate("ngayhenlaysach"));
                    temp.add(rs.getInt(5));
                    temp.add(rs.getInt("madatsach"));
                    System.out.println("trang thai dat saach = " + rs.getInt(5));
                    lst.add(temp);
                }
            }
        } finally {
            rs.getStatement().getConnection().close();
        }
        return lst;
    }

    public boolean datDuocKhong(String mand, int maTuaSach) {
        String sql = "SELECT * FROM DatSach WHERE mand = ? and matuasach = ? and (trangthai = 0 or trangthai = 1)";
        return selectBySql(sql, mand, maTuaSach).isEmpty();
    }

    public List<DatSach> danhSachDenLuotMuon(int matuasach, int soluongsach) {
        String sql = "{call sp_danhSachDenLuotMuon (?,?)}";
        return selectBySql(sql, matuasach, soluongsach);
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
