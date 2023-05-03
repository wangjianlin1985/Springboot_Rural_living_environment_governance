package com.lhz.project.mapper;

import java.util.List;
import java.util.Map;

import com.lhz.project.entity.Wsjg;

public interface WsjgMapper {
    int deleteByPrimaryKey(Integer id);


    int insertSelective(Wsjg record);

    Wsjg selectByPrimaryKey(Integer id);

    List<Map<String,Object>>    tongjilaji();
    List<Map<String,Object>> tongjiwushui();

    List<Wsjg> findList(Wsjg record);
    
    int updateByPrimaryKeySelective(Wsjg record);


}