Create database PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Topic1
use PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Topic1

CREATE TABLE sanpham (
    masp CHAR(4) PRIMARY KEY NOT NULL,
    tensp NVARCHAR(50) NULL,
    gia FLOAT NULL,
    loaisp NVARCHAR(50) NULL
);

INSERT INTO sanpham (masp, tensp, gia, loaisp) VALUES
('SP01', N'Laptop Dell XPS', 25000000.00, N'Thiết bị điện tử'),
('SP02', N'Áo phông Adidas', 550000.50, N'Thời trang'),
('SP03', N'Điện thoại Samsung S21', 18500000.00, N'Thiết bị điện tử');

