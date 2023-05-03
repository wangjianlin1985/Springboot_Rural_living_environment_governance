package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer id);



    List<SysRole> findList(SysRole record);
    
    int updateByPrimaryKeySelective(SysRole record);


}