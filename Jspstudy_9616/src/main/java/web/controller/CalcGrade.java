package web.controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/calc-grade") //무조건 대문자, _ 쓰지말고 -써야함
public class CalcGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset = UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		PrintWriter out = response.getWriter();
		
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
		
	}

}
