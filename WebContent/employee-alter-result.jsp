<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>従業員情報-変更登録結果</title>
</head>
<body>
	<%
		int processingNumber = (Integer) request.getAttribute("processingNumber");
		if (processingNumber > 0) {
	%>
	次のデータを変更登録しました。<br>
	<%
		} else {
	%>
	次のデータを変更登録できませんでした。<br>
	<%
		}
	%>
	<jsp:useBean id="employee" scope="session" class="model.entity.EmployeeBean" />
	コード：<jsp:getProperty property="code" name="employee" /><br>
	氏名：<jsp:getProperty property="name" name="employee" /><br>
	年齢：<jsp:getProperty property="age" name="employee" /><br>
	部署：<jsp:getProperty property="section" name="employee" /><br>

	<form action="menu.html" method="POST">
		<input type="submit" value="メニュー画面に戻る">
	</form>

	<% session.invalidate(); %>

</body>
</html>