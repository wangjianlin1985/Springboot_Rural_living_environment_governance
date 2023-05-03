/*
 * StringUtil.java
 * 版权所有：江苏电力信息技术有限公司 2007 - 2012
 * 江苏电力信息技术有限公司保留所有权利，未经允许不得以任何形式使用。
 */
package com.lhz.atom.util;

import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.NumberFormat;

/**
 * 将原有Utils中的String相关方法移入本类
 * @author Administrator
 *
 */
public class StringUtil {
	
	
	/**
	 * 0x4e00
	 */
	private static final int INT0X4E00 = 0x4e00;
	/**
	 * 0x9fa5
	 */
	private static final int INT0X9FA5 = 0x9fa5;
	/**
	 * 0xf900
	 */
	private static final int INT0XF900 = 0xf900;
	/**
	 * 0xfa2d
	 */
	private static final int INT0XFA2D = 0xfa2d;
	
	/**
	 * 判断一个字符串是否有值，空格也不算有值
	 * @author Fu Qiming
	 * @param str
	 * @return
	 */
	public static boolean availableStr(String str){
		return (str!=null && !"".equals(str) && !"null".equals(str));
	}
	
	/**
     * 截取子字符串
     *
     * @param str 需要截取的字符串
     * @param len 截取的位数
     * @return String 返回的子字符串
     */
    public static String getSubString(String str, int len) {
        if (isEmpty(str)) {
            return "";
        }

        if (0 >= len) {
            return str;
        }

        final int byteLength = getByteLength(str);

        if (byteLength < len) {
            return str;
        }

        StringBuffer sb = new StringBuffer(str);
        sb.setLength(len);

        while (getByteLength(sb.toString()) > len) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * 得到字节长度
     *
     * @param str 需要得到长度的字符串
     * @return 返回字节的长度
     */
    public static int getByteLength(String str) {
        int len = 0;

        if (isEmpty(str)) {
            return len;
        }

        try {
			len = str.getBytes("UTF-8").length;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}

        return len;
    }
    
    /**
     * 判断字符串是否为空
     * @param str 字符串
     * @return true：空 false：非空
     */
    public static boolean isEmpty(String str) {

        if (null == str || 0 == str.length()||"null".equals(str)||"".equals(str)) {
            return true;
        }

        return false;
    }
    
	static String ipAddress;

    // Fortify 安全检测修改
//	/**
//	 * 获得本机IP
//	 * @return
//	 * @throws UnknownHostException
//	 */
//	public final static String getIpAddress(){
//		if (ipAddress==null){
//			try {
//				ipAddress=InetAddress.getLocalHost().getHostAddress();
//			} catch (UnknownHostException e) {
//				throw new RuntimeException(e);
//			}
//		}
//		return ipAddress;
//	}


	/**
	 * 把字符串中的双引号和反斜杠替换为画面能够识别的字符串
	 * @param inStr
	 * @return outStr
	 */
	public static String escapeSpecialChar(String inStr){
		if (null == inStr || "null".equals(inStr) || "".equals(inStr)) {
			return "";
		}

		String outStr = "";
		
		//替换双引号
		String srcStr1 = "\"";	
		String destStr1 = "\\\\\"";  

		
		//替换反斜杠
		String srcStr2 = "\\\\";
		String destStr2 = "\\\\\\\\";
		
		outStr = inStr.replaceAll(srcStr2, destStr2);
		outStr = outStr.replaceAll(srcStr1, destStr1);
		
		return outStr;
		
	}
	
	/**
	 * 将String中的xml格式的Excel的关键字转义
	 * @param str
	 * @return
	 */
	public static String encodeExcelXmlStr(String str){
		if(isEmpty(str)){
			return str;
		}
		return str.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(">", "&gt;").replaceAll("\"","&quot;" ).replaceAll("\r\n","&#10;").replaceAll("\n","&#10;");
	}
	
	
	/**
	 *将数字格式化成为货币格式输出 
	 * @param number	输入数字
	 * @return	货币格式
	 */
	public static String formatCurrency(double number){
		NumberFormat formater = NumberFormat.getCurrencyInstance();		
		return formater.format(number);
	}
	

	public static String escapeFormat(String sql) {
		return sql.replaceAll("_", "/_").replaceAll("%", "/%");
	}

	/**
	 * 判断字符是否为汉字（汉字标点不为汉字字符）
	 * @param oneChar 
	 * @return boolean
	 */
	public static boolean isChineseWithoutPunctuation(char oneChar){
		if((oneChar >= INT0X4E00 && oneChar <= INT0X9FA5)
		 ||(oneChar >= INT0XF900 && oneChar <=INT0XFA2D)){
			return true;
		}
		return false;
	}

}
