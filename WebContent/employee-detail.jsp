<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報-詳細</title>
</head>
<body>
	<jsp:useBean id="employee" scope="session" class="model.entity.EmployeeBean"/>

	コード：<jsp:getProperty name="employee" property="code"/><br>
	氏名：<jsp:getProperty name="employee" property="name"/><br>
	年齢：<jsp:getProperty name="employee" property="age"/><br>
	部署：<jsp:getProperty name="employee" property="section"/><br>

	<form action="employee-alter-form.jsp" method="POST">
		<input type="submit" value="変更する">
	</form>

	<form action="employee-list-servlet" method="POST">
		<input type="submit" value="一覧表示">
	</form>
</body>
</html>