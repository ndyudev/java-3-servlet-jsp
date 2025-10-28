CREATE DATABASE PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Practice_ASM;
GO

DROP DATABASE PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Practice_ASM

USE QLDA2034

USE PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Practice_ASM;
GO

-- Bảng Category
CREATE TABLE Category(
	idCategory VARCHAR(10) NOT NULL PRIMARY KEY,
	nameCategory NVARCHAR(50)
);
GO

-- Bảng Book
CREATE TABLE Book(
	idBook VARCHAR(10) NOT NULL PRIMARY KEY,
	nameBook NVARCHAR(100),
	priceBook DECIMAL(10,2),
	yearBook INT,
	idCategory VARCHAR(10),
	FOREIGN KEY (idCategory) REFERENCES Category(idCategory)
);
GO

-- Insert Category (5 records)
INSERT INTO Category VALUES
('C01', N'Programming'),
('C02', N'Web Development'),
('C03', N'Database'),
('C04', N'Design UI/UX'),
('C05', N'Artificial Intelligence');
GO

-- Insert Book (5 records)
INSERT INTO Book VALUES
('B01', N'Java Core Mastery', 199.99, 2022, 'C01'),
('B02', N'Fullstack with Spring Boot', 249.50, 2023, 'C02'),
('B03', N'SQL Server Deep Dive', 159.00, 2021, 'C03'),
('B04', N'UI/UX Design Trends 2025', 179.90, 2024, 'C04'),
('B05', N'Machine Learning with Python', 299.00, 2023, 'C05');
GO
