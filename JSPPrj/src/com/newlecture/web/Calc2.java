package com.newlecture.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// application 저장소
		// ServletContext
		ServletContext application = req.getServletContext();
		
		// session 
		HttpSession session = req.getSession();
		
		// 3.
		// Cookie
		Cookie[] cookies = req.getCookies();
		
		// 응답 인코딩 설정
		res.setCharacterEncoding("UTF-8");
		// 문서 설정
		res.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		// 계산
		if(op.equals("=")) {
			// application 설정
//			int x = (Integer)application.getAttribute("value");
			
			// session으로 설정
//			int x = (Integer)session.getAttribute("value");
//			int y = v;
			
			// application 설정
//			String operator = (String)application.getAttribute("op");;
			
			// session으로 설정
//			String operator = (String)session.getAttribute("op");;
			
			// 4.
			// Cookie에서 값 꺼내기
			int x = 0;
			int y = v;
			String operator = "";
			for(Cookie c : cookies) {
				if (c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			for(Cookie c : cookies) {
				if (c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			int result = 0;
			
			if(operator.equals("+")) {
				result = x + y;
			}else {
				result = x - y;
			}
			res.getWriter().printf("result is %d\n", result);
		}else { // 값을 저장
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			// 1.
			// cookie
			// 반드시 문자형이어야함.
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			// 1-1
			// 쿠키 페이지경로 설정
			// / -> 모든 페이지
			// /notice/ -> notice가 포함된 하위 페이지
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			
			// 2-2
			// 쿠키가 사용자에게 남아있을 시간
			// setMaxAge
			valueCookie.setMaxAge(60*60);
			opCookie.setMaxAge(60*60);
			
			
			// 2.
			// 클라이언트에게 전달이 됨.
			// 응답헤더에 심어지게 된다.
			res.addCookie(valueCookie);
			res.addCookie(opCookie);
		}
		
	}
}
