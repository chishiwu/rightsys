package com.dfrz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		System.out.println("doFilter login.............");
		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession();
		String Path=req.getRequestURI();
		
		HttpServletResponse res=(HttpServletResponse)response;
	
		String login_user=(String)session.getAttribute("login_user");
		
		if(Path.indexOf("login.jsp")>-1||Path.indexOf("LoginServlet")>-1){
			chain.doFilter(request, response);
		}else{
			if(login_user==null||login_user.equals("")){
				res.sendRedirect("login.jsp");
				return;
			}
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("begin loginFilter");
		
	}

}
