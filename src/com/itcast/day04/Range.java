package com.itcast.day04;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class Range {

	public static void main(String[] args) throws IOException {
		URL url=new URL("http://localhost:8080/day04/a.txt");
		HttpURLConnection connection=(HttpURLConnection) url.openConnection();
		/*
		 * 在请求头中加入Range
		 */
		connection.setRequestProperty("Range", "bytes=5-");
		InputStream inputStream=connection.getInputStream();
		
		byte[] bs=new byte[1024];
		int len=0;
		FileOutputStream outputStream=new FileOutputStream(new File("D:\\1.txt"), true);
		while ((len=inputStream.read(bs))!=-1) {
			outputStream.write(bs, 0, len);	
		}
		outputStream.close();
		inputStream.close();
	}

}
