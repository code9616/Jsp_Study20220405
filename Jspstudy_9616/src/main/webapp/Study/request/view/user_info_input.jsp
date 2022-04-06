<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Jspstudy_9616/Study/request/controller/user_info_controller.jsp" method="get">
	<div>
		<label>사용자아이디 : </label>
		<input type = "text" name="username">
	</div>
	<div>
		<label>연락처 : </label>
		<input type = "text" name="phone">
	</div>
	<div>
		<label>이메일 : </label>
		<input type = "text" name="email">
	</div>
	<div>
		<label>주소 : </label>
		<input type = "text" name="address">
	</div>
		<input type="checkbox" name="select" value="off">취업<br>
		<input type="checkbox" name="select" value="off">공부<br>
		<input type="checkbox" name="select" value="off">취미<br>
	<button type="submit">전송</button>
	</form>
</body>
</html>