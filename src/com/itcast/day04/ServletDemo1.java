package com.itcast.day04;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPOutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo1 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		test01(resp);
//		test02(resp);
		test03(resp);
	}

	private void test03(HttpServletResponse resp) throws IOException {
		/*
		 * 设置输出格式
		 */
//		resp.setHeader("Content-Type", "text/html");
		resp.setHeader("Content-Type", "image/jpeg");
		/*
		 * 设置以下载方式打开文件
		 */
		resp.setHeader("content-disposition", "attachment;filename=jordan.jpg");
		InputStream in=this.getServletContext().getResourceAsStream("/jordan.jpg");
		byte[] bs=new byte[1024];
		int len=0;
		OutputStream out=resp.getOutputStream();
		while ((len=in.read(bs))!=-1) {
			out.write(bs);
		}
	}

	private void test02(HttpServletResponse resp) throws IOException {
		String data="aaaaaaaaaaaaaaaaa";
		System.out.println("原始数据大小:"+data.getBytes().length);
		
		/*
		 * 数据压缩
		 */
		ByteArrayOutputStream bout=new ByteArrayOutputStream();
		GZIPOutputStream gout=new GZIPOutputStream(bout);
		gout.write(data.getBytes());
		gout.close();
		
		byte[] gzip=bout.toByteArray();
		System.out.println("压缩后数据大小:"+gzip.length);
		/*
		 * 设置数据压缩格式
		 */
		resp.setHeader("Content-Encoding", "gzip");
		
		/*
		 * 设置数据长度
		 */
		resp.setHeader("Content-Length", gzip.length+"");
		/*
		 * 设置数据刷新时间，单位为秒
		 */
		resp.setHeader("refresh", "3;url='http://www.baidu.com'");
		resp.getOutputStream().write(gzip);
	}

	private void test01(HttpServletResponse resp) {
		/*
		 * 利用location实现重定向
		 */
		resp.setStatus(302);
		resp.setHeader("location", "/day04/index.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
	
}
