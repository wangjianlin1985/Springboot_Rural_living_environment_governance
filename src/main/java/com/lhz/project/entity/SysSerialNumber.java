package com.lhz.project.entity;

public class SysSerialNumber {

		
		   //   Id
			private Integer id;
		
		   //   编号类型(1:入库  2：销售)
			private String serialType;
		
		   //   编号开头
			private String code;
		
		   //   编号中间
			private String median;
		
		   //   编号自增长
			private String num;
	private String serialNo;

	/**
	 * 获取: Id
	 */
	public String getSerialNo() {
		return serialNo;
	}
	/**
	 * 设置: Id
	 *
	 */
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
		     /**
		     * 获取: Id
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: Id
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取: 编号类型(1:入库  2：销售)
		     */
		    public String getSerialType() {
			return serialType;
		    }
		     /**
		     * 设置: 编号类型(1:入库  2：销售)
		     * 
		     */
		    public void setSerialType(String serialType) {
			this.serialType = serialType;
		    }
		     /**
		     * 获取: 编号开头
		     */
		    public String getCode() {
			return code;
		    }
		     /**
		     * 设置: 编号开头
		     * 
		     */
		    public void setCode(String code) {
			this.code = code;
		    }
		     /**
		     * 获取: 编号中间
		     */
		    public String getMedian() {
			return median;
		    }
		     /**
		     * 设置: 编号中间
		     * 
		     */
		    public void setMedian(String median) {
			this.median = median;
		    }
		     /**
		     * 获取: 编号自增长
		     */
		    public String getNum() {
			return num;
		    }
		     /**
		     * 设置: 编号自增长
		     * 
		     */
		    public void setNum(String num) {
			this.num = num;
		    }
       
 
       
 
   

}
