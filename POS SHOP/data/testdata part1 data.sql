use Postshop

--Insert data for table NhanVien
INSERT INTO NhanVien VALUES
('NV01', N'Nguyễn Văn A', '1980-01-01', '0912345678','anv@gmail.com', '091234567890',1, N'Hà Nội', 1, 0),
('NV02', N'Trần Thị B', '1982-04-05', '0909876543','giah27240@gmail.com', '090987654321',0, N'Hà Nam', 1, 0),
('NV03', N'Đinh Thị C', '1985-07-07', '0998765432','cdh@gmail.com', '099876543210',1, N'Hà Tĩnh', 0, 2),
('NV04', N'Đinh Thị D', '1985-07-07', '0998765432','cdh@gmail.com', '099876543210',1, N'Hà Tĩnh', 0, 1)
--Insert data for table KhachHang
INSERT INTO KhachHang VALUES
('KH01', N'Nguyễn Văn X', '0902222222', 'xnv@gmail.com', 1),
('KH02', N'Trần Thị Y', '0903333333', 'ytt@gmail.com', 0),
('KH03', N'Đinh Thị Z', '0904444444', NULL, 1)

--Insert data for table XuatXu
INSERT INTO XuatXu VALUES
('XX01', N'Việt Nam'),
('XX02', N'Trung Quốc'),
('XX03', N'Nhật Bản')

--Insert data for table PhanLoai
INSERT INTO PhanLoai VALUES
('PL01', N'Áo thun'),
('PL02', N'Quần jeans'),
('PL03', N'Giày dép')

--Insert data for table MauSac
INSERT INTO MauSac VALUES
('MC01', N'Đỏ'),
('MC02', N'Xanh'),
('MC03', N'Vàng')

--Insert data for table KichThuoc
INSERT INTO KichThuoc VALUES
('KT01', N'S'),
('KT02', N'M'),
('KT03', N'L')

--Insert data for table ChatLieu
INSERT INTO ChatLieu VALUES
('CL01', N'Cotton'),
('CL02', N'Len'),
('CL03', N'Da')

--Insert data for table KieuDang
INSERT INTO KieuDang VALUES
('KD01', N'Cổ tròn'),
('KD02', N'Cổ V'),
('KD03', N'Cổ bẻ')

--Insert data for table NhaCungCap
INSERT INTO NhaCungCap VALUES
('NCC01', N'Công ty A', '0901234567', 'ncc1@gmail.com', N'Đà Nẵng'),
('NCC02', N'Công ty B', '0902234567', 'ncc2@gmail.com', N'Hà Nội'),
('NCC03', N'Công ty C', '0903345678', 'ncc3@gmail.com', N'TP. Hồ Chí Minh')

--Insert data for table KhuyenMai
INSERT INTO KhuyenMai VALUES
('KM01', 3, N'Giảm 10%', '2023-10-29', '2024-12-31'),
('KM02', 5, N'Giảm 15%', '2023-11-29', '2024-02-28'),
('KM03', 7, N'Giảm 20%', '2023-12-29', '2024-05-15')

--Insert data for table SanPham
INSERT INTO SanPham VALUES
('SP01', N'Áo thun đỏ S', 100000, 500,'NCC01', 'KM01', 0, 'CL01', 'KD01', 'KT01', 'MC01', 'XX01', 'PL01', 5, 105000,''),
('SP02', N'Áo thun xanh M', 110000, 550,'NCC01','KM02', 0, 'CL01', 'KD02', 'KT02', 'MC02', 'XX01', 'PL01', 7, 117700,''),
('SP03', N'Quần jean L', 300000, 600,'NCC02', NULL, 1, 'CL02', 'KD03', 'KT03', 'MC03', 'XX02', 'PL02', 10, 330000,''),
('SP04', N'Quần jean Z', 400000, 600,'NCC02', NULL, 1, 'CL02', 'KD03', 'KT03', 'MC03', 'XX02', 'PL02', 10, 440000,''),
('SP05', N'Quần jean X', 500000, 600,'NCC02', NULL, 2, 'CL02', 'KD03', 'KT03', 'MC03', 'XX02', 'PL02', 10, 550000,''),
('SP06', N'Quần jean XL', 600000, 600,'NCC02', NULL, 2, 'CL02', 'KD03', 'KT03', 'MC03', 'XX02', 'PL02', 10, 660000,'')

--Insert data for table TaiKhoan
INSERT INTO TaiKhoan VALUES
('NV01', '123456'),
('NV02', '1234567'),
('NV03', '12345678')
--Insert data for table HoaDon
INSERT INTO HoaDon VALUES
('HD01','2022-01-05','KH01','NV01', 1, 640995),
('HD02','2022-02-14','KH02','NV02', 1, 223630),
('HD03','2022-03-30','KH03','NV03', 0, 330000)

--Insert data for table ChiTietHoaDon
INSERT INTO ChiTietHoaDon VALUES
('SP01','HD01',3, 3, 305550),
('SP02','HD01',5, 3, 335445),
('SP02','HD02',5, 2, 223630),
('SP03','HD03',NULL, 1, 330000)
--Insert data for table HoaDonTraHang
INSERT INTO HoaDonTraHang VALUES
('TH01','2022-01-06',1,'SP01','HD01'),
('TH02','2022-02-15',2,'SP02','HD02')