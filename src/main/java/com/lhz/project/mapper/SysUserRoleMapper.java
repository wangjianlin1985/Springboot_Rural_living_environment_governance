package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysUserRole;

public interface SysUserRoleMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysUserRole record);

    SysUserRole selectByPrimaryKey(Integer id);



    List<SysUserRole> findList(SysUserRole record);
    
    int updateByPrimaryKeySelective(SysUserRole record);


}