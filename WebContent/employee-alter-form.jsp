<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報-変更入力フォーム</title>
</head>
<body>
	<jsp:useBean id="employee" class="model.entity.EmployeeBean" scope="session"/>
	<form action="employee-alter-confirm.jsp" method="post">
		コード：<jsp:getProperty property="code" name="employee" /><br>
		氏名：<input type="text" name="name"
			value="<jsp:getProperty property="name" name="employee" />"><br>
		年齢：<input type="text" name="age"
			value="<jsp:getProperty property="age" name="employee" />"><br>
		部署：<input type="text" name="section"
			value="<jsp:getProperty property="section" name="employee" />"><br>
		<input type="submit" value="変更する">
	</form>

	<form action="employee-detail-servlet" method="POST">
		<input type="hidden" name="code" value="<%=employee.getCode()%>">
		<input type="submit" value="詳細表示画面に戻る">
	</form>

</body>
</html>