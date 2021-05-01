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

		// application �����
		// ServletContext
		ServletContext application = req.getServletContext();
		
		// session 
		HttpSession session = req.getSession();
		
		// 3.
		// Cookie
		Cookie[] cookies = req.getCookies();
		
		// ���� ���ڵ� ����
		res.setCharacterEncoding("UTF-8");
		// ���� ����
		res.setContentType("text/html; charset=UTF-8");
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		
		int v = 0;
		if(!v_.equals("")) {
			v = Integer.parseInt(v_);
		}
		
		// ���
		if(op.equals("=")) {
			// application ����
//			int x = (Integer)application.getAttribute("value");
			
			// session���� ����
//			int x = (Integer)session.getAttribute("value");
//			int y = v;
			
			// application ����
//			String operator = (String)application.getAttribute("op");;
			
			// session���� ����
//			String operator = (String)session.getAttribute("op");;
			
			// 4.
			// Cookie���� �� ������
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
		}else { // ���� ����
//			application.setAttribute("value", v);
//			application.setAttribute("op", op);
//			session.setAttribute("value", v);
//			session.setAttribute("op", op);
			
			// 1.
			// cookie
			// �ݵ�� �������̾����.
			Cookie valueCookie = new Cookie("value", String.valueOf(v));
			Cookie opCookie = new Cookie("op", op);
			
			// 1-1
			// ��Ű ��������� ����
			// / -> ��� ������
			// /notice/ -> notice�� ���Ե� ���� ������
			valueCookie.setPath("/calc2");
			opCookie.setPath("/calc2");
			
			// 2-2
			// ��Ű�� ����ڿ��� �������� �ð�
			// setMaxAge
			valueCookie.setMaxAge(60*60);
			opCookie.setMaxAge(60*60);
			
			
			// 2.
			// Ŭ���̾�Ʈ���� ������ ��.
			// ��������� �ɾ����� �ȴ�.
			res.addCookie(valueCookie);
			res.addCookie(opCookie);
		}
		
	}
}
