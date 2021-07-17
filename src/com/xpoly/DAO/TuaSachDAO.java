/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.TuaSach;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Dell
 */
public class TuaSachDAO implements IDAO<TuaSach, Integer>{

    @Override
    public void insert(TuaSach model) {
        String insert_sql = "INSERT INTO TUASACH (tentuasach,nxb,namxb,sotrang,giatien,motxa,ghichu,soluong,madm) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(insert_sql, model.getMaTuaSach(),
                model.getNxb(),model.getNamxb(),
                model.getSoLuong(),model.getGiaTien(),
                model.getMoTa(),model.getGhiChu(),
                model.getSoLuong(),model.getMadm()
        
        );
    }
    
    @Override
    public void update(TuaSach model) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TuaSach> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TuaSach> selectBySql(String sql, Object... args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TuaSach selectById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TuaSach readFromResultSet(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
