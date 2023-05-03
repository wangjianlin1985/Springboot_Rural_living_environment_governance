package com.lhz.project.mapper;

import java.util.List;
import java.util.Map;

import com.lhz.project.entity.Trzljg;

public interface TrzljgMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Trzljg record);

    Trzljg selectByPrimaryKey(Integer id);

    List<Map<String,Object>> tongji();

    List<Trzljg> findList(Trzljg record);
    
    int updateByPrimaryKeySelective(Trzljg record);


}