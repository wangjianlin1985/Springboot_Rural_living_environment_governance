package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysDepartment;

public interface SysDepartmentMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysDepartment record);

    SysDepartment selectByPrimaryKey(Integer id);



    List<SysDepartment> findList(SysDepartment record);
    
    int updateByPrimaryKeySelective(SysDepartment record);


}