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
		// ��ȡ������Ϣ
		return super.getServletConfig();
	}

	@Override
	public String getServletInfo() {
		//��ȡ���ߣ�copyright,�汾����Ϣ
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
