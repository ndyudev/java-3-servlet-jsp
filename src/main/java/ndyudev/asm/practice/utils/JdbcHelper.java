package ndyudev.asm.practice.utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {

    private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBURL = 
        "jdbc:sqlserver://localhost:1433;"
      + "databaseName=PS44284_ChauNhatDuy_SOF203_Java3_Servlet_Practice_ASM;"
      + "encrypt=false;"
      + "trustServerCertificate=true;"
      + "useUnicode=true;"
      + "characterEncoding=UTF-8;";

    private static final String USERNAME = "sa";
    private static final String PASSWORD = "ndyudev227";

    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy driver SQL Server!", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
    }

    public static int executeUpdate(String sql, Object... values) throws SQLException {
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            setParameters(stmt, values);
            return stmt.executeUpdate();
        }
    }

    public static ResultSet executeQuery(String sql, Object... values) throws SQLException {
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        setParameters(stmt, values);
        return stmt.executeQuery();
    }

    public static ResultSet executeCallQuery(String sql, Object... values) throws SQLException {
        Connection conn = getConnection();
        CallableStatement stmt = conn.prepareCall(sql);
        setParameters(stmt, values);
        return stmt.executeQuery();
    }

    private static void setParameters(PreparedStatement stmt, Object... values) throws SQLException {
        if (values != null) {
            for (int i = 0; i < values.length; i++) {
                stmt.setObject(i + 1, values[i]);
            }
        }
    }
}