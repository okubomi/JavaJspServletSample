/*
 * WebApp_05_sp03_UseBean
 * model.dao.EmployeeDAO.java
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeBean;

/**
 * m_employeeテーブルのDAOです。
 * @author emBex Education
 */
public class EmployeeDAO {
	/**
	 * すべての従業員のリストを返します。
	 * @return 従業員のリスト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public List<EmployeeBean> selectAll()
			throws SQLException, ClassNotFoundException {

		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();

		// データベースへの接続の取得、Statementの取得、SQLステートメントの実行
		try (Connection con = ConnectionManager.getConnection();
				Statement stmt = con.createStatement();
				ResultSet res = stmt.executeQuery("SELECT * FROM m_employee")) {

			// 結果の操作
			while (res.next()) {
				String code = res.getString("code");
				String name = res.getString("name");
				int age = res.getInt("age");
				String section = res.getString("section");

				EmployeeBean employee = new EmployeeBean();
				employee.setCode(code);
				employee.setName(name);
				employee.setAge(age);
				employee.setSection(section);

				employeeList.add(employee);
			}
		}
		return employeeList;
	}

	/**
	 * 引数で指定したコードの従業員オブジェクトを返します。
	 * @return 従業員オブジェクト
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public EmployeeBean select(String code)
			throws SQLException, ClassNotFoundException {

		EmployeeBean employee = new EmployeeBean();

		String sql = "SELECT * FROM m_employee WHERE code = ?";
		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			// プレースホルダへの値の設定
			pstmt.setString(1, code);

			// SQLステートメントの実行
			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			while (res.next()) {
				employee.setCode(res.getString("code"));
				employee.setName(res.getString("name"));
				employee.setAge(res.getInt("age"));
				employee.setSection(res.getString("section"));
			}
		}
		return employee;
	}

	/**
	 * 指定された内容の従業員情報を更新します。
	 * @param employee 従業員オブジェクト
	 * @return 処理件数
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public int update(EmployeeBean employee) throws SQLException, ClassNotFoundException {
		int processingNumber = 0; //処理件数

		String sql = "UPDATE m_employee SET name = ?, age = ?, section = ? WHERE code = ?";

		// データベースへの接続の取得、PreparedStatementの取得
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// DTOからのデータの取り出し
			String code = employee.getCode();
			String name = employee.getName();
			int age = employee.getAge();
			String section = employee.getSection();

			// プレースホルダへの値の設定
			pstmt.setString(1, name);
			pstmt.setInt(2, age);
			pstmt.setString(3, section);
			pstmt.setString(4, code);

			// SQLステートメントの実行
			processingNumber = pstmt.executeUpdate();
		}
		return processingNumber;
	}
}