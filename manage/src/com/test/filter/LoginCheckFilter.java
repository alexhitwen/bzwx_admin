package com.test.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 是否登录过滤器com.nccd.report.odsmonitor.filter.LoginCheckFilter
 * 
 * @author wwh
 * @version 1.0
 * @created 2011-7-29
 */
public class LoginCheckFilter implements Filter {
	// private Logger logger = Logger.getLogger(getClass());

	public LoginCheckFilter() {
		super();
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		if (request.getSession().getAttribute("loginUser") == null) {
			request.getRequestDispatcher("/user/login.jsp").forward(request,
					(HttpServletResponse) arg1);
			return;
		}
		arg2.doFilter(arg0, arg1);
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}
}
