<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>학점계산기</h1>
	<button type="button" class="subject-plus">과목 추가</button>
	<form action="/Jspstudy_9616/calc-grade" method="get">
		<div>
			<table>
				<thead>
					<tr>
						<th>과목</th>
						<th>점수</th>
						<th>학점</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" name="subject"></td>
						<td>
							<select name="grade">
								<option value="A+">A+</option>
								<option value="A">A</option>
								<option value="B+">B+</option>
								<option value="B">B</option>
								<option value="C+">C+</option>
								<option value="C">C</option>
								<option value="D+">D+</option>
								<option value="D">D</option>
								<option value="F">F</option>
							</select>						
						</td>
						<td><input type="text" name="time"></td>
					</tr>
				</tbody>
			</table>
		</div>
		<button>계산</button>
	</form>
	<script type="text/javascript" src="/Jspstudy_9616/Study/grade/view/js/grade.js"></script>
</body>
</html>