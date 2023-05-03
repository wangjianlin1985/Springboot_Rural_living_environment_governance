package com.lhz.project.entity;

public class SysDictData {

		
		   //   id
			private Integer id;
		
		   //    父ID 
			private Integer pid;
		
		   //    数据类别
			private String dataType;
		
		   //   字典名称key
			private String dataName;
		
		   //    数据名称/值 value
			private String dataValue;
		
		   //    顺序 
			private Integer sortNo;
		
		   //   0正常
			private Boolean status;
		
		   //   数据描述
			private String dataDesc;
		
		   //   创建时间 
			private String createTime;

			//用于判断pid ！= 0 的查询
			private String nopid;


	/**
	 * 获取: id
	 */
	public String getNopid() {
		return nopid;
	}
	/**
	 * 设置: id
	 *
	 */
	public void setNopid(String nopid) {
		this.nopid = nopid;
	}
		     /**
		     * 获取: id
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: id
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取:  父ID 
		     */
		    public Integer getPid() {
			return pid;
		    }
		     /**
		     * 设置:  父ID 
		     * 
		     */
		    public void setPid(Integer pid) {
			this.pid = pid;
		    }
		     /**
		     * 获取:  数据类别
		     */
		    public String getDataType() {
			return dataType;
		    }
		     /**
		     * 设置:  数据类别
		     *  数据类别,首字母大写 
		     */
		    public void setDataType(String dataType) {
			this.dataType = dataType;
		    }
		     /**
		     * 获取: 字典名称key
		     */
		    public String getDataName() {
			return dataName;
		    }
		     /**
		     * 设置: 字典名称key
		     * 
		     */
		    public void setDataName(String dataName) {
			this.dataName = dataName;
		    }
		     /**
		     * 获取:  数据名称/值 value
		     */
		    public String getDataValue() {
			return dataValue;
		    }
		     /**
		     * 设置:  数据名称/值 value
		     * 
		     */
		    public void setDataValue(String dataValue) {
			this.dataValue = dataValue;
		    }
		     /**
		     * 获取:  顺序 
		     */
		    public Integer getSortNo() {
			return sortNo;
		    }
		     /**
		     * 设置:  顺序 
		     * 
		     */
		    public void setSortNo(Integer sortNo) {
			this.sortNo = sortNo;
		    }
		     /**
		     * 获取: 0正常
		     */
		    public Boolean getStatus() {
			return status;
		    }
		     /**
		     * 设置: 0正常
		     * 0正常,1删除
		     */
		    public void setStatus(Boolean status) {
			this.status = status;
		    }
		     /**
		     * 获取: 数据描述
		     */
		    public String getDataDesc() {
			return dataDesc;
		    }
		     /**
		     * 设置: 数据描述
		     * 
		     */
		    public void setDataDesc(String dataDesc) {
			this.dataDesc = dataDesc;
		    }
		     /**
		     * 获取: 创建时间 
		     */
		    public String getCreateTime() {
			return createTime;
		    }
		     /**
		     * 设置: 创建时间 
		     * 
		     */
		    public void setCreateTime(String createTime) {
			this.createTime = createTime;
		    }


	@Override
	public String toString() {
		return "SysDictData{" +
				"id=" + id +
				", pid=" + pid +
				", dataType='" + dataType + '\'' +
				", dataName='" + dataName + '\'' +
				", dataValue='" + dataValue + '\'' +
				", sortNo=" + sortNo +
				", status=" + status +
				", dataDesc='" + dataDesc + '\'' +
				", createTime='" + createTime + '\'' +
				'}';
	}
}
