package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 응답 인코딩 설정
		res.setCharacterEncoding("UTF-8");
		// 문서 설정
		res.setContentType("text/html; charset=UTF-8");
		
		
		int x = 0;
		int y = 0;
		
		String[] num_ = req.getParameterValues("num");
		
		int result = 0;
		
		for(int i=0; i<num_.length; i++) {
			int num = Integer.parseInt(num_[i]);
			result+=num;
		}	
		res.getWriter().printf("result is %d\n", result);
	}
}
