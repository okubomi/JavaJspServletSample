/*
 * WebApp_05_sp03_UseBean
 * servlet.EmployeeDetailServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * 従業員情報の詳細表示を制御する
 * @author emBex Education
 */
@WebServlet("/employee-detail-servlet")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String code = request.getParameter("code");

		// DAOの生成
		EmployeeDAO dao = new EmployeeDAO();

		try {
			EmployeeBean employee = dao.select(code);

			// セッションオブジェクトの取得
			HttpSession session = request.getSession();

			// セッションスコープへの属性の設定
			session.setAttribute("employee", employee);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("employee-detail.jsp");
		rd.forward(request, response);
	}
}