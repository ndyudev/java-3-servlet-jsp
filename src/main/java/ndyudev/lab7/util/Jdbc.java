package ndyudev.lab7.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Jdbc {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost;databaseName=java3_servlet_jsp;encrypt=false";
	static String username = "sa";
	static String password = "ndyudev227";
	
	static {
		try { // nạp driver
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/**Mở kết nối*/
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dburl, username, password);
	}
	/**Thao tác dữ liệu*/
	public static int executeUpdate(String sql, Object... values) throws SQLException {
		PreparedStatement stmt = Jdbc.createPreStmt(sql, values);
		return stmt.executeUpdate();
	}
	/**Truy vấn dữ liệu*/
	public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
		PreparedStatement stmt = Jdbc.createPreStmt(sql, values);
		return stmt.executeQuery();
	}
	/**Tạo PreparedStatement làm việc với SQL hoặc PROC*/
	private static PreparedStatement createPreStmt(String sql, Object... values) throws SQLException {
		Connection connection = Jdbc.getConnection();
		PreparedStatement stmt = null;
		if(sql.trim().startsWith("{")) {
			stmt = connection.prepareCall(sql);
		} 
		stmt = connection.prepareStatement(sql);
		for (int i = 0; i < values.length; i++) {
			stmt.setObject(i + 1, values[i]);
		}
		return stmt;
	}
	public static void main(String[] args) {
		try {
			Connection conn = Jdbc.getConnection();
			System.out.println("connect ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
