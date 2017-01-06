package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class FirstServlet extends GenericServlet{

	@Override
	public void destroy() {
		System.out.println("destory");
	}

	@Override
	public ServletConfig getServletConfig() {
		// 获取启动信息
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		//获取作者，copyright,版本等信息
		return super.getServletInfo();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("init");
	}

	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		response.getOutputStream().write("hello servlet".getBytes());
	}

	
}
