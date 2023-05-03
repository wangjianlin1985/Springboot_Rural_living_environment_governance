package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.Szjg;

public interface SzjgMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Szjg record);

    Szjg selectByPrimaryKey(Integer id);

    Szjg tongji();

    List<Szjg> findList(Szjg record);
    
    int updateByPrimaryKeySelective(Szjg record);


}