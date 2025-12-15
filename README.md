# 🚀 Java 3 – Lập trình Web với Servlet & JSP (SOF203)

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge\&logo=openjdk\&logoColor=white)
![Servlet](https://img.shields.io/badge/Jakarta_Servlet-Fail--Fast-blue?style=for-the-badge)
![JSP](https://img.shields.io/badge/JSP-Tomcat-orange?style=for-the-badge\&logo=apache-tomcat\&logoColor=black)
![Database](https://img.shields.io/badge/Database-MSSQL-CC2927?style=for-the-badge\&logo=microsoft-sql-server\&logoColor=white)
![Build](https://img.shields.io/badge/Build-Maven-C71A36?style=for-the-badge\&logo=apache-maven\&logoColor=white)

> Repository chứa **Labs + Assignment** môn **Java 3 – Lập trình Web với Servlet & JSP**. Build theo mô hình **MVC**, chạy ổn áp trên **Tomcat**, dùng **SQL Server** để lưu trữ dữ liệu.

---

## 📌 Mục lục

* [Giới thiệu](#-giới-thiệu)
* [Công nghệ sử dụng](#-công-nghệ-sử-dụng)
* [Cấu trúc thư mục](#-cấu-trúc-thư-mục)
* [Chức năng chính (Assignment)](#-chức-năng-chính-assignment)
* [Hướng dẫn cài đặt](#-hướng-dẫn-cài-đặt)
* [Cách chạy & Demo](#-cách-chạy--demo)
* [Đóng góp](#-đóng-góp)
* [Tác giả](#-tác-giả)

---

## 📖 Giới thiệu

Dự án được xây dựng nhằm phục vụ học tập và thực hành **Java Web** với:

* **Servlet**: Xử lý nghiệp vụ & điều hướng
* **JSP/JSTL**: Hiển thị giao diện
* **MVC**: Tách bạch Model – View – Controller, code dễ đọc, dễ maintain
* **SQL Server + Hibernate/JPA**: Quản lý & thao tác dữ liệu

Phù hợp cho sinh viên đang học **Java 3 (SOF203)** hoặc muốn ôn lại nền tảng **Servlet & JSP**.

---

## 🛠 Công nghệ sử dụng

### Core

* **JDK**: 17
* **Build Tool**: Maven

### Backend

* **Jakarta Servlet API**
* **JSP / JSTL**
* **Hibernate Core / JPA**
* **SQL Server JDBC Driver**
* **Lombok** (giảm boilerplate code)

### Frontend

* **HTML / CSS / JavaScript**
* **Bootstrap 5**

### Server & Database

* **Apache Tomcat**: 9.0 / 10.0
* **Microsoft SQL Server**

---

## 📂 Cấu trúc thư mục

```text
java-3-servlet-jsp/
├── src/
│   ├── main/
│   │   ├── java/               # Servlet, Controller, Model, DAO, Utils
│   │   ├── resources/          # Cấu hình (Hibernate, DB)
│   │   └── webapp/             # JSP, CSS, JS, Images
├── database/                   # Script SQL tạo CSDL
├── pom.xml                     # Maven dependencies
└── README.md                   # Tài liệu dự án
```

---

## ✨ Chức năng chính (Assignment)

### 👤 Quản lý Tài khoản

* Đăng nhập / Đăng xuất
* Đổi mật khẩu
* Cập nhật thông tin cá nhân

### 📦 Quản lý Sản phẩm

* Thêm / Sửa / Xóa sản phẩm
* Xem danh sách & chi tiết sản phẩm

### 🛒 Quản lý Đơn hàng

* Giỏ hàng
* Lịch sử mua hàng

### 🔐 Phân quyền

* **Admin**

  * CRUD Users
  * CRUD Products
* **User**

  * Xem sản phẩm
  * Mua hàng

### ⚙️ Tiện ích khác

* Upload hình ảnh
* Gửi Email
* Đa ngôn ngữ (I18n)

---

## 🚀 Hướng dẫn cài đặt

### 1️⃣ Clone repository

```bash
git clone https://github.com/ndyudev/java-3-servlet-jsp.git
cd java-3-servlet-jsp
```

### 2️⃣ Cấu hình Database

1. Mở **SQL Server Management Studio (SSMS)**
2. Chạy file script trong thư mục `database/` (ví dụ: `Poly.sql`)
3. Cập nhật thông tin kết nối DB:

**hibernate.cfg.xml** hoặc **DBContext.java**

```xml
<property name="connection.username">sa</property>
<property name="connection.password">YOUR_PASSWORD</property>
```

### 3️⃣ Build & Run

1. Mở project bằng **IntelliJ IDEA** hoặc **Eclipse** (Import Maven Project)
2. Đợi Maven tải dependencies
3. Cấu hình **Tomcat Server**

   * Artifact: `java-3-servlet-jsp:war exploded`
4. Nhấn **Run / Debug**

---

## ▶️ Cách chạy & Demo

Truy cập trên trình duyệt:

```
http://localhost:8080/java-3-servlet-jsp
```

---

## 🤝 Đóng góp

* Fork repository
* Tạo branch mới
* Commit & tạo Pull Request

Mọi ý kiến đóng góp đều được welcome. Phát hiện bug thì cứ mạnh dạn mở **Issue**.

---

## 👤 Tác giả

**Châu Nhật Duy**

* GitHub: [@ndyudev](https://github.com/ndyudev)
* Facebook: Châu Nhật Duy

---

> Made with ❤️ & ☕ by **ndyudev**
