/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.PMCT;
import com.xpoly.model.PhieuMuon;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class PhieuMuonCT_DAO implements IDAO<PMCT, String> {

    @Override
    public void insert(PMCT model) {
        String sql = "insert into pmct (maphieumuon ,maquyensach ,trangthai ,solangiahan ,ghichu ) values (?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaPhieuMuon(), model.getMaQuyenSach(), 0,
                 0, model.getGhiChu());
    }

    @Override
    public void update(PMCT model) {
        String sql = "update pmct set trangthai =?,ngaygiahan =?,solangiahan =?,ghichu =? where maphieumuon = ? and maquyensach = ?";
        JdbcHelper.executeUpdate(sql, model.getTrangThai(), model.getNgayGiaHan(), model.getSoLanGiaHan(), model.getGhiChu(),
                model.getMaPhieuMuon(), model.getMaQuyenSach());
    }

    @Override
    public void delete(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PMCT selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PMCT> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<PMCT> selectByMaPhieuMuon(int id) {
        String sql = "select * from pmct where maphieumuon = ? ";
        return selectBySql(sql, id);
    }
    
    public PMCT selectById(int maphieumuon, int maquyensach) {
        String sql = "select * from pmct where maphieumuon = ? and maquyensach = ?";
        List<PMCT> lst = selectBySql(sql, maphieumuon, maquyensach);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public List<PMCT> selectBySql(String sql, Object... args) {
        List<PMCT> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    PMCT model = readFromResultSet(rs);
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
    public PMCT readFromResultSet(ResultSet rs) throws SQLException {
        PMCT model = new PMCT();
        model.setMaPhieuMuon(rs.getInt(1));
        model.setMaQuyenSach(rs.getInt(2));
        model.setTrangThai(rs.getInt(3));
        model.setNgayGiaHan(rs.getDate(4));
        model.setSoLanGiaHan(rs.getInt(5));
        model.setGhiChu(rs.getString(6));
        return model;
    }

}
