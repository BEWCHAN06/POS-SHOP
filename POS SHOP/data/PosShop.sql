USE [master]
GO
/****** Object:  Database [Postshop]    Script Date: 15/12/2023 9:28:41 SA ******/
CREATE DATABASE [Postshop]

GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Postshop].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Postshop] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Postshop] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Postshop] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Postshop] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Postshop] SET ARITHABORT OFF 
GO
ALTER DATABASE [Postshop] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [Postshop] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Postshop] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Postshop] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Postshop] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Postshop] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Postshop] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Postshop] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Postshop] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Postshop] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Postshop] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Postshop] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Postshop] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Postshop] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Postshop] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Postshop] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Postshop] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Postshop] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Postshop] SET  MULTI_USER 
GO
ALTER DATABASE [Postshop] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Postshop] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Postshop] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Postshop] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Postshop] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Postshop] SET QUERY_STORE = ON
GO
ALTER DATABASE [Postshop] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Postshop]
GO
/****** Object:  Table [dbo].[ChatLieu]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChatLieu](
	[maCL] [varchar](7) NOT NULL,
	[chatLieu] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maCL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietHoaDon]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietHoaDon](
	[maSP] [varchar](7) NOT NULL,
	[maHD] [varchar](7) NOT NULL,
	[phanTramKhuyenMai] [float] NULL,
	[soLuong] [int] NULL,
	[thanhTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC,
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHD] [varchar](7) NOT NULL,
	[ngayLap] [date] NULL,
	[maKH] [varchar](7) NULL,
	[maNV] [varchar](7) NULL,
	[trangThai] [int] NULL,
	[tongTien] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[maHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[maKH] [varchar](7) NOT NULL,
	[tenKH] [nvarchar](50) NOT NULL,
	[SDT] [varchar](50) NULL,
	[email] [varchar](50) NULL,
	[gioiTinh] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhuyenMai]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhuyenMai](
	[maKM] [varchar](7) NOT NULL,
	[phanTramKhuyenMai] [float] NULL,
	[tenKhuyenMai] [nvarchar](50) NULL,
	[ngayBatDau] [date] NULL,
	[ngayKetThuc] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[maKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KichThuoc]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KichThuoc](
	[maKT] [varchar](7) NOT NULL,
	[kichThuoc] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKT] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KieuDang]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KieuDang](
	[maKD] [varchar](7) NOT NULL,
	[kieuDang] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maKD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[MauSac]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[MauSac](
	[maMS] [varchar](7) NOT NULL,
	[mauSac] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maMS] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhaCungCap]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhaCungCap](
	[maNCC] [varchar](7) NOT NULL,
	[tenNCC] [nvarchar](50) NOT NULL,
	[SDT] [varchar](10) NULL,
	[email] [varchar](50) NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNV] [varchar](7) NOT NULL,
	[tenNV] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[SDT] [varchar](10) NOT NULL,
	[email] [varchar](50) NOT NULL,
	[CMND] [varchar](12) NOT NULL,
	[gioiTinh] [bit] NOT NULL,
	[diaChi] [nvarchar](50) NOT NULL,
	[chucVu] [bit] NOT NULL,
	[trangThai] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhanLoai]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhanLoai](
	[maPL] [varchar](7) NOT NULL,
	[phanLoai] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maPL] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SanPham]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[maSP] [varchar](7) NOT NULL,
	[tenSP] [nvarchar](50) NOT NULL,
	[giaNhap] [float] NULL,
	[soLuong] [int] NOT NULL,
	[maNCC] [varchar](7) NULL,
	[maKM] [varchar](7) NULL,
	[trangThai] [int] NULL,
	[maCL] [varchar](7) NULL,
	[maKD] [varchar](7) NULL,
	[maKT] [varchar](7) NULL,
	[maMS] [varchar](7) NULL,
	[maXX] [varchar](7) NULL,
	[maPL] [varchar](7) NULL,
	[loiTheoPhanTram] [int] NULL,
	[giaBan] [float] NULL,
	[hinhAnh] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[maSP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [varchar](7) NOT NULL,
	[matKhau] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[XuatXu]    Script Date: 15/12/2023 9:28:42 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[XuatXu](
	[maXX] [varchar](7) NOT NULL,
	[xuatXu] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[maXX] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL10', N' Lụa chéo')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL09', N'Caosu')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL01', N'Cotton')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL03', N'Da')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL04', N'Kaki')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL02', N'Len')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL07', N'Nỉ Chân Cua')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL08', N'Vải')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL05', N'Vải dù')
INSERT [dbo].[ChatLieu] ([maCL], [chatLieu]) VALUES (N'CL06', N'Vải Nano')
GO
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP01', N'HD01', 3, 3, 305550)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP01', N'HD04', 0, 1, 110000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP01', N'HD06', 0, 1, 110000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP01', N'HD07', 0, 1, 110000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD01', 5, 3, 335445)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD02', 5, 2, 223630)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD05', 0, 1, 132000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD07', 0, 1, 132000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD08', 0, 1, 132000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP02', N'HD09', 0, 1, 132000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP03', N'HD03', NULL, 2, 660000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP04', N'HD06', 0, 1, 330000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP04', N'HD09', 0, 1, 330000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP06', N'HD05', 0, 1, 385000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP06', N'HD07', 0, 1, 385000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP06', N'HD08', 0, 1, 385000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP08', N'HD07', 0, 1, 385000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP08', N'HD09', 0, 1, 385000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP10', N'HD05', 0, 1, 275000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP10', N'HD08', 0, 1, 275000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP10', N'HD09', 0, 1, 275000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP12', N'HD05', 0, 1, 550000)
INSERT [dbo].[ChiTietHoaDon] ([maSP], [maHD], [phanTramKhuyenMai], [soLuong], [thanhTien]) VALUES (N'SP14', N'HD08', 0, 1, 540000)
GO
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD01', CAST(N'2022-01-05' AS Date), N'KH01', N'NV01', 1, 640995)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD02', CAST(N'2022-02-14' AS Date), N'KH02', N'NV02', 1, 223630)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD03', CAST(N'2022-03-30' AS Date), N'KH03', N'NV03', 1, 660000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD04', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 110000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD05', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 1342000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD06', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 440000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD07', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 1012000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD08', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 1332000)
INSERT [dbo].[HoaDon] ([maHD], [ngayLap], [maKH], [maNV], [trangThai], [tongTien]) VALUES (N'HD09', CAST(N'2023-12-14' AS Date), N'KH01', N'NV01', 1, 1122000)
GO
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH01', N'Ẩn Danh', N'0902222222', N'xnv@gmail.com', 1)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH02', N'Đinh Hoàng Chiến', N'0917798113', N'dinhlemy@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH03', N'Đan Mỹ Chi', N'0925197741', N'danmychi@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH04', N'Nguyễn Văn Tùng', N'0566920965', N'nguyenvantung@gmail.com', 1)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH05', N'Bùi Hải Lâm', N'0912596378', N'buihailam@gmail.com', 1)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH06', N'Phạm Thị Hằng Nga', N'0917458963', N'phamthihangnga@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH07', N'Lê Tiến Tâm', N'0912225036', N'letientam@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH08', N'Ngô Ngọc Bích', N'0915578964', N'ngobichngoc@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH09', N'Lê Tuấn Kiệt', N'0910236669', N'letuankiet@gmail.com', 1)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH10', N'Nguyễn Hà My', N'0911455720', N'nguyenhamy@gmail.com', 0)
INSERT [dbo].[KhachHang] ([maKH], [tenKH], [SDT], [email], [gioiTinh]) VALUES (N'KH11', N'Nguyễn Hà My', N'0911555420', N'nguyenminhnghia@gmail.com', 0)
GO
INSERT [dbo].[KhuyenMai] ([maKM], [phanTramKhuyenMai], [tenKhuyenMai], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM01', 3, N'Giảm 10%', CAST(N'2023-12-16' AS Date), CAST(N'2024-12-31' AS Date))
INSERT [dbo].[KhuyenMai] ([maKM], [phanTramKhuyenMai], [tenKhuyenMai], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM02', 15, N'Giảm 15%', CAST(N'2023-12-16' AS Date), CAST(N'2024-02-28' AS Date))
INSERT [dbo].[KhuyenMai] ([maKM], [phanTramKhuyenMai], [tenKhuyenMai], [ngayBatDau], [ngayKetThuc]) VALUES (N'KM03', 20, N'Khuyển mãi tết', CAST(N'2023-12-30' AS Date), CAST(N'2024-01-31' AS Date))
GO
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT04', N'37')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT05', N'38')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT06', N'39')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT07', N'40')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT08', N'41')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT09', N'42')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT03', N'L')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT02', N'M')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT01', N'S')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT10', N'XL')
INSERT [dbo].[KichThuoc] ([maKT], [kichThuoc]) VALUES (N'KT11', N'XXL')
GO
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD07', N'Basic')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD04', N'BodyFit')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD13', N'Cao Gót')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD14', N'Cao Gót Mũi Nhọn')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD03', N'Cổ bẻ')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD01', N'Cổ tròn')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD02', N'Cổ V')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD11', N'Dép Quai Ngang')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD08', N'Hoddie')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD05', N'Ống suông')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD09', N'Rộng')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD12', N'Sandas')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD06', N'SlimFit')
INSERT [dbo].[KieuDang] ([maKD], [kieuDang]) VALUES (N'KD10', N'Sneaker')
GO
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MS07', N'Be')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MS04', N'Đen')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MC01', N'Đỏ')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MS08', N'Nhiều Màu')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MS06', N'Trắng ')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MC03', N'Vàng')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MS05', N'Xám')
INSERT [dbo].[MauSac] ([maMS], [mauSac]) VALUES (N'MC02', N'Xanh')
GO
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC01', N'Công ty may mặc Quảng Việt', N'0901234567', N'ncc1@gmail.com', N'Đà Nẵng')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC02', N'Công ty TNHH May Bico Kids', N'0902234567', N'ncc2@gmail.com', N'Hà Nội')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC03', N'Công Ty TNHH HADES', N'0903345678', N'ncc3@gmail.com', N'TP. Hồ Chí Minh')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC04', N'công cổ phần quần áo thời trang', N'0337061506', N'baotran.060195@gmail.com', N'tp.hcm')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC05', N'Công ty TNHH May áo khoác Thịnh Phát', N'0935818711', N'maymacthinhphat@gmail.com', N'269/99 Phan Huy Ích, P 14, Q Gò Vấp, TP HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC06', N'Công ty TNHH May Trang Sỉ', N'0968853302', N'Lienhetrangsi@gmail.com', N'TP HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC07', N'Công ty TNHH May Khang Thịnh', N'0914296114', N'maymackhangthinh@gmail.com', N'TP HCM')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC08', N'Công ty TNHH May Thêu Giày An Phước', N'0283835005', N'maydodongphuc@anphuoc.com.vn', N'100/11-12 An Dương Vương, P.9, Q.5, Tp.Hồ Chí Minh')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC09', N'Công ty TNHH May VNXK Eva', N'0904879533', N'MayVNXKEVA@yahoo.com.vn', N'Hà Nội')
INSERT [dbo].[NhaCungCap] ([maNCC], [tenNCC], [SDT], [email], [diaChi]) VALUES (N'NCC10', N'Công ty TNHH May áo khoác Ann', N'0918567109', N'tranyenngoc9x@gmail.com', N'TP HCM')
GO
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [SDT], [email], [CMND], [gioiTinh], [diaChi], [chucVu], [trangThai]) VALUES (N'NV01', N'Nguyễn Văn A', CAST(N'1980-01-01' AS Date), N'0912345678', N'anv@gmail.com', N'091234567890', 1, N'Hà Nội', 1, 0)
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [SDT], [email], [CMND], [gioiTinh], [diaChi], [chucVu], [trangThai]) VALUES (N'NV02', N'Trần Thị B', CAST(N'1982-04-05' AS Date), N'0909876543', N'giah27240@gmail.com', N'090987654321', 0, N'Hà Nam', 1, 0)
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [SDT], [email], [CMND], [gioiTinh], [diaChi], [chucVu], [trangThai]) VALUES (N'NV03', N'Đinh Thị C', CAST(N'1985-07-07' AS Date), N'0998765432', N'cdh@gmail.com', N'099876543210', 1, N'Hà Tĩnh', 0, 2)
INSERT [dbo].[NhanVien] ([maNV], [tenNV], [ngaySinh], [SDT], [email], [CMND], [gioiTinh], [diaChi], [chucVu], [trangThai]) VALUES (N'NV04', N'Đinh Thị D', CAST(N'1985-07-07' AS Date), N'0998765432', N'cdh@gmail.com', N'099876543210', 1, N'Hà Tĩnh', 0, 1)
GO
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL06', N'Áo Khoác')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL01', N'Áo thun')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL09', N'Cosplay')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL03', N'Giày dép')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL07', N'Hoddie')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL08', N'Nón')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL05', N'Quần Âu')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL02', N'Quần jeans')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL04', N'Quần short')
INSERT [dbo].[PhanLoai] ([maPL], [phanLoai]) VALUES (N'PL10', N'Sơ Mi')
GO
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP01', N'Áo thun đỏ có cổ', 100000, 497, N'NCC01', N'KM01', 1, N'CL01', N'KD03', N'KT01', N'MC01', N'XX01', N'PL01', 40, 140000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP02', N'Áo thun xanh thể thao', 120000, 396, N'NCC01', N'KM01', 1, N'CL01', N'KD02', N'KT02', N'MC02', N'XX01', N'PL01', 10, 132000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP03', N'Quần short vải dù', 300000, 298, N'NCC01', N'KM01', 1, N'CL05', N'KD04', N'KT03', N'MS04', N'XX01', N'PL04', 40, 420000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP04', N'Quần short kaki', 300000, 298, N'NCC02', N'KM01', 1, N'CL04', N'KD04', N'KT03', N'MS04', N'XX01', N'PL04', 40, 420000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP05', N'Quần jean dài ống suông', 350000, 300, N'NCC02', N'KM01', 1, N'CL01', N'KD03', N'KT03', N'MC02', N'XX02', N'PL02', 40, 490000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP06', N'Quần jean dai slimfit', 350000, 297, N'NCC01', N'KM03', 1, N'CL01', N'KD06', N'KT03', N'MS04', N'XX01', N'PL02', 30, 455000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP07', N'Quần Tây Đen', 350000, 250, N'NCC01', NULL, 1, N'CL06', N'KD04', N'KT03', N'MS04', N'XX01', N'PL05', 30, 455000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP08', N'Quần Tây Xám', 350000, 248, N'NCC01', NULL, 1, N'CL06', N'KD06', N'KT03', N'MS05', N'XX01', N'PL05', 30, 455000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP09', N'Áo khoác chống nắng', 200000, 200, N'NCC01', NULL, 1, N'CL05', N'KD07', N'KT03', N'MS04', N'XX01', N'PL06', 10, 220000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP10', N'Hoodie FreeFire Siêu Cấp', 250000, 197, N'NCC01', NULL, 1, N'CL01', N'KD09', N'KT03', N'MS06', N'XX02', N'PL07', 10, 275000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP11', N'Hoddie Mùa Đông', 400000, 300, N'NCC01', NULL, 1, N'CL07', N'KD09', N'KT02', N'MS04', N'XX04', N'PL07', 30, 520000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP12', N'Giày MLB', 500000, 299, N'NCC01', NULL, 1, N'CL03', N'KD10', N'KT08', N'MS06', N'XX04', N'PL03', 30, 650000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP13', N'Giày Nike AF1', 400000, 300, N'NCC01', NULL, 1, N'CL03', N'KD10', N'KT08', N'MS06', N'XX02', N'PL03', 10, 440000, N'GiayNike.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP14', N'Giày Thể Thao Adidas', 450000, 299, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT07', N'MS05', N'XX04', N'PL03', 10, 495000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP15', N'Giày Sandas nữ', 300000, 200, N'NCC01', NULL, 1, N'CL03', N'KD12', N'KT04', N'MS07', N'XX01', N'PL03', 10, 330000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP16', N'Giày Sandas Nam', 300000, 200, N'NCC01', NULL, 1, N'CL08', N'KD12', N'KT08', N'MS04', N'XX01', N'PL03', 10, 330000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP17', N'Giày Sandas Nữ Thời Trang', 250000, 200, N'NCC01', NULL, 1, N'CL09', N'KD12', N'KT04', N'MS04', N'XX02', N'PL03', 10, 275000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP18', N'Giày Cao Gót Nữ', 300000, 200, N'NCC01', NULL, 1, N'CL09', N'KD13', N'KT04', N'MS07', N'XX01', N'PL03', 10, 330000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP19', N'Giày Cao Gót Mũi Nhọn', 150000, 200, N'NCC01', NULL, 1, N'CL03', N'KD14', N'KT04', N'MS06', N'XX02', N'PL03', 10, 165000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP20', N'Dép Bánh Mì Nam Nữ', 250000, 300, N'NCC01', NULL, 1, N'CL09', N'KD07', N'KT07', N'MS07', N'XX02', N'PL03', 10, 275000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP21', N'Dép Unisex Quai Ngang', 50000, 100, N'NCC01', NULL, 1, N'CL09', N'KD07', N'KT08', N'MS06', N'XX02', N'PL03', 10, 55000, N'Unisexquaingang.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP22', N'Dép Cá Mập', 100000, 200, N'NCC01', NULL, 1, N'CL09', N'KD07', N'KT05', N'MC02', N'XX02', N'PL03', 10, 110000, N'DepCaMap.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP23', N' Dép quai ngang LOUI.S VUITTON', 250000, 200, N'NCC01', NULL, 1, N'CL09', N'KD07', N'KT07', N'MS04', N'XX02', N'PL03', 10, 275000, N'Depbao.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP24', N' Dép đi biển thời trang Hàn Quốc', 50000, 100, N'NCC01', NULL, 1, N'CL09', N'KD07', N'KT06', N'MC01', N'XX02', N'PL03', 10, 55000, N'depkep.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP25', N'NÓN BUCKET - NY 1 MẶT', 50000, 100, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT01', N'MS04', N'XX02', N'PL08', 10, 55000, N'Nontaibeo.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP26', N'Nón Mũ Lưỡi Trai LA MLB', 50000, 100, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT01', N'MS06', N'XX02', N'PL08', 10, 55000, N'nonMLB.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP27', N'Mũ Lưỡi Trai Nam Nữ Nhiều Họa Tiết Thêu Chữ', 70000, 200, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT02', N'MS08', N'XX02', N'PL08', 10, 77000, N'nonthue.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP28', N'Trang phục cosplay HASUNE MIKU', 600000, 50, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT01', N'MS08', N'XX02', N'PL09', 10, 660000, N'docosplay.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP29', N'cosplay nhân vật Nahida', 500000, 50, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT01', N'MS08', N'XX02', N'PL09', 10, 550000, N'cosplayxanh.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP30', N'Sơ Mi Trắng dài tay', 250000, 200, N'NCC01', NULL, 1, N'CL10', N'KD04', N'KT03', N'MS06', N'XX01', N'PL10', 10, 275000, N'Somitrang.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP31', N'Sơ Mi Đen Tay Dài', 250000, 200, N'NCC01', NULL, 1, N'CL10', N'KD07', N'KT03', N'MS04', N'XX01', N'PL10', 10, 275000, N'somiden.jpg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP32', N'áo polo', 100000, 2, N'NCC01', NULL, 1, N'CL10', N'KD07', N'KT04', N'MS07', N'XX04', N'PL06', 10, 110000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP33', N'áo polo', 100000, 2, N'NCC01', NULL, 1, N'CL10', N'KD07', N'KT03', N'MS07', N'XX04', N'PL06', 10, 110000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP34', N'áo polo', 100000, 2, N'NCC01', NULL, 1, N'CL10', N'KD07', N'KT02', N'MS07', N'XX04', N'PL06', 10, 110000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP35', N'áo polo', 100000, 2, N'NCC01', NULL, 1, N'CL10', N'KD07', N'KT01', N'MS07', N'XX04', N'PL06', 10, 110000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP36', N'ÁO THUN COTTON K1', 170000, 100, N'NCC01', N'KM02', 1, N'CL10', N'KD07', N'KT03', N'MS07', N'XX04', N'PL06', 40, 238000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP37', N'ÁO THUN COTTON K1', 170000, 100, N'NCC01', N'KM02', 1, N'CL10', N'KD07', N'KT02', N'MS07', N'XX04', N'PL06', 40, 238000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP38', N'ÁO THUN COTTON K1', 170000, 100, N'NCC01', N'KM02', 1, N'CL10', N'KD07', N'KT01', N'MS07', N'XX04', N'PL06', 40, 238000, N'')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP39', N'ÁO THUN NAM TAY DÀI PHONG CÁCH HÀN QUỐC ', 145000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT07', N'MS06', N'XX02', N'PL01', 10, 159500, N'aopolo.jpeg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP40', N'ÁO KHOÁC KAKI NAM CỔ TRỤ PHỐI TÚI  ', 180000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT03', N'MS06', N'XX02', N'PL01', 20, 216000, N'aopolo.jpeg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP41', N'ÁO KHOÁC KAKI NAM CỔ TRỤ PHỐI TÚI  ', 180000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT02', N'MS06', N'XX02', N'PL01', 20, 216000, N'aopolo.jpeg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP42', N'ÁO KHOÁC KAKI NAM CỔ TRỤ PHỐI TÚI  ', 180000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT01', N'MS06', N'XX02', N'PL01', 20, 216000, N'aopolo.jpeg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP43', N'ÁO KHOÁC KAKI NAM CỔ TRỤ PHỐI TÚI  ', 180000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT10', N'MS06', N'XX02', N'PL01', 20, 216000, N'aopolo.jpeg')
INSERT [dbo].[SanPham] ([maSP], [tenSP], [giaNhap], [soLuong], [maNCC], [maKM], [trangThai], [maCL], [maKD], [maKT], [maMS], [maXX], [maPL], [loiTheoPhanTram], [giaBan], [hinhAnh]) VALUES (N'SP44', N'ÁO KHOÁC KAKI NAM CỔ TRỤ PHỐI TÚI  ', 180000, 10, N'NCC01', NULL, 1, N'CL08', N'KD07', N'KT11', N'MS06', N'XX02', N'PL01', 20, 216000, N'aopolo.jpeg')
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV01', N'123456')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV02', N'1234567')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau]) VALUES (N'NV03', N'12345678')
GO
INSERT [dbo].[XuatXu] ([maXX], [xuatXu]) VALUES (N'XX04', N'America')
INSERT [dbo].[XuatXu] ([maXX], [xuatXu]) VALUES (N'XX03', N'Nhật Bản')
INSERT [dbo].[XuatXu] ([maXX], [xuatXu]) VALUES (N'XX02', N'Trung Quốc')
INSERT [dbo].[XuatXu] ([maXX], [xuatXu]) VALUES (N'XX01', N'Việt Nam')
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__ChatLieu__427A5E608C55123E]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[ChatLieu] ADD UNIQUE NONCLUSTERED 
(
	[chatLieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KichThuo__8687F7420A9C6716]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[KichThuoc] ADD UNIQUE NONCLUSTERED 
(
	[kichThuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__KieuDang__FC7E80E161B228B1]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[KieuDang] ADD UNIQUE NONCLUSTERED 
(
	[kieuDang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__MauSac__139304BC95CFA3B3]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[MauSac] ADD UNIQUE NONCLUSTERED 
(
	[mauSac] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__PhanLoai__DF11B6C7F6395E12]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[PhanLoai] ADD UNIQUE NONCLUSTERED 
(
	[phanLoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__XuatXu__4CD366DEFA1A8363]    Script Date: 15/12/2023 9:28:42 SA ******/
ALTER TABLE [dbo].[XuatXu] ADD UNIQUE NONCLUSTERED 
(
	[xuatXu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[HoaDon] ADD  DEFAULT (getdate()) FOR [ngayLap]
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHD])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD FOREIGN KEY([maSP])
REFERENCES [dbo].[SanPham] ([maSP])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([maKH])
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maCL])
REFERENCES [dbo].[ChatLieu] ([maCL])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maKD])
REFERENCES [dbo].[KieuDang] ([maKD])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maKM])
REFERENCES [dbo].[KhuyenMai] ([maKM])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maKT])
REFERENCES [dbo].[KichThuoc] ([maKT])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maMS])
REFERENCES [dbo].[MauSac] ([maMS])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maNCC])
REFERENCES [dbo].[NhaCungCap] ([maNCC])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maPL])
REFERENCES [dbo].[PhanLoai] ([maPL])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([maXX])
REFERENCES [dbo].[XuatXu] ([maXX])
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD FOREIGN KEY([tenTaiKhoan])
REFERENCES [dbo].[NhanVien] ([maNV])
GO
ALTER TABLE [dbo].[ChiTietHoaDon]  WITH CHECK ADD CHECK  (([soLuong]>(0)))
GO
ALTER TABLE [dbo].[KhachHang]  WITH CHECK ADD CHECK  (([SDT] like '0%' AND len([SDT])>=(10)))
GO
ALTER TABLE [dbo].[KhuyenMai]  WITH CHECK ADD CHECK  (([phanTramKhuyenMai]>(0)))
GO
ALTER TABLE [dbo].[NhaCungCap]  WITH CHECK ADD CHECK  (([SDT] like '0%' AND len([SDT])=(10)))
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD CHECK  (([ngaySinh]>='1900-01-01'))
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD CHECK  (([giaNhap]>(0)))
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD CHECK  (([loiTheoPhanTram]>(0)))
GO
USE [master]
GO
ALTER DATABASE [Postshop] SET  READ_WRITE 
GO
