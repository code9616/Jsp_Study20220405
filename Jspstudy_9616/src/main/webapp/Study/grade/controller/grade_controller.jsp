<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String[] subjects = request.getParameterValues("subject");
	String[] grade = request.getParameterValues("grade");
	String[] time = request.getParameterValues("time");

	double score = 0;
	int totalTime = 0;
	double gradeAvg = 0;
	for(int i = 0; i < subjects.length; i++){
		totalTime += Integer.parseInt(time[i]);
	
		if(grade[i].equals("A+")){
			score += (4.5 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("A")){
			score += (4 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("B+")){
			score += (3.5 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("B")){
			score += (3.0 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("C+")){
			score += (2.5 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("C")){
			score += (2.0 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("D+")){
			score += (1.5 * Integer.parseInt(time[i]));
		}else if(grade[i].equals("D")){
			score += (1.0 * Integer.parseInt(time[i]));
		}else{
			score += 0;
		}
	}
	
	gradeAvg = score / totalTime;

	System.out.println(gradeAvg);
	
	StringBuilder builder = new StringBuilder(); //문자열을 만듬
	builder.append("<body>");
	builder.append("<script>");
	builder.append("alert(\"총 평점 : " + gradeAvg + "\");");
	builder.append("history.back();");
	builder.append("</script>");
	builder.append("</body>");
	
	
	System.out.println(builder.toString());
	out.write(builder.toString());
	
	
%>
