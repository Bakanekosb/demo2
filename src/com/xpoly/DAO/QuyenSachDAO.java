/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.QuyenSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class QuyenSachDAO implements IDAO<QuyenSach, Integer> {

//    vitri nvarchar(20) not null,
//duocmuonve bit not null, -- (duocmuonve = 1, doctaicho = 0)
//tinhtrang int not null, -- (dangphucvu = 0, hong = 1, mat = 2, ngungphucvu = 3)
//trangthai int not null, -- (sansanchomuon = 0, dangmuon = 1, duocdat = 2 )
//ghichu nvarchar(50),
//matuasach
    @Override
    public void insert(QuyenSach model) {
        String insert_sql = "INSERT INTO Quyensach (vitri,duocmuonve,ghichu, matuasach)  "
                + "VALUES(?,?,?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getViTri(), model.isDuocMuonVe(),
                model.getGhiChu(), model.getMaTuaSach());
    }

    @Override
    public void update(QuyenSach model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuyenSach selectById(Integer id) {
      String selectById_sql = "SELECT * FROM QuyenSach WHERE MAQUYENSACH = ?";
        List<QuyenSach> lst = selectBySql(selectById_sql, id);
        return lst.isEmpty() ? null : lst.get(0);
    }

    @Override
    public List<QuyenSach> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<QuyenSach> selectSachSanSangChoMuonByTuaSach(int id) {
        String selectAllByTuaSach_sql = "select * from QuyenSach where matuasach = ? and duocmuonve = 1 and tinhtrang = 0 and trangthai = 0";
        List<QuyenSach> lst = selectBySql(selectAllByTuaSach_sql, id);
        return lst;
    }
    

    @Override
    public List<QuyenSach> selectBySql(String sql, Object... args) {
        List<QuyenSach> lst = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    QuyenSach model = readFromResultSet(rs);
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
    public QuyenSach readFromResultSet(ResultSet rs) throws SQLException {
        QuyenSach model = new QuyenSach();
        model.setMaQuyenSach(rs.getInt(1));
        model.setViTri(rs.getString(2));
        model.setDuocMuonVe(rs.getBoolean(3));
        model.setTinhTrang(rs.getInt(4));
        model.setTrangThai(rs.getInt(5));
        model.setGhiChu(rs.getString(6));
        model.setMaTuaSach(rs.getInt(7));
        return model;
    }

//    private int maQuyenSach;
//    private String viTri;
//    private boolean duocMuonVe;
//    private int tinhTrang;
//    private int trangThai;
//    private String ghiChu;
//    int maTuaSach;
}
