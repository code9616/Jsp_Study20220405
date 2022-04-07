<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "student.Student"%>

<%
	
	Student student = Student.builder()
			.schoolName(request.getParameter("schoolName"))
			.name(request.getParameter("name"))
			.studentYear(request.getParameter("studentYear"))
			.department(request.getParameter("department"))
			.grade(request.getParameter("grade"))
			.build();

	request.setAttribute("student", student);
		
%>

<jsp:forward page="../view/student_info_show.jsp"></jsp:forward>


