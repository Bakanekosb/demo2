/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xpoly.Service;

import com.xpoly.DAO.DatSachDAO;
import com.xpoly.DAO.PhieuMuonCT_DAO;
import com.xpoly.DAO.PhieuMuon_DAO;
import com.xpoly.DAO.QuyenSachDAO;
import com.xpoly.Interface.IService;
import com.xpoly.helper.Constant;
import com.xpoly.helper.EzHelper;
import com.xpoly.model.DatSach;
import com.xpoly.model.PMCT;
import com.xpoly.model.PhieuMuon;
import com.xpoly.model.QuyenSach;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell
 */
public class PhieuMuon_Service {

    DatSachDAO datSachDAO = new DatSachDAO();
    QuyenSachDAO quyenSachDAO = new QuyenSachDAO();
    PhieuMuon_DAO phieuMuonDAO = new PhieuMuon_DAO();
    PhieuMuonCT_DAO pmctDAO = new PhieuMuonCT_DAO();

    public List<PhieuMuon> danhSachPhieuMuon() {
        return phieuMuonDAO.selectAll();
    }

    public List<PhieuMuon> danhSachPhieuMuonHoanThanh() {
        List<PhieuMuon> lst = new ArrayList<>();
        for (PhieuMuon x : danhSachPhieuMuon()) {
            if (phieuMuonDAO.soSachChuaTraTrongPhieuMuon(x.getMaPhieuMuon()) == 0) {
                lst.add(x);
            }
        }
        return lst;
    }

    public List<PhieuMuon> danhSachPhieuMuonChuaHoanThanh() {
        List<PhieuMuon> lst = new ArrayList<>();
        for (PhieuMuon x : danhSachPhieuMuon()) {
            if (phieuMuonDAO.soSachChuaTraTrongPhieuMuon(x.getMaPhieuMuon()) != 0) {
                lst.add(x);
            }
        }
        return lst;
    }

    public int soSachMuonDuoc(String mand) {
        int soSachDangMuon = phieuMuonDAO.soSachDangMuon(mand);
        return Constant.SO_SACH_MUON_TOI_DA - soSachDangMuon;
    }

    public int kiemTraQuyenSach(int maquyensach, String mand) {
        int matuasach = quyenSachDAO.selectById(maquyensach).getMaTuaSach();
        System.out.println("dsfsdfs" + !phieuMuonDAO.tuaSachDangDuocMuon(matuasach, mand));
        if (phieuMuonDAO.tuaSachDangDuocMuon(matuasach, mand)) {
            return -1;
        }

        if (quyenSachDAO.selectSachSanSangChoMuonByQuyenSach(maquyensach)) {
            return 1; // mượn được
        }

        // sách được bạn đọc đặt trước
        if (datSachDAO.sachDuocBanDocDatTruocKhong(maquyensach, mand)) {
            return 1;
        }

        // tựa sách đang không được mượn
        return 0;
    }

    public int themPhieuMuon(PhieuMuon model) {
        try {
            phieuMuonDAO.insert(model);
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int themPhieuMuonCT(List<PMCT> lst) {
        try {
            for (PMCT x : lst) {
                pmctDAO.insert(x);
            }
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public void updateTrangThaiQuyenSach(QuyenSach model) {
        model.setTrangThai(1);
        try {
            quyenSachDAO.update(model);
        } catch (Exception e) {
        }
    }

    public void updateTrangThaiDatSach(int maquyensach, String mand) {
        DatSach ds = datSachDAO.selectDatSachDangChoDenLay(mand, maquyensach);
        if (ds != null) {
            int madatsach = ds.getMaDatSach();
            try {
                datSachDAO.updateTrangThaiDatSach(4, madatsach, EzHelper.now());
            } catch (Exception e) {
            }
        }
    }

    public boolean giaHanDuoc(int maphieumuon, int maquyensach) {
        PMCT pmct = pmctDAO.selectById(maphieumuon, maquyensach);
        PhieuMuon phieuMuon = phieuMuonDAO.selectById(maphieumuon);
        if (phieuMuonDAO.soSanhNgay(phieuMuon.getNgayMuon()) <= 7) {
            return true;
        }
        if (pmct.getSoLanGiaHan() == Constant.SO_LAN_GIA_HAN_TOI_DA || pmct.getSoLanGiaHan() == 0) {
            return false; // không gia hạn thêm được;
        }
        if (phieuMuonDAO.soSanhNgay(pmct.getNgayGiaHan()) <= 7) {
            return true;
        }
        return false;
    }

    public int giaHanSach(int maphieumuon, int maquyensach) {
        PMCT pmct = pmctDAO.selectById(maphieumuon, maquyensach);
        PhieuMuon phieuMuon = phieuMuonDAO.selectById(maphieumuon);
        if (giaHanDuoc(maphieumuon, maquyensach)) {
            pmct.setNgayGiaHan(EzHelper.now());
            pmct.setSoLanGiaHan(pmct.getSoLanGiaHan() + 1);
            try {
                pmctDAO.update(pmct);
                return 1;
            } catch (Exception e) {
                return -1;
            }
        }
        return -1;
    }

}
