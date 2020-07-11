<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報-変更確認</title>
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
	%>
	従業員情報を以下の内容に変更します。よろしいですか？<br>
	<jsp:useBean id="employee" scope="session" class="model.entity.EmployeeBean" />

	<jsp:setProperty property="name" name="employee" param="name" />
	<jsp:setProperty property="age" name="employee" param="age" />
	<jsp:setProperty property="section" name="employee" param="section" />

	コード：<jsp:getProperty property="code" name="employee" /><br>
	氏名：<jsp:getProperty property="name" name="employee" /><br>
	年齢：<jsp:getProperty property="age" name="employee" /><br>
	部署：<jsp:getProperty property="section" name="employee" /><br>

	<form action="employee-alter-servlet" method="POST">
		<input type="submit" value="変更する">
	</form>

	<form action="employee-alter-form.jsp" method="POST">
		<input type="submit" value="変更フォームに戻る">
	</form>

</body>
</html>