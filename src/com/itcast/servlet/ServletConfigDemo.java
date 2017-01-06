package com.itcast.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletConfigDemo extends HttpServlet{
	//private ServletConfig config;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		String value=config.getInitParameter("data");
		
		/*
		 * 得到指定的
		 */
		String value=this.getServletConfig().getInitParameter("data");
		
		/*
		 * 得到所有的
		 */
		Enumeration<String> enumeration =this.getServletConfig().getInitParameterNames();
		while (enumeration.hasMoreElements()) {
			String name=enumeration.nextElement();
			String value1=this.getServletConfig().getInitParameter(name);
			System.out.println(value1);
		}
		System.out.println(value);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		this.config=config;
//	}
	
}
