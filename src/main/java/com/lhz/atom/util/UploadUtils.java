/*
 * FileUtil.java
 * 版权所有：江苏电力信息技术有限公司 2007 - 2012
 * 江苏电力信息技术有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.lhz.atom.util;

import java.io.File;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lhz.atom.domains.AttachmentEntry;

/**
 * 文件IO操作Util<p>
 * 创建日期：2012-7-19<br>
 * 修改历史：<br>
 * 修改日期：<br>
 * 修改作者：<br>
 * 修改内容：<br>
 * @author wuxiang
 * @version 1.0
 */
public class UploadUtils {
	/**
	 * 缺省的拷贝块32k
	 */
	public static final int DEFAULT_BLOCK_SIZE = 1024 * 32;

	/**
	 * 保存文件
	 * @param file
	 * @param fileType
	 * @return
	 */
	public static AttachmentEntry UploadFile(MultipartFile file, String fileType) {
		AttachmentEntry ae = null;
		try {
			ae = new AttachmentEntry();
	        String fileName = file.getOriginalFilename();
	        ae.setFileName(FilenameUtils.getName(fileName));
	        ae.setFileSize(file.getSize());
	        ae.setFileType(FilenameUtils.getExtension(fileName));
		       /* attachmentEntry.setDataId(dataId);*/
		        //文件保存根目录
		    	String profiles = "D:/profiles";
		    	//文件类型的路径
		    	String fileTypePath = profiles+ File.separator+fileType;
		    	//按照日期存放文件
				String yyyyMMddPath = fileType+File.separator+ DateUtil.formatDateTime(new Date(),"yyyyMMdd");
				//文件重新命名
				String yyyyMMddHHmmss = DateUtil.formatDateTime(new Date(),"yyyyMMddHHmmss");
				//判断是否存在根目录文件夹，若不存在，则创建，若存在，则直接保存
				UploadUtils.dirExits(new File(profiles));
				//判断是否存在文件类型文件夹，若不存在，则创建，若存在，则直接保存
				UploadUtils.dirExits(new File(fileTypePath));
				//判断是否存在当日文件夹，若不存在，则创建，若存在，则直接保存
				UploadUtils.dirExits(new File(profiles+ File.separator+yyyyMMddPath));
				//拼凑需要需要转存的路径
				String filePath = profiles+File.separator+yyyyMMddPath+File.separator+yyyyMMddHHmmss+"."+FilenameUtils.getExtension(fileName);
				//存入数据库路径
				String savePath =  yyyyMMddPath+File.separator+yyyyMMddHHmmss+"."+FilenameUtils.getExtension(fileName);
				ae.setFilePath(savePath);
				//上传到服务器，并且返回服务器的路径
				file.transferTo(new File(filePath));
				
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ae;
	}


	/**
	 * 判断文件夹是否存在
	 * @param file
	 */
	public static void dirExits(File file){
		if(file.exists()){
			if(file.isDirectory()){
				System.out.println("dir exists");
			}else{
				System.out.println("the same name file exists ,can not create it..");
			}

		}else{
			System.out.println("dir not exists , create it ...");
			file.mkdir();
		}

	}
	
	
}
