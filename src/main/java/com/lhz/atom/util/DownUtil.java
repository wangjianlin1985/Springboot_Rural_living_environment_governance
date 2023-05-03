/*
 * IOUtil.java
 * 版权所有：江苏电力信息技术有限公司 2007 - 2012
 * 江苏电力信息技术有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.lhz.atom.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lhz.config.ApplicationConfig;

/**
 * 将原来Utils中IO相关方法移入本类
 * @author Administrator
 *
 */
public class DownUtil {
	
	/**
	 * 文件下载根目录
	 */
	private static String profiles = "D:/profiles";




	
	/**
	 * 文件下载
	 * @param is 文件输入流
	 * @param response Http的响应
	 * @param fileName 文件名
	 */
	public static void downLoadFileByPath(HttpServletResponse response,String downFilePath,String fileName){
	/*	setResponse(response,fileName);*/
		String filePath=profiles+File.separator+downFilePath;
		InputStream is = null;
		OutputStream toCilent=null;
		try {
			File file = new File(filePath);
			if(file.exists()){
				is=new FileInputStream(file);
				byte[] buffer = new byte[is.available()];
				is.read(buffer);
				is.close();
				//清空response
				response.reset();
				//设置response头文件
				String fileNameString= new String(fileName.getBytes("gbk"),"iso-8859-1");
				response.addHeader("Content-Disposition", "attachment;filename="+fileNameString);
				response.addHeader("Content-Length", ""+file.length());
				toCilent = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				toCilent.write(buffer);
				toCilent.flush();
				/*inputStreamMoveOutputStream(is, response.getOutputStream());*/
			}else{
				System.out.println("下载文件不存在&&&");
			}
			
		} catch (IOException e) {
			throw new RuntimeException(e);
		}finally {
			
				try {
					if(is!=null){
						is.close();
					}
					if(toCilent!=null){
						toCilent.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
	}
public static void down(HttpServletRequest request ,HttpServletResponse response,String path){
		
		System.out.println(path+"__________");
		File files = null;
		String filenames = null;
		try {
				// path是指欲下载的文件的路径。
			files = new File(path);
				// 取得文件名。
				filenames = files.getName();
				// 取得文件的后缀名。
				String ext = filenames.substring(filenames.lastIndexOf(".") + 1).toUpperCase();
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(path));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				//清空response
				response.reset();
				//设置response的Header
				String filenameString = new String(filenames.getBytes("gbk"),"iso-8859-1");
				response.addHeader("Content-Disposition", "attachment;filename=" + filenameString);
				response.addHeader("Content-Length", "" + files.length());
				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				  if (files!=null && files.isFile()) {
		               files.delete();
		               System.out.println(path+"__文件删除成功");
				  }
			}
	}
/**
 * 
 * @param request
 * @param response
 * @param path     文件路径
 * @param filenames   文件名称
 * @param flag   是否删除
 */
public static void down(HttpServletRequest request ,HttpServletResponse response,String path ,String filenames,boolean flag){
		
		System.out.println(path+"__________");
		File files = null;
		try {
				// path是指欲下载的文件的路径。
				files = new File(path);
				// 取得文件名。
				//String filenames = files.getName();
				// 取得文件的后缀名。
			//	String ext = filenames.substring(filenames.lastIndexOf(".") + 1).toUpperCase();
				// 以流的形式下载文件。
				InputStream fis = new BufferedInputStream(new FileInputStream(path));
				byte[] buffer = new byte[fis.available()];
				fis.read(buffer);
				fis.close();
				//清空response
				response.reset();
				//设置response的Header
				String filenameString = new String(filenames.getBytes("gbk"),"iso-8859-1");
				response.addHeader("Content-Disposition", "attachment;filename=" + filenameString);
				response.addHeader("Content-Length", "" + files.length());
				OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
				response.setContentType("application/octet-stream");
				toClient.write(buffer);
				toClient.flush();
				toClient.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}finally {
				  if (files!=null && files.isFile()) {
					  if(flag) {
						  files.delete();
			               System.out.println(path+"____文件删除成功");  
					  }
		             
				  }
			}
	}
}
