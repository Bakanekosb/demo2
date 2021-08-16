/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.helper.JdbcHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ThongKeDAO {
    public List<Object[]> getSachMuonTheoThang(int year) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_sachMuonTheoThang (?)}";
                rs = JdbcHelper.executeQuery(sql, year);
                while (rs.next()) {   
                    Object[] model = {
                        rs.getInt(1),
                        rs.getInt(2),
                    };
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return list;
    }
    
    public List<Object[]> getNamVaSoSachMuon() {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_namMuon}";
                rs = JdbcHelper.executeQuery(sql);
                while (rs.next()) { 
                    list.add(new Object[]{rs.getInt(1), rs.getInt(2)});
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);

        }
        return list;
    }
}
