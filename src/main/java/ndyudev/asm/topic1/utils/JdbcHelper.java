package ndyudev.asm.topic1.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {
	static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	static String dburl = "jdbc:sqlserver://localhost;databaseName=PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Topic1;encrypt=false";
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
		PreparedStatement stmt = JdbcHelper.createPreStmt(sql, values);
		return stmt.executeUpdate();
	}
	/**Truy vấn dữ liệu*/
	public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
		PreparedStatement stmt = JdbcHelper.createPreStmt(sql, values);
		return stmt.executeQuery();
	}
	/**Tạo PreparedStatement làm việc với SQL hoặc PROC*/
	private static PreparedStatement createPreStmt(String sql, Object... values) throws SQLException {
		Connection connection = JdbcHelper.getConnection();
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
			Connection conn = JdbcHelper.getConnection();
			System.out.println("connect ");
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}
