<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/Jspstudy_9616/Study/forward/loginController.jsp" method = "get">
		<div>
			<label>아이디: </label>
			<input type="text" name="username2" value="aaa">
		</div>
		<div>
			<label>비밀번호: </label>
			<input type="password" name="password2" value="bbb">
		</div>
		<input type="hidden" name="login-flag" value="0">
		<button type="submit">로그인</button>
	</form>
</body>
</html>