package ndyudev.lab6.slider;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost;databaseName=java3_servlet_jsp;encrypt=false;";
	static String username = "sa";
	static String password = "ndyudev227";

	static {
		try { // nạp driver
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	/** Mở kết nối */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, username, password);
	}

	/** Thao tác dữ liệu */
	public static int executeUpdate(String sql, Object... values) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
		return statement.executeUpdate();
	}

	/** Truy vấn dữ liệu */
	public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
		Connection connection = getConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
		return statement.executeQuery();
	}

	/* goi hàm */
	public static ResultSet executeCallQuery(String sql, Object... values) throws SQLException {
		Connection connection = getConnection();
		CallableStatement statement = connection.prepareCall(sql);
		for (int i = 0; i < values.length; i++) {
			statement.setObject(i + 1, values[i]);
		}
		return statement.executeQuery();
	}

	public static void main(String[] args) {
		
		try {
			String sql = "SELECT * FROM NEWS WHERE CATEGORYID = ?";
			Object[] values = {"ctgr01"};
			ResultSet resultSet = JdbcHelper.executeQuery(sql, values);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
//		/* truy vấn */
//		try {
//			String sql = "select * from employees where salary between ? and ?";
//			Object[] values = { 4000, 6000 }; // mảng chứa các giá trị tham số ResultSet
//			ResultSet resultSet = JdbcHelper.executeQuery(sql, values);
//			while (resultSet.next()) {
//				String fullname = resultSet.getString("fullname"); // thay column bằng tên cột trong bảng
//				Double salary = resultSet.getDouble("salary");
//				System.out.println(fullname + " - " + salary);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/* cap nhat */
//		try {
//			String sql = "update employees set salary = ? where id = ?"; // thử từng câu
//			Object[] values = { 5050.0, "em01" };
//			int rows = JdbcHelper.executeUpdate(sql, values);
//			System.out.println(rows);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		/* goi ham */
//		String sql = "{Call sp_salary_report(?,?)}";
//		try {
//			ResultSet rs = JdbcHelper.executeCallQuery(sql, 2024, 2024);
//			while (rs.next()) {
//				String departmentName = rs.getString("departmentName"); // thay column bằng tên cột trong bảng
//				Double sum = rs.getDouble("SumSalary");
//				System.out.println(departmentName + " - " + sum);
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
	}
}
