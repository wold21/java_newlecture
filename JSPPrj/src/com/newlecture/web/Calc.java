package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		// ÀÀ´ä ÀÎÄÚµù ¼³Á¤
		res.setCharacterEncoding("UTF-8");
		// ¹®¼­ ¼³Á¤
		res.setContentType("text/html; charset=UTF-8");
		
		
		int x = 0;
		int y = 0;
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String oper = req.getParameter("operator");
		
		if(!x_.equals("")) {
			x = Integer.parseInt(x_);
		}
		if(!y_.equals("")) {
			y = Integer.parseInt(y_);
		}
		
		int result = 0;
		if(oper.equals("µ¡¼À")) {
			result = x + y;
		}else if(oper.equals("»¬¼À")){
			result = x - y;
		}
		
		res.getWriter().printf("result is %d\n", result);
	}
}
