package com.lhz.project.mapper;

import java.util.List;
import java.util.Map;

import com.lhz.project.entity.Jtjg;

public interface JtjgMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Jtjg record);

    Jtjg selectByPrimaryKey(Integer id);

    List<Map<String,Object>>  tongji();

    List<Jtjg> findList(Jtjg record);
    
    int updateByPrimaryKeySelective(Jtjg record);


}