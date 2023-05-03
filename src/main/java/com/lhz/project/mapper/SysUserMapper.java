package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysUser;

public interface SysUserMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Integer id);

    SysUser  login(SysUser record);

    List<SysUser> findList(SysUser record);
    
    int updateByPrimaryKeySelective(SysUser record);


   /**
    *    获取最大人员编号,用于插入操作
    * @return
    */
    SysUser getMaxUserNo();
}