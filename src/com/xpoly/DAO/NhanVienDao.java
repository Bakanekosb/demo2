/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.DAO;

import com.xpoly.Interface.IDAO;
import com.xpoly.helper.JdbcHelper;
import com.xpoly.model.DanhMuc;
import com.xpoly.model.DatSach;
import com.xpoly.model.NguoiDung;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Admin
 */
public class NhanVienDao implements IDAO<NguoiDung, String> {

    @Override
    public void insert(NguoiDung model) {
        String sql = "insert into nguoidung (mand,hoten,ngaysinh,gioitinh,sdt,email,diachi,vaitro,ghichu,matkhau,vitien,anh,trangthai)\n"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        JdbcHelper.executeUpdate(sql, model.getMaND(), model.getHoTen(), model.getNgaySinh(),
                model.isGioiTinh(), model.getSdt(), model.getEmail(), model.getDiaChi(),
                model.getVaiTro(), model.getGhiChu(), model.getMatKhau(), model.getViTien(),
                model.getAnh(), model.getTrangthai());

    }

    @Override
    public void update(NguoiDung model) {
        String sql = "update nguoidung set hoten = ? ,ngaysinh = ? ,gioitinh = ? ,sdt = ?, email = ? ,diachi = ?"
                + " ,vaitro = ? ,ghichu = ? , matkhau = ? where mand = ?";
        JdbcHelper.executeUpdate(sql, model.getHoTen(), model.getNgaySinh(),
                model.isGioiTinh(), model.getSdt(), model.getEmail(), model.getDiaChi(),
                 model.getVaiTro(), model.getGhiChu(), model.getMatKhau(), model.getMaND()
        );
    }

    public void updatevitien(NguoiDung model) {
        String sql = "update nguoidung set vitien = ? where mand = ? ";
        JdbcHelper.executeUpdate(sql, model.getViTien(), model.getMaND());
    }

    @Override
    public void delete(String id) {
        String sql = "update nguoidung set trangthai = 1 where mand = ?";
        JdbcHelper.executeUpdate(sql, id);
    }

    @Override
    public NguoiDung selectById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<NguoiDung> selectMand(String mand) {

        String sql = "select * from nguoidung where mand = ?";

        return selectBySql(sql, mand);
    }

    public List<NguoiDung> getvitien(String mand) {

        String sql = "select vitien from nguoidung where mand = ?";

        return selectBySql(sql, mand);
    }

    @Override
    public List<NguoiDung> selectAll() {

        String sql = "select * from nguoidung where (vaitro  =  0 or vaitro = 1) and trangthai = 0";
        return selectBySql(sql);
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
        return lst;
    }

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
        return model;
    }

    public void SendMail(String toMail, String subJect, String Messagee) {
        final String username = "huyndph12680@fpt.edu.vn";
        final String password = "anhhuy93";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.ssl.trust", "*"); //SSL
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2"); //SSL//TLS
        // Dang nhap gmail
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(toMail)
            );
            message.setSubject(subJect);
            int i = 0;
            message.setText(Messagee);

            Transport.send(message);

            System.out.println("Done");

        } catch (MessagingException e) {
        }
    }

}
