<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<style type="text/css">
	#container {
		margin: 0px auto;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
		
		width: 500px;
		height: 300px;
	}
</style>
</head>
<body>
	<div id="container">
		<div>
			<h1>회원가입</h1>
		</div>
		<form action="/Jspstudy_9616/signup" method="post">
			<div>
				<div class="item-input">
					<label class="item-label">이메일</label>
					<input type="text" name="email">
				</div>
				<div class="item-input">
					<label class="item-label">이름</label>
					<input type="text" name="name">
				</div>
				<div class="item-input">
					<label class="item-label">사용자이름</label>
					<input type="text" name="username">
				</div>
				<div class="item-input">
					<label class="item-label">비밀번호</label>
					<input type="password" name="password">
				</div>
			</div>
			<button type="button" class="signup-button">회원가입</button>
		</form>
	</div>
	
	<script type="text/javascript" src="/Jspstudy_9616/static/js/signup.js"></script>
	
</body>
</html>
