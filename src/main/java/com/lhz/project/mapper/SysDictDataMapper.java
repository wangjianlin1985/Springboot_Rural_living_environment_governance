package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.SysDictData;

public interface SysDictDataMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(SysDictData record);

    SysDictData selectByPrimaryKey(Integer id);


    List<SysDictData> findList(SysDictData record);
    
    int updateByPrimaryKeySelective(SysDictData record);


}