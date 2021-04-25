package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class Add extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// 응답 인코딩 설정
		res.setCharacterEncoding("UTF-8");
		// 문서 설정
		res.setContentType("text/html; charset=UTF-8");
		
		
		int x = 0;
		int y = 0;
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		
		if(!x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if(!y_.equals("")) {
			y = Integer.parseInt(y_);
		}
		
		int result = x+y;
		
		res.getWriter().printf("result is %d\n", result);
	}
}
