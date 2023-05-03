package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

public interface SysMenuMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysMenu record);

    SysMenu selectByPrimaryKey(Integer id);

    List<SysMenu>  getMenusByRoleId(@Param(value="roleId") String roleId);

    List<SysMenu> getMenusByUserByRoleId(@Param(value="roleId") String roleId);


    List<SysMenu> findList(SysMenu record);
    
    int updateByPrimaryKeySelective(SysMenu record);


}