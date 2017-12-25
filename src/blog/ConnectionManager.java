package blog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	/**
	 * JDBCドライバのクラス名
	 */
	final static String DRIVER = "com.mysql.jdbc.Driver";

	/**
	 * データベースのURL
	 */
	final static String URL = "jdbc:mysql://localhost/mydb";

	/**
	 * データベースのユーザー
	 */
	final static String USER = "root";

	/**
	 * データベースのパスワード
	 */
	final static String PASS = "mysql";

	/**
	 * Connectionを取得
	 */
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			throw new IllegalStateException("fail to classload : " + e.getMessage());
		}
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		return con;
	}
}
