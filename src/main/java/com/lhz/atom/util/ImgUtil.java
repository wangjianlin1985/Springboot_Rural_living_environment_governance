package com.lhz.atom.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;

public class ImgUtil {
	/**
	 * 读数据库，获取图片输入流
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public static FileInputStream query_getPhotoImageBlob(String adress) {
		FileInputStream is = null;
		File filePic = new File(adress);
		try {
			is = new FileInputStream(filePic);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return is;

	}


}
