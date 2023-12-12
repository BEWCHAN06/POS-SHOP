CREATE DATABASE Postshop

USE Postshop

-- Tạo bảng NhanVien
CREATE TABLE NhanVien
(
maNV varchar(7) PRIMARY KEY,
tenNV nvarchar(50) NOT NULL,
ngaySinh date CHECK (ngaySinh >='1900-01-01'),
SDT varchar (10) NOT NULL,
email varchar(50) NOT NULL,
CMND varchar(12) NOT NULL,
gioiTinh bit NOT NULL,
diaChi nvarchar(50) NOT NULL,
chucVu bit NOT NULL,
trangThai int NOT NULL CHECK (trangThai = 1 or trangThai = 2 or trangThai = 3),
)

-- Tạo bảng KhachHang
CREATE TABLE KhachHang
(
maKH varchar(7) PRIMARY KEY,
tenKH nvarchar(50) NOT NULL,
ngaySinh date CHECK (ngaySinh >='1900-01-01'),
SDT varchar(50) CHECK (SDT like '0%' and LEN(SDT) >= 10),
email varchar(50),
gioiTinh bit NOT NULL
)

-- Tạo bảng XuatXu
CREATE TABLE XuatXu
(
maXX varchar(7) PRIMARY KEY,
xuatXu nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng PhanLoai
CREATE TABLE PhanLoai
(
maPL varchar(7) PRIMARY KEY,
phanLoai nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng MauSac
CREATE TABLE MauSac
(
maMS varchar(7) PRIMARY KEY,
mauSac nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng KichThuoc
CREATE TABLE KichThuoc
(
maKT varchar(7) PRIMARY KEY,
kichThuoc nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng ChatLieu
CREATE TABLE ChatLieu
(
maCL varchar(7) PRIMARY KEY,
chatLieu nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng KieuDang
CREATE TABLE KieuDang
(
maKD varchar(7) PRIMARY KEY,
kieuDang nvarchar(50) NOT NULL UNIQUE
)

-- Tạo bảng NhaCungCap
CREATE TABLE NhaCungCap
(
maNCC varchar(7) PRIMARY KEY,
tenNCC nvarchar(50) NOT NULL,
SDT varchar(10) CHECK (SDT like '0%' and LEN(SDT)=10),
email varchar(50) NOT NULL,
diaChi nvarchar(50) NOT NULL
)

-- Tạo bảng KhuyenMai

CREATE TABLE KhuyenMai
(
maKM varchar(7) PRIMARY KEY,
phanTramKhuyenMai double precision CHECK (phanTramKhuyenMai > 0),
tenKhuyenMai nvarchar(50),
ngayBatDau date ,
ngayKetThuc date 
)

-- Tạo bảng SanPham
CREATE TABLE SanPham
(
maSP varchar(7) PRIMARY KEY,
tenSP nvarchar(50) NOT NULL,
giaNhap double precision CHECK (giaNhap > 0),
soLuong int NOT NULL,
maNCC varchar(7) FOREIGN KEY REFERENCES NhaCungCap(maNCC),
maKM varchar(7) FOREIGN KEY REFERENCES KhuyenMai(maKM),
trangThai int CHECK (trangThai = 1 or trangThai = 2 or trangThai = 3),
maCL varchar(7) FOREIGN KEY REFERENCES ChatLieu(maCL),
maKD varchar(7) FOREIGN KEY REFERENCES KieuDang(maKD),
maKT varchar(7) FOREIGN KEY REFERENCES KichThuoc(maKT),
maMS varchar(7) FOREIGN KEY REFERENCES MauSac(maMS),
maXX varchar(7) FOREIGN KEY REFERENCES XuatXu(maXX),
maPL varchar(7) FOREIGN KEY REFERENCES PhanLoai(maPL),
loiTheoPhanTram int CHECK (loiTheoPhanTram > 0),
giaBan double precision,
hinhAnh varchar(50)
)

-- Tạo bảng TaiKhoan
CREATE TABLE TaiKhoan
(
tenTaiKhoan varchar(7) PRIMARY KEY,
matKhau nvarchar(50) NOT NULL,
maNV varchar(7) FOREIGN KEY REFERENCES NhanVien(maNV),
loaiTaiKhoan bit NOT NULL
)

-- Tạo bảng HoaDon
CREATE TABLE HoaDon
(
maHD varchar(7) PRIMARY KEY,
ngayLap date DEFAULT GETDATE(),
maKH varchar(7) FOREIGN KEY REFERENCES KhachHang(maKH),
maNV varchar(7) FOREIGN KEY REFERENCES NhanVien(maNV),
trangThai int,
tongTien double precision
)

-- Tạo bảng ChiTietHoaDon
CREATE TABLE ChiTietHoaDon
(
maSP varchar(7),
maHD varchar(7),
phanTramKhuyenMai double precision,
soLuong int CHECK (soLuong > 0),
PRIMARY KEY (maSP, maHD),
FOREIGN KEY (maSP) REFERENCES SanPham (maSP),
FOREIGN KEY (maHD) REFERENCES HoaDon(maHD),
thanhTien double precision
)

-- Tạo bảng HoaDonTraHang
CREATE TABLE HoaDonTraHang
(
maTH varchar(7) PRIMARY KEY,
ngayTra date DEFAULT GETDATE(),
soLuong int CHECK (soLuong > 0),
maSP varchar(7) FOREIGN KEY REFERENCES SanPham(maSP),
maHD varchar(7) FOREIGN KEY REFERENCES HoaDon(maHD)
)
