/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 77 thai ha
 */
public class DangNhapDAO implements IDAO<NguoiDung, String>{

    @Override
    public void insert(NguoiDung model) {
        String sql = "insert into nguoidung (mand,hoten,ngaysinh,gioitinh,sdt,email,diachi,vaitro,ghichu,matkhau,vitien)"
                + " VALUSE(?,?,?,?,?,?,?,?,?,?,?) ";
                JdbcHelper.executeUpdate(sql, 
                        model.getMaND(),
                        model.getHoTen(),
                        model.getNgaySinh(),
                        model.isGioiTinh(),
                        model.getSdt(),
                        model.getEmail(),
                        model.getDiaChi(),
                        model.getVaiTro(),
                        model.getGhiChu(),
                        model.getMatKhau(),
                        model.getViTien()
                );
    }

    @Override
    public void update(NguoiDung model) {
        String sql = "update nguoidung set matkhau = ? where mand = ?";
        JdbcHelper.executeUpdate(sql,model.getMatKhau(),model.getMaND());
                
    }

    @Override
    public void delete(String mand) {
            String sql = "Select * from NguoiDung mand = ?";
            JdbcHelper.executeUpdate(sql, mand);
    }

   
    public NguoiDung findById(String MaND) {
        String sql = "SELECT * FROM nguoidung WHERE mand= ?";
        List<NguoiDung> list = selectBySql(sql, MaND);
        return list.size() > 0 ? list.get(0) : null; 
    }

    @Override
    public List<NguoiDung> selectAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<NguoiDung> selectBySql(String sql, Object... args) {
       List<NguoiDung> lst = new ArrayList<>();
        try {
            System.out.println("select");
            ResultSet rs = null;
            try {
                rs = JdbcHelper.executeQuery(sql, args);
                while (rs.next()) {
                    NguoiDung model = readFromResultSet(rs);
                    lst.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return lst;    }

    @Override
    public NguoiDung readFromResultSet(ResultSet rs) throws SQLException {
        NguoiDung model = new NguoiDung();
        model.setMaND(rs.getString(1));
        model.setHoTen(rs.getString(2));
        model.setNgaySinh(rs.getDate(3));
        model.setGioiTinh(rs.getBoolean(4));
        model.setSdt(rs.getString(5));
        model.setEmail(rs.getString(6));
        model.setDiaChi(rs.getString(7));
        model.setVaiTro(rs.getInt(8));
        model.setGhiChu(rs.getString(9));
        model.setMatKhau(rs.getString(10));
        model.setViTien(rs.getDouble(11));
        model.setAnh(rs.getString(12));
        return model;    }

    @Override
    public NguoiDung selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<NguoiDung> select(String sql, String MaND) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
