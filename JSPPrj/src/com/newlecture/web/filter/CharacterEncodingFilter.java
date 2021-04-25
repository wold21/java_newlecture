package com.newlecture.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class CharacterEncodingFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void doFilter(ServletRequest req
			, ServletResponse res
			, FilterChain chain)
			throws IOException, ServletException {

		
		System.out.println("before filter");
		
		req.setCharacterEncoding("UTF-8");
		// ��û�� ���� �帧�� ���� ���ͷ� �Ѱܼ� res�� �Ѵ�. 
		// �帧�� �����Ѵٰ� �����ϸ��.
		chain.doFilter(req, res);
		
		System.out.println("after filter");
	}

}
