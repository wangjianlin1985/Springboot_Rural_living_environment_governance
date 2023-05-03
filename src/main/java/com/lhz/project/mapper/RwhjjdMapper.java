package com.lhz.project.mapper;

import java.util.List;

import com.lhz.project.entity.Rwhjjd;

public interface RwhjjdMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Rwhjjd record);

    Rwhjjd selectByPrimaryKey(Integer id);

    Rwhjjd tongji();

    List<Rwhjjd> findList(Rwhjjd record);
    
    int updateByPrimaryKeySelective(Rwhjjd record);


}