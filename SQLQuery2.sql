--DROP DATABASE qltv

--create database qltv
use qltv
go

if OBJECT_ID('tacgia') is not null
drop table tacgia
go
create table tacgia(
matg int identity not null primary key,
tentg nvarchar (100) not null,
ngaysinh date,
quoctich nvarchar (100),
trangthai int default 0 --(hoat dong),
)


if OBJECT_ID('danhmuc') is not null
drop table danhmuc
go
create table danhmuc(
madm varchar(10) not null primary key,
tendm nvarchar (100) not null,
trangthai int default 0 --(hoat dong),
)

if OBJECT_ID('tuasach') is not null
drop table tuasach
go
create table tuasach(
matuasach int identity(10000,1) not null primary key,
tentuasach nvarchar(100) not null,
nxb nvarchar(50),
namxuatban int,
sotrang int not null,
giatien money not null,
mota nvarchar(200),
ghichu nvarchar(200),
trangthai int default 0 not null,
soluong int not null,
anh nvarchar(max),
madm varchar(10) foreign key references danhmuc (madm),
soluongthich int default 0
)

ALTER TABLE tuasach
ALTER COLUMN giatien float

if OBJECT_ID('sach_tg') is not null
drop table sach_tg
go
create table sach_tg(
matuasach int not null foreign key references tuasach(matuasach),
matg int not null foreign key references tacgia(matg),
primary key (matuasach, matg)
)

if OBJECT_ID('quyensach') is not null
drop table quyensach
go
create table quyensach(
maquyensach int identity (100000,1) not null primary key,
vitri nvarchar(20) not null,
duocmuonve bit not null, -- (duocmuonve = 1, doctaicho = 0)
tinhtrang int default 0 not null, -- (dangphucvu = 0, hong = 1, mat = 2, ngungphucvu = 3)
trangthai int default 0  not null, -- (sansanchomuon = 0, dangmuon = 1, duocdat = 2 )
ghichu nvarchar(50),
matuasach int foreign key references tuasach(matuasach) 
)

if OBJECT_ID('nguoidung') is not null
drop table nguoidung
go
create table nguoidung(
mand varchar(10) primary key not null,
hoten nvarchar (50) not null,
ngaysinh date not null,
gioitinh int not null,
sdt varchar (15) not null,
email varchar (50) ,
diachi nvarchar (150) not null,
vaitro int not null,
ghichu nvarchar (100),
matkhau varchar (50) not null,
vitien money not null,
anh varchar(max),
trangthai int default 0 --(hoat dong),
)

ALTER TABLE nguoidung
ALTER COLUMN vitien float

if OBJECT_ID('lichsugiaodich') is not null
drop table lichsugiaodich
go
create table lichsugiaodich(
magd int identity primary key not null,
mand varchar(10) not null foreign key references nguoidung(mand) ,
ngaygiaodich date not null,
sotien money not null,
noidung nvarchar(100) not null,
nguoitaogiaodich varchar(10) not null foreign key references nguoidung(mand)
)


if OBJECT_ID('datsach') is not null
drop table datsach
go
create table datsach(
madatsach int identity primary key not null,
mand varchar(10) not null foreign key references nguoidung(mand),
matuasach int not null foreign key references tuasach(matuasach),
ngaydat date not null,
trangthai int not null, --(dangdat = 0, cholaysach = 1, huydat = 2, quahen = 3, dalay = 4 )
ngayhenlaysach date
)

if OBJECT_ID('phieumuon') is not null
drop table phieumuon
go
create table phieumuon(
maphieumuon int identity not null primary key,
mabandoc varchar(10) not null foreign key references nguoidung(mand) ,
ngaymuon date not null,
nguoitaophieu varchar(10) not null foreign key references nguoidung(mand)
)

if OBJECT_ID('pmct') is not null
drop table pmct
go
create table pmct(
maphieumuon int not null foreign key references phieumuon(maphieumuon) ,
maquyensach int not null foreign key references quyensach(maquyensach) ,
trangthai int not null, --(dangmuon = 0, datra = 1, quahan = 2)
ngaygiahan date,
solangiahan int,
ghichu nvarchar (50),
primary key (maphieumuon ,maquyensach ) 
)


if OBJECT_ID('phieutra') is not null
drop table phieutra
go
create table phieutra(
maphieutra int identity not null primary key,
mabandoc varchar(10) not null foreign key references nguoidung(mand) ,
ngaytra date not null,
nguoitaophieu varchar(10) not null foreign key references nguoidung(mand)
)

if OBJECT_ID('ptct') is not null
drop table ptct
go
create table ptct(
maphieutra int not null foreign key references phieutra(maphieutra) ,
maquyensach int not null foreign key references quyensach(maquyensach) ,
trangthai int not null, --(mat = 0, datra = 1, quahan = 2)
ghichu nvarchar (50),
primary key (maphieutra , maquyensach) 
)

if OBJECT_ID('sachuathich') is not null
drop table sachuathich
go
create table sachuathich(
mand varchar(10) not null foreign key references nguoidung(mand),
matuasach int not null foreign key references tuasach(matuasach),
primary key (mand , matuasach) 

)


insert into tacgia (tentg, ngaysinh, quoctich)
values (N'Xuân Diệu','1968-08-02',N'Việt Nam'),
(N'Văn cao','1972-02-06',N'Việt nam'),
(N'Ngô tất tố','1950-02-06',N'Việt nam'),
(N'Nguyễn Tuân','1966-02-06',N'Việt nam'),
(N'Như Quỳnh','1960-08-07',N'Việt nam'),
(N'Nam cao','1950-09-01',N'Việt nam'),
(N'Nguyễn Ái Quốc','1890-05-19',N'Việt nam'),
(N'Tố Hữu','1942-04-06',N'Việt nam'),
(N'Nguyễn khuyến','1977-02-07',N'Việt nam'),
(N'Tản Đà','1960-02-06',N'Việt nam')

select * from tacgia

 insert into danhmuc (madm,tendm)
 values ('000',N'Tin học, thông tin và tác phẩm tổng quát'),
('100',N'Triết học & tâm lý học'),
('200',N'Tôn giáo'),
('300',N'Khoa học xã hội'),
('400',N'Ngôn ngữ'),
('500',N'Khoa học tự nhiên và toán học'),
('600',N'Công nghệ (khoa học ứng dụng)'),
('700',N'Nghệ thuật, mỹ thuật và trang trí'),
('800',N'Văn học (văn chương) và tu từ học'),
('900',N'Lịch sử, địa lý và các ngành phụ trợ')

select * from danhmuc

select * from tuasach
insert into tuasach (tentuasach,nxb,namxuatban,sotrang,giatien,mota,ghichu,trangthai,soluong,anh,madm)
values (N'Sống trong sợ hãi 1',N'Tiến Bộ ' ,2000,180,250000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Bí ẩn những Ngôi sao 2',N'Kim Đồng' ,2000,260,210000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Thiền Sư Bất tử 3',N'Kim Đồng' ,2000,220,180000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Độ kiếp 5',N'Kim Đồng' ,2000,100,100000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Nhật kí trong tù 7',N'Kim Đồng' ,2000,250,100000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Người ngựa ngựa người 8',N'Kim Đồng' ,2000,150,280000,N'văn học cổ điển',N'sách mới',0,20,'','100'), 
	  (N'Chiếc lá cuối cùng 9',N'Kim Đồng' ,2000,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Đêm Đen tối 0',N'Kim Đồng' ,2001,50,200000,N'văn học cổ điển',N'sách mới',0,10,'','300'), 
	  (N'Người cùng khổ 1',N'Kim Đồng' ,2001,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','300'), 
	  (N'Người cùng khổ 2',N'Kim Đồng' ,2001,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','300'),

	  (N'Sống trong sợ hãi 3',N'Tiến Bộ ' ,2001,180,250000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Bí ẩn những Ngôi sao',N'Kim Đồng' ,2002,260,210000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Thiền Sư Bất tử',N'Kim Đồng' ,2002,220,180000,N'văn học cổ điển',N'sách mới',0,10,'','600'), 
	  (N'Độ kiếp',N'Kim Đồng' ,2002,100,100000,N'văn học cổ điển',N'sách mới',0,10,'','600'), 
	  (N'Nhật kí trong tù',N'Kim Đồng' ,2002,250,100000,N'văn học cổ điển',N'sách mới',0,10,'','500'), 
	  (N'Người ngựa ngựa người ',N'Kim Đồng' ,2002,150,280000,N'văn học cổ điển',N'sách mới',0,20,'','500'), 
	  (N'Chiếc lá cuối cùng',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','500'), 
	  (N'Đêm Đen tối ',N'Kim Đồng' ,2002,50,200000,N'văn học cổ điển',N'sách mới',0,10,'','700'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','700'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','700'),

	  (N'Sống trong sợ hãi',N'Tiến Bộ ' ,2002,180,250000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Bí ẩn những Ngôi sao',N'Kim Đồng' ,2002,260,210000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Thiền Sư Bất tử',N'Kim Đồng' ,2002,220,180000,N'văn học cổ điển',N'sách mới',0,10,'','700'), 
	  (N'Độ kiếp',N'Kim Đồng' ,2002,100,100000,N'văn học cổ điển',N'sách mới',0,10,'','900'), 
	  (N'Nhật kí trong tù',N'Kim Đồng' ,2002,250,100000,N'văn học cổ điển',N'sách mới',0,10,'','900'), 
	  (N'Người ngựa ngựa người ',N'Kim Đồng' ,2002,150,280000,N'văn học cổ điển',N'sách mới',0,20,'','900'), 
	  (N'Chiếc lá cuối cùng',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','800'), 
	  (N'Đêm Đen tối ',N'Kim Đồng' ,2002,50,200000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','100'),

	  (N'Sống trong sợ hãi',N'Tiến Bộ ' ,2002,180,250000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Bí ẩn những Ngôi sao',N'Kim Đồng' ,2002,260,210000,N'văn học cổ điển',N'sách mới',0,10,'','300'), 
	  (N'Thiền Sư Bất tử',N'Kim Đồng' ,2002,220,180000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Độ kiếp',N'Kim Đồng' ,2002,100,100000,N'văn học cổ điển',N'sách mới',0,10,'','600'), 
	  (N'Nhật kí trong tù',N'Kim Đồng' ,2002,250,100000,N'văn học cổ điển',N'sách mới',0,10,'','400'), 
	  (N'Người ngựa ngựa người ',N'Kim Đồng' ,2002,150,280000,N'văn học cổ điển',N'sách mới',0,20,'','800'), 
	  (N'Chiếc lá cuối cùng',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','800'), 
	  (N'Đêm Đen tối ',N'Kim Đồng' ,2002,50,200000,N'văn học cổ điển',N'sách mới',0,10,'','900'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','900'), 
	  (N'Người cùng khổ ',N'Kim Đồng' ,2002,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','200'),

	  (N'Sống trong sợ hãi',N'Tiến Bộ ' ,2003,180,250000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Bí ẩn những Ngôi sao',N'Kim Đồng' ,2003,260,210000,N'văn học cổ điển',N'sách mới',0,10,'','100'), 
	  (N'Thiền Sư Bất tử',N'Kim Đồng' ,2003,220,180000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Độ kiếp',N'Kim Đồng' ,2003,100,100000,N'văn học cổ điển',N'sách mới',0,10,'','200'), 
	  (N'Nhật kí trong tù',N'Kim Đồng' ,2003,250,100000,N'văn học cổ điển',N'sách mới',0,10,'','600'), 
	  (N'Người ngựa ngựa người ',N'Kim Đồng' ,2003,150,280000,N'văn học cổ điển',N'sách mới',0,20,'','700'), 
	  (N'Chiếc lá cuối cùng',N'Kim Đồng' ,2003,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','600'), 
	  (N'Đêm Đen tối ',N'Kim Đồng' ,2003,50,200000,N'văn học cổ điển',N'sách mới',0,10,'','800'), 
	  (N'Người cùng khổ ',N'Kim Đồng',2003 ,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','900'), 
	  (N'Người cùng khổ ',N'Kim Đồng',2003 ,200,200000,N'văn học cổ điển',N'sách mới',0,10,'','400')

INSERT INTO TUASACH (tentuasach,nxb,namxuatban,sotrang,giatien,mota,ghichu,soluong,madm,anh) values 
('Doraemon','kd',1999,234,232,'','',10,'000','f914130ad14e9bb8a1624cdca23b8610.jpg') 
--tenTuaSach=Doraemon, nxb=1999, soTrang=234, giaTien=232.0, moTa=, ghiChu=, trangThai=0, soLuong=23, madm=000
	  select * from tuasach

select * from sach_tg
delete sach_tg
select * from quyensach

insert into quyensach (vitri,duocmuonve,matuasach) 
values ('C',0,10000)



insert into quyensach (vitri,duocmuonve,tinhtrang,trangthai,ghichu,matuasach) 
values ('A',0,0,0,N'sách mới chưa hư hỏng',10000),
	('A',0,0,0,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',1,0,0,N'sách mới chưa hư hỏng',10001),
	('A',1,0,1,N'sách mới chưa hư hỏng',10001),
	('A',0,0,0,N'sách mới chưa hư hỏng',10002),
	('A',1,0,0,N'sách mới chưa hư hỏng',10002),
	('A',0,0,0,N'sách mới chưa hư hỏng',10003),
	('A',0,0,0,N'sách mới chưa hư hỏng',10003),
	('A',0,0,0,N'sách mới chưa hư hỏng',10004),
	('A',0,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',0,0,0,N'sách mới chưa hư hỏng',10006),
	('A',0,0,0,N'sách mới chưa hư hỏng',10007),
	('A',0,0,0,N'sách mới chưa hư hỏng',10008),
	('A',0,0,0,N'sách mới chưa hư hỏng',10009),
	('A',1,0,0,N'sách mới chưa hư hỏng',10009),
	('A',0,0,0,N'sách mới chưa hư hỏng',10010),
	('A',1,0,0,N'sách mới chưa hư hỏng',10010),
	('A',1,0,0,N'sách mới chưa hư hỏng',10010),
	('A',1,0,0,N'sách mới chưa hư hỏng',10010),
	('A',0,0,0,N'sách mới chưa hư hỏng',10013),
	('A',1,0,0,N'sách mới chưa hư hỏng',10013),
	('A',0,0,0,N'sách mới chưa hư hỏng',10003),
	('A',1,0,0,N'sách mới chưa hư hỏng',10003),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',0,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',1,0,0,N'sách mới chưa hư hỏng',10004),
	('A',0,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',1,0,0,N'sách mới chưa hư hỏng',10005),
	('A',0,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('A',1,0,0,N'sách mới chưa hư hỏng',10006),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',1,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',0,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',0,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',0,0,0,N'sách đọc tại thư viện k mượn về',10007),
	('B',0,0,0,N'sách đọc tại thư viện k mượn về',10007)

select * from quyensach


insert into nguoidung (mand,hoten,ngaysinh,gioitinh,sdt,email,diachi,vaitro,ghichu,matkhau,vitien)
values ('ND001',N'Nguyễn Danh Huy','1993-07-09',1,'0369793690','huyndph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',1,N'quản trị viên','12345678',50000),
('ND002',N'Hoàng Hồng Quang','1987-07-09',1,'0369565565','hongquang@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',1,N'quản trị viên','12345678',50000),
('ND003',N'Trần Văn Thao','2000-07-09',1,'03697945630','vanthaoph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',0,N'thủ thư ','12345678',50000),
('ND004',N'TRần Đại Nghĩa ','1999-07-09',1,'0369645645','dainghiaph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',0,'thủ thư ','12345678',50000),
('ND005',N'Vương Đắc Đại','1999-07-09',1,'036974312.','dacdai@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND006',N'Vương Đắc Trường','1990-07-09',1,'036123467','dactruong@gmai.com',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND007',N'Dương Thùy Dương','1999-07-09',0,'035304564554','Thuyduong@gmai.com',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND008',N'Dương Vân Anh','1996-07-09',0,'0366456434','vananh@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND009',N'Nguyễn Thị Thu Hằng','1997-07-09',0,'0369789879','tuandao@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND010',N'Đào Anh Tuân','2000-07-09',1,'03697936373','huyndph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND011',N'Trương Tam Phong ','1993-07-09',1,'036973737','huyndph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND012',N'Tần Thủy Hoàng ','1993-06-08',1,'0369213','huyndph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000),
('ND013',N'Kim jong sun','1993-02-09',1,'03697213312','huyndph12680@fpt.edu.vn',N'Phượng cách - Quốc oai- Hà Nội',2,N'Người dùng','12345678',50000)
select * from nguoidung	

insert into phieumuon 
values ('ND001','2021-07-12','ND001'),
('ND001','2021-07-12','ND001'),
('ND001','2021-07-10','ND001'),
('ND001','2021-07-11','ND001'),
('ND002','2021-07-12','ND002'),
('ND002','2021-07-11','ND002'),
('ND003','2021-07-11','ND003'),
('ND003','2021-07-12','ND003'),
('ND004','2021-07-10','ND004'),
('ND004','2021-07-10','ND004'),
('ND004','2021-07-11','ND004'),
('ND004','2021-07-12','ND004'),
('ND005','2021-07-10','ND005'),
('ND005','2021-07-11','ND005'),
('ND005','2021-07-11','ND005'),
('ND005','2021-07-12','ND005'),
('ND005','2021-07-12','ND005')

select * from phieumuon
insert into phieumuon 
values 
('ND007','2021-07-12','ND004'),
('ND001','2021-07-12','ND001'),
('ND001','2021-07-12','ND001'),
('ND002','2021-07-12','ND002'),
('ND002','2021-07-12','ND002'),
('ND003','2021-07-12','ND003'),
('ND004','2021-07-12','ND004'),
('ND004','2021-07-12','ND004'),
('ND005','2021-07-12','ND005'),
('ND005','2021-07-12','ND005')

select * from pmct
insert into pmct 
values (1,100011,0,'2021-07-19',1,''),
(1,100001,0,'2021-07-19',0,''),
(1,100002,0,'2021-07-18',0,''),
(2,100003,0,'2021-07-17',0,''),
(2,100004,0,'2021-07-18',0,''),
(2,100005,1,'2021-07-17',0,''),
(2,100006,1,'2021-07-17',0,''),
(3,100007,0,'2021-07-17',0,''),
(3,100008,0,'2021-07-17',0,''),
(4,100009,0,'2021-07-17',0,''),
(4,100000,0,'2021-07-16',1,''),
(5,100010,0,'2021-07-16',1,'')

IF OBJECT_ID('SP_SELECTTG') IS NOT NULL
DROP PROC SP_SELECTTG
GO 
CREATE PROC SP_SELECTTG ( @KEYWORD NVARCHAR(50), @PAGENUMBER INT, @ROWSOFPAGE INT)
AS
	BEGIN 
				SELECT * FROM tacgia
				WHERE (tentg LIKE @KEYWORD OR matg LIKE @KEYWORD) and trangthai = 0 -- tim kiem
				ORDER BY tentg
				OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END


IF OBJECT_ID('SP_TGTOTALROWS') IS NOT NULL
DROP PROC SP_TGTOTALROWS
GO 
CREATE PROC SP_TGTOTALROWS ( @KEYWORD NVARCHAR(50))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM tacgia
		WHERE tentg LIKE @KEYWORD OR matg LIKE @KEYWORD							
	END

--SELECT MAX(matuasach) as matuasach FROM TUASACH
--SELECT * FROM TUASACH where matuasach = (select max(matuasach) from tuasach)


IF OBJECT_ID('SP_SELECTTUASACH') IS NOT NULL
DROP PROC SP_SELECTTUASACH
GO 
CREATE PROC SP_SELECTTUASACH ( @KEYWORD NVARCHAR(50), @PAGENUMBER INT, @ROWSOFPAGE INT, @Trangthai INT,
								@danhmuc varchar(10))
AS
	BEGIN 
				SELECT * FROM TUASACH
				WHERE (matuasach LIKE @KEYWORD OR tentuasach LIKE @KEYWORD)  -- tim kiem
				    and Trangthai = @Trangthai and madm like @danhmuc
				ORDER BY matuasach
				OFFSET (@PAGENUMBER - 1) * @ROWSOFPAGE ROWS
				FETCH NEXT @ROWSOFPAGE ROWS ONLY 				
	END
go



IF OBJECT_ID('SP_TuaSachTOTALROWS') IS NOT NULL
DROP PROC SP_TuaSachTOTALROWS
GO 
CREATE PROC SP_TuaSachTOTALROWS ( @KEYWORD NVARCHAR(50),@Trangthai INT,
								@danhmuc varchar(10))
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM TUASACH
		WHERE (matuasach LIKE @KEYWORD OR tentuasach LIKE @KEYWORD) and trangthai = @Trangthai
		and madm like @danhmuc
	END

-- exec SP_TuaSachTOTALROWS '%%',0,'%%'
-- SELECT * FROM SACH_TG WHERE MATUASACH = ?

IF OBJECT_ID('SP_SOQUYENSACH') IS NOT NULL
DROP PROC SP_SOQUYENSACH
GO 
CREATE PROC SP_SOQUYENSACH ( @matuasach int)
AS
	BEGIN 
		SELECT COUNT (*) TOTAL FROM quyensach
		WHERE matuasach = @matuasach
	END

select * from sachuathich

insert into sachuathich values ('nd001',10001)
insert into sachuathich values ('nd001',10002)
insert into sachuathich values ('nd001',10003)
insert into sachuathich values ('nd001',10004)

select * from datsach
insert into datsach (mand, matuasach, ngaydat, trangthai, ngayhenlaysach) values	
('ND001',10001,'7-21-2020',2,NULL),
('ND001',10002,'7-25-2020',1,'7-21-2021'),
('ND001',10003,'7-29-2020',0,NULL),
('ND001',10007,'8-5-2020',0,NULL),
('ND001',10008,'8-9-2020',0,NULL),
('ND001',10011,'8-11-2020',2,NULL)



insert into sach_tg values 
(10001,1),
(10001,2),
(10001,3),
(10003,4),
(10003,6),
(10005,4),
(10006,1),
(10007,1)

select * from quyensach
select * from phieumuon
select * from pmct
select * from phieumuon where maphieumuon = 1

select * from phieutra
insert into phieutra  (mabandoc, ngaytra, nguoitaophieu)
values
('ND001','2020-8-8','ND004'),
('ND002','2020-8-8','ND004'),
('ND003','2020-8-8','ND004'),
('ND006','2020-8-8','ND004'),
('ND005','2020-8-8','ND004')

insert into ptct values 
(3, 100001, 1, ''),
(3, 100002, 1, ''),
(3, 100003, 1, ''),
(4, 100004, 1, ''),
(4, 100005, 1, ''),
(4, 100006, 1, '')