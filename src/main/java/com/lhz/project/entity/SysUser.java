package com.lhz.project.entity;

public class SysUser {

		
		   //   Id
			private Integer id;
		
		   //   员工编号
			private String userNo;
		
		   //   用户密码
			private String password;
		
		   //   Name
			private String name;
		
		   //   部门
			private Integer departmentId;
		
		   //   CreateTime
			private String createTime;
		
		   //   UpdateTime
			private String updateTime;
		
		   //   备注
			private String remark;
			
			private String verificationCode;
			
			/**
			 * 离职状态（1在职 2离职）
			 */
			private String leaveOffice;
			
			private String departmentName;
			
			
			
			private Integer roleId;

			private String roleName;
    
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
		     * 获取: 员工编号
		     */
		    public String getUserNo() {
			return userNo;
		    }
		     /**
		     * 设置: 员工编号
		     * 
		     */
		    public void setUserNo(String userNo) {
			this.userNo = userNo;
		    }
		     /**
		     * 获取: 用户密码
		     */
		    public String getPassword() {
			return password;
		    }
		     /**
		     * 设置: 用户密码
		     * 
		     */
		    public void setPassword(String password) {
			this.password = password;
		    }
		     /**
		     * 获取: Name
		     */
		    public String getName() {
			return name;
		    }
		     /**
		     * 设置: Name
		     * 
		     */
		    public void setName(String name) {
			this.name = name;
		    }
		     /**
		     * 获取: 部门
		     */
		    public Integer getDepartmentId() {
			return departmentId;
		    }
		     /**
		     * 设置: 部门
		     * 
		     */
		    public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		    }
		     /**
		     * 获取: CreateTime
		     */
		    public String getCreateTime() {
			return createTime;
		    }
		     /**
		     * 设置: CreateTime
		     * 
		     */
		    public void setCreateTime(String createTime) {
			this.createTime = createTime;
		    }
		     /**
		     * 获取: UpdateTime
		     */
		    public String getUpdateTime() {
			return updateTime;
		    }
		     /**
		     * 设置: UpdateTime
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
			public String getVerificationCode() {
				return verificationCode;
			}
			public void setVerificationCode(String verificationCode) {
				this.verificationCode = verificationCode;
			}
			public String getLeaveOffice() {
				return leaveOffice;
			}
			public void setLeaveOffice(String leaveOffice) {
				this.leaveOffice = leaveOffice;
			}
			public String getDepartmentName() {
				return departmentName;
			}
			public void setDepartmentName(String departmentName) {
				this.departmentName = departmentName;
			}
			public Integer getRoleId() {
				return roleId;
			}
			public void setRoleId(Integer roleId) {
				this.roleId = roleId;
			}
			public String getRoleName() {
				return roleName;
			}
			public void setRoleName(String roleName) {
				this.roleName = roleName;
			}
       
 
       
 
   

}
