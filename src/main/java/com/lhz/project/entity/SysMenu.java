package com.lhz.project.entity;

public class SysMenu {

		
		   //   主键
			private Integer id;
		
		   //   菜单名称
			private String menuName;
		
		   //   路径
			private String url;
		
		   //   图标
			private String icon;
		
		   //   父id
			private String pid;
		
		   //   菜单类型（菜单，按钮）
			private String type;
		
		   //   排序
			private String orderNum;
		
		   //   创建时间
			private String createTime;
		
		   //   修改时间
			private String updateTime;
		
		   //   备注
			private String remark;

			//父类名称
	private String pName;
	//角色菜单id
	private String roleMenuId;
    
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
		     * 获取: 菜单名称
		     */
		    public String getMenuName() {
			return menuName;
		    }
		     /**
		     * 设置: 菜单名称
		     *
		     */
		    public void setMenuName(String menuName) {
			this.menuName = menuName;
		    }
		     /**
		     * 获取: 路径
		     */
		    public String getUrl() {
			return url;
		    }
		     /**
		     * 设置: 路径
		     *
		     */
		    public void setUrl(String url) {
			this.url = url;
		    }
		     /**
		     * 获取: 图标
		     */
		    public String getIcon() {
			return icon;
		    }
		     /**
		     * 设置: 图标
		     *
		     */
		    public void setIcon(String icon) {
			this.icon = icon;
		    }
		     /**
		     * 获取: 父id
		     */
		    public String getPid() {
			return pid;
		    }
		     /**
		     * 设置: 父id
		     *
		     */
		    public void setPid(String pid) {
			this.pid = pid;
		    }
		     /**
		     * 获取: 菜单类型（菜单，按钮）
		     */
		    public String getType() {
			return type;
		    }
		     /**
		     * 设置: 菜单类型（菜单，按钮）
		     *
		     */
		    public void setType(String type) {
			this.type = type;
		    }
		     /**
		     * 获取: 排序
		     */
		    public String getOrderNum() {
			return orderNum;
		    }
		     /**
		     * 设置: 排序
		     *
		     */
		    public void setOrderNum(String orderNum) {
			this.orderNum = orderNum;
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


	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getRoleMenuId() {
		return roleMenuId;
	}

	public void setRoleMenuId(String roleMenuId) {
		this.roleMenuId = roleMenuId;
	}
}
