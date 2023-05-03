package com.lhz.project.entity;

public class SysRole {

		
		   //   主键
			private Integer id;
		
		   //   角色名称
			private String roleName;

			//角色编码
			private String roleCode;
		   //   创建时间
			private String createTime;
		
		   //   修改时间
			private String updateTime;
		
		   //   备注
			private String remark;


	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}
		     /**
		     * 获取: 主键
		     */
		    public Integer getId() {
			return id;
		    }
		     /**
		     * 设置: 主键
		     * 
		     */
		    public void setId(Integer id) {
			this.id = id;
		    }
		     /**
		     * 获取: 角色名称
		     */
		    public String getRoleName() {
			return roleName;
		    }
		     /**
		     * 设置: 角色名称
		     * 
		     */
		    public void setRoleName(String roleName) {
			this.roleName = roleName;
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
		     /**
		     * 获取: 修改时间
		     */
		    public String getUpdateTime() {
			return updateTime;
		    }
		     /**
		     * 设置: 修改时间
		     * 
		     */
		    public void setUpdateTime(String updateTime) {
			this.updateTime = updateTime;
		    }
		     /**
		     * 获取: 备注
		     */
		    public String getRemark() {
			return remark;
		    }
		     /**
		     * 设置: 备注
		     * 
		     */
		    public void setRemark(String remark) {
			this.remark = remark;
		    }
       
 
       
 
   

}
