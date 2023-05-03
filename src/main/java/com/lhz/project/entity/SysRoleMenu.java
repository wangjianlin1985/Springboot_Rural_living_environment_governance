package com.lhz.project.entity;

public class SysRoleMenu {

		
		   //   主键
			private Integer id;
		
		   //   角色id
			private Integer roleId;
		
		   //   菜单id
			private Integer menuId;

			//菜单Ids
			private String menuIds;
    
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
		     * 获取: 角色id
		     */
		    public Integer getRoleId() {
			return roleId;
		    }
		     /**
		     * 设置: 角色id
		     * 
		     */
		    public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		    }
		     /**
		     * 获取: 用户id
		     */
		    public Integer getMenuId() {
			return menuId;
		    }
		     /**
		     * 设置: 用户id
		     * 
		     */
		    public void setMenuId(Integer menuId) {
			this.menuId = menuId;
		    }


	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
