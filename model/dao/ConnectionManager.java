/*
 * WebApp_05_sp03_UseBean
 * model.dao.ConnectionManager.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * コネクションマネージャ
 * @author emBex Education
 */
public class ConnectionManager {

	/**
	 * データベースURL
	 */
	private final static String URL = "jdbc:mysql://localhost:3306/sampledb?useSSL=false";

	/**
	 * ユーザ
	 */
	private final static String USER = "appUser7291";

	/**
	 * パスワード
	 */
	private final static String PASSWORD = "appPass4295";

	/**
	 * データベースへの接続を取得して返します。
	 *
	 * @return コネクション
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Connection getConnection() throws SQLException, ClassNotFoundException {

		// JDBCドライバの読み込み
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection(URL, USER, PASSWORD);

	}
}
