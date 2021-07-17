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
import java.util.List;

/**
 *
 * @author Dell
 */
public class QuyenSachDAO implements IDAO<QuyenSach, Integer>{

//    vitri nvarchar(20) not null,
//duocmuonve bit not null, -- (duocmuonve = 1, doctaicho = 0)
//tinhtrang int not null, -- (dangphucvu = 0, hong = 1, mat = 2, ngungphucvu = 3)
//trangthai int not null, -- (sansanchomuon = 0, dangmuon = 1, duocdat = 2 )
//ghichu nvarchar(50),
//matuasach
    
    @Override
    public void insert(QuyenSach model) {
        String insert_sql = "INSERT INTO Quyensach (vitri,duocmuonve,matuasach)  "
                + "VALUES(?,?,?)";
        JdbcHelper.executeUpdate(insert_sql,model.getViTri(),model.isDuocMuonVe(), model.getMaTuaSach());    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuyenSach> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuyenSach> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public QuyenSach readFromResultSet(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
