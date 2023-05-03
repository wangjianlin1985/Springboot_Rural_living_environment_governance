package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysRoleMenu;

public interface SysRoleMenuMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysRoleMenu record);

    SysRoleMenu selectByPrimaryKey(Integer id);

    int deleteByRoleId(Integer id);

    List<SysRoleMenu> findList(SysRoleMenu record);
    
    int updateByPrimaryKeySelective(SysRoleMenu record);


}