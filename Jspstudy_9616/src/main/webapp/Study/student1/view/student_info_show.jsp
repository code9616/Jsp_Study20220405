<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "student.Student" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%

	Student student = (Student)request.getAttribute("student");
	
	
%>
<body>

<h1>학생정보 출력</h1>
	
		<div>
			<label>학교명 : </label>
			<input type="text"  name="schoolName"  value="<%=student.getSchoolName() %>">
		</div>
		<div>
			<label>학생이름 : </label>
			<input type="text"  name="name" value="<%=student.getName() %>">
		</div>
		<div>
			<label>학년 : </label>
			<input type="text"  name="studentYear" value="<%=student.getStudentYear() %>">
		</div>
		<div>
			<label>학과 : </label>
			<input type="text"  name="department" value="<%=student.getDepartment() %>">
		</div>
		<div>
			<label>학점 : </label>
			<span><%=student.getGrade() %></span>
		</div>
</body>
</html>