<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "user.User" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	String username = request.getParameter("username");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	String address = request.getParameter("address");
	String[] select = request.getParameterValues("select");
	
	System.out.println(select.length);
	
	for(String str : select){
		System.out.println(str);
	}
	int data = (Integer)request.getAttribute("data");
	System.out.println(data);
	
	User user = (User)request.getAttribute("user");
%>
<body>
	사용자아이디 : <%=user.getUsername() %> <br>
	연락처 : <%=user.getPhone() %> <br>
	이메일 : <%=user.getEmail() %> <br>
	주소 : <%=user.getAddress() %>
</body>
</html>