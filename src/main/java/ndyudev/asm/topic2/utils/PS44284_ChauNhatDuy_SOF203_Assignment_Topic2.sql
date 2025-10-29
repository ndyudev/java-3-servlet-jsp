CREATE DATABASE PS44284_ChauNhatDuy_SOF203_Assignment_Topic2

use PS44284_ChauNhatDuy_SOF203_Assignment_Topic2

drop database PS44284_ChauNhatDuy_SOF203_Assignment_Topic2

create table Student (
	masv char(4) not null primary key,
	hoten nvarchar(50) null,
	namsinh int null,
	gioitinh bit null,
	makhoa nvarchar(20) null
)

INSERT INTO Student (masv, hoten, namsinh, gioitinh, makhoa) VALUES 
('S001', 'Nguyen Van A', 2006, 0, 'IT'),
('S002', 'Nguyen Van B', 2003, 1, 'IT'),
('S003', 'Nguyen Van C', 2004, 0, 'IT'),
('S004', 'Nguyen Van D', 2005, 1, 'BA'),
('S004', 'Nguyen Van D', 2005, 1, 'BA')