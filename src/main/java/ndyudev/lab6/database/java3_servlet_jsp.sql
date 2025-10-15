create database java3_servlet_jsp
GO
USE java3_servlet_jsp;
GO

-- Bảng Department
CREATE TABLE Department (
	id NVARCHAR(10) PRIMARY KEY,
	name NVARCHAR(100) NOT NULL,
	description NVARCHAR(255)
);
GO

-- Bảng Employee
CREATE TABLE Employee (
	id NVARCHAR(10) PRIMARY KEY,
	fullname NVARCHAR(100) NOT NULL,
	password NVARCHAR(50) NOT NULL,
	gender BIT,
	birthday DATE,
	photo NVARCHAR(255),
	salary FLOAT,
	departmentid NVARCHAR(10),
	FOREIGN KEY (departmentid) REFERENCES Department(id)
);
GO

-- Dữ liệu mẫu cho Department
INSERT INTO Department (id, name, description) VALUES
('D01', N'Human Resources', N'Handles recruitment, employee relations, and HR policies'),
('D02', N'Finance', N'Manages company budgets, payroll, and financial records'),
('D03', N'IT', N'Handles software, hardware, and technical support'),
('D04', N'Marketing', N'Oversees company branding and promotional campaigns'),
('D05', N'Sales', N'Focuses on client relationships and product sales'),
('D06', N'R&D', N'Researches and develops new products and technologies'),
('D07', N'Operations', N'Manages logistics, production, and workflow efficiency'),
('D08', N'Customer Service', N'Supports customers and handles inquiries'),
('D09', N'Administration', N'Manages office supplies, documents, and facilities'),
('D10', N'Legal', N'Handles legal compliance and company policies');
GO

-- Dữ liệu mẫu cho Employee
INSERT INTO Employee (id, fullname, password, gender, birthday, photo, salary, departmentid) VALUES
('E001', N'Nguyen Van A', '123', 1, '1995-01-12', 'a.jpg', 1200, 'D01'),
('E002', N'Tran Thi B', '123', 0, '1998-05-20', 'b.jpg', 1500, 'D02'),
('E003', N'Le Van C', '123', 1, '1992-03-10', 'c.jpg', 2000, 'D03'),
('E004', N'Pham Thi D', '123', 0, '1999-09-25', 'd.jpg', 1100, 'D04'),
('E005', N'Do Van E', '123', 1, '1994-07-02', 'e.jpg', 1700, 'D05'),
('E006', N'Hoang Thi F', '123', 0, '1997-11-13', 'f.jpg', 1850, 'D06'),
('E007', N'Bui Van G', '123', 1, '1993-04-05', 'g.jpg', 2200, 'D07'),
('E008', N'Nguyen Thi H', '123', 0, '1996-12-17', 'h.jpg', 1350, 'D08'),
('E009', N'Tran Van I', '123', 1, '1991-08-29', 'i.jpg', 2500, 'D09'),
('E010', N'Le Thi J', '123', 0, '1999-02-14', 'j.jpg', 1450, 'D10');
GO

-- Kiểm tra dữ liệu
SELECT * FROM Department;
SELECT * FROM Employee;

