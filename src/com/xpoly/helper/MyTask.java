/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.helper;

import com.xpoly.DAO.DatSachDAO;
import com.xpoly.DAO.NguoiDungDAO;
import com.xpoly.DAO.TuaSachDAO;
import com.xpoly.model.DatSach;
import com.xpoly.model.TuaSach;
import java.sql.ResultSet;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

/**
 *
 * @author Dell
 */
public class MyTask extends TimerTask {

    DatSachDAO datSachDao = new DatSachDAO();
    List<DatSach> lst_datSach = new ArrayList<>();
    NguoiDungDAO nguoiDungDAO = new NguoiDungDAO();

    @Override
    public void run() {     
        sendEmailHuySach();
        if (cacTuaSachSanSangChoMuonThem() != null) {
                      cacTuaSachSanSangChoMuonThem().forEach((k, v)
                    -> lst_datSach.addAll(datSachDao.danhSachDenLuotMuon(k, v))
            );            
        }
        choNguoiDatTiepTheoMuonSach();
        datSachKhongDenLay();
    }

    // Khi sách được đặt đến hẹn nhưng bạn đọc không đến mượn
    public Map<Integer, Integer> cacTuaSachSanSangChoMuonThem() {
        Map<Integer, Integer> map_sach = new HashMap<>();
        String sql = "{call sp_danhSachDatSachKhongDenLay (?)}";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, EzHelper.now());
            while (rs.next()) {
                map_sach.put(rs.getInt(1), rs.getInt(2));
            }
            System.out.println(map_sach.size());
        } catch (Exception e) {
        }
        return map_sach;
    }

    public void choNguoiDatTiepTheoMuonSach() {
        Date ngayHen = Date.from(Instant.now().plus(2, ChronoUnit.DAYS));
        System.out.println("ngay hen = " + ngayHen + lst_datSach.size());
        for (DatSach x : lst_datSach) {
            datSachDao.updateTrangThaiDatSach(1, x.getMaDatSach(), ngayHen);
            String email = nguoiDungDAO.selectById(x.getMand()).getEmail();
                System.out.println(email);
            TuaSach tuaSach = new TuaSachDAO().selectById(x.getMaTuaSach());
            String mess = "Tựa sách " + tuaSach.getTenTuaSach() + " bạn đặt vào ngày " + x.getNgayDat()
                    + " đã sẵn sàng cho mượn.\n Tựa sách sẽ được giữ trong 2 ngày, hạn cuối là : " + ngayHen;
            HelpSendEmail.SendMail(email, "Sách đã sẵn sàng cho mượn", mess);
        }
    }

    public void datSachKhongDenLay() {
        String sql = "{call sp_datSachKhongDenLay (?)}";
        JdbcHelper.executeUpdate(sql, EzHelper.now());
    }
    
    public void sendEmailHuySach(){
        String sql = "{call sp_EmailDatSachKhongDenLay (?)}";
        try {
            ResultSet rs = JdbcHelper.executeQuery(sql, EzHelper.now());
            while (rs.next()) {
                String email = rs.getString(1);
                int madatsach = rs.getInt(2);
                String mess = "Đơn đặt sách số : " + madatsach + "đã quá hạn lấy và bị hủy. Nếu có nhu cầu xin mời đặt lại.";
            HelpSendEmail.SendMail(email, "Đơn đặt sách quá hạn", mess);
            }
        } catch (Exception e) {
        }
    }
}
