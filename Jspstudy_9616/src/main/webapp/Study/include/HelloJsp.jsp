<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> <%-- 이게 꼭 있어야 JSP 파일 --%>

<%!
	private String name = "김지훈";
	private String phone = "010-1234-1234";
	private	String email = "qwerty12@gmail.comm";
	
	public void show(){
		System.out.println(name);
		System.out.println(phone);
		System.out.println(email);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		for(int i = 0; i < 5; i++){
			this.show();
	%>
	
		<p><%=this.name %></p> <%-- 표현식 tag만 --%>
	
	<%
		}
	%>
	<h1>hello JSP</h1>
</body>
</html>

<%--
page 지시자 속성 및 기본값
language 
contentType
import
session
pageEncoding
--%>