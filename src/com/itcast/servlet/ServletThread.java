package com.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.SingleThreadModel;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletThread extends HttpServlet implements SingleThreadModel{
	int i=0;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		synchronized (this) {
			i++;
			try {
				Thread.sleep(1000*4);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		resp.getOutputStream().write((""+i).getBytes());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}

}
