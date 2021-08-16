SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('SP_COUNTBOOKBYCAT') IS NOT NULL
DROP PROC SP_COUNTBOOKBYCAT
CREATE PROC [dbo].[SP_COUNTBOOKBYCAT] ( @ID NVARCHAR(50))
AS
BEGIN
    SELECT COUNT(*) FROM tuasach
    WHERE madm = @ID
END
GO
/****** Object:  StoredProcedure [dbo].[SP_SELECTBOOKBYCAT]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_SELECTBOOKBYCAT] ') IS NOT NULL
DROP PROC [SP_SELECTBOOKBYCAT] 
CREATE PROC [dbo].[SP_SELECTBOOKBYCAT] ( @ID NVARCHAR(50))
AS
BEGIN
    SELECT * FROM tuasach
    WHERE madm = @ID
END
GO
/****** Object:  StoredProcedure [dbo].[SP_SELECTTG]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_SELECTTG]  ') IS NOT NULL
DROP PROC [SP_SELECTTG] 
CREATE PROC [dbo].[SP_SELECTTG] ( @KEYWORD NVARCHAR(50), @PAGENUMBER INT, @ROWSOFPAGE INT)
AS
	BEGIN 
				SELECT * FROM tacgia
				WHERE tentg LIKE @KEYWORD OR matg LIKE @KEYWORD  -- tim kiem
				ORDER BY tentg
				OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END
GO
/****** Object:  StoredProcedure [dbo].[SP_SELECTTUASACH]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_SELECTTUASACH]  ') IS NOT NULL
DROP PROC [SP_SELECTTUASACH] 
CREATE PROC [dbo].[SP_SELECTTUASACH] ( @KEYWORD NVARCHAR(50), @PAGENUMBER INT, @ROWSOFPAGE INT, @Trangthai INT, @danhmuc varchar(10))
AS
	BEGIN 
				SELECT * FROM TUASACH
				WHERE (matuasach LIKE @KEYWORD OR tentuasach LIKE @KEYWORD)  -- tim kiem
				    and Trangthai = @Trangthai and madm like @danhmuc
				ORDER BY matuasach
				OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END
GO
/****** Object:  StoredProcedure [dbo].[SP_SOQUYENSACH]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_SOQUYENSACH]  ') IS NOT NULL
DROP PROC [SP_SOQUYENSACH] 
CREATE PROC [dbo].[SP_SOQUYENSACH] ( @matuasach int)
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM quyensach
		WHERE matuasach = @matuasach
	END
GO
/****** Object:  StoredProcedure [dbo].[SP_sosachdoctaicho]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_sosachdoctaicho]  ') IS NOT NULL
DROP PROC [SP_sosachdoctaicho] 
CREATE PROC [dbo].[SP_sosachdoctaicho] ( @matuasach int)
AS
	BEGIN 
		SELECT Count(*) FROM QuyenSach WHERE MaTuaSach = @matuasach and duocmuonve = 0							
	END
GO
/****** Object:  StoredProcedure [dbo].[SP_TGTOTALROWS]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_TGTOTALROWS]  ') IS NOT NULL
DROP PROC [SP_TGTOTALROWS] 
CREATE PROC [dbo].[SP_TGTOTALROWS] ( @KEYWORD NVARCHAR(50))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM tacgia
		WHERE tentg LIKE @KEYWORD OR matg LIKE @KEYWORD							
	END
GO
/****** Object:  StoredProcedure [dbo].[SP_TuaSachTOTALROWS]    Script Date: 7/31/2021 10:02:55 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
IF OBJECT_ID('[SP_TuaSachTOTALROWS]  ') IS NOT NULL
DROP PROC [SP_TuaSachTOTALROWS] 
CREATE PROC [dbo].[SP_TuaSachTOTALROWS] ( @KEYWORD NVARCHAR(50),@Trangthai INT,
								@danhmuc varchar(10))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM TUASACH
		WHERE (matuasach LIKE @KEYWORD OR tentuasach LIKE @KEYWORD) and trangthai = @Trangthai
		and madm like @danhmuc
	END
GO



IF OBJECT_ID('[sp_selecttuasachfromdatsach]  ') IS NOT NULL
DROP PROC sp_selecttuasachfromdatsach 
go
CREATE PROC sp_selecttuasachfromdatsach ( @KEYWORD NVARCHAR(50), @Trangthai1 INT, @Trangthai2 INT, @mand varchar(10))
AS
	BEGIN 
				SELECT * FROM datsach join tuasach
				on datsach.matuasach = tuasach.matuasach
				WHERE (datsach.matuasach LIKE @KEYWORD OR tentuasach LIKE @KEYWORD)  -- tim kiem
				    and datsach.Trangthai <= @Trangthai2 and datsach.trangthai >= @trangthai1 and mand like @mand
				ORDER BY madatsach asc
				--OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				--FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END
GO




IF OBJECT_ID('sp_danhSachDatSachKhongDenLay') IS NOT NULL
DROP PROC sp_danhSachDatSachKhongDenLay 
go
CREATE PROC sp_danhSachDatSachKhongDenLay ( @today DATE )
AS
	BEGIN 				 
				SELECT matuasach, count(matuasach) soLuongTuaSach FROM datsach
				where datsach.trangthai = 1 and ngayhenlaysach < @today
				group by matuasach
	END
GO



IF OBJECT_ID('sp_EmailDatSachKhongDenLay') IS NOT NULL
DROP PROC sp_EmailDatSachKhongDenLay 
go
CREATE PROC sp_EmailDatSachKhongDenLay ( @today DATE )
AS
	BEGIN 				 
				SELECT email, madatsach FROM datsach
				join nguoidung on datsach.mand = nguoidung.mand
				where datsach.trangthai = 1 and ngayhenlaysach < @today
	END
GO

IF OBJECT_ID('sp_danhSachDatSachKhongDenLay1') IS NOT NULL
DROP PROC sp_danhSachDatSachKhongDenLay1 
go
CREATE PROC sp_danhSachDatSachKhongDenLay1 ( @today DATE, @matuasach INT out, @count INT out )
AS
	BEGIN 				 
				SELECT @matuasach = matuasach FROM datsach 
				where trangthai = 1 and ngayhenlaysach < @today
				group by matuasach
				SELECT @count = count(*) FROM datsach 
				where trangthai = 1 and ngayhenlaysach < @today
				group by matuasach
	END
GO

IF OBJECT_ID('sp_danhSachDatSachKhongDenLay2') IS NOT NULL
DROP PROC sp_danhSachDatSachKhongDenLay2 
go
CREATE PROC sp_danhSachDatSachKhongDenLay2 ( @today DATE)
AS
	BEGIN 		
	Declare @matuasach2 INT , @count2 INT 
	exec sp_danhSachDatSachKhongDenLay1 '2021-8-8', @matuasach = @matuasach2 out,
	@count = @count2 out
	select @matuasach2, @count2
	END
GO

exec sp_danhSachDatSachKhongDenLay2 '2021-8-8'

IF OBJECT_ID('sp_danhSachDenLuotMuon') IS NOT NULL
DROP PROC sp_danhSachDenLuotMuon 
go
CREATE PROC sp_danhSachDenLuotMuon ( @matuasach int, @soluongsach int)
AS
	BEGIN 				 
				SELECT TOP (@soluongsach) * FROM datsach 
				where trangthai = 0 and matuasach = @matuasach
	END
GO

exec sp_danhSachDenLuotMuon 10007, 2


IF OBJECT_ID('sp_datSachKhongDenLay') IS NOT NULL
DROP PROC sp_datSachKhongDenLay 
go
CREATE PROC sp_datSachKhongDenLay ( @today DATE)
AS
	BEGIN 
				update datsach set trangthai = 3
				where madatsach in 
				(SELECT madatsach FROM datsach 
				where trangthai = 1 and ngayhenlaysach < @today)			
	END
GO

IF OBJECT_ID('sp_datSachKhongDenLay1') IS NOT NULL
DROP PROC sp_datSachKhongDenLay1 
go
CREATE PROC sp_datSachKhongDenLay1
AS
	BEGIN 
				update datsach set trangthai = 3
				where madatsach in 
				(SELECT madatsach FROM datsach 
				where trangthai = 1 and ngayhenlaysach < GETDATE())			
	END
GO

select * from datsach
select GETDATE()

IF OBJECT_ID('SP_TGTOTALROWSNGUOIDUNG') IS NOT NULL
DROP PROC SP_TGTOTALROWSNGUOIDUNG
GO 
CREATE PROC SP_TGTOTALROWSNGUOIDUNG ( @KEYWORD NVARCHAR(50))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM nguoidung
		WHERE (hoten LIKE @KEYWORD OR mand LIKE @KEYWORD) and vaitro = 2	and  trangthai = 0							
	END
	-- TÌM KIẾM NGƯỜI DÙNG CÓ VAI TRÒ LÀBẠN ĐỌC

IF OBJECT_ID('SP_TGTOTALROWSNHANVIEN') IS NOT NULL
DROP PROC SP_TGTOTALROWSNHANVIEN
GO 
CREATE PROC SP_TGTOTALROWSNHANVIEN ( @KEYWORD NVARCHAR(50))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM nguoidung
		WHERE (hoten LIKE @KEYWORD OR mand LIKE @KEYWORD) and (vaitro = 0 OR vaitro = 1 ) and trangthai = 0						
	END
	-- TÌM KIẾM NGƯỜI DÙNG CÓ VAI TRÒ LÀ ADMIN HOẶC THỦ THƯ

	USE QLTV
IF OBJECT_ID('SP_SELECTNGUOIDUNG') IS NOT NULL
DROP PROC SP_SELECTNGUOIDUNG
GO 
	CREATE PROC SP_SELECTNGUOIDUNG ( @KEYWORD NVARCHAR(50), @PAGENUMBER INT, @ROWSOFPAGE INT)
AS
	BEGIN 
				SELECT * FROM nguoidung
				WHERE hoten LIKE @KEYWORD OR mand LIKE @KEYWORD and (vaitro = 0 OR vaitro = 1 )   and trangthai = 0	  -- tim kiem
				ORDER BY mand
				OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END

	-- TÍNH SỐ SÁCH ĐANG MƯỢN
IF OBJECT_ID('SP_SOSACHDANGMUON') IS NOT NULL
DROP PROC SP_SOSACHDANGMUON
GO 
CREATE PROC SP_SOSACHDANGMUON (@MAND VARCHAR(10))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM PMCT JOIN phieumuon
		ON pmct.maphieumuon = phieumuon.maphieumuon
		WHERE mabandoc = @MAND AND trangthai = 0			
	END

-- kiểm tra có đúng người đặt sách không

IF OBJECT_ID('SP_coDungNguoiDatSachKhong') IS NOT NULL
DROP PROC SP_coDungNguoiDatSachKhong
GO 
CREATE PROC SP_coDungNguoiDatSachKhong (@matuasach int, @mand varchar(10))
AS
	BEGIN 
		SELECT count(*) TrueOrFalse from datsach where matuasach = 100004 and mand = 'nd002' 
	--	where matuasach = @matuasach and mand = @mand 
		and trangthai = 1
	END

-- số sách chưa trả trong 1 phiếu mượn

IF OBJECT_ID('SP_soSachChuaTraTrongPhieuMuon') IS NOT NULL
DROP PROC SP_soSachChuaTraTrongPhieuMuon
GO 
CREATE PROC SP_soSachChuaTraTrongPhieuMuon (@maphieumuon int)
AS
	BEGIN 
		SELECT count(*) from phieumuon join pmct
		ON pmct.maphieumuon = phieumuon.maphieumuon
		WHERE phieumuon.maphieumuon = @maphieumuon and trangthai = 0
	END

IF OBJECT_ID('SP_soSanhNgay') IS NOT NULL
DROP PROC SP_soSanhNgay
GO 
CREATE PROC SP_soSanhNgay (@day date)
AS
	BEGIN 
		SELECT DATEDIFF(day, @day ,GETDATE())
		-- SELECT DATEDIFF(day, '2021-8-8' , GETDATE())
	END

IF OBJECT_ID('SP_tuaSachDangMuon') IS NOT NULL
DROP PROC SP_tuaSachDangMuon
GO 
CREATE PROC SP_tuaSachDangMuon (@matuasach int, @mand varchar(10))
AS
	BEGIN 
		SELECT count(*) from tuasach join quyensach on tuasach.matuasach = quyensach.matuasach
		join pmct ON pmct.maquyensach = quyensach.maquyensach
		join phieumuon on pmct.maphieumuon = phieumuon.maphieumuon
		-- WHERE tuasach.matuasach = 10002 and pmct.trangthai = 0 and mabandoc = 'nd002'
		WHERE tuasach.matuasach = @matuasach and pmct.trangthai = 0 and mabandoc = @mand
	END

IF OBJECT_ID('SP_sachSanSangChoMuon') IS NOT NULL
DROP PROC SP_sachSanSangChoMuon
GO 
CREATE PROC SP_sachSanSangChoMuon (@matuasach int, @count int out)
AS
	BEGIN 
		select @count = count(*) from QuyenSach where matuasach = @matuasach and duocmuonve = 1 and tinhtrang = 0 and trangthai = 0
	END

	select count(*) from QuyenSach where matuasach = 10003 and duocmuonve = 1 and tinhtrang = 0 and trangthai = 0

IF OBJECT_ID('sp_topFavorite') IS NOT NULL
DROP PROC sp_topFavorite 
go
CREATE PROC sp_topFavorite 
AS
	BEGIN 				 
				SELECT top 8 * FROM tuasach
				order by soluongthich desc
	END
GO

exec sp_topFavorite

if OBJECT_ID('review') is not null
drop table review
go
create table review(
id int identity primary key,
mand varchar(10) not null foreign key references nguoidung(mand),
matuasach int not null foreign key references tuasach(matuasach),
noidung nvarchar(max),
ngayreview date
)

if OBJECT_ID('photo') is not null
drop table photo
go
create table photo(
id int identity primary key,
photoName nvarchar(max),
photo image
)

select * from photo


IF OBJECT_ID('sp_namMuon') IS NOT NULL
DROP PROC sp_namMuon 
go
CREATE PROC sp_namMuon
AS
	BEGIN 				 
				select Distinct YEAR(ngaymuon),count(*) as sosachmuon  from pmct join phieumuon on pmct.maphieumuon = phieumuon.maphieumuon
				group by YEAR(ngaymuon)
	END
GO

IF OBJECT_ID('sp_sachMuonTheoThang') IS NOT NULL
DROP PROC sp_sachMuonTheoThang 
go
CREATE PROC sp_sachMuonTheoThang (@nam int)
AS
	BEGIN 				 
				select count(*) as sosachmuon, MONTH(ngaymuon) as thang from pmct join phieumuon on pmct.maphieumuon = phieumuon.maphieumuon
				where YEAR(ngaymuon) = @nam
				group by MONTH(ngaymuon)
	END
GO

IF OBJECT_ID('sp_nguoiMuonTheoThang') IS NOT NULL
DROP PROC sp_sachMuonTheoThang 
go
CREATE PROC sp_sachMuonTheoThang (@nam int)
AS
	BEGIN 				 
				select count(mabandoc) as songuoimuon,mabandoc, MONTH(ngaymuon) as thang from pmct join phieumuon on pmct.maphieumuon = phieumuon.maphieumuon
				where YEAR(ngaymuon) = 2021
				group by MONTH(ngaymuon), mabandoc
	END
GO